// Generated from antlr4/SqlLexer.g4 by ANTLR 4.13.2
package com.example.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlLexerParser}.
 */
public interface SqlLexerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlLexerParser#greeting}.
	 * @param ctx the parse tree
	 */
	void enterGreeting(SqlLexerParser.GreetingContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlLexerParser#greeting}.
	 * @param ctx the parse tree
	 */
	void exitGreeting(SqlLexerParser.GreetingContext ctx);
}