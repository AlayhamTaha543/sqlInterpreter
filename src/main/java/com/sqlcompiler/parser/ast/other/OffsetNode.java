package com.sqlcompiler.parser.ast.other;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;

public class OffsetNode extends ASTNode {
    public final ExpressionNode offsetValue;
    public final boolean useFetchSyntax; // true for OFFSET ... ROWS, false for OFFSET
    
    public OffsetNode(ExpressionNode offsetValue, boolean useFetchSyntax) {
        this.offsetValue = offsetValue;
        this.useFetchSyntax = useFetchSyntax;
    }
    
    public OffsetNode(ExpressionNode offsetValue) {
        this(offsetValue, false);
    }
    
    // Check if offset is set
    public boolean isSet() {
        return offsetValue != null;
    }
    
    // Get offset as integer (if possible)
    public Integer getOffsetAsInteger() {
        if (offsetValue == null) {
            return null;
        }
        
        try {
            String value = offsetValue.toString();
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
        
        if (useFetchSyntax) {
            return "OFFSET " + offsetValue + " ROWS";
        } else {
            return "OFFSET " + offsetValue;
        }
    }
    
    // Combined LIMIT and OFFSET string
    public String toCombinedString(LimitNode limitNode) {
        if (!isSet() && (limitNode == null || !limitNode.isSet())) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        if (isSet()) {
            sb.append("OFFSET ").append(offsetValue);
            if (useFetchSyntax) {
                sb.append(" ROWS");
            }
        }
        
        if (limitNode != null && limitNode.isSet()) {
            if (isSet()) {
                sb.append(" ");
            }
            
            if (useFetchSyntax || limitNode.isRowCount == false) {
                // Use FETCH FIRST syntax
                sb.append("FETCH FIRST ").append(limitNode.limitValue).append(" ROWS");
                if (limitNode.withTies) {
                    sb.append(" WITH TIES");
                }
            } else {
                // Use LIMIT syntax
                sb.append("LIMIT ").append(limitNode.limitValue);
                if (limitNode.withTies) {
                    sb.append(" WITH TIES");
                }
            }
        }
        
        return sb.toString();
    }
}