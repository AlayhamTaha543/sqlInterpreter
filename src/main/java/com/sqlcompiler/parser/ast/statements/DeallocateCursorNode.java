package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;

public class DeallocateCursorNode extends ASTNode {
    
    public final String cursorName;
    public final boolean global;
    
    public DeallocateCursorNode(String cursorName, boolean global) {
        this.cursorName = cursorName;
        this.global = global;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "DEALLOCATE " + (global ? "GLOBAL " : "") + cursorName;
    }
}