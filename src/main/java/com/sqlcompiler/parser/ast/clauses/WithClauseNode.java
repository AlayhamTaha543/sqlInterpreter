package com.sqlcompiler.parser.ast.clauses;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents WITH clause containing one or more CTEs
 * 
 * WITH [RECURSIVE] cte1 AS (...), cte2 AS (...)
 */
public class WithClauseNode extends ASTNode {
    
    public final boolean recursive;
    public final List<CTENode> ctes;
    
    public WithClauseNode(boolean recursive, List<CTENode> ctes) {
        this.recursive = recursive;
        this.ctes = ctes != null ? new ArrayList<>(ctes) : new ArrayList<>();
    }
    
    public WithClauseNode(List<CTENode> ctes) {
        this(false, ctes);
    }
    
    public int getCTECount() {
        return ctes.size();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("WITH ");
        if (recursive) sb.append("RECURSIVE ");
        sb.append(ctes.size()).append(" CTE(s)");
        return sb.toString();
    }
}