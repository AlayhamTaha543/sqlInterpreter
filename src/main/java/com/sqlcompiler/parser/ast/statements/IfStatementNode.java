package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;

public class IfStatementNode extends ASTNode {
    public final ExpressionNode condition;
    public final ASTNode thenStatement;
    public final ASTNode elseStatement; // Optional

    public IfStatementNode(ExpressionNode condition, ASTNode thenStatement, ASTNode elseStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}