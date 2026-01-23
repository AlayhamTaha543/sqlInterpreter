package com.sqlcompiler.compiler;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.clauses.*;
import com.sqlcompiler.parser.ast.expressions.*;
import com.sqlcompiler.parser.ast.other.ColumnDefinitionNode;
import com.sqlcompiler.parser.ast.other.DropDatabaseNode;
import com.sqlcompiler.parser.ast.other.DropTableNode;
import com.sqlcompiler.parser.ast.statements.*; 

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Utility to visualize custom AST using Graphviz DOT format.
 * Uses the Visitor pattern for proper traversal.
 */
public class ASTVisualizer implements ASTVisitor<Integer> {

        @Override
        public Integer visit(com.sqlcompiler.parser.ast.other.DataTypeNode node) {
            String label = "DataType: " + (node.typeName != null ? node.typeName : "?");
            return createNode(label, "lightgray");
        }
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
                currentId, escapedLabel, color));
        return currentId;
    }

    /**
     * Creates an edge between two nodes
     */
    private void createEdge(int fromId, int toId, String label) {
        if (label != null && !label.isEmpty()) {
            dotContent.append(String.format(
                    "  node%d -> node%d [label=\"%s\"];\n",
                    fromId, toId, escapeLabel(label)));
        } else {
            dotContent.append(String.format(
                    "  node%d -> node%d;\n",
                    fromId, toId));
        }
    }

    /**
     * Escapes special characters for DOT format
     */
    private String escapeLabel(String label) {
        if (label == null)
            return "";
        return label.replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\\", "\\\\")
                .substring(0, Math.min(label.length(), 50));
    }

    /**
     * Determine whether a SortItem represents ascending order.
     * Uses reflection to support various SortItem implementations without requiring
     * a specific API.
     */
    private boolean getSortItemAscending(OrderByClauseNode.SortItem item) {
        if (item == null)
            return true;
        try {
            // Try common method names
            java.lang.reflect.Method m = null;
            try {
                m = item.getClass().getMethod("isAscending");
            } catch (NoSuchMethodException ignored) {
            }
            if (m == null)
                try {
                    m = item.getClass().getMethod("isAsc");
                } catch (NoSuchMethodException ignored) {
                }
            if (m == null)
                try {
                    m = item.getClass().getMethod("getAscending");
                } catch (NoSuchMethodException ignored) {
                }
            if (m == null)
                try {
                    m = item.getClass().getMethod("getAsc");
                } catch (NoSuchMethodException ignored) {
                }

            if (m != null) {
                Object res = m.invoke(item);
                if (res instanceof Boolean)
                    return (Boolean) res;
            }

            // Try common field names
            String[] fieldNames = { "ascending", "asc", "isAscending", "isAsc", "direction" };
            for (String fname : fieldNames) {
                try {
                    java.lang.reflect.Field f = item.getClass().getField(fname);
                    Object val = f.get(item);
                    if (val instanceof Boolean)
                        return (Boolean) val;
                    if (val != null) {
                        String s = val.toString().toLowerCase();
                        if (s.equals("asc") || s.equals("ascending"))
                            return true;
                        if (s.equals("desc") || s.equals("descending"))
                            return false;
                    }
                } catch (NoSuchFieldException ignored) {
                }
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
        if (node.hasWithClause()) {
            int withId = node.withClause.accept(this);
            createEdge(nodeId, withId, null);
        }
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
public Integer visit(InsertStatementNode node) {
    int nodeId = createNode("INSERT STATEMENT", "lightblue");

    // Target table
    if (node.target != null && !node.target.isEmpty()) {
        int targetId = createNode("Target: " + node.target, "lightcyan");
        createEdge(nodeId, targetId, "into");
    }

    // Columns
    if (node.columns != null && !node.columns.isEmpty()) {
        String colsLabel = "Columns: " + String.join(", ", node.columns);
        int colsId = createNode(colsLabel, "paleturquoise");
        createEdge(nodeId, colsId, null);
    }

    // Source
    int sourceId = createNode("Source", "aliceblue");
    createEdge(nodeId, sourceId, null);

    // Values
    if (node.valueRows != null && !node.valueRows.isEmpty()) {
        int valuesId = createNode("VALUES", "lightsteelblue");
        createEdge(sourceId, valuesId, null);
        
        for (int i = 0; i < node.valueRows.size(); i++) {
            int rowId = createNode("Row " + (i + 1), "powderblue");
            createEdge(valuesId, rowId, null);
            
            List<ExpressionNode> row = node.valueRows.get(i);
            for (ExpressionNode expr : row) {
                if (expr != null) {
                    int valId = expr.accept(this);
                    createEdge(rowId, valId, null);
                }
            }
        }
    }
    // Query source (INSERT ... SELECT)
    else if (node.querySource != null) {
        int queryId = node.querySource.accept(this);
        createEdge(sourceId, queryId, "select");
    }
    // Default values
    else if (node.defaultValues) {
        int defaultId = createNode("DEFAULT VALUES", "lightblue");
        createEdge(sourceId, defaultId, null);
    }

    return nodeId;
}
@Override
    public Integer visit(ValuesClauseNode node) {
        int nodeId = createNode("VALUES", "lightgray");
        for (com.sqlcompiler.parser.ast.statements.ValuesRowNode row : node.rows) {
            int rowId = row.accept(this);
            createEdge(nodeId, rowId, null);
        }
        return nodeId;
    }

    @Override
    public Integer visit(ValuesRowNode node) {
        int nodeId = createNode("Row", "whitesmoke");
        for (com.sqlcompiler.parser.ast.expressions.ExpressionNode val : node.values) {
            int valId = val.accept(this);
            createEdge(nodeId, valId, null);
        }
        return nodeId;
    }

    @Override
    public Integer visit(ColumnDefinitionNode node) {
        String label = "ColumnDef: " + node.columnName;
        int nodeId = createNode(label, "palegoldenrod");

        if (node.dataType != null) {
            int typeId = node.dataType.accept(this);
            createEdge(nodeId, typeId, "type");
        }

        if (node.attributes != null && !node.attributes.isEmpty()) {
            int attrsId = createNode("Attrs: " + String.join(", ", node.attributes), "lemonchiffon");
            createEdge(nodeId, attrsId, null);
        }

        return nodeId;

    }

    @Override
    public Integer visit(UpdateStatementNode node) {
        int nodeId = createNode("UPDATE STATEMENT", "lightcoral");

        // TOP clause
        if (node.hasTopClause()) {
            String topLabel = "TOP: " + node.topExpression;
            if (node.topPercent)
                topLabel += " PERCENT";
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
            // Include alias in the Item label itself
            String itemLabel = "SelectItem";
            if (item.alias != null && !item.alias.isEmpty()) {
                itemLabel += " (AS " + item.alias + ")";
            }
            int itemId = createNode(itemLabel, "palegreen");
            createEdge(nodeId, itemId, null);

            // Only add the expression as child
            if (item.expression != null) {
                int exprId = item.expression.accept(this);
                createEdge(itemId, exprId, "expression");
            }
        }

        return nodeId;
    }

    @Override
    public Integer visit(FromClauseNode node) {
        int nodeId = createNode("FROM", "lightblue");

        for (FromClauseNode.TableSource table : node.tableSources) {
            String sourceLabel = "TableSource";
            if (table.alias != null && !table.alias.isEmpty()) {
                sourceLabel += " (AS " + table.alias + ")";
            }
            int sourceId = createNode(sourceLabel, "lightcyan");
            createEdge(nodeId, sourceId, null);

            // Visit the table/subquery (use reflection to support different TableSource APIs)
            try {
                Object src = null;
                // try common public field
                try {
                    java.lang.reflect.Field f = table.getClass().getField("source");
                    src = f.get(table);
                } catch (NoSuchFieldException | IllegalAccessException ignored) {
                }
                // try common getters if field not found
                if (src == null) {
                    try {
                        java.lang.reflect.Method m = table.getClass().getMethod("getSource");
                        src = m.invoke(table);
                    } catch (NoSuchMethodException ignored) {
                        try {
                            java.lang.reflect.Method m2 = table.getClass().getMethod("getTable");
                            src = m2.invoke(table);
                        } catch (NoSuchMethodException ignored2) {
                        }
                    }
                }
                if (src instanceof ASTNode) {
                    int tableId = ((ASTNode) src).accept(this);
                    createEdge(sourceId, tableId, "source");
                }
            } catch (Exception ignored) {
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

        // Joined table with alias in label
        if (node.table != null) {
            String tableLabel = "JoinedTable";
            if (node.alias != null && !node.alias.isEmpty()) {
                tableLabel += " (AS " + node.alias + ")";
            }
            int tableContainerId = createNode(tableLabel, "mistyrose");
            createEdge(nodeId, tableContainerId, "table");

            int tableId = node.table.accept(this);
            createEdge(tableContainerId, tableId, "source");
        }

        // Join condition
        if (node.condition != null) {
            int condId = createNode("ON", "lightgoldenrodyellow");
            createEdge(nodeId, condId, null);

            int exprId = node.condition.accept(this);
            createEdge(condId, exprId, "condition");
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

    @Override
    public Integer visit(AlterStatementNode node) {
        int nodeId = createNode("ALTER TABLE", "lightyellow");

        // Table name
        if (node.tableName != null) {
            int tableId = node.tableName.accept(this);
            createEdge(nodeId, tableId, "table");
        }

        // Action
        if (node.isAddColumn()) {
            int actionId = createNode("ADD COLUMN", "khaki");
            createEdge(nodeId, actionId, null);

            String colInfo = node.columnDefinition.columnName + ": " +
                    node.columnDefinition.dataType;
            int colId = createNode(colInfo, "palegoldenrod");
            createEdge(actionId, colId, null);

            if (node.columnDefinition.constraints != null) {
                int constId = createNode("Constraints: " + node.columnDefinition.constraints, "lemonchiffon");
                createEdge(colId, constId, null);
            }
        } else if (node.isDropColumn()) {
            int actionId = createNode("DROP COLUMN", "khaki");
            createEdge(nodeId, actionId, null);

            int colId = createNode("Column: " + node.dropColumnName, "palegoldenrod");
            createEdge(actionId, colId, null);
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
            label += " (AS " + node.alias + ")";
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

        if (node.inputExpression != null) {
            int inputId = node.inputExpression.accept(this);
            createEdge(nodeId, inputId, "input");
        }

        // Visit all WHEN clauses
        for (WhenClauseNode whenClause : node.whenClauses) {
            int whenId = whenClause.accept(this);
            createEdge(nodeId, whenId, "when");
        }

        // Visit ELSE expression if exists
        if (node.elseExpression != null) {
            int elseId = node.elseExpression.accept(this);
            createEdge(nodeId, elseId, "else");
        }

        return nodeId;
    }

    @Override
    public Integer visit(NotExpressionNode node) {
        int nodeId = createNode("NOT", "lightsteelblue");
        if (node.getExpression() != null) {
            int exprId = node.getExpression().accept(this);
            createEdge(nodeId, exprId, "expr");
        }
        return nodeId;
    }

    @Override
    public Integer visit(WhenClauseNode node) {
        int nodeId = createNode("WHEN", "lemonchiffon");
        try {
            // Try common field names for condition
            Object condition = null;
            String[] condNames = { "condition", "whenExpression", "expression", "expr" };
            for (String fname : condNames) {
                try {
                    java.lang.reflect.Field f = node.getClass().getField(fname);
                    condition = f.get(node);
                    if (condition != null)
                        break;
                } catch (NoSuchFieldException ignored) {
                }
            }
            // Try common getter if field not found
            if (condition == null) {
                try {
                    java.lang.reflect.Method m = node.getClass().getMethod("getCondition");
                    condition = m.invoke(node);
                } catch (NoSuchMethodException ignored) {
                }
            }
            if (condition instanceof ASTNode) {
                int condId = ((ASTNode) condition).accept(this);
                createEdge(nodeId, condId, "condition");
            }

            // Try common field names for result/then expression
            Object result = null;
            String[] resNames = { "result", "thenExpression", "thenExpr", "resultExpression", "then" };
            for (String fname : resNames) {
                try {
                    java.lang.reflect.Field f = node.getClass().getField(fname);
                    result = f.get(node);
                    if (result != null)
                        break;
                } catch (NoSuchFieldException ignored) {
                }
            }
            // Try common getter if field not found
            if (result == null) {
                try {
                    java.lang.reflect.Method m = node.getClass().getMethod("getResult");
                    result = m.invoke(node);
                } catch (NoSuchMethodException ignored) {
                }
                try {
                    java.lang.reflect.Method m = node.getClass().getMethod("getThenExpression");
                    if (result == null)
                        result = m.invoke(node);
                } catch (NoSuchMethodException ignored) {
                }
            }
            if (result instanceof ASTNode) {
                int resId = ((ASTNode) result).accept(this);
                createEdge(nodeId, resId, "result");
            }
        } catch (Exception ignored) {
            // best-effort visualization; ignore reflection errors
        }
        return nodeId;
    }

    @Override
    public Integer visit(SubqueryNode node) {
        String label = "Subquery";
        if (node.getAlias() != null && !node.getAlias().isEmpty()) {
            label += " (AS " + node.getAlias() + ")";
        }
        int nodeId = createNode(label, "lightsteelblue");

        if (node.getQuery() != null) {
            int queryId = node.getQuery().accept(this);
            createEdge(nodeId, queryId, "query");
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

    @Override
    public Integer visit(WithClauseNode node) {
        String label = "WITH";
        if (node.recursive)
            label += " RECURSIVE";
        int nodeId = createNode(label, "lavenderblush");

        for (int i = 0; i < node.ctes.size(); i++) {
            int cteId = node.ctes.get(i).accept(this);
            createEdge(nodeId, cteId, "cte" + (i + 1));
        }

        return nodeId;
    }

    @Override
    public Integer visit(CTENode node) {
        String label = "CTE: " + node.name;
        if (node.hasColumnAliases()) {
            label += "\n(" + String.join(", ", node.columnAliases) + ")";
        }
        int nodeId = createNode(label, "mistyrose");

        if (node.query != null) {
            int queryId = node.query.accept(this);
            createEdge(nodeId, queryId, "query");
        }

        return nodeId;
    }

    @Override
    public Integer visit(RenameStatementNode node) {
        int nodeId = createNode("RENAME TABLE", "lightsalmon");

        for (RenameItemNode item : node.renameItems) {
            int itemId = item.accept(this);
            createEdge(nodeId, itemId, null);
        }

        return nodeId;
    }

    @Override
    public Integer visit(RenameItemNode node) {
        int itemId = createNode("RenameItem", "peachpuff");

        int oldId = createNode("Old: " + node.oldName, "lightblue");
        createEdge(itemId, oldId, "from");

        int newId = createNode("New: " + node.newName, "lightgreen");
        createEdge(itemId, newId, "to");

        return itemId;
    }

    @Override
    public Integer visit(DeclareCursorNode node) {
        int nodeId = createNode("DECLARE CURSOR : " + node.cursorName, "lightsteelblue");

        if (!node.options.isEmpty()) {
            int optId = createNode("Options: " + String.join(", ", node.options), "aliceblue");
            createEdge(nodeId, optId, null);
        }

        if (node.query != null) {
            int queryId = node.query.accept(this);
            createEdge(nodeId, queryId, "query");
        }

        return nodeId;
    }

    @Override
    public Integer visit(OpenCursorNode node) {
        return createNode("OPEN CURSOR : " + node.cursorName, "lightblue");
    }

    @Override
    public Integer visit(CloseCursorNode node) {
        return createNode("CLOSE CURSOR : " + node.cursorName, "lightblue");
    }

    @Override
    public Integer visit(FetchCursorNode node) {
        String label = "FETCH ";
        if (node.orientation != null)
            label += " " + node.orientation;
        label += node.cursorName;
        return createNode(label, "powderblue");
    }

    @Override
    public Integer visit(DeallocateCursorNode node) {
        return createNode("DEALLOCATE\n" + node.cursorName, "lightblue");
    }

    // ======= Added missing visit implementations for Delete/Drop nodes =======

@Override
public Integer visit(DeleteTargetItemNode node) {
    String label = "Table: " + node.toString();
    int nodeId = createNode(label, "palegoldenrod");
    
    // Add detailed breakdown if needed
    if (node.database != null || node.schema != null) {
        if (node.database != null) {
            int dbId = createNode("DB: " + node.database, "lightgoldenrodyellow");
            createEdge(nodeId, dbId, null);
        }
        if (node.schema != null) {
            int schemaId = createNode("Schema: " + node.schema, "lightgoldenrodyellow");
            createEdge(nodeId, schemaId, null);
        }
        int nameId = createNode("Name: " + node.tableName, "lightgoldenrodyellow");
        createEdge(nodeId, nameId, null);
    }
    
    return nodeId;
}
@Override
public Integer visit(DeleteTargetNode node) {
    int nodeId = createNode("DELETE TARGET", "peachpuff");
    
    // Show all target items
    if (node.items != null && !node.items.isEmpty()) {
        for (DeleteTargetItemNode item : node.items) {
            int itemId = item.accept(this);
            createEdge(nodeId, itemId, "table");
        }
    }
    
    return nodeId;
}

    @Override
    public Integer visit(DeleteStatementNode node) {
        int nodeId = createNode("DELETE STATEMENT", "lightcoral");
        
        // Delete target (which table(s) to delete from)
        if (node.target != null) {
            int targetId = node.target.accept(this);
            createEdge(nodeId, targetId, "target");
        }
        
        // FROM clause (for joins)
        if (node.fromClause != null) {
            int fromId = node.fromClause.accept(this);
            createEdge(nodeId, fromId, "from");
        }
        
        // WHERE clause
        if (node.whereClause != null) {
            int whereId = node.whereClause.accept(this);
            createEdge(nodeId, whereId, "where");
        }
        
        // Show if has FROM keyword
        if (node.hasFromKeyword) {
            int infoId = createNode("Has FROM keyword", "mistyrose");
            createEdge(nodeId, infoId, null);
        }
        
        return nodeId;
    }

    @Override
    public Integer visit(DropStatementNode node) {
        // Generic DROP statement node
        return createNode("DROP STATEMENT", "khaki");
    }

    @Override
    public Integer visit(DropTableNode node) {
        String label = "DROP TABLE";
        // best-effort try to show table name if available via common field
        try {
            java.lang.reflect.Field f = node.getClass().getField("tableName");
            Object val = f.get(node);
            if (val != null)
                label += ": " + val.toString();
        } catch (Exception ignored) {
        }
        return createNode(label, "lightyellow");
    }

    @Override
    public Integer visit(DropDatabaseNode node) {
        String label = "DROP DATABASE";
        // best-effort try to show database name if available via common field
        try {
            java.lang.reflect.Field f = node.getClass().getField("databaseName");
            Object val = f.get(node);
            if (val != null)
                label += ": " + val.toString();
        } catch (Exception ignored) {
        }
        return createNode(label, "lightyellow");
    }

    @Override
    public Integer visit(MergeStatementNode node) {
        int nodeId = createNode("MERGE STATEMENT", "lightcoral");

        // WITH clause
        if (node.withClause != null) {
            int withId = node.withClause.accept(this);
            createEdge(nodeId, withId, "with");
        }

        // Target table
        if (node.targetTable != null) {
            int targetId = createNode("TARGET", "lightsalmon");
            createEdge(nodeId, targetId, null);

            int tableId = node.targetTable.accept(this);
            createEdge(targetId, tableId, null);
        }

        // Source table
        if (node.sourceTable != null) {
            int sourceId = createNode("SOURCE", "lightskyblue");
            createEdge(nodeId, sourceId, null);

            int tableId = node.sourceTable.accept(this);
            createEdge(sourceId, tableId, null);
        }

        // ON condition
        if (node.onCondition != null) {
            int onId = createNode("ON", "lightgoldenrodyellow");
            createEdge(nodeId, onId, null);

            int condId = node.onCondition.accept(this);
            createEdge(onId, condId, "condition");
        }

        // WHEN clauses
        if (node.whenClauses != null) {
            for (MergeWhenClauseNode when : node.whenClauses) {
                int whenId = when.accept(this);
                createEdge(nodeId, whenId, "when");
            }
        }

        return nodeId;
    }
@Override
public Integer visit(MergeWhenClauseNode node) {
    String label = "WHEN " + node.mergeType;
    int nodeId = createNode(label, "peachpuff");

    // Optional condition
    if (node.condition != null) {
        int condId = createNode("AND", "lemonchiffon");
        createEdge(nodeId, condId, null);

        int exprId = node.condition.accept(this);
        createEdge(condId, exprId, "condition");
    }

    // Action
    int actionId = createNode("ACTION: " + node.actionType, "lightsteelblue");
    createEdge(nodeId, actionId, null);

    switch (node.actionType) {
        case UPDATE:
            if (node.assignments != null) {
                for (UpdateStatementNode.SetAssignment a : node.assignments) {
                    int assignId = createNode("SET [" + a.operator + "]", "mistyrose");
                    createEdge(actionId, assignId, null);

                    if (a.target != null) {
                        int targetId = a.target.accept(this);
                        createEdge(assignId, targetId, "target");
                    }

                    if (a.value != null) {
                        int valueId = a.value.accept(this);
                        createEdge(assignId, valueId, "value");
                    }
                }
            }
            break;

        case INSERT:
            int insertId = createNode("INSERT", "palegreen");
            createEdge(actionId, insertId, null);

            if (node.insertColumns != null) {
                int colsId = createNode(
                        "Columns: " + String.join(", ", node.insertColumns),
                        "honeydew"
                );
                createEdge(insertId, colsId, null);
            }

            if (node.insertValues != null) {
                for (ExpressionNode expr : node.insertValues) {
                    int valId = expr.accept(this);
                    createEdge(insertId, valId, "value");
                }
            }
            break;

        case DELETE:
            // DELETE has no extra children
            break;
    }

    return nodeId;
}
@Override
public Integer visit(TruncateStatementNode node) {
    int nodeId = createNode("TRUNCATE TABLE", "lightyellow");

    // Table name
    if (node.tableName != null) {
        int tableId = createNode("Table: " + node.tableName, "lavender");
        createEdge(nodeId, tableId, null);
    }

    // Optional option (e.g. RESTART IDENTITY)
    if (node.option != null && !node.option.isEmpty()) {
        int optId = createNode("Option: " + node.option, "lemonchiffon");
        createEdge(nodeId, optId, null);
    }

    return nodeId;
}
@Override
public Integer visit(StatementBlockNode node) {
    int nodeId = createNode("BLOCK [" + node.statements.size() + " stmts]", "lightgray");
    
    for (int i = 0; i < node.statements.size(); i++) {
        int stmtId = node.statements.get(i).accept(this);
        createEdge(nodeId, stmtId, "stmt" + (i + 1));
    }
    
    return nodeId;
}
@Override
public Integer visit(IfStatementNode node) {
    int nodeId = createNode("IF STATEMENT", "orange");

    if (node.condition != null) {
        int condId = node.condition.accept(this);
        createEdge(nodeId, condId, "condition");
    }

    if (node.thenStatement != null) {
        int thenId = node.thenStatement.accept(this);
        createEdge(nodeId, thenId, "then");
    }

    if (node.elseStatement != null) {
        int elseId = node.elseStatement.accept(this);
        createEdge(nodeId, elseId, "else");
    }

    return nodeId;
}
@Override
public Integer visit(CreateStatementNode node) {
    int nodeId = createNode("CREATE TABLE", "lightyellow");

    if (node.table != null) {
        int tableId = node.table.accept(this);
        createEdge(nodeId, tableId, "table");
    }

    if (node.tableElements != null && !node.tableElements.isEmpty()) {
        int elemsId = createNode("Elements", "khaki");
        createEdge(nodeId, elemsId, null);
        
        for (ASTNode element : node.tableElements) {
            int elemId = element.accept(this);
            createEdge(elemsId, elemId, null);
        }
    }

    return nodeId;
}
}
