package com.sqlcompiler.parser.ast.expressions;

import com.sqlcompiler.parser.ast.ASTVisitor;

public class NotExpressionNode extends ExpressionNode {
    private final ExpressionNode expression;

    public NotExpressionNode(ExpressionNode expression) {
        this.expression = expression;
    }

    public ExpressionNode getExpression() {
        return expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        // You can implement this when you add support in ASTVisitor
        // For now, throw a descriptive exception
        throw new UnsupportedOperationException(
            "NotExpressionNode visitor not implemented. Add visit(NotExpressionNode) to ASTVisitor interface."
        );
    }

    @Override
    public String toString() {
        return "NOT (" + expression.toString() + ")";
    }
}