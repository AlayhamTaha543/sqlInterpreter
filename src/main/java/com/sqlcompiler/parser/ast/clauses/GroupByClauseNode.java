package com.sqlcompiler.parser.ast.clauses;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;
import java.util.ArrayList;
import java.util.List;

public class GroupByClauseNode extends ASTNode {
    
    public static class GroupingElement {
        public final ExpressionNode expression;
        public final boolean rollup; // For GROUP BY ROLLUP
        public final boolean cube;   // For GROUP BY CUBE
        
        public GroupingElement(ExpressionNode expression, boolean rollup, boolean cube) {
            this.expression = expression;
            this.rollup = rollup;
            this.cube = cube;
        }
        
        public GroupingElement(ExpressionNode expression) {
            this(expression, false, false);
        }
        
        @Override
        public String toString() {
            String result = expression.toString();
            if (rollup) {
                result = "ROLLUP(" + result + ")";
            } else if (cube) {
                result = "CUBE(" + result + ")";
            }
            return result;
        }
    }
    
    public final List<GroupingElement> groupingElements;
    public final List<ExpressionNode> groupingSets; // For GROUPING SETS
    
    public GroupByClauseNode(List<GroupingElement> groupingElements, 
                            List<ExpressionNode> groupingSets) {
        this.groupingElements = groupingElements != null ? 
            new ArrayList<>(groupingElements) : new ArrayList<>();
        this.groupingSets = groupingSets != null ? 
            new ArrayList<>(groupingSets) : new ArrayList<>();
    }
    
    public GroupByClauseNode(List<GroupingElement> groupingElements) {
        this(groupingElements, null);
    }
    
    public GroupByClauseNode(ExpressionNode expression) {
        this(new ArrayList<>());
        this.groupingElements.add(new GroupingElement(expression));
    }
    
    public boolean isEmpty() {
        return groupingElements.isEmpty() && groupingSets.isEmpty();
    }
    
    public boolean hasRollup() {
        return groupingElements.stream().anyMatch(e -> e.rollup);
    }
    
    public boolean hasCube() {
        return groupingElements.stream().anyMatch(e -> e.cube);
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        // Typically visited through SelectStatementNode
        return null;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder("GROUP BY ");
        
        if (!groupingSets.isEmpty()) {
            sb.append("GROUPING SETS (");
            for (int i = 0; i < groupingSets.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(groupingSets.get(i));
            }
            sb.append(")");
        } else if (!groupingElements.isEmpty()) {
            for (int i = 0; i < groupingElements.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(groupingElements.get(i));
            }
        }
        
        return sb.toString();
    }
}