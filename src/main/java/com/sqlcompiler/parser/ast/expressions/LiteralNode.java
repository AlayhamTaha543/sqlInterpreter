package com.sqlcompiler.parser.ast.expressions;


import com.sqlcompiler.parser.ast.ASTVisitor;

public class LiteralNode extends ExpressionNode {
    public final Object value;
    public final String type; // "STRING", "NUMBER", "BOOLEAN", "NULL", "DATE"
    
    public LiteralNode(Object value, String type) {
        this.value = value;
        this.type = type;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        if ("STRING".equals(type)) {
            return "'" + value + "'";
        }
        return String.valueOf(value);
    }
}
