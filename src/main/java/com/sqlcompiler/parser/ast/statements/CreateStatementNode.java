package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.TableNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a CREATE TABLE statement
 * 
 * CREATE TABLE table_name (
 *     column1 datatype,
 *     column2 datatype,
 *     ...
 * )
 */
public class CreateStatementNode extends ASTNode {
    
    public final TableNode table;              // Table being created
    public final List<ASTNode> tableElements;  // Column definitions and constraints
    
    public CreateStatementNode(TableNode table, List<ASTNode> tableElements) {
        this.table = table;
        this.tableElements = tableElements != null ? new ArrayList<>(tableElements) : new ArrayList<>();
    }
    
    public CreateStatementNode(TableNode table) {
        this(table, new ArrayList<>());
    }
    
    public boolean hasElements() {
        return tableElements != null && !tableElements.isEmpty();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        
        if (table != null) {
            sb.append(table.tableName);
        }
        
        if (hasElements()) {
            sb.append(" (");
            for (int i = 0; i < tableElements.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(tableElements.get(i));
            }
            sb.append(")");
        }
        
        return sb.toString();
    }
}

