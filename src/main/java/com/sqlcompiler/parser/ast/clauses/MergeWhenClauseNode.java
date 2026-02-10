package com.sqlcompiler.parser.ast.clauses;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;
import com.sqlcompiler.parser.ast.statements.UpdateStatementNode;

import java.util.List;

public class MergeWhenClauseNode extends ASTNode {
    public enum MergeType {
        MATCHED, NOT_MATCHED
    }

    public enum ActionType {
        UPDATE, DELETE, INSERT
    }

    public final MergeType mergeType;
    public final ExpressionNode condition; // Optional AND searchCondition
    public final ActionType actionType;

    // For Update Action
    public final List<UpdateStatementNode.SetAssignment> assignments;
    // For Insert Action
    public final List<String> insertColumns;
    public final List<ExpressionNode> insertValues;

    public MergeWhenClauseNode(MergeType mergeType, ExpressionNode condition, ActionType actionType,
            List<UpdateStatementNode.SetAssignment> assignments,
            List<String> insertColumns, List<ExpressionNode> insertValues) {
        this.mergeType = mergeType;
        this.condition = condition;
        this.actionType = actionType;
        this.assignments = assignments;
        this.insertColumns = insertColumns;
        this.insertValues = insertValues;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}