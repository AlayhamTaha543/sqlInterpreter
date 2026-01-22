package com.sqlcompiler.parser.ast.expressions;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.clauses.WhenClauseNode;
import java.util.ArrayList;
import java.util.List;

public class CaseexpressionNode extends ExpressionNode {
    public final ExpressionNode inputExpression; // Optional
    public final List<WhenClauseNode> whenClauses;
    public final ExpressionNode elseExpression; // Optional
    
    public CaseexpressionNode(ExpressionNode inputExpression,
                             List<WhenClauseNode> whenClauses,
                             ExpressionNode elseExpression) {
        this.inputExpression = inputExpression;
        this.whenClauses = whenClauses != null ? new ArrayList<>(whenClauses) : new ArrayList<>();
        this.elseExpression = elseExpression;
    }
    
    public CaseexpressionNode(List<WhenClauseNode> whenClauses, ExpressionNode elseExpression) {
        this(null, whenClauses, elseExpression);
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (inputExpression != null) {
            children.add(inputExpression);
        }
        children.addAll(whenClauses);
        if (elseExpression != null) {
            children.add(elseExpression);
        }
        return children;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CASE");
        
        if (inputExpression != null) {
            sb.append(" ").append(inputExpression);
        }
        
        for (WhenClauseNode clause : whenClauses) {
            sb.append(" ").append(clause.toString());
        }
        
        if (elseExpression != null) {
            sb.append(" ELSE ").append(elseExpression);
        }
        
        sb.append(" END");
        return sb.toString();
    }
}