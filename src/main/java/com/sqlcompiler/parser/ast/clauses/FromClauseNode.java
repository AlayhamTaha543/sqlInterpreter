package com.sqlcompiler.parser.ast.clauses;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;
import java.util.ArrayList;
import java.util.List;

public class FromClauseNode extends ASTNode {
    
    public static class TableSource {
        public final ExpressionNode source; // Could be TableNode, SubqueryNode, etc.
        public final String alias;
        public final List<JoinClauseNode> joins; // Joins on this table
        
        public TableSource(ExpressionNode source, String alias, List<JoinClauseNode> joins) {
            this.source = source;
            this.alias = alias;
            this.joins = joins != null ? new ArrayList<>(joins) : new ArrayList<>();
        }
        
        public TableSource(ExpressionNode source, String alias) {
            this(source, alias, null);
        }
        
        public TableSource(ExpressionNode source) {
            this(source, null, null);
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(source.toString());
            if (alias != null && !alias.isEmpty()) {
                sb.append(" AS ").append(alias);
            }
            return sb.toString();
        }
    }
    
    public final List<TableSource> tableSources;
    public final boolean isLateral; // For LATERAL joins
    
    public FromClauseNode(List<TableSource> tableSources, boolean isLateral) {
        this.tableSources = tableSources != null ? new ArrayList<>(tableSources) : new ArrayList<>();
        this.isLateral = isLateral;
    }
    
    public FromClauseNode(List<TableSource> tableSources) {
        this(tableSources, false);
    }
    
    public FromClauseNode(ExpressionNode table, String alias) {
        this(new ArrayList<>(), false);
        this.tableSources.add(new TableSource(table, alias));
    }
    
    public FromClauseNode(ExpressionNode table) {
        this(table, null);
    }
    
    // Get first table source
    public TableSource getFirstTable() {
        return !tableSources.isEmpty() ? tableSources.get(0) : null;
    }
    
    // Check if multiple tables
    public boolean hasMultipleTables() {
        return tableSources.size() > 1;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        // Typically visited through SelectStatementNode
        return null;
    }
    
    @Override
    public String toString() {
        if (tableSources.isEmpty()) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder("FROM ");
        if (isLateral) {
            sb.append("LATERAL ");
        }
        
        for (int i = 0; i < tableSources.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(tableSources.get(i));
        }
        
        return sb.toString();
    }
}
