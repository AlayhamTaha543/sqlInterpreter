package com.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import com.example.antlr4.SqlLexerLexer;
import com.example.antlr4.SqlLexerParser;

public class App 
{
    public static void main( String[] args )
    {
        // The input string we want to parse
        String input = "hello World";

        // Create a CharStream from the input string
        CharStream charStream = CharStreams.fromString(input);

        // Create a lexer that feeds off of the CharStream
        SqlLexerLexer lexer = new SqlLexerLexer(charStream);

        // Create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser that feeds off the tokens buffer
        SqlLexerParser parser = new SqlLexerParser(tokens);

        // Begin parsing at the 'greeting' rule (our entry point)
        ParseTree tree = parser.greeting();

        // Print the tree structure (LISP-style)
        System.out.println("Parse Tree: " + tree.toStringTree(parser));

        // You can also walk the tree with a listener or visitor
        // For this simple example, just printing the tree is enough.
    }
}