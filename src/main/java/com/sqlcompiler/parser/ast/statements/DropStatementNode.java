package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.other.DropDatabaseNode;
import com.sqlcompiler.parser.ast.other.DropTableNode;

public class DropStatementNode extends ASTNode {
    public final DropTableNode dropTable;
    public final DropDatabaseNode dropDatabase;

    public DropStatementNode(
        DropTableNode dropTable, 
        DropDatabaseNode dropDatabase
    ) {
        this.dropTable = dropTable;
        this.dropDatabase = dropDatabase;
    }
   

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}