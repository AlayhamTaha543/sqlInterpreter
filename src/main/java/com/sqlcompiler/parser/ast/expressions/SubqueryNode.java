package com.sqlcompiler.parser.ast.expressions;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;

public class SubqueryNode extends ExpressionNode {
    public final ASTNode query; // يمكن أن يكون SELECT, INSERT, UPDATE, DELETE
    public final String alias;
    
    public SubqueryNode(ASTNode query, String alias) {
        this.query = query;
        this.alias = alias;
    }
    
    public SubqueryNode(ASTNode query) {
        this(query, null);
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        String result = "(" + query.toString() + ")";
        if (alias != null && !alias.isEmpty()) {
            result += " AS " + alias;
        }
        return result;
    }
}