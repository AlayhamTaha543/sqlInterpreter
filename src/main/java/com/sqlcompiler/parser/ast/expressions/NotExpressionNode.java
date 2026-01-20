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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }

    @Override
    public String toString() {
        return "NOT";
    }

}
