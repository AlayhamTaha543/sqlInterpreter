package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;

import java.util.ArrayList;
import java.util.List;

public class FetchCursorNode extends ASTNode {
    
    public final String orientation;        // NEXT, PRIOR, FIRST, LAST, ABSOLUTE, RELATIVE
    public final ExpressionNode position;   // For ABSOLUTE/RELATIVE
    public final String cursorName;
    public final boolean global;
    public final List<String> intoVariables;
    
    public FetchCursorNode(String orientation, ExpressionNode position, 
                          String cursorName, boolean global, List<String> intoVariables) {
        this.orientation = orientation;
        this.position = position;
        this.cursorName = cursorName;
        this.global = global;
        this.intoVariables = intoVariables != null ? 
                            new ArrayList<>(intoVariables) : new ArrayList<>();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FETCH ");
        if (orientation != null) sb.append(orientation).append(" ");
        sb.append((global ? "GLOBAL " : "")).append(cursorName);
        if (!intoVariables.isEmpty()) {
            sb.append(" INTO ").append(String.join(", ", intoVariables));
        }
        return sb.toString();
    }
}