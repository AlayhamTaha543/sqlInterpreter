package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a block of statements (BEGIN...END)
 */
public class StatementBlockNode extends ASTNode {
    
    public final List<ASTNode> statements;
    
    public StatementBlockNode(List<ASTNode> statements) {
        this.statements = statements != null ? 
                         new ArrayList<>(statements) : new ArrayList<>();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "StatementBlock [" + statements.size() + " statement(s)]";
    }
}