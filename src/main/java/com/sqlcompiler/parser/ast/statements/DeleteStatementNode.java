package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.clauses.FromClauseNode;
import com.sqlcompiler.parser.ast.clauses.WhereClauseNode;
import com.sqlcompiler.parser.ast.clauses.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteStatementNode extends ASTNode {
    public final DeleteTargetNode target; 
    public final FromClauseNode fromClause;
    public final WhereClauseNode whereClause;
    public final Boolean hasFromKeyword;
    
    public DeleteStatementNode(
        DeleteTargetNode target,
        FromClauseNode fromClause,
        WhereClauseNode whereClause,
        Boolean hasFromKeyword
    ) {
        this.target = target;
        this.fromClause = fromClause;
        this.whereClause = whereClause;
        this.hasFromKeyword = hasFromKeyword != null ? hasFromKeyword : false;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        
        return visitor.visit(this);
    }
}