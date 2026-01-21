package com.sqlcompiler.parser.ast.clauses;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;
import java.util.ArrayList;
import java.util.List;

public class SelectClauseNode extends ASTNode {
    
    public static class SelectItem {
        public final ExpressionNode expression;
        public final String alias;
        public final boolean allColumns; // true for "*"
        
        public SelectItem(ExpressionNode expression, String alias) {
            this.expression = expression;
            this.alias = alias;
            this.allColumns = false;
        }
        
        public SelectItem(ExpressionNode expression) {
            this(expression, null);
        }
        
        // Constructor for wildcard (*)
        public SelectItem(String tableName) {
            this.expression = null;
            this.alias = null;
            this.allColumns = true;
        }
        
        @Override
        public String toString() {
            if (allColumns) {
                return "*";
            }
            String result = expression != null ? expression.toString() : "";
            if (alias != null && !alias.isEmpty()) {
                result += " AS " + alias;
            }
            return result;
        }
    }
    
    // Properties
    public final boolean distinct;
    public final boolean distinctRow; // DISTINCTROW
    public final List<SelectItem> selectItems;
    public final ExpressionNode top; // TOP clause (e.g., TOP 10)
    public final boolean topPercent; // TOP 10 PERCENT
    public final boolean withTies; // WITH TIES
    
    // Constructor with all options
    public SelectClauseNode(boolean distinct, boolean distinctRow, 
                           List<SelectItem> selectItems, ExpressionNode top,
                           boolean topPercent, boolean withTies) {
        this.distinct = distinct;
        this.distinctRow = distinctRow;
        this.selectItems = selectItems != null ? new ArrayList<>(selectItems) : new ArrayList<>();
        this.top = top;
        this.topPercent = topPercent;
        this.withTies = withTies;
    }
    
    // Simplified constructors
    public SelectClauseNode(List<SelectItem> selectItems) {
        this(false, false, selectItems, null, false, false);
    }
    
    public SelectClauseNode(boolean distinct, List<SelectItem> selectItems) {
        this(distinct, false, selectItems, null, false, false);
    }
    
    public SelectClauseNode(ExpressionNode top, boolean topPercent, 
                           boolean withTies, List<SelectItem> selectItems) {
        this(false, false, selectItems, top, topPercent, withTies);
    }
    
    // Factory method for wildcard select
    public static SelectClauseNode createWildcardSelect(boolean distinct) {
        List<SelectItem> items = new ArrayList<>();
        items.add(new SelectItem((String) null)); // wildcard
        return new SelectClauseNode(distinct, items);
    }
    
    // Check if it's a simple wildcard select
    public boolean isWildcardSelect() {
        return selectItems.size() == 1 && selectItems.get(0).allColumns;
    }
    
    // Check if select is empty
    public boolean isEmpty() {
        return selectItems.isEmpty();
    }
    
    // Get aliases for all select items that have aliases
    public List<String> getAliases() {
        List<String> aliases = new ArrayList<>();
        for (SelectItem item : selectItems) {
            if (item.alias != null && !item.alias.isEmpty()) {
                aliases.add(item.alias);
            }
        }
        return aliases;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        // Note: Typically SELECT clause is visited through SelectStatementNode
        // but if you need direct visitation:
        return null; // أو يمكنك إضافة visit method في الـ visitor
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SELECT ");
        
        // Add TOP clause if exists
        if (top != null) {
            sb.append("TOP ");
            sb.append(top);
            if (topPercent) {
                sb.append(" PERCENT");
            }
            if (withTies) {
                sb.append(" WITH TIES");
            }
            sb.append(" ");
        }
        
        // Add DISTINCT/DISTINCTROW
        if (distinct) {
            sb.append("DISTINCT ");
        } else if (distinctRow) {
            sb.append("DISTINCTROW ");
        }
        
        // Add select items
        for (int i = 0; i < selectItems.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(selectItems.get(i));
        }
        
        return sb.toString();
    }
}