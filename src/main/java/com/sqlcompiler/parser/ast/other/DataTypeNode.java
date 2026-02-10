package com.sqlcompiler.parser.ast.other;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;

/**
 * Represents a SQL data type
 * 
 * Examples: INT, VARCHAR(50), DECIMAL(10,2), etc.
 */
public class DataTypeNode extends ASTNode {
    
    public final String typeName;      // e.g., "INT", "VARCHAR", "DECIMAL"
    public final Integer precision;    // For types like VARCHAR(50) or DECIMAL(10,2)
    public final Integer scale;        // For types like DECIMAL(10,2)
    
    public DataTypeNode(String typeName, Integer precision, Integer scale) {
        this.typeName = typeName;
        this.precision = precision;
        this.scale = scale;
    }
    
    public DataTypeNode(String typeName, Integer precision) {
        this(typeName, precision, null);
    }
    
    public DataTypeNode(String typeName) {
        this(typeName, null, null);
    }
    
    public boolean hasPrecision() {
        return precision != null;
    }
    
    public boolean hasScale() {
        return scale != null;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(typeName);
        
        if (hasPrecision()) {
            sb.append("(").append(precision);
            if (hasScale()) {
                sb.append(",").append(scale);
            }
            sb.append(")");
        }
        
        return sb.toString();
    }
}

