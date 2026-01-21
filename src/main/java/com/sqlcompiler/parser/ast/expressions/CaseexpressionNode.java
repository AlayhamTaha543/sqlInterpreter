package com.sqlcompiler.parser.ast.expressions;
import com.sqlcompiler.parser.ast.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

public class CaseexpressionNode extends ExpressionNode {
    public static class WhenClause {
        public final ExpressionNode whenCondition;
        public final ExpressionNode thenExpression;
        
        public WhenClause(ExpressionNode whenCondition, ExpressionNode thenExpression) {
            this.whenCondition = whenCondition;
            this.thenExpression = thenExpression;
        }
        
        @Override
        public String toString() {
            return "WHEN " + whenCondition + " THEN " + thenExpression;
        }
    }
    
    public final ExpressionNode inputExpression; // Optional
    public final List<WhenClause> whenClauses;
    public final ExpressionNode elseExpression; // Optional
    
    public CaseexpressionNode(ExpressionNode inputExpression, 
                             List<WhenClause> whenClauses, 
                             ExpressionNode elseExpression) {
        this.inputExpression = inputExpression;
        this.whenClauses = whenClauses != null ? new ArrayList<>(whenClauses) : new ArrayList<>();
        this.elseExpression = elseExpression;
    }
    
    public CaseexpressionNode(List<WhenClause> whenClauses, ExpressionNode elseExpression) {
        this(null, whenClauses, elseExpression);
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CASE");
        
        if (inputExpression != null) {
            sb.append(" ").append(inputExpression);
        }
        
        for (WhenClause clause : whenClauses) {
            sb.append(" ").append(clause.toString());
        }
        
        if (elseExpression != null) {
            sb.append(" ELSE ").append(elseExpression);
        }
        
        sb.append(" END");
        return sb.toString();
    }
}