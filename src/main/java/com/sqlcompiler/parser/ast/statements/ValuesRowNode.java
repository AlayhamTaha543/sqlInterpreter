package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single row of values in a VALUES clause
 * 
 * (value1, value2, value3, ...)
 */
public class ValuesRowNode extends ASTNode {
    
    public final List<ExpressionNode> values;  // List of value expressions
    
    public ValuesRowNode(List<ExpressionNode> values) {
        this.values = values != null ? new ArrayList<>(values) : new ArrayList<>();
    }
    
    public ValuesRowNode() {
        this(new ArrayList<>());
    }
    
    public boolean isEmpty() {
        return values == null || values.isEmpty();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(values.get(i));
        }
        
        sb.append(")");
        return sb.toString();
    }
}

