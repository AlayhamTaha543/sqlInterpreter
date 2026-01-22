package com.sqlcompiler.parser.ast;

import com.sqlcompiler.parser.SQLParser;
import com.sqlcompiler.parser.SQLParserBaseVisitor;
import com.sqlcompiler.parser.ast.clauses.*;
import com.sqlcompiler.parser.ast.expressions.*;
import com.sqlcompiler.parser.ast.statements.AlterStatementNode;
import com.sqlcompiler.parser.ast.statements.ProgramNode;
import com.sqlcompiler.parser.ast.statements.SelectStatementNode;
import com.sqlcompiler.parser.ast.statements.UpdateStatementNode;

import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends SQLParserBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitSqlStatements(SQLParser.SqlStatementsContext ctx) {
        ProgramNode program = new ProgramNode();

        for (SQLParser.BatchContext batch : ctx.batch()) {
            for (SQLParser.SqlStatementContext stmtCtx : batch.sqlStatement()) {
                ASTNode stmt = null;

                if (stmtCtx.selectStatement() != null) {
                    stmt = visit(stmtCtx.selectStatement());
                } else if (stmtCtx.updateStatement() != null) {
                    stmt = visit(stmtCtx.updateStatement());
                } else if (stmtCtx.insertStatement() != null) {
                    // stmt = visit(stmtCtx.insertStatement());
                    System.out.println("⚠️  INSERT statement found but not yet implemented");
                } else if (stmtCtx.deleteStatement() != null) {
                    // stmt = visit(stmtCtx.deleteStatement());
                    System.out.println("⚠️  DELETE statement found but not yet implemented");
                } else if (stmtCtx.alterStatement() != null) {
                    stmt = visit(stmtCtx.alterStatement());
                }

                if (stmt != null) {
                    program.addStatement(stmt);
                }
            }
        }

        return program;
    }
    // =================================================
    // UPDATE STATEMENT
    // =================================================

    @Override
    public ASTNode visitUpdateStatement(SQLParser.UpdateStatementContext ctx) {

        // 1. Get target table
        ExpressionNode targetTable = buildUpdateTarget(ctx.updateTarget());

        // 2. Build SET assignments
        List<UpdateStatementNode.SetAssignment> assignments = new ArrayList<>();
        for (SQLParser.UpdateSetClauseContext setCtx : ctx.updateSetClause()) {
            assignments.add(buildSetAssignment(setCtx));
        }

        // 3. Build optional FROM clause
        FromClauseNode fromClause = null;
        if (ctx.fromClause() != null) {
            fromClause = buildFromClause(ctx.fromClause());
        }

        // 4. Build optional WHERE clause
        WhereClauseNode whereClause = null;
        if (ctx.whereClause() != null) {
            whereClause = buildWhereClause(ctx.whereClause());
        }

        // 5. Handle TOP clause (optional)
        ExpressionNode topExpression = null;
        boolean topPercent = false;
        boolean topWithTies = false;

        if (ctx.topClause() != null) {
            SQLParser.TopClauseContext topCtx = ctx.topClause();

            // TOP can be: TOP n or TOP (expression)
            if (topCtx.INTEGER() != null) {
                topExpression = new LiteralNode(
                        Long.parseLong(topCtx.INTEGER().getText()),
                        "INTEGER");
            } else if (topCtx.expression() != null) {
                topExpression = (ExpressionNode) visit(topCtx.expression());
            }

            topPercent = topCtx.PERCENT() != null;
            topWithTies = topCtx.TIES() != null;
        }

        return new UpdateStatementNode(
                targetTable,
                assignments,
                fromClause,
                whereClause,
                topExpression,
                topPercent,
                topWithTies);
    }
    // =================================================
    // ALTER STATEMENT
    // =================================================

    @Override
    public ASTNode visitAlterStatement(SQLParser.AlterStatementContext ctx) {

        // Get table name
        ExpressionNode tableName = new TableNode(ctx.tableName().getText());

        // Check if it's ADD or DROP
        if (ctx.ADD() != null && ctx.columnDefinition() != null) {
            // ALTER TABLE ADD column
            return buildAlterAddColumn(tableName, ctx.columnDefinition());

        } else if (ctx.DROP() != null && ctx.COLUMN() != null && ctx.columnName() != null) {
            // ALTER TABLE DROP COLUMN
            String dropColumnName = ctx.columnName().getText();
            return new AlterStatementNode(tableName, dropColumnName);
        }

        throw new RuntimeException("Unsupported ALTER TABLE operation");
    }

    /**
     * Builds ALTER TABLE ADD COLUMN
     */
    private AlterStatementNode buildAlterAddColumn(
            ExpressionNode tableName,
            SQLParser.ColumnDefinitionContext ctx) {

        String columnName = ctx.columnName().getText();
        String dataType = ctx.dataType().getText();

        // Build constraints string (simplified - you can make this more detailed)
        StringBuilder constraints = new StringBuilder();
        if (ctx.columnAttribute() != null && !ctx.columnAttribute().isEmpty()) {
            for (SQLParser.ColumnAttributeContext attr : ctx.columnAttribute()) {
                if (constraints.length() > 0)
                    constraints.append(" ");
                constraints.append(attr.getText());
            }
        }

        AlterStatementNode.ColumnDefinition colDef = new AlterStatementNode.ColumnDefinition(
                columnName,
                dataType,
                constraints.length() > 0 ? constraints.toString() : null);

        return new AlterStatementNode(tableName, colDef);
    }

    /**
     * Builds the update target (table name or variable)
     */
    private ExpressionNode buildUpdateTarget(SQLParser.UpdateTargetContext ctx) {
        if (ctx.tableName() != null) {
            return new TableNode(ctx.tableName().getText());
        } else if (ctx.USER_VARIABLE() != null) {
            // Handle table variables like @temp_table
            return new LiteralNode(ctx.USER_VARIABLE().getText(), "VARIABLE");
        }
        throw new RuntimeException("Unsupported update target");
    }

    /**
     * Builds a SET assignment: column = expression
     */
    private UpdateStatementNode.SetAssignment buildSetAssignment(
            SQLParser.UpdateSetClauseContext ctx) {

        // Get the column being updated
        ExpressionNode target = buildFullColumnName(ctx.fullColumnName());

        // Get the operator (=, +=, -=, etc.)
        String operator = ctx.assignmentOperator().getText();

        // Get the value expression
        ExpressionNode value = (ExpressionNode) visit(ctx.expression());

        return new UpdateStatementNode.SetAssignment(target, operator, value);
    }

    /**
     * Builds a column reference from fullColumnName
     */
    private ExpressionNode buildFullColumnName(SQLParser.FullColumnNameContext ctx) {
        if (ctx.tableName() != null && ctx.columnName() != null) {
            // table.column
            return new ColumnNode(
                    ctx.columnName().getText(),
                    ctx.tableName().getText());
        } else if (ctx.columnName() != null) {
            // just column
            return new ColumnNode(ctx.columnName().getText());
        } else if (ctx.USER_VARIABLE() != null) {
            // @variable
            return new LiteralNode(ctx.USER_VARIABLE().getText(), "VARIABLE");
        }
        throw new RuntimeException("Unsupported column name format");
    }

    // =================================================
    // SELECT STATEMENT
    // =================================================

    @Override
    public ASTNode visitSelectStatement(SQLParser.SelectStatementContext ctx) {

        SQLParser.QuerySpecificationContext qs = extractQuerySpecification(ctx.queryExpression());

        if (qs == null) {
            throw new RuntimeException(
                    "Only simple SELECT queries are supported (no UNION yet).");
        }
        GroupByClauseNode groupByClause = qs.groupByClause() != null ? buildGroupByClause(qs.groupByClause()) : null;
        HavingClauseNode havingClause = qs.havingClause() != null ? buildHavingClause(qs.havingClause()) : null;
        SelectClauseNode selectClause = buildSelectClause(qs.selectList());
        FromClauseNode fromClause = buildFromClause(qs.fromClause());
        WhereClauseNode whereClause = qs.whereClause() != null ? buildWhereClause(qs.whereClause()) : null;
        OrderByClauseNode orderByClause = ctx.orderByClause() != null ? buildOrderByClause(ctx.orderByClause()) : null;
        return new SelectStatementNode(
                selectClause,
                fromClause,
                whereClause,
                null, groupByClause, havingClause, orderByClause, null, null);
    }

    private SQLParser.QuerySpecificationContext extractQuerySpecification(
            SQLParser.QueryExpressionContext ctx) {

        if (ctx.querySpecification() != null && ctx.querySpecification().size() > 0) {
            return ctx.querySpecification(0);
        }

        if (ctx.queryExpression() != null) {
            return extractQuerySpecification(ctx.queryExpression());
        }

        return null;
    }

    // =================================================
    // WHERE / SEARCH CONDITION
    // =================================================

    private WhereClauseNode buildWhereClause(SQLParser.WhereClauseContext ctx) {
        ExpressionNode condition = (ExpressionNode) visit(ctx.searchCondition());
        return new WhereClauseNode(condition);
    }

    @Override
    public ASTNode visitSearchCondition(SQLParser.SearchConditionContext ctx) {

        // AND / OR
        if (ctx.searchCondition().size() == 2) {
            ExpressionNode left = (ExpressionNode) visit(ctx.searchCondition(0));
            ExpressionNode right = (ExpressionNode) visit(ctx.searchCondition(1));

            String op = ctx.AND() != null ? "AND" : "OR";
            return new BinaryExpressionNode(left, op, right);
        }

        // NOT
        if (ctx.NOT() != null) {
            ExpressionNode expr = (ExpressionNode) visit(ctx.searchCondition(0));
            return new NotExpressionNode(expr);
        }

        // predicate
        if (ctx.predicate() != null) {
            return visit(ctx.predicate());
        }

        return visitChildren(ctx);
    }

    // =================================================
    // PREDICATES
    // =================================================

    @Override
    public ASTNode visitPredicate(SQLParser.PredicateContext ctx) {

        // comparison: a > b
        if (ctx.comparisonOperator() != null) {
            ExpressionNode left = (ExpressionNode) visit(ctx.expression(0));
            ExpressionNode right = (ExpressionNode) visit(ctx.expression(1));
            String op = ctx.comparisonOperator().getText();
            return new BinaryExpressionNode(left, op, right);
        }

        // fallback
        return visitChildren(ctx);
    }

    // =================================================
    // SELECT CLAUSE
    // =================================================

    private SelectClauseNode buildSelectClause(SQLParser.SelectListContext ctx) {

        boolean distinct = ctx.getParent() instanceof SQLParser.QuerySpecificationContext
                && ((SQLParser.QuerySpecificationContext) ctx.getParent())
                        .distinctClause() != null;

        List<SelectClauseNode.SelectItem> items = new ArrayList<>();

        // SELECT *
        if (ctx.STAR() != null) {
            items.add(
                    new SelectClauseNode.SelectItem(
                            new ColumnNode("*"),
                            null));
            return new SelectClauseNode(distinct, items);
        }

        for (SQLParser.SelectListElementContext e : ctx.selectListElement()) {

            ExpressionNode expr = null;

            // expression
            if (e.expression() != null) {
                expr = (ExpressionNode) visit(e.expression());
            }
            // table.*
            else if (e.tableName() != null) {
                expr = new ColumnNode("*", e.tableName().getText());
            }
            // *
            else if (e.STAR() != null) {
                expr = new ColumnNode("*");
            }

            String alias = e.columnAlias() != null ? e.columnAlias().getText() : null;

            items.add(new SelectClauseNode.SelectItem(expr, alias));
        }

        return new SelectClauseNode(distinct, items);
    }

    // =================================================
    // FROM CLAUSE - ENHANCED WITH JOIN SUPPORT
    // =================================================

    private FromClauseNode buildFromClause(SQLParser.FromClauseContext ctx) {
        if (ctx == null)
            return null;

        List<FromClauseNode.TableSource> tables = new ArrayList<>();

        for (SQLParser.TableSourceContext ts : ctx.tableSource()) {
            tables.add(buildTableSource(ts));
        }

        return new FromClauseNode(tables);
    }

    /**
     * Builds a single TableSource with its joins
     */
    private FromClauseNode.TableSource buildTableSource(SQLParser.TableSourceContext ctx) {

        // Build the base table/subquery
        SQLParser.TableSourceItemContext item = ctx.tableSourceItem();
        ExpressionNode source;
        String alias;

        // Handle tableName
        if (item.tableName() != null) {
            String name = item.tableName().getText();
            source = new TableNode(name);
            alias = item.tableAlias() != null ? item.tableAlias().getText() : null;
        }
        // Handle subquery: (SELECT ...)
        else if (item.queryExpression() != null) {
            source = buildSubquery(item.queryExpression());
            alias = item.tableAlias() != null ? item.tableAlias().getText() : null;
        }
        // Handle parenthesized tableSource: (t1 JOIN t2)
        else if (item.tableSource() != null) {
            // Recursive case
            FromClauseNode.TableSource nested = buildTableSource(item.tableSource());
            source = nested.source;
            alias = nested.alias;
        } else {
            throw new RuntimeException("Unsupported table source type");
        }

        // Build joins for this table
        List<JoinClauseNode> joins = new ArrayList<>();
        for (SQLParser.JoinPartContext jp : ctx.joinPart()) {
            joins.add(buildJoinClause(jp));
        }

        return new FromClauseNode.TableSource(source, alias, joins);
    }

    /**
     * Builds a JoinClauseNode from a joinPart using your JoinType enum
     */
    private JoinClauseNode buildJoinClause(SQLParser.JoinPartContext ctx) {

        // Determine join type using your enum
        JoinClauseNode.JoinType joinType = JoinClauseNode.JoinType.INNER; // default
        boolean isOuter = false;

        if (ctx.joinType() != null) {
            if (ctx.joinType().LEFT() != null) {
                isOuter = ctx.joinType().OUTER() != null;
                joinType = isOuter ? JoinClauseNode.JoinType.LEFT_OUTER : JoinClauseNode.JoinType.LEFT;
            } else if (ctx.joinType().RIGHT() != null) {
                isOuter = ctx.joinType().OUTER() != null;
                joinType = isOuter ? JoinClauseNode.JoinType.RIGHT_OUTER : JoinClauseNode.JoinType.RIGHT;
            } else if (ctx.joinType().FULL() != null) {
                isOuter = ctx.joinType().OUTER() != null;
                joinType = isOuter ? JoinClauseNode.JoinType.FULL_OUTER : JoinClauseNode.JoinType.FULL;
            } else if (ctx.joinType().CROSS() != null) {
                joinType = JoinClauseNode.JoinType.CROSS;
            } else if (ctx.joinType().INNER() != null) {
                joinType = JoinClauseNode.JoinType.INNER;
            }
        }

        // Build the joined table
        SQLParser.TableSourceItemContext item = ctx.tableSourceItem();
        ExpressionNode rightTable;
        String rightAlias;

        if (item.tableName() != null) {
            rightTable = new TableNode(item.tableName().getText());
            rightAlias = item.tableAlias() != null ? item.tableAlias().getText() : null;
        } else if (item.queryExpression() != null) {
            rightTable = buildSubquery(item.queryExpression());
            rightAlias = item.tableAlias() != null ? item.tableAlias().getText() : null;
        } else if (item.tableSource() != null) {
            // Handle nested table sources
            FromClauseNode.TableSource nested = buildTableSource(item.tableSource());
            rightTable = nested.source;
            rightAlias = nested.alias;
        } else {
            throw new RuntimeException("Unsupported join table source");
        }

        // Build join condition
        ExpressionNode condition = null;
        if (ctx.joinCondition() != null) {
            if (ctx.joinCondition().searchCondition() != null) {
                condition = (ExpressionNode) visit(ctx.joinCondition().searchCondition());
            }
            // Handle USING clause if needed
            else if (ctx.joinCondition().USING() != null) {
                // Build a condition from USING columns
                // For simplicity, you might want to create a special node or convert to ON
                List<SQLParser.ColumnNameContext> columns = ctx.joinCondition().columnName();
                if (columns.size() > 0) {
                    // Create equality conditions for USING columns
                    // Example: USING(id, name) -> t1.id = t2.id AND t1.name = t2.name
                    // This is a simplified approach - you may want to handle this differently
                    condition = buildUsingCondition(columns);
                }
            }
        }

        // Use your JoinClauseNode constructor
        return new JoinClauseNode(joinType, rightTable, rightAlias, condition, false, isOuter);
    }

    /**
     * Builds a condition from USING clause columns
     * USING(col1, col2) becomes col1 = col1 AND col2 = col2
     */
    private ExpressionNode buildUsingCondition(List<SQLParser.ColumnNameContext> columns) {
        if (columns.isEmpty()) {
            return null;
        }

        ExpressionNode condition = null;
        for (SQLParser.ColumnNameContext col : columns) {
            String colName = col.getText();
            ColumnNode left = new ColumnNode(colName);
            ColumnNode right = new ColumnNode(colName);
            BinaryExpressionNode equality = new BinaryExpressionNode(left, "=", right);

            if (condition == null) {
                condition = equality;
            } else {
                condition = new BinaryExpressionNode(condition, "AND", equality);
            }
        }

        return condition;
    }

    /**
     * Helper to build a subquery expression node
     */
    private ExpressionNode buildSubquery(SQLParser.QueryExpressionContext ctx) {
        // Extract the query specification from the query expression
        SQLParser.QuerySpecificationContext qs = extractQuerySpecification(ctx);

        if (qs == null) {
            throw new RuntimeException("Invalid subquery structure");
        }

        // Build the subquery components
        HavingClauseNode havingClause = qs.havingClause() != null ? buildHavingClause(qs.havingClause()) : null;
        SelectClauseNode selectClause = buildSelectClause(qs.selectList());
        FromClauseNode fromClause = buildFromClause(qs.fromClause());
        WhereClauseNode whereClause = qs.whereClause() != null ? buildWhereClause(qs.whereClause()) : null;
        GroupByClauseNode groupByClause = qs.groupByClause() != null ? buildGroupByClause(qs.groupByClause()) : null;
        // Create the select statement
        SelectStatementNode subSelect = new SelectStatementNode(
                selectClause,
                fromClause,
                whereClause,
                null, groupByClause, havingClause, null, null, null);

        // Wrap in SubqueryNode
        return new SubqueryNode(subSelect);
    }

    // =================================================
    // EXPRESSIONS
    // =================================================

    @Override
    public ASTNode visitExpression(SQLParser.ExpressionContext ctx) {

        // literal
        if (ctx.literal() != null) {
            return visit(ctx.literal());
        }

        // column
        if (ctx.columnReference() != null) {
            return visit(ctx.columnReference());
        }

        // binary expression
        if (ctx.expression().size() == 2) {
            ExpressionNode left = (ExpressionNode) visit(ctx.expression(0));
            ExpressionNode right = (ExpressionNode) visit(ctx.expression(1));
            String op = ctx.getChild(1).getText();
            return new BinaryExpressionNode(left, op, right);
        }

        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitColumnReference(SQLParser.ColumnReferenceContext ctx) {
        String column = ctx.columnName().getText();
        String table = ctx.tableName() != null ? ctx.tableName().getText() : null;
        return new ColumnNode(column, table);
    }

    // =================================================
    // LITERALS
    // =================================================

    @Override
    public ASTNode visitLiteral(SQLParser.LiteralContext ctx) {

        String text = ctx.getText();

        if (ctx.STRING() != null) {
            return new LiteralNode(
                    text.substring(1, text.length() - 1),
                    "STRING");
        }

        if (ctx.INTEGER() != null) {
            return new LiteralNode(Long.parseLong(text), "INTEGER");
        }

        if (ctx.FLOATN() != null) {
            return new LiteralNode(Double.parseDouble(text), "FLOAT");
        }

        if (ctx.TRUE() != null || ctx.FALSE() != null) {
            return new LiteralNode(Boolean.parseBoolean(text), "BOOLEAN");
        }

        if (ctx.NULL() != null) {
            return new LiteralNode(null, "NULL");
        }

        return null;
    }
    // =================================================
    // GROUP BY CLAUSE
    // =================================================

    private GroupByClauseNode buildGroupByClause(SQLParser.GroupByClauseContext ctx) {
        List<ExpressionNode> groupByExpressions = new ArrayList<>();

        for (SQLParser.GroupByItemContext item : ctx.groupByItem()) {
            groupByExpressions.add((ExpressionNode) visit(item.expression()));
        }

        return new GroupByClauseNode(groupByExpressions);
    }

    // =================================================
    // HAVING CLAUSE
    // =================================================

    private HavingClauseNode buildHavingClause(SQLParser.HavingClauseContext ctx) {
        ExpressionNode condition = (ExpressionNode) visit(ctx.searchCondition());
        return new HavingClauseNode(condition);
    }
    // =================================================
    // AGGREGATE FUNCTIONS
    // =================================================

    @Override
    public ASTNode visitAggregateFunction(SQLParser.AggregateFunctionContext ctx) {
        // Determine the aggregate type
        AggregateFunctionNode.AggregateType type;
        if (ctx.COUNT() != null) {
            type = AggregateFunctionNode.AggregateType.COUNT;
        } else if (ctx.SUM() != null) {
            type = AggregateFunctionNode.AggregateType.SUM;
        } else if (ctx.AVG() != null) {
            type = AggregateFunctionNode.AggregateType.AVG;
        } else if (ctx.MIN() != null) {
            type = AggregateFunctionNode.AggregateType.MIN;
        } else if (ctx.MAX() != null) {
            type = AggregateFunctionNode.AggregateType.MAX;
        } else {
            throw new RuntimeException("Unknown aggregate function");
        }

        // Check for DISTINCT
        boolean distinct = ctx.DISTINCT() != null;

        // Get the argument (expression or *)
        ExpressionNode argument = null;
        if (ctx.expression() != null) {
            argument = (ExpressionNode) visit(ctx.expression());
        } else if (ctx.STAR() != null) {
            // For COUNT(*), we can use a special marker or null
            argument = new ColumnNode("*");
        }

        return new AggregateFunctionNode(type, argument, distinct, null);
    }
    // =================================================
    // ORDER BY CLAUSE
    // =================================================

    private OrderByClauseNode buildOrderByClause(SQLParser.OrderByClauseContext ctx) {
        List<OrderByClauseNode.SortItem> sortItems = new ArrayList<>();

        for (SQLParser.OrderByExpressionContext item : ctx.orderByExpression()) {
            ExpressionNode expression = (ExpressionNode) visit(item.expression());

            // Determine sort direction
            OrderByClauseNode.SortDirection direction = OrderByClauseNode.SortDirection.ASC;
            if (item.DESC() != null) {
                direction = OrderByClauseNode.SortDirection.DESC;
            }

            sortItems.add(new OrderByClauseNode.SortItem(expression, direction));
        }

        return new OrderByClauseNode(sortItems);
    }

}