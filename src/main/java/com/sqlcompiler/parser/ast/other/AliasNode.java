package com.sqlcompiler.parser.ast.other;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;

public class AliasNode extends ASTNode {
    public final String alias;
    public final ExpressionNode expression; // Optional: the expression being aliased
    
    public AliasNode(String alias, ExpressionNode expression) {
        this.alias = alias;
        this.expression = expression;
    }
    
    public AliasNode(String alias) {
        this(alias, null);
    }
    
    // Check if alias is valid (not null and not empty)
    public boolean isValid() {
        return alias != null && !alias.trim().isEmpty();
    }
    
    // Factory method for creating alias with expression
    public static AliasNode of(String alias, ExpressionNode expression) {
        return new AliasNode(alias, expression);
    }
    
    // Factory method for creating alias without expression
    public static AliasNode of(String alias) {
        return new AliasNode(alias);
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        // Alias is typically visited as part of other nodes
        return null;
    }
    
    @Override
    public String toString() {
        if (expression != null) {
            return expression.toString() + " AS " + alias;
        }
        return alias;
    }
    
    // Convenience method to get alias with AS keyword
    public String toSqlString() {
        return "AS " + alias;
    }
}