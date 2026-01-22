package com.sqlcompiler.parser.ast;

import com.sqlcompiler.parser.SQLParser;
import com.sqlcompiler.parser.SQLParserBaseVisitor;
import com.sqlcompiler.parser.ast.clauses.*;
import com.sqlcompiler.parser.ast.expressions.*;
import com.sqlcompiler.parser.ast.statements.SelectStatementNode;

import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends SQLParserBaseVisitor<ASTNode> {

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
        HavingClauseNode havingClause = qs.havingClause() != null ? buildHavingClause(qs.havingClause()) : null;
        SelectClauseNode selectClause = buildSelectClause(qs.selectList());
        FromClauseNode fromClause = buildFromClause(qs.fromClause());
        WhereClauseNode whereClause = qs.whereClause() != null ? buildWhereClause(qs.whereClause()) : null;

        return new SelectStatementNode(
                selectClause,
                fromClause,
                whereClause,
                null, null, havingClause, null, null, null);
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

        // Create the select statement
        SelectStatementNode subSelect = new SelectStatementNode(
                selectClause,
                fromClause,
                whereClause,
                null, null, havingClause, null, null, null);

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

    // private GroupByClauseNode buildGroupByClause(SQLParser.GroupByClauseContext ctx) {
    //     List<ExpressionNode> groupByExpressions = new ArrayList<>();

    //     for (SQLParser.ExpressionContext expr : ctx.expression()) {
    //         groupByExpressions.add((ExpressionNode) visit(expr));
    //     }

    //     return new GroupByClauseNode(groupByExpressions);
    // }

    // =================================================
    // HAVING CLAUSE
    // =================================================

    private HavingClauseNode buildHavingClause(SQLParser.HavingClauseContext ctx) {
        ExpressionNode condition = (ExpressionNode) visit(ctx.searchCondition());
        return new HavingClauseNode(condition);
    }

}