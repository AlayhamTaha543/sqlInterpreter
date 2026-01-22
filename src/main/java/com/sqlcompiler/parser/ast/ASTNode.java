package com.sqlcompiler.parser.ast;

public abstract class ASTNode {
    public abstract <T> T accept(ASTVisitor<T> visitor);
}