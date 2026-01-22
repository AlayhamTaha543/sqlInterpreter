package com.sqlcompiler.parser.ast.expressions;


import com.sqlcompiler.parser.ast.ASTVisitor;

public class BinaryExpressionNode extends ExpressionNode {
    public final ExpressionNode left;
    public final String operator; // =, <>, <, >, <=, >=, AND, OR, LIKE, IN
    public final ExpressionNode right;
    
    public BinaryExpressionNode(ExpressionNode left, String operator, ExpressionNode right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return left + " " + operator + " " + right;
    }
    
}