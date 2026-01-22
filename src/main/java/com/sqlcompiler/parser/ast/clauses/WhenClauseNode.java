package com.sqlcompiler.parser.ast.clauses;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;
import java.util.ArrayList;
import java.util.List;

public class WhenClauseNode extends ASTNode {
    public final ExpressionNode whenCondition;
    public final ExpressionNode thenExpression;
    
    public WhenClauseNode(ExpressionNode whenCondition, ExpressionNode thenExpression) {
        this.whenCondition = whenCondition;
        this.thenExpression = thenExpression;
    }
    
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (whenCondition != null) {
            children.add(whenCondition);
        }
        if (thenExpression != null) {
            children.add(thenExpression);
        }
        return children;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "WHEN " + whenCondition + " THEN " + thenExpression;
    }
}