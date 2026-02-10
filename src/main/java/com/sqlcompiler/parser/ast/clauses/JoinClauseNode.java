package com.sqlcompiler.parser.ast.clauses;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;

public class JoinClauseNode extends ASTNode {
    
    public enum JoinType {
        INNER("INNER JOIN"),
        LEFT("LEFT JOIN"),
        RIGHT("RIGHT JOIN"),
        FULL("FULL JOIN"),
        CROSS("CROSS JOIN"),
        NATURAL("NATURAL JOIN"),
        LEFT_OUTER("LEFT OUTER JOIN"),
        RIGHT_OUTER("RIGHT OUTER JOIN"),
        FULL_OUTER("FULL OUTER JOIN");
        
        private final String sql;
        
        JoinType(String sql) {
            this.sql = sql;
        }
        
        @Override
        public String toString() {
            return sql;
        }
    }
    
    public final JoinType joinType;
    public final ExpressionNode table; // Table, subquery, or another expression
    public final String alias;
    public final ExpressionNode condition; // ON clause or USING clause expression
    public final boolean isNatural;
    public final boolean isOuter;
    
    public JoinClauseNode(JoinType joinType, ExpressionNode table, String alias, 
                         ExpressionNode condition, boolean isNatural, boolean isOuter) {
        this.joinType = joinType;
        this.table = table;
        this.alias = alias;
        this.condition = condition;
        this.isNatural = isNatural;
        this.isOuter = isOuter;
    }
    
    // Simplified constructors
    public JoinClauseNode(JoinType joinType, ExpressionNode table, ExpressionNode condition) {
        this(joinType, table, null, condition, false, false);
    }
    
    public JoinClauseNode(ExpressionNode table, ExpressionNode condition) {
        this(JoinType.INNER, table, condition);
    }
    
    // Factory methods for common join types
    public static JoinClauseNode createInnerJoin(ExpressionNode table, ExpressionNode condition) {
        return new JoinClauseNode(JoinType.INNER, table, condition);
    }
    
    public static JoinClauseNode createLeftJoin(ExpressionNode table, ExpressionNode condition) {
        return new JoinClauseNode(JoinType.LEFT, table, condition);
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        // Typically visited through FromClauseNode or SelectStatementNode
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        if (isNatural) {
            sb.append("NATURAL ");
        }
        
        sb.append(joinType).append(" ");
        sb.append(table.toString());
        
        if (alias != null && !alias.isEmpty()) {
            sb.append(" AS ").append(alias);
        }
        
        if (condition != null && !isNatural) {
            sb.append(" ON ").append(condition.toString());
        }
        
        return sb.toString();
    }
}