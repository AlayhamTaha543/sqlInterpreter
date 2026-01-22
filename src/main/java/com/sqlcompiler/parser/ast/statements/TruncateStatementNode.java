package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;


public class TruncateStatementNode extends ASTNode {
    public final String tableName;
    public final String option; // e.g., "RESTART IDENTITY"

    public TruncateStatementNode(String tableName, String option) {
        this.tableName = tableName;
        this.option = option;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}