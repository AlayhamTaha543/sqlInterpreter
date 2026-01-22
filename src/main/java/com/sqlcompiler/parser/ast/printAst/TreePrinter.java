package com.sqlcompiler.parser.ast.printAst;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.clauses.FromClauseNode;
import com.sqlcompiler.parser.ast.clauses.GroupByClauseNode;
import com.sqlcompiler.parser.ast.clauses.HavingClauseNode;
import com.sqlcompiler.parser.ast.clauses.JoinClauseNode;
import com.sqlcompiler.parser.ast.clauses.OrderByClauseNode;
import com.sqlcompiler.parser.ast.clauses.SelectClauseNode;
import com.sqlcompiler.parser.ast.clauses.WhereClauseNode;
import com.sqlcompiler.parser.ast.expressions.AggregateFunctionNode;
import com.sqlcompiler.parser.ast.expressions.BinaryExpressionNode;
import com.sqlcompiler.parser.ast.expressions.CaseexpressionNode;
import com.sqlcompiler.parser.ast.expressions.ColumnNode;
import com.sqlcompiler.parser.ast.expressions.FunctionCallNode;
import com.sqlcompiler.parser.ast.expressions.LiteralNode;
import com.sqlcompiler.parser.ast.expressions.SubqueryNode;
import com.sqlcompiler.parser.ast.expressions.TableNode;
import com.sqlcompiler.parser.ast.statements.ProgramNode;
import com.sqlcompiler.parser.ast.statements.SelectStatementNode;
import com.sqlcompiler.parser.ast.statements.UpdateStatementNode;

public class TreePrinter implements ASTVisitor<Void> {
    private int level = 0;
    private final StringBuilder output = new StringBuilder();

    public static String print(ASTNode node) {
        TreePrinter printer = new TreePrinter();
        if (node != null) {
            node.accept(printer);
        }
        return printer.output.toString();
    }

    private String getIndent() {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("|   ");
        }
        return indent.toString();
    }

    private void addLine(String text) {
        output.append(getIndent()).append("+-- ").append(text).append("\n");
    }

    // ========== Statements ==========
    @Override
