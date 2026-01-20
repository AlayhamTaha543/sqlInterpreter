package com.sqlcompiler.parser.ast.expressions;


import com.sqlcompiler.parser.ast.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

public class AggregateFunctionNode extends ExpressionNode {
    public enum AggregateType {
        COUNT, SUM, AVG, MIN, MAX, 
        COUNT_DISTINCT, SUM_DISTINCT, AVG_DISTINCT
    }
    
    public final AggregateType type;
    public final ExpressionNode argument;
    public final boolean distinct;
    public final List<ExpressionNode> arguments; // لبعض الدوال التي تأخذ أكثر من معامل
    public final ExpressionNode filterClause; // Optional FILTER clause
    
    // Constructor for single argument
    public AggregateFunctionNode(AggregateType type, ExpressionNode argument, 
                                 boolean distinct, ExpressionNode filterClause) {
        this.type = type;
        this.argument = argument;
        this.distinct = distinct;
        this.arguments = new ArrayList<>();
        if (argument != null) {
            this.arguments.add(argument);
        }
        this.filterClause = filterClause;
    }
    
    // Constructor for multiple arguments
    public AggregateFunctionNode(AggregateType type, List<ExpressionNode> arguments, 
                                 boolean distinct, ExpressionNode filterClause) {
        this.type = type;
        this.arguments = arguments != null ? new ArrayList<>(arguments) : new ArrayList<>();
        this.argument = !arguments.isEmpty() ? arguments.get(0) : null;
        this.distinct = distinct;
        this.filterClause = filterClause;
    }
    
    // Simplified constructors
    public AggregateFunctionNode(AggregateType type, ExpressionNode argument) {
        this(type, argument, false, null);
    }
    
    public AggregateFunctionNode(AggregateType type, List<ExpressionNode> arguments) {
        this(type, arguments, false, null);
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(type.name());
        
        if (type.name().contains("DISTINCT")) {
            sb.append("(");
            if (argument != null) {
                sb.append(argument);
            } else if (type == AggregateType.COUNT || type == AggregateType.COUNT_DISTINCT) {
                sb.append("*");
            }
            sb.append(")");
        } else {
            sb.append("(");
            if (distinct) {
                sb.append("DISTINCT ");
            }
            
            if (!arguments.isEmpty()) {
                for (int i = 0; i < arguments.size(); i++) {
                    if (i > 0) sb.append(", ");
                    sb.append(arguments.get(i));
                }
            } else if (type == AggregateType.COUNT) {
                sb.append("*");
            }
            sb.append(")");
        }
        
        if (filterClause != null) {
            sb.append(" FILTER (WHERE ").append(filterClause).append(")");
        }
        
        return sb.toString();
    }
}
