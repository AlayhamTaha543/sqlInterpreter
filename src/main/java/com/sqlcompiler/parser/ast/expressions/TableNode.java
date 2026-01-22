package com.sqlcompiler.parser.ast.expressions;


import com.sqlcompiler.parser.ast.ASTVisitor;

public class TableNode extends ExpressionNode {
    public final String tableName;
    public final String alias;
    
    public TableNode(String tableName, String alias) {
        this.tableName = tableName;
        this.alias = alias;
    }
    
    public TableNode(String tableName) {
        this(tableName, null);
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return alias != null ? tableName + " AS " + alias : tableName;
    }
}
