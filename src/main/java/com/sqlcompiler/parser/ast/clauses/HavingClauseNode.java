package com.sqlcompiler.parser.ast.clauses;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;

public class HavingClauseNode extends ASTNode {
    public final ExpressionNode condition;
    
    public HavingClauseNode(ExpressionNode condition) {
        this.condition = condition;
    }
    
    public boolean isEmpty() {
        return condition == null;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        // Typically visited through SelectStatementNode
        return null;
    }
    
    @Override
    public String toString() {
        return condition != null ? "HAVING " + condition.toString() : "";
    }
}