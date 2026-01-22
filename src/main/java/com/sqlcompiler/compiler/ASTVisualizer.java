package com.sqlcompiler.compiler;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.clauses.*;
import com.sqlcompiler.parser.ast.expressions.*;
import com.sqlcompiler.parser.ast.statements.ProgramNode;
import com.sqlcompiler.parser.ast.statements.SelectStatementNode;
import com.sqlcompiler.parser.ast.statements.UpdateStatementNode;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility to visualize custom AST using Graphviz DOT format.
 * Uses the Visitor pattern for proper traversal.
 */
public class ASTVisualizer implements ASTVisitor<Integer> {
    private StringBuilder dotContent;
    private int nodeCount;

    public ASTVisualizer() {
        this.dotContent = new StringBuilder();
        this.nodeCount = 0;
    }

    /**
     * Generates a DOT file from the given AST.
     */
    public void generateDotFile(ASTNode ast, String filePath) throws IOException {
        dotContent.setLength(0);
        nodeCount = 0;
        
        dotContent.append("digraph AST {\n");
        dotContent.append("  node [shape=box, fontname=\"Arial\", style=filled];\n");
        dotContent.append("  edge [fontname=\"Arial\", fontsize=10];\n");
        
        if (ast != null) {
            ast.accept(this);
        }
        
        dotContent.append("}\n");
        
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(dotContent.toString());
        }
    }

    /**
     * Creates a node in the DOT graph and returns its ID
     */
    private int createNode(String label, String color) {
        int currentId = nodeCount++;
        String escapedLabel = escapeLabel(label);
        dotContent.append(String.format(
            "  node%d [label=\"%s\", fillcolor=%s];\n", 
            currentId, escapedLabel, color
        ));
        return currentId;
    }

    /**
     * Creates an edge between two nodes
     */
    private void createEdge(int fromId, int toId, String label) {
        if (label != null && !label.isEmpty()) {
            dotContent.append(String.format(
                "  node%d -> node%d [label=\"%s\"];\n", 
                fromId, toId, escapeLabel(label)
            ));
        } else {
            dotContent.append(String.format(
                "  node%d -> node%d;\n", 
                fromId, toId
            ));
        }
    }
    /**
     * Escapes special characters for DOT format
     */
    private String escapeLabel(String label) {
        if (label == null) return "";
        return label.replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\\", "\\\\")
                   .substring(0, Math.min(label.length(), 50));
    }

    /**
     * Determine whether a SortItem represents ascending order.
     * Uses reflection to support various SortItem implementations without requiring a specific API.
     */
    private boolean getSortItemAscending(OrderByClauseNode.SortItem item) {
        if (item == null) return true;
        try {
            // Try common method names
            java.lang.reflect.Method m = null;
            try { m = item.getClass().getMethod("isAscending"); } catch (NoSuchMethodException ignored) {}
            if (m == null) try { m = item.getClass().getMethod("isAsc"); } catch (NoSuchMethodException ignored) {}
            if (m == null) try { m = item.getClass().getMethod("getAscending"); } catch (NoSuchMethodException ignored) {}
            if (m == null) try { m = item.getClass().getMethod("getAsc"); } catch (NoSuchMethodException ignored) {}

            if (m != null) {
                Object res = m.invoke(item);
                if (res instanceof Boolean) return (Boolean) res;
            }

            // Try common field names
            String[] fieldNames = {"ascending", "asc", "isAscending", "isAsc", "direction"};
            for (String fname : fieldNames) {
                try {
                    java.lang.reflect.Field f = item.getClass().getField(fname);
                    Object val = f.get(item);
                    if (val instanceof Boolean) return (Boolean) val;
                    if (val != null) {
                        String s = val.toString().toLowerCase();
                        if (s.equals("asc") || s.equals("ascending")) return true;
                        if (s.equals("desc") || s.equals("descending")) return false;
                    }
                } catch (NoSuchFieldException ignored) {}
            }
        } catch (Exception ignored) {
            // fallback to default
        }
        return true; // default to ascending
    }
    

    // ========== Statements ==========
    @Override
    public Integer visit(SelectStatementNode node) {
        int nodeId = createNode("SELECT STATEMENT", "lightgreen");
        
        if (node.selectClause != null) {
            int childId = node.selectClause.accept(this);
            createEdge(nodeId, childId, null);
        }
        
        if (node.fromClause != null) {
            int childId = node.fromClause.accept(this);
            createEdge(nodeId, childId, null);
        }
        
        if (node.whereClause != null) {
            int childId = node.whereClause.accept(this);
            createEdge(nodeId, childId, null);
        }
        
        if (node.groupByClause != null) {
            int childId = node.groupByClause.accept(this);
            createEdge(nodeId, childId, null);
        }
        
        if (node.havingClause != null) {
            int childId = node.havingClause.accept(this);
            createEdge(nodeId, childId, null);
        }
        
        if (node.orderByClause != null) {
            int childId = node.orderByClause.accept(this);
            createEdge(nodeId, childId, null);
        }
        
        return nodeId;
    }
    
    @Override
    public Integer visit(UpdateStatementNode node) {
        int nodeId = createNode("UPDATE STATEMENT", "lightcoral");
        
        // TOP clause
        if (node.hasTopClause()) {
            String topLabel = "TOP: " + node.topExpression;
            if (node.topPercent) topLabel += " PERCENT";
            int topId = createNode(topLabel, "mistyrose");
            createEdge(nodeId, topId, null);
        }
        
        // Target table
        if (node.targetTable != null) {
            int targetId = createNode("Target", "lightcoral");
            createEdge(nodeId, targetId, null);
            
            int tableId = node.targetTable.accept(this);
            createEdge(targetId, tableId, null);
        }
        
        // SET assignments
        int setId = createNode("SET", "lightsalmon");
        createEdge(nodeId, setId, null);
        
        for (UpdateStatementNode.SetAssignment assignment : node.setAssignments) {
            int assignId = createNode("Assignment [" + assignment.operator + "]", "peachpuff");
            createEdge(setId, assignId, null);
            
            // Target column
            if (assignment.target != null) {
                int targetColId = assignment.target.accept(this);
                createEdge(assignId, targetColId, "target");
            }
            
            // Value
            if (assignment.value != null) {
                int valueId = assignment.value.accept(this);
                createEdge(assignId, valueId, "value");
            }
        }
        
        // FROM clause
        if (node.hasFromClause()) {
            int fromId = node.fromClause.accept(this);
            createEdge(nodeId, fromId, null);
        }
        
        // WHERE clause
        if (node.hasWhereClause()) {
            int whereId = node.whereClause.accept(this);
            createEdge(nodeId, whereId, null);
        }
        
        return nodeId;
    }

    // ========== Clauses ==========
    @Override
    public Integer visit(SelectClauseNode node) {
        String label = "SELECT" + (node.distinct ? " DISTINCT" : "");
        int nodeId = createNode(label, "lightgreen");
        
        for (SelectClauseNode.SelectItem item : node.selectItems) {
            String itemLabel = "Item";
            if (item.alias != null && !item.alias.isEmpty()) {
                itemLabel += " AS " + item.alias;
            }
            int itemId = createNode(itemLabel, "palegreen");
            createEdge(nodeId, itemId, null);
            
            if (item.expression != null) {
                int exprId = item.expression.accept(this);
                createEdge(itemId, exprId, null);
            }
        }
        
        return nodeId;
    }

    @Override
    public Integer visit(FromClauseNode node) {
        int nodeId = createNode("FROM", "lightblue");
        
        for (FromClauseNode.TableSource table : node.tableSources) {
            String sourceLabel = "Source";
            if (table.alias != null && !table.alias.isEmpty()) {
                sourceLabel += " AS " + table.alias;
            }
            int sourceId = createNode(sourceLabel, "lightcyan");
            createEdge(nodeId, sourceId, null);
            
            // Visit the table/subquery
            if (table.source != null) {
                int tableId = table.source.accept(this);
                createEdge(sourceId, tableId, null);
            }
            
            // Visit all joins
            if (table.joins != null) {
                for (JoinClauseNode join : table.joins) {
                    int joinId = join.accept(this);
                    createEdge(sourceId, joinId, "join");
                }
            }
        }
        
        return nodeId;
    }

    @Override
    public Integer visit(WhereClauseNode node) {
        int nodeId = createNode("WHERE", "lightyellow");
        
        if (node.condition != null) {
            int condId = node.condition.accept(this);
            createEdge(nodeId, condId, null);
        }
        
        return nodeId;
    }

    @Override
    public Integer visit(JoinClauseNode node) {
        String label = node.joinType.toString();
        int nodeId = createNode(label, "lightcoral");
        
        // Joined table
        if (node.table != null) {
            String tableLabel = "Table";
            if (node.alias != null && !node.alias.isEmpty()) {
                tableLabel += " AS " + node.alias;
            }
            int tableContainerId = createNode(tableLabel, "mistyrose");
            createEdge(nodeId, tableContainerId, null);
            
            int tableId = node.table.accept(this);
            createEdge(tableContainerId, tableId, null);
        }
        
        // Join condition
        if (node.condition != null) {
            int condId = createNode("ON", "lightgoldenrodyellow");
            createEdge(nodeId, condId, null);
            
            int exprId = node.condition.accept(this);
            createEdge(condId, exprId, null);
        }
        
        return nodeId;
    }

    @Override
    public Integer visit(GroupByClauseNode node) {
        int nodeId = createNode("GROUP BY", "palegreen");
        
        if (node.groupingElements != null) {
            for (GroupByClauseNode.GroupingElement elem : node.groupingElements) {
                if (elem.expression != null) {
                    int exprId = elem.expression.accept(this);
                    createEdge(nodeId, exprId, null);
                }
            }
        }
        
        return nodeId;
    }

    @Override
    public Integer visit(HavingClauseNode node) {
        int nodeId = createNode("HAVING", "lightgoldenrodyellow");
        
        if (node.condition != null) {
            int condId = node.condition.accept(this);
            createEdge(nodeId, condId, null);
        }
        
        return nodeId;
    }
    @Override
    public Integer visit(OrderByClauseNode node) {
        int nodeId = createNode("ORDER BY", "lightgoldenrodyellow");
        
        if (node.sortItems != null) {
            for (OrderByClauseNode.SortItem item : node.sortItems) {
                String direction = getSortItemAscending(item) ? "ASC" : "DESC";
                int itemId = createNode("Sort [" + direction + "]", "palegoldenrod");
                createEdge(nodeId, itemId, null);
                
                if (item.expression != null) {
                    int exprId = item.expression.accept(this);
                    createEdge(itemId, exprId, null);
                }
            }
        }
        
        return nodeId;
    }
    @Override
