package com.sqlcompiler.parser.ast.other;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import java.util.List;

public class DropTableNode extends ASTNode {
    public final List<String> tableNames;
    public final boolean ifExists;
    public final boolean isTemporary;
    public final String behavior;

    public DropTableNode(List<String> tableNames, boolean ifExists, boolean isTemporary, String behavior) {
        this.tableNames = tableNames;
        this.ifExists = ifExists;
        this.isTemporary = isTemporary;
        this.behavior = behavior;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}