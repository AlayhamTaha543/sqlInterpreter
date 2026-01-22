package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

public class DeclareCursorNode extends ASTNode {
    
    public final String cursorName;
    public final List<String> options;           // LOCAL, GLOBAL, SCROLL, etc.
    public final SelectStatementNode query;
    public final boolean readOnly;
    public final List<String> updateColumns;     // FOR UPDATE OF columns
    
    public DeclareCursorNode(String cursorName, List<String> options, 
                            SelectStatementNode query, boolean readOnly,
                            List<String> updateColumns) {
        this.cursorName = cursorName;
        this.options = options != null ? new ArrayList<>(options) : new ArrayList<>();
        this.query = query;
        this.readOnly = readOnly;
        this.updateColumns = updateColumns != null ? 
                            new ArrayList<>(updateColumns) : new ArrayList<>();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "DECLARE " + cursorName + " CURSOR";
    }
}