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

        SQLParser.QuerySpecificationContext qs =
                extractQuerySpecification(ctx.queryExpression());

        if (qs == null) {
            throw new RuntimeException(
                "Only simple SELECT queries are supported (no UNION yet)."
            );
        }

        SelectClauseNode selectClause = buildSelectClause(qs.selectList());
        FromClauseNode fromClause = buildFromClause(qs.fromClause());
        WhereClauseNode whereClause =
                qs.whereClause() != null ? buildWhereClause(qs.whereClause()) : null;

        return new SelectStatementNode(
                selectClause,
                fromClause,
                whereClause,
                null, null, null, null, null, null
        );
    }

    private SQLParser.QuerySpecificationContext extractQuerySpecification(
            SQLParser.QueryExpressionContext ctx) {

        // If this queryExpression contains one or more QuerySpecification children,
        // return the first one (handles set operators like UNION/EXCEPT/INTERSECT).
        if (ctx.querySpecification() != null && ctx.querySpecification().size() > 0) {
            return ctx.querySpecification(0);
        }

        // Otherwise this is a parenthesized queryExpression: recurse into it.
        if (ctx.queryExpression() != null) {
            return extractQuerySpecification(ctx.queryExpression());
        }

        return null;
    }

    // =================================================
    // WHERE / SEARCH CONDITION
    // =================================================

    private WhereClauseNode buildWhereClause(SQLParser.WhereClauseContext ctx) {
        ExpressionNode condition =
                (ExpressionNode) visit(ctx.searchCondition());
        return new WhereClauseNode(condition);
    }

    @Override
    public ASTNode visitSearchCondition(SQLParser.SearchConditionContext ctx) {

        // AND / OR
        if (ctx.searchCondition().size() == 2) {
            ExpressionNode left =
                    (ExpressionNode) visit(ctx.searchCondition(0));
            ExpressionNode right =
                    (ExpressionNode) visit(ctx.searchCondition(1));

            String op = ctx.AND() != null ? "AND" : "OR";
            return new BinaryExpressionNode(left, op, right);
        }

        // NOT
        if (ctx.NOT() != null) {
            ExpressionNode expr =
                    (ExpressionNode) visit(ctx.searchCondition(0));
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
            ExpressionNode left =
                    (ExpressionNode) visit(ctx.expression(0));
            ExpressionNode right =
                    (ExpressionNode) visit(ctx.expression(1));
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

        boolean distinct =
            ctx.getParent() instanceof SQLParser.QuerySpecificationContext
            && ((SQLParser.QuerySpecificationContext) ctx.getParent())
                    .distinctClause() != null;

        List<SelectClauseNode.SelectItem> items = new ArrayList<>();

        // SELECT *
        if (ctx.STAR() != null) {
            items.add(
                new SelectClauseNode.SelectItem(
                    new ColumnNode("*"),
                    null
                )
            );
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

            String alias =
                e.columnAlias() != null ? e.columnAlias().getText() : null;

            items.add(new SelectClauseNode.SelectItem(expr, alias));
        }

        return new SelectClauseNode(distinct, items);
    }

    // =================================================
    // FROM CLAUSE
    // =================================================

    private FromClauseNode buildFromClause(SQLParser.FromClauseContext ctx) {
        if (ctx == null) return null;

        List<FromClauseNode.TableSource> tables = new ArrayList<>();

        for (SQLParser.TableSourceContext ts : ctx.tableSource()) {
            String name =
                    ts.tableSourceItem().tableName().getText();
            String alias =
                    ts.tableSourceItem().tableAlias() != null
                            ? ts.tableSourceItem().tableAlias().getText()
                            : null;

            tables.add(
                new FromClauseNode.TableSource(
                    new TableNode(name),
                    alias
                )
            );
        }

        return new FromClauseNode(tables);
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
            ExpressionNode left =
                    (ExpressionNode) visit(ctx.expression(0));
            ExpressionNode right =
                    (ExpressionNode) visit(ctx.expression(1));
            String op = ctx.getChild(1).getText();
            return new BinaryExpressionNode(left, op, right);
        }

        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitColumnReference(SQLParser.ColumnReferenceContext ctx) {
        String column = ctx.columnName().getText();
        String table =
                ctx.tableName() != null ? ctx.tableName().getText() : null;
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
                    "STRING"
            );
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
}
