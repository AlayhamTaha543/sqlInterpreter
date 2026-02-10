package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.clauses.FromClauseNode;
import com.sqlcompiler.parser.ast.clauses.WhereClauseNode;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an UPDATE statement
 * 
 * UPDATE table_name
 * SET column1 = value1, column2 = value2
 * FROM other_tables
 * WHERE condition
 */
public class UpdateStatementNode extends ASTNode {
    
    /**
     * Represents a single SET assignment: column = expression
     */
    public static class SetAssignment {
        public final ExpressionNode target;      // Column being updated
        public final String operator;            // =, +=, -=, etc.
        public final ExpressionNode value;       // New value expression
        
        public SetAssignment(ExpressionNode target, String operator, ExpressionNode value) {
            this.target = target;
            this.operator = operator;
            this.value = value;
        }
        
        public SetAssignment(ExpressionNode target, ExpressionNode value) {
            this(target, "=", value);
        }
        
        @Override
        public String toString() {
            return target + " " + operator + " " + value;
        }
    }
    
    // Core components
    public final ExpressionNode targetTable;           // Table to update (can be TableNode or variable)
    public final List<SetAssignment> setAssignments;   // SET clause assignments
    public final FromClauseNode fromClause;            // Optional FROM clause (for joins)
    public final WhereClauseNode whereClause;          // Optional WHERE clause
    
    // Optional components (from your grammar)
    public final ExpressionNode topExpression;         // TOP(n) or TOP n
    public final boolean topPercent;                   // TOP n PERCENT
    public final boolean topWithTies;                  // TOP n WITH TIES
    
    public UpdateStatementNode(
            ExpressionNode targetTable,
            List<SetAssignment> setAssignments,
            FromClauseNode fromClause,
            WhereClauseNode whereClause,
            ExpressionNode topExpression,
            boolean topPercent,
            boolean topWithTies) {
        
        this.targetTable = targetTable;
        this.setAssignments = setAssignments != null ? 
                             new ArrayList<>(setAssignments) : new ArrayList<>();
        this.fromClause = fromClause;
        this.whereClause = whereClause;
        this.topExpression = topExpression;
        this.topPercent = topPercent;
        this.topWithTies = topWithTies;
    }
    
    // Simplified constructor (most common case)
    public UpdateStatementNode(
            ExpressionNode targetTable,
            List<SetAssignment> setAssignments,
            WhereClauseNode whereClause) {
        this(targetTable, setAssignments, null, whereClause, null, false, false);
    }
    
    // Basic constructor
    public UpdateStatementNode(
            ExpressionNode targetTable,
            List<SetAssignment> setAssignments) {
        this(targetTable, setAssignments, null, null, null, false, false);
    }
    
    public boolean hasFromClause() {
        return fromClause != null;
    }
    
    public boolean hasWhereClause() {
        return whereClause != null;
    }
    
    public boolean hasTopClause() {
        return topExpression != null;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UPDATE ");
        
        // TOP clause
        if (topExpression != null) {
            sb.append("TOP (").append(topExpression).append(")");
            if (topPercent) sb.append(" PERCENT");
            if (topWithTies) sb.append(" WITH TIES");
            sb.append(" ");
        }
        
        // Target table
        sb.append(targetTable);
        
        // SET clause
        sb.append(" SET ");
        for (int i = 0; i < setAssignments.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(setAssignments.get(i));
        }
        
        // FROM clause
        if (fromClause != null) {
            sb.append(" ").append(fromClause);
        }
        
        // WHERE clause
        if (whereClause != null) {
            sb.append(" ").append(whereClause);
        }
        
        return sb.toString();
    }
}