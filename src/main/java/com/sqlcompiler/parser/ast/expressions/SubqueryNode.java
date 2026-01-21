package com.sqlcompiler.parser.ast.expressions;

import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.statements.SelectStatementNode;

/**
 * Represents a subquery that can be used in various contexts:
 * - FROM clause: FROM (SELECT ...) AS alias
 * - WHERE clause: WHERE id IN (SELECT ...)
 * - SELECT clause: SELECT (SELECT ...) AS col
 * - JOIN: JOIN (SELECT ...) ON ...
 */
public class SubqueryNode extends ExpressionNode {
    
    private final SelectStatementNode query;
    private final String alias;
    
    public SubqueryNode(SelectStatementNode query, String alias) {
        this.query = query;
        this.alias = alias;
    }
    
    public SubqueryNode(SelectStatementNode query) {
        this(query, null);
    }
    
    public SelectStatementNode getQuery() {
        return query;
    }
    
    public String getAlias() {
        return alias;
    }
    
    public boolean hasAlias() {
        return alias != null && !alias.isEmpty();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(query.toString());
        sb.append(")");
        
        if (hasAlias()) {
            sb.append(" AS ").append(alias);
        }
        
        return sb.toString();
    }
}