package com.sqlcompiler.parser.ast.other;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a column definition in a CREATE TABLE statement
 * 
 * column_name data_type [attributes]
 */
public class ColumnDefinitionNode extends ASTNode {
    
    public final String columnName;
    public final DataTypeNode dataType;
    public final List<String> attributes;  // e.g., PRIMARY KEY, NOT NULL, etc.
    
    public ColumnDefinitionNode(String columnName, DataTypeNode dataType, List<String> attributes) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.attributes = attributes != null ? new ArrayList<>(attributes) : new ArrayList<>();
    }
    
    public ColumnDefinitionNode(String columnName, DataTypeNode dataType) {
        this(columnName, dataType, new ArrayList<>());
    }
    
    public boolean hasAttributes() {
        return attributes != null && !attributes.isEmpty();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(columnName);
        sb.append(" ").append(dataType);
        
        if (hasAttributes()) {
            sb.append(" ").append(String.join(" ", attributes));
        }
        
        return sb.toString();
    }
}

