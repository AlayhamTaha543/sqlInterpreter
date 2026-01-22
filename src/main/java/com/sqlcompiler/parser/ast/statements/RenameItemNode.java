package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import java.util.ArrayList;
import java.util.List;

public class RenameItemNode extends ASTNode {
    public final String oldName;
    public final String newName;
    
    public RenameItemNode(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
  
    public List<ASTNode> getChildren() {
        return new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return oldName + " TO " + newName;
    }
}