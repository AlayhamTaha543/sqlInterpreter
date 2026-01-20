package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.clauses.*;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;
import java.util.ArrayList;
import java.util.List;

public class SelectStatementNode extends ASTNode {
    public final SelectClauseNode selectClause;
    public final FromClauseNode fromClause;
    public final WhereClauseNode whereClause;
    public final List<JoinClauseNode> joins;
    public final GroupByClauseNode groupByClause;
    public final HavingClauseNode havingClause;
    public final OrderByClauseNode orderByClause;
    public final ExpressionNode limit;
    public final ExpressionNode offset;
    
    public SelectStatementNode(
        SelectClauseNode selectClause,
        FromClauseNode fromClause,
        WhereClauseNode whereClause,
        List<JoinClauseNode> joins,
        GroupByClauseNode groupByClause,
        HavingClauseNode havingClause,
        OrderByClauseNode orderByClause,
        ExpressionNode limit,
        ExpressionNode offset
    ) {
        this.selectClause = selectClause;
        this.fromClause = fromClause;
        this.whereClause = whereClause;
        this.joins = joins != null ? joins : new ArrayList<>();
        this.groupByClause = groupByClause;
        this.havingClause = havingClause;
        this.orderByClause = orderByClause;
        this.limit = limit;
        this.offset = offset;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}