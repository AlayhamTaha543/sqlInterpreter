package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.clauses.MergeWhenClauseNode;
import com.sqlcompiler.parser.ast.clauses.WithClauseNode;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;
import java.util.List;

public class MergeStatementNode extends ASTNode {
    public final WithClauseNode withClause;
    public final ExpressionNode targetTable;
    public final ExpressionNode sourceTable;
    public final ExpressionNode onCondition;
    public final List<MergeWhenClauseNode> whenClauses;

    public MergeStatementNode(WithClauseNode withClause, ExpressionNode target, ExpressionNode source, 
                                ExpressionNode onCondition, List<MergeWhenClauseNode> whenClauses) {
        this.withClause = withClause;
        this.targetTable = target;
        this.sourceTable = source;
        this.onCondition = onCondition;
        this.whenClauses = whenClauses;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}