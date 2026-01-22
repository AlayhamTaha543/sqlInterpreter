package com.sqlcompiler.parser.ast.clauses;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.statements.SelectStatementNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single CTE (Common Table Expression)
 * 
 * WITH cte_name (col1, col2) AS (
 *   SELECT ...
 * )
 */
public class CTENode extends ASTNode {
    
    public final String name;
    public final List<String> columnAliases;
    public final SelectStatementNode query;
    
    public CTENode(String name, List<String> columnAliases, SelectStatementNode query) {
        this.name = name;
        this.columnAliases = columnAliases != null ? 
                            new ArrayList<>(columnAliases) : new ArrayList<>();
        this.query = query;
    }
    
    public CTENode(String name, SelectStatementNode query) {
        this(name, null, query);
    }
    
    public boolean hasColumnAliases() {
        return columnAliases != null && !columnAliases.isEmpty();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        
        if (hasColumnAliases()) {
            sb.append(" (");
            for (int i = 0; i < columnAliases.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(columnAliases.get(i));
            }
            sb.append(")");
        }
        
        sb.append(" AS (...)");
        return sb.toString();
    }
}