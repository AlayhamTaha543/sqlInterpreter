package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a VALUES clause in an INSERT statement
 * 
 * VALUES (value1, value2, ...), (value3, value4, ...)
 */
public class ValuesClauseNode extends ASTNode {
    
    public final List<ValuesRowNode> rows;     // List of value rows
    
    public ValuesClauseNode(List<ValuesRowNode> rows) {
        this.rows = rows != null ? new ArrayList<>(rows) : new ArrayList<>();
    }
    
    public ValuesClauseNode() {
        this(new ArrayList<>());
    }
    
    public boolean isEmpty() {
        return rows == null || rows.isEmpty();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VALUES ");
        
        for (int i = 0; i < rows.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(rows.get(i));
        }
        
        return sb.toString();
    }
}