public Void visit(ProgramNode node) {
    addLine("Program [" + node.getStatementCount() + " statement(s)]");
    level++;
    
    for (int i = 0; i < node.statements.size(); i++) {
        addLine("Statement[" + (i + 1) + "]:");
        level++;
        node.statements.get(i).accept(this);
        level--;
    }
    
    level--;
    return null;
}
    @Override
    public Void visit(SelectStatementNode node) {
        addLine("SelectStatement");
        level++;

        // SELECT clause
        if (node.selectClause != null) {
            node.selectClause.accept(this);
        }

        // FROM clause
        if (node.fromClause != null) {
            node.fromClause.accept(this);
        }

        // WHERE clause
        if (node.whereClause != null) {
            node.whereClause.accept(this);
        }

        // GROUP BY clause
        if (node.groupByClause != null) {
            node.groupByClause.accept(this);
        }

        // HAVING clause
        if (node.havingClause != null) {
            node.havingClause.accept(this);
        }

        // ORDER BY clause
        if (node.havingClause != null && !node.havingClause.isEmpty()) {
            node.havingClause.accept(this);
        }

        // LIMIT (make sure you have this property in SelectStatementNode)
        if (node.limit != null) {
            addLine("LIMIT: " + node.limit);
        }

        // OFFSET (make sure you have this property in SelectStatementNode)
        if (node.offset != null) {
            addLine("OFFSET: " + node.offset);
        }

        level--;
        return null;
    }
    
    @Override
    public Void visit(UpdateStatementNode node) {
        addLine("UpdateStatement");
        level++;
        
        // TOP clause
        if (node.hasTopClause()) {
            String topText = "TOP: " + node.topExpression;
            if (node.topPercent) topText += " PERCENT";
            if (node.topWithTies) topText += " WITH TIES";
            addLine(topText);
        }
        
        // Target table
        addLine("UPDATE Target");
        level++;
        if (node.targetTable != null) {
            node.targetTable.accept(this);
        }
        level--;
        
        // SET clause
        addLine("SET");
        level++;
        for (UpdateStatementNode.SetAssignment assignment : node.setAssignments) {
            addLine("Assignment [" + assignment.operator + "]");
            level++;
            
            // Target column
            addLine("Target:");
            level++;
            if (assignment.target != null) {
                assignment.target.accept(this);
            }
            level--;
            
            // Value expression
            addLine("Value:");
            level++;
            if (assignment.value != null) {
                assignment.value.accept(this);
            }
            level--;
            
            level--;
        }
        level--;
        
        // FROM clause (for joins)
        if (node.hasFromClause()) {
            node.fromClause.accept(this);
        }
        
        // WHERE clause
        if (node.hasWhereClause()) {
            node.whereClause.accept(this);
        }
        
        level--;
        return null;
    }
    
    // ========== Clauses ==========
    @Override
    public Void visit(SelectClauseNode node) {
        addLine("SELECT" + (node.distinct ? " DISTINCT" : ""));
        level++;

        for (SelectClauseNode.SelectItem item : node.selectItems) {
            String aliasText = (item.alias != null && !item.alias.isEmpty()) ? " AS " + item.alias : "";

            if (item.expression != null) {
                // Check if it's a wildcard column
                if (item.expression instanceof ColumnNode) {
                    ColumnNode col = (ColumnNode) item.expression;
                    if ("*".equals(col.columnName)) {
                        addLine("Wildcard (*)");
                        continue;
                    }
                }

                addLine("SelectItem" + aliasText);
                level++;
                item.expression.accept(this);
                level--;
            }
        }

        level--;
        return null;
    }

    @Override
    public Void visit(FromClauseNode node) {
        addLine("FROM");
        level++;

        for (FromClauseNode.TableSource table : node.tableSources) {
            String aliasText = (table.alias != null && !table.alias.isEmpty()) ? " AS " + table.alias : "";
            addLine("TableSource" + aliasText);

            level++;

            // Print the table/subquery source
            if (table.source != null) {
                table.source.accept(this);
            }

            // Print all joins for this table source
            if (table.joins != null && !table.joins.isEmpty()) {
                for (JoinClauseNode join : table.joins) {
                    join.accept(this);
                }
            }

            level--;
        }

        level--;
        return null;
    }

    @Override
    public Void visit(WhereClauseNode node) {
        if (node != null && node.condition != null) {
            addLine("WHERE");
            level++;
            node.condition.accept(this);
            level--;
        }
        return null;
    }

    @Override
    public Void visit(JoinClauseNode node) {
        if (node != null) {
            addLine("JOIN: " + node.joinType);
            level++;

            // Print the joined table
            if (node.table != null) {
                String aliasText = (node.alias != null && !node.alias.isEmpty()) ? " AS " + node.alias : "";
                addLine("JoinedTable" + aliasText);
                level++;
                node.table.accept(this);
                level--;
            }

            // Print the join condition
            if (node.condition != null) {
                addLine("ON");
                level++;
                node.condition.accept(this);
                level--;
            }

            level--;
        }
        return null;
    }

    @Override
    public Void visit(GroupByClauseNode node) {
        if (node != null && node.groupingElements != null && !node.groupingElements.isEmpty()) {
            addLine("GROUP BY");
            level++;
            for (GroupByClauseNode.GroupingElement elem : node.groupingElements) {
                if (elem.expression != null) {
                    elem.expression.accept(this);
                }
            }
            level--;
        }
        return null;
    }

    @Override
    public Void visit(HavingClauseNode node) {
        if (node != null && node.condition != null) {
            addLine("HAVING");
            level++;
            node.condition.accept(this);
            level--;
        }
        return null;
    }

    @Override
    public Void visit(OrderByClauseNode node) {
        if (node != null && node.sortItems != null && !node.sortItems.isEmpty()) {
            addLine("ORDER BY");
            level++;
            for (OrderByClauseNode.SortItem item : node.sortItems) {
                if (item.expression != null) {
                    String direction = "ASC";
                    // Use reflection to check for an isAscending() method if the field is not present
                    try {
                        java.lang.reflect.Method m = item.getClass().getMethod("isAscending");
                        Object val = m.invoke(item);
                        if (val instanceof Boolean && !((Boolean) val)) {
                            direction = "DESC";
                        }
                    } catch (Exception e) {
                        // If no method/accessible, default to ASC
                    }
                    addLine("SortItem [" + direction + "]");
                    level++;
                    item.expression.accept(this);
                    level--;
                }
            }
            level--;
        }
        return null;
    }

    // ========== Expressions ==========
    @Override
    public Void visit(ColumnNode node) {
        if (node != null) {
            String text = node.tableName != null ? node.tableName + "." + node.columnName : node.columnName;
            addLine("Column: " + text);
        }
        return null;
    }

    @Override
    public Void visit(TableNode node) {
        if (node != null) {
            String aliasText = (node.alias != null && !node.alias.isEmpty()) ? " AS " + node.alias : "";
            addLine("Table: " + node.tableName + aliasText);
        }
        return null;
    }

    @Override
    public Void visit(LiteralNode node) {
        if (node != null) {
            addLine("Literal[" + node.type + "]: " + node.value);
        }
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNode node) {
        if (node != null) {
            addLine("BinaryExpr: " + node.operator);
            level++;

            // Left operand
            if (node.left != null) {
                addLine("Left:");
                level++;
                node.left.accept(this);
                level--;
            }

            // Right operand
            if (node.right != null) {
                addLine("Right:");
                level++;
                node.right.accept(this);
                level--;
            }

            level--;
        }
        return null;
    }

    @Override
    public Void visit(FunctionCallNode node) {
        if (node != null) {
            addLine("Function: " + node.functionName);

            // If the function has arguments, print them
            if (node.arguments != null && !node.arguments.isEmpty()) {
                level++;
                for (int i = 0; i < node.arguments.size(); i++) {
                    addLine("Arg[" + i + "]:");
                    level++;
                    node.arguments.get(i).accept(this);
                    level--;
                }
                level--;
            }
        }
        return null;
    }

    @Override
    public Void visit(AggregateFunctionNode node) {
        if (node != null) {
            String distinctText = node.distinct ? " DISTINCT" : "";
            addLine("Aggregate: " + node.type + distinctText);

            // Print the argument
            if (node.argument != null) {
                level++;
                node.argument.accept(this);
                level--;
            }
        }
        return null;
    }

    @Override
    public Void visit(CaseexpressionNode node) {
        addLine("CaseExpression");
        level++;

        // You would add logic here to print WHEN/THEN/ELSE branches
        // depending on your CaseExpressionNode implementation

        level--;
        return null;
    }

    @Override
    public Void visit(SubqueryNode node) {
        if (node != null) {
            String aliasText = (node.getAlias() != null && !node.getAlias().isEmpty()) ? " AS " + node.getAlias() : "";
            addLine("Subquery" + aliasText);

            if (node.getQuery() != null) {
                level++;
                node.getQuery().accept(this);
                level--;
            }
        }
        return null;
    }
}