public Integer visit(ProgramNode node) {
    int nodeId = createNode("SQL Program [" + node.getStatementCount() + " stmt(s)]", "lightgray");
    
    for (int i = 0; i < node.statements.size(); i++) {
        int stmtId = node.statements.get(i).accept(this);
        createEdge(nodeId, stmtId, "stmt" + (i + 1));
    }
    
    return nodeId;
}

    // ========== Expressions ==========
    @Override
    public Integer visit(ColumnNode node) {
        String label = "Column: ";
        if (node.tableName != null) {
            label += node.tableName + "." + node.columnName;
        } else {
            label += node.columnName;
        }
        return createNode(label, "lightcyan");
    }

    @Override
    public Integer visit(TableNode node) {
        String label = "Table: " + node.tableName;
        if (node.alias != null && !node.alias.isEmpty()) {
            label += " AS " + node.alias;
        }
        return createNode(label, "lavender");
    }

    @Override
    public Integer visit(LiteralNode node) {
        String label = "Literal[" + node.type + "]: " + 
                      (node.value != null ? node.value.toString() : "NULL");
        return createNode(label, "lightpink");
    }

    @Override
    public Integer visit(BinaryExpressionNode node) {
        int nodeId = createNode("BinaryExpr: " + node.operator, "wheat");
        
        if (node.left != null) {
            int leftId = node.left.accept(this);
            createEdge(nodeId, leftId, "left");
        }
        
        if (node.right != null) {
            int rightId = node.right.accept(this);
            createEdge(nodeId, rightId, "right");
        }
        
        return nodeId;
    }

    @Override
    public Integer visit(FunctionCallNode node) {
        String label = "Function: " + node.functionName;
        int nodeId = createNode(label, "plum");
        
        if (node.arguments != null) {
            for (int i = 0; i < node.arguments.size(); i++) {
                int argId = node.arguments.get(i).accept(this);
                createEdge(nodeId, argId, "arg" + i);
            }
        }
        
        return nodeId;
    }

    @Override
    public Integer visit(AggregateFunctionNode node) {
        String label = "Aggregate: " + node.type;
        if (node.distinct) {
            label += " DISTINCT";
        }
        int nodeId = createNode(label, "orchid");
        
        if (node.argument != null) {
            int argId = node.argument.accept(this);
            createEdge(nodeId, argId, null);
        }
        
        return nodeId;
    }

    @Override
    public Integer visit(CaseexpressionNode node) {
        int nodeId = createNode("CASE Expression", "thistle");
        
        // Add logic here based on your CaseExpressionNode structure
        // For example:
        // if (node.whenClauses != null) {
        //     for (WhenClause when : node.whenClauses) {
        //         // process WHEN clauses
        //     }
        // }
        
        return nodeId;
    }

    @Override
    public Integer visit(SubqueryNode node) {
        String label = "Subquery";
        if (node.getAlias() != null && !node.getAlias().isEmpty()) {
            label += " AS " + node.getAlias();
        }
        int nodeId = createNode(label, "lightsteelblue");
        
        if (node.getQuery() != null) {
            int queryId = node.getQuery().accept(this);
            createEdge(nodeId, queryId, null);
        }
        
        return nodeId;
    }

    /**
     * Generates PNG from DOT file using Graphviz.
     */
    public static boolean generatePng(String dotFilePath, String pngFilePath) {
        try {
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", dotFilePath, "-o", pngFilePath);
            Process process = pb.start();
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (IOException | InterruptedException e) {
            System.err.println("Error generating PNG: " + e.getMessage());
            return false;
        }
    }
}