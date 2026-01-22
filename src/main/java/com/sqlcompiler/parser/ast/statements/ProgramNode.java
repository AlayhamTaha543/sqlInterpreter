package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a SQL program/batch containing multiple statements
 */
public class ProgramNode extends ASTNode {
    
    public final List<ASTNode> statements;
    
    public ProgramNode(List<ASTNode> statements) {
        this.statements = statements != null ? 
                         new ArrayList<>(statements) : new ArrayList<>();
    }
    
    public ProgramNode() {
        this(new ArrayList<>());
    }
    
    public void addStatement(ASTNode statement) {
        this.statements.add(statement);
    }
    
    public int getStatementCount() {
        return statements.size();
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "Program [" + statements.size() + " statement(s)]";
    }
}