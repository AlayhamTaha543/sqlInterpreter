package com.sqlcompiler.parser.ast.expressions;


import com.sqlcompiler.parser.ast.ASTVisitor;
import java.util.ArrayList;
import java.util.List;

public class FunctionCallNode extends ExpressionNode {
    public final String functionName;
    public final List<ExpressionNode> arguments;
    public final boolean distinct; // لبعض الدوال التي تدعم DISTINCT
    public final String windowDefinition; // Optional window clause
    public final boolean isAggregate; // هل هي دالة تجميع؟
    
    public FunctionCallNode(String functionName, List<ExpressionNode> arguments, 
                           boolean distinct, String windowDefinition, boolean isAggregate) {
        this.functionName = functionName.toUpperCase();
        this.arguments = arguments != null ? new ArrayList<>(arguments) : new ArrayList<>();
        this.distinct = distinct;
        this.windowDefinition = windowDefinition;
        this.isAggregate = isAggregate;
    }
    
    // Constructors for common cases
    public FunctionCallNode(String functionName, List<ExpressionNode> arguments) {
        this(functionName, arguments, false, null, false);
    }
    
    public FunctionCallNode(String functionName, ExpressionNode argument) {
        this(functionName, new ArrayList<>(), false, null, false);
        this.arguments.add(argument);
    }
    
    public static FunctionCallNode createAggregate(String functionName, List<ExpressionNode> arguments) {
        return new FunctionCallNode(functionName, arguments, false, null, true);
    }
    
    public static FunctionCallNode createAggregate(String functionName, List<ExpressionNode> arguments, boolean distinct) {
        return new FunctionCallNode(functionName, arguments, distinct, null, true);
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(functionName).append("(");
        
        if (distinct) {
            sb.append("DISTINCT ");
        }
        
        for (int i = 0; i < arguments.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(arguments.get(i));
        }
        
        sb.append(")");
        
        if (windowDefinition != null && !windowDefinition.isEmpty()) {
            sb.append(" OVER (").append(windowDefinition).append(")");
        }
        
        return sb.toString();
    }
}
