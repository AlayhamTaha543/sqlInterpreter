package com.sqlcompiler.parser.ast.clauses;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;
import java.util.ArrayList;
import java.util.List;

public class OrderByClauseNode extends ASTNode {
    
    public enum SortDirection {
        ASC("ASC"),
        DESC("DESC");
        
        private final String sql;
        
        SortDirection(String sql) {
            this.sql = sql;
        }
        
        @Override
        public String toString() {
            return sql;
        }
    }
    
    public static class SortItem {
        public final ExpressionNode expression;
        public final SortDirection direction;
        public final String collation; // Optional collation
        public final boolean nullsFirst; // NULLS FIRST
        public final boolean nullsLast;  // NULLS LAST
        
        public SortItem(ExpressionNode expression, SortDirection direction, 
                       String collation, boolean nullsFirst, boolean nullsLast) {
            this.expression = expression;
            this.direction = direction;
            this.collation = collation;
            this.nullsFirst = nullsFirst;
            this.nullsLast = nullsLast;
        }
        
        public SortItem(ExpressionNode expression, SortDirection direction) {
            this(expression, direction, null, false, false);
        }
        
        public SortItem(ExpressionNode expression) {
            this(expression, SortDirection.ASC);
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(expression.toString());
            
            if (direction != null && direction != SortDirection.ASC) {
                sb.append(" ").append(direction);
            }
            
            if (collation != null && !collation.isEmpty()) {
                sb.append(" COLLATE ").append(collation);
            }
            
            if (nullsFirst) {
                sb.append(" NULLS FIRST");
            } else if (nullsLast) {
                sb.append(" NULLS LAST");
            }
            
            return sb.toString();
        }
    }
    
    public final List<SortItem> sortItems;
    
    public OrderByClauseNode(List<SortItem> sortItems) {
        this.sortItems = sortItems != null ? new ArrayList<>(sortItems) : new ArrayList<>();
    }
    
    public OrderByClauseNode(ExpressionNode expression, SortDirection direction) {
        this(new ArrayList<>());
        this.sortItems.add(new SortItem(expression, direction));
    }
    
    public OrderByClauseNode(ExpressionNode expression) {
        this(expression, SortDirection.ASC);
    }
    
    public boolean isEmpty() {
        return sortItems.isEmpty();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        // Typically visited through SelectStatementNode
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder("ORDER BY ");
        for (int i = 0; i < sortItems.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(sortItems.get(i));
        }
        
        return sb.toString();
    }
}
