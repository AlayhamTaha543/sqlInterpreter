package com.sqlcompiler.parser.ast.other;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;

public class DropDatabaseNode extends ASTNode {
    public final String databaseName;
    public final boolean ifExists;

    public DropDatabaseNode(String databaseName, boolean ifExists) {
        this.databaseName = databaseName;
        this.ifExists = ifExists;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}