package com.sqlcompiler.parser.ast.other;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;

public class LimitNode extends ASTNode {
    public final ExpressionNode limitValue;
    public final boolean withTies; // For LIMIT ... WITH TIES
    public final boolean isRowCount; // true for LIMIT, false for FETCH FIRST
    
    public LimitNode(ExpressionNode limitValue, boolean withTies, boolean isRowCount) {
        this.limitValue = limitValue;
        this.withTies = withTies;
        this.isRowCount = isRowCount;
    }
    
    // Constructor for standard LIMIT clause
    public LimitNode(ExpressionNode limitValue) {
        this(limitValue, false, true);
    }
    
    // Constructor for LIMIT with WITH TIES
    public LimitNode(ExpressionNode limitValue, boolean withTies) {
        this(limitValue, withTies, true);
    }
    
    // Factory method for FETCH FIRST
    public static LimitNode fetchFirst(ExpressionNode rowCount, boolean withTies) {
        return new LimitNode(rowCount, withTies, false);
    }
    
    // Factory method for standard LIMIT
    public static LimitNode limit(ExpressionNode rowCount) {
        return new LimitNode(rowCount);
    }
    
    // Check if limit is set
    public boolean isSet() {
        return limitValue != null;
    }
    
    // Get limit as integer (if possible)
    public Integer getLimitAsInteger() {
        if (limitValue == null) {
            return null;
        }
        
        try {
            String value = limitValue.toString();
            // Remove quotes if present
            value = value.replace("'", "").replace("\"", "");
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        // Typically visited through SelectStatementNode
        return null;
    }
    
    @Override
    public String toString() {
        if (!isSet()) {
            return "";
        }
        
        if (isRowCount) {
            StringBuilder sb = new StringBuilder("LIMIT ");
            sb.append(limitValue);
            if (withTies) {
                sb.append(" WITH TIES");
            }
            return sb.toString();
        } else {
            // FETCH FIRST syntax
            StringBuilder sb = new StringBuilder("FETCH FIRST ");
            sb.append(limitValue).append(" ROWS");
            if (withTies) {
                sb.append(" WITH TIES");
            }
            return sb.toString();
        }
    }
    
    // Alternative SQL syntax (for different database dialects)
    public String toSqlString(boolean useFetchSyntax) {
        if (!isSet()) {
            return "";
        }
        
        if (useFetchSyntax) {
            return "FETCH FIRST " + limitValue + " ROWS" + (withTies ? " WITH TIES" : "");
        } else {
            return "LIMIT " + limitValue + (withTies ? " WITH TIES" : "");
        }
    }
}