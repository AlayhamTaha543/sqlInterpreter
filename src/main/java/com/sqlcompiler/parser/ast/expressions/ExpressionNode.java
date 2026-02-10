package com.sqlcompiler.parser.ast.expressions;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;

public abstract class ExpressionNode extends ASTNode {
    // Base class for all expressions
    
    @Override
    public abstract <T> T accept(ASTVisitor<T> visitor);
}
