package com.sqlcompiler.parser.ast.clauses;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;

public class DeleteTargetItemNode extends ASTNode {
    public final String database;
    public final String schema;
    public final String tableName;
    public final String alias;

    public DeleteTargetItemNode(String database, String schema, String tableName, String alias) {
        this.database = database;
        this.schema = schema;
        this.tableName = tableName;
        this.alias = alias;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (database != null) sb.append(database).append(".");
        if (schema != null) sb.append(schema).append(".");
        sb.append(tableName);
        if (alias != null) sb.append(" AS ").append(alias);
        return sb.toString();
    }
}