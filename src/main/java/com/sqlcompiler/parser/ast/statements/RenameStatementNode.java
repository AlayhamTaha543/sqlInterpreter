package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import java.util.ArrayList;
import java.util.List;

public class RenameStatementNode extends ASTNode {
    public final List<RenameItemNode> renameItems;
    
    public RenameStatementNode(List<RenameItemNode> renameItems) {
        this.renameItems = renameItems != null ? new ArrayList<>(renameItems) : new ArrayList<>();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    public List<ASTNode> getChildren() {
        return new ArrayList<>(renameItems);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RENAME TABLE ");
        for (int i = 0; i < renameItems.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(renameItems.get(i));
        }
        return sb.toString();
    }
}