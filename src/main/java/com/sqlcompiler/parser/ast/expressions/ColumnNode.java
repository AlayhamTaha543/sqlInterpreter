package com.sqlcompiler.parser.ast.expressions;


import com.sqlcompiler.parser.ast.ASTVisitor;

public class ColumnNode extends ExpressionNode {
    public final String columnName;
    public final String tableName; // يمكن أن يكون null
    
    public ColumnNode(String columnName, String tableName) {
        this.columnName = columnName;
        this.tableName = tableName;
    }
    
    public ColumnNode(String columnName) {
        this(columnName, null);
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return tableName != null ? tableName + "." + columnName : columnName;
    }
}