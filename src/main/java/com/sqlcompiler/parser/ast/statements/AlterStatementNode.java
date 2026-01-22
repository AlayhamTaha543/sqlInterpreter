package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;

/**
 * Represents an ALTER TABLE statement
 * ALTER TABLE table_name ADD column_definition
 * ALTER TABLE table_name DROP COLUMN column_name
 */
public class AlterStatementNode extends ASTNode {
    
    public enum AlterAction {
        ADD_COLUMN,
        DROP_COLUMN
    }
    
    /**
     * Represents a column definition for ADD COLUMN
     */
    public static class ColumnDefinition {
        public final String columnName;
        public final String dataType;
        public final String constraints;  // Can store constraints as string
        
        public ColumnDefinition(String columnName, String dataType, String constraints) {
            this.columnName = columnName;
            this.dataType = dataType;
            this.constraints = constraints;
        }
        
        public ColumnDefinition(String columnName, String dataType) {
            this(columnName, dataType, null);
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(columnName).append(" ").append(dataType);
            if (constraints != null && !constraints.isEmpty()) {
                sb.append(" ").append(constraints);
            }
            return sb.toString();
        }
    }
    
    public final ExpressionNode tableName;
    public final AlterAction action;
    public final ColumnDefinition columnDefinition;  // For ADD
    public final String dropColumnName;              // For DROP
    
    // Constructor for ADD COLUMN
    public AlterStatementNode(ExpressionNode tableName, ColumnDefinition columnDefinition) {
        this.tableName = tableName;
        this.action = AlterAction.ADD_COLUMN;
        this.columnDefinition = columnDefinition;
        this.dropColumnName = null;
    }
    
    // Constructor for DROP COLUMN
    public AlterStatementNode(ExpressionNode tableName, String dropColumnName) {
        this.tableName = tableName;
        this.action = AlterAction.DROP_COLUMN;
        this.columnDefinition = null;
        this.dropColumnName = dropColumnName;
    }
    
    public boolean isAddColumn() {
        return action == AlterAction.ADD_COLUMN;
    }
    
    public boolean isDropColumn() {
        return action == AlterAction.DROP_COLUMN;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ALTER TABLE ");
        sb.append(tableName);
        
        if (isAddColumn()) {
            sb.append(" ADD ").append(columnDefinition);
        } else if (isDropColumn()) {
            sb.append(" DROP COLUMN ").append(dropColumnName);
        }
        
        return sb.toString();
    }
}