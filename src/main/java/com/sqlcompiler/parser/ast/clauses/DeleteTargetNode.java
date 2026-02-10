package com.sqlcompiler.parser.ast.clauses;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import java.util.List;

public class DeleteTargetNode extends ASTNode {
    public final List<DeleteTargetItemNode> items;

    public DeleteTargetNode(List<DeleteTargetItemNode> items) {
        this.items = items;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}