package com.sqlcompiler.parser.ast.printAst;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.clauses.CTENode;
import com.sqlcompiler.parser.ast.clauses.DeleteTargetItemNode;
import com.sqlcompiler.parser.ast.clauses.DeleteTargetNode;
import com.sqlcompiler.parser.ast.clauses.FromClauseNode;
import com.sqlcompiler.parser.ast.clauses.GroupByClauseNode;
import com.sqlcompiler.parser.ast.clauses.HavingClauseNode;
import com.sqlcompiler.parser.ast.clauses.JoinClauseNode;
import com.sqlcompiler.parser.ast.clauses.MergeWhenClauseNode;
import com.sqlcompiler.parser.ast.clauses.OrderByClauseNode;
import com.sqlcompiler.parser.ast.clauses.SelectClauseNode;
import com.sqlcompiler.parser.ast.clauses.WhenClauseNode;
import com.sqlcompiler.parser.ast.clauses.WhereClauseNode;
import com.sqlcompiler.parser.ast.clauses.WithClauseNode;
import com.sqlcompiler.parser.ast.expressions.AggregateFunctionNode;
import com.sqlcompiler.parser.ast.expressions.BinaryExpressionNode;
import com.sqlcompiler.parser.ast.expressions.CaseexpressionNode;
import com.sqlcompiler.parser.ast.expressions.ColumnNode;
import com.sqlcompiler.parser.ast.expressions.FunctionCallNode;
import com.sqlcompiler.parser.ast.expressions.LiteralNode;
import com.sqlcompiler.parser.ast.expressions.SubqueryNode;
import com.sqlcompiler.parser.ast.expressions.TableNode;
import com.sqlcompiler.parser.ast.other.DropDatabaseNode;
import com.sqlcompiler.parser.ast.other.DropTableNode;
import com.sqlcompiler.parser.ast.statements.AlterStatementNode;
import com.sqlcompiler.parser.ast.statements.CloseCursorNode;
import com.sqlcompiler.parser.ast.statements.DeallocateCursorNode;
import com.sqlcompiler.parser.ast.statements.DeclareCursorNode;
import com.sqlcompiler.parser.ast.statements.DeleteStatementNode;
import com.sqlcompiler.parser.ast.statements.DropStatementNode;
import com.sqlcompiler.parser.ast.statements.FetchCursorNode;
import com.sqlcompiler.parser.ast.statements.MergeStatementNode;
import com.sqlcompiler.parser.ast.statements.OpenCursorNode;
import com.sqlcompiler.parser.ast.statements.ProgramNode;
import com.sqlcompiler.parser.ast.statements.RenameItemNode;
import com.sqlcompiler.parser.ast.statements.RenameStatementNode;
import com.sqlcompiler.parser.ast.statements.SelectStatementNode;
import com.sqlcompiler.parser.ast.statements.TruncateStatementNode;
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
        if (node.hasWithClause()) {
            node.withClause.accept(this);
        }
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
            if (node.topPercent)
                topText += " PERCENT";
            if (node.topWithTies)
                topText += " WITH TIES";
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

    @Override
    public Void visit(AlterStatementNode node) {
        addLine("AlterStatement");
        level++;

        // Table name
        addLine("ALTER TABLE");
        level++;
        if (node.tableName != null) {
            node.tableName.accept(this);
        }
        level--;

        // Action
        if (node.isAddColumn()) {
            addLine("ADD COLUMN");
            level++;
            addLine("Column: " + node.columnDefinition.columnName);
            addLine("DataType: " + node.columnDefinition.dataType);
            if (node.columnDefinition.constraints != null) {
                addLine("Constraints: " + node.columnDefinition.constraints);
            }
            level--;
        } else if (node.isDropColumn()) {
            addLine("DROP COLUMN");
            level++;
            addLine("Column: " + node.dropColumnName);
            level--;
        }

        level--;
        return null;
    }

    // ========== Clauses ==========

    // ddddddddddddddrop drop drop drop drop drop
    @Override
    public Void visit(DropStatementNode node) {
        addLine("DropStatementNode");
        level++;

        if (node.dropTable != null) {
            node.dropTable.accept(this);
        }
        if (node.dropDatabase != null) {
            node.dropDatabase.accept(this);
        }

        level--;
        return null;
    }

    // helper drop
    @Override
    public Void visit(DropTableNode node) {
        addLine("DropTableNode");
        level++;

        if (node.ifExists)
            addLine("IF EXISTS");
        if (node.isTemporary)
            addLine("TEMPORARY");

        if (node.tableNames != null) {
            for (String name : node.tableNames) {
                addLine("Table: " + name);
            }
        }

        if (node.behavior != null)
            addLine("Behavior: " + node.behavior);

        level--;
        return null;
    }

    @Override
    public Void visit(DropDatabaseNode node) {
        addLine("DropDatabaseNode");

        level++;

        if (node.ifExists) {
            addLine("IF EXISTS");
        }

        if (node.databaseName != null) {
            addLine("Name: " + node.databaseName);
        }

        level--;
        return null;
    }

    //
    // detlet delte delte detlete deltet
    @Override
    public Void visit(DeleteStatementNode node) {
        addLine("DeleteStatementNode");
        level++;

        if (node.target != null) {
            node.target.accept(this);
        }

        if (node.hasFromKeyword) {
            addLine("Has FROM: true");
        }

        if (node.whereClause != null) {
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
                    // Use reflection to check for an isAscending() method if the field is not
                    // present
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

    @Override
    public Void visit(DeleteTargetNode node) {
        addLine("DeleteTarget"); // This creates a box labeled 'DeleteTarget'
        level++;

        // Tell the printer to go down into each item (the actual tables)
        for (DeleteTargetItemNode item : node.items) {
            item.accept(this);
        }

        level--;
        return null;
    }

    @Override
    public Void visit(DeleteTargetItemNode node) {
        // This uses your toString() which returns "database.schema.table"
        addLine("Table: " + node.toString());

        // If you want even more detail in the photo, you can add these:
        if (node.database != null || node.schema != null) {
            level++;
            if (node.database != null)
                addLine("DB: " + node.database);
            if (node.schema != null)
                addLine("Schema: " + node.schema);
            addLine("Name: " + node.tableName);
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

    @Override
    public Void visit(WithClauseNode node) {
        String label = "WITH";
        if (node.recursive)
            label += " RECURSIVE";
        addLine(label + " [" + node.getCTECount() + " CTE(s)]");
        level++;

        for (int i = 0; i < node.ctes.size(); i++) {
            addLine("CTE[" + (i + 1) + "]:");
            level++;
            node.ctes.get(i).accept(this);
            level--;
        }

        level--;
        return null;
    }

    @Override
    public Void visit(CTENode node) {
        String label = "CTE: " + node.name;
        if (node.hasColumnAliases()) {
            label += " (" + String.join(", ", node.columnAliases) + ")";
        }
        addLine(label);
        level++;

        if (node.query != null) {
            addLine("Query:");
            level++;
            node.query.accept(this);
            level--;
        }

        level--;
        return null;
    }

    @Override
    public Void visit(DeclareCursorNode node) {
        addLine("DECLARE CURSOR: " + node.cursorName);
        level++;

        if (!node.options.isEmpty()) {
            addLine("Options: " + String.join(", ", node.options));
        }

        addLine("Query:");
        level++;
        if (node.query != null) {
            node.query.accept(this);
        }
        level--;

        if (node.readOnly) {
            addLine("Mode: READ ONLY");
        } else if (!node.updateColumns.isEmpty()) {
            addLine("FOR UPDATE OF: " + String.join(", ", node.updateColumns));
        }

        level--;
        return null;
    }

    @Override
    public Void visit(OpenCursorNode node) {
        addLine("OPEN CURSOR: " + (node.global ? "GLOBAL " : "") + node.cursorName);
        return null;
    }

    @Override
    public Void visit(CloseCursorNode node) {
        addLine("CLOSE CURSOR: " + (node.global ? "GLOBAL " : "") + node.cursorName);
        return null;
    }

    @Override
    public Void visit(FetchCursorNode node) {
        String label = "FETCH";
        if (node.orientation != null) {
            label += " " + node.orientation;
            if (node.position != null) {
                label += " " + node.position;
            }
        }
        label += ": " + (node.global ? "GLOBAL " : "") + node.cursorName;
        addLine(label);

        if (!node.intoVariables.isEmpty()) {
            level++;
            addLine("INTO: " + String.join(", ", node.intoVariables));
            level--;
        }

        return null;
    }

    @Override
    public Void visit(DeallocateCursorNode node) {
        addLine("DEALLOCATE CURSOR: " + (node.global ? "GLOBAL " : "") + node.cursorName);
        return null;
    }

    // Add other visit methods for different ASTNode types as needed
    public Void visit(WhenClauseNode node) {
        if (node != null) {
            addLine("WhenClause");
            level++;

            // WHEN condition
            if (node.whenCondition != null) {
                addLine("WHEN:");
                level++;
                node.whenCondition.accept(this);
                level--;
            }

            // THEN expression
            if (node.thenExpression != null) {
                addLine("THEN:");
                level++;
                node.thenExpression.accept(this);
                level--;
            }

            level--;
        }
        return null;
    }

    @Override
    public Void visit(RenameStatementNode node) {
        getIndent();
        System.out.println("RenameStatement");
        level++;

        for (RenameItemNode item : node.renameItems) {
            item.accept(this);
        }

        level--;
        return null;
    }

    @Override
    public Void visit(RenameItemNode node) {
        getIndent();
        System.out.println("RenameItem");
        level++;

        getIndent();
        System.out.println("OldName: " + node.oldName);

        getIndent();
        System.out.println("NewName: " + node.newName);

        level--;
        return null;
    }

    @Override
    public Void visit(TruncateStatementNode node) {
        getIndent();
        System.out.println("TRUNCATE TABLE: " + node.tableName);
        if (node.option != null) {
            level++;
            getIndent();
            System.out.println("Option: " + node.option);
            level--;
        }
        return null;
    }

    @Override
    public Void visit(MergeStatementNode node) {
        getIndent();
        System.out.println("MERGE STATEMENT");
        level++;

        getIndent();
        System.out.println("Target: " + node.targetTable.toString());

        getIndent();
        System.out.println("Source: " + node.sourceTable.toString());

        getIndent();
        System.out.println("ON Condition:");
        level++;
        node.onCondition.accept(this);
        level--;

        for (MergeWhenClauseNode when : node.whenClauses) {
            when.accept(this);
        }

        level--;
        return null;
    }

    @Override
    public Void visit(MergeWhenClauseNode node) {
        getIndent();
        System.out.println("WHEN " + node.mergeType + " THEN " + node.actionType);
        // Add logic to print assignments for UPDATE or values for INSERT
        return null;
    }
}