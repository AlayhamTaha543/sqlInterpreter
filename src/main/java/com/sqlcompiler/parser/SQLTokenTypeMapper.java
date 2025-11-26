package com.sqlcompiler.parser;

import com.sqlcompiler.parser.SQLLexer;

/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * SQL TOKEN TYPE MAPPER - Token Type Name Mapping Utility
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * PURPOSE:
 *   This class maps ANTLR token type codes (integers) to human-readable token
 *   type names (strings). It serves as the central mapping utility for all
 *   lexer tokens defined in SQLLexer.g4.
 * 
 * WHY THIS CLASS EXISTS:
 *   ANTLR internally represents tokens as integer constants. For example:
 *   - SQLLexer.SELECT = 1
 *   - SQLLexer.FROM = 2
 *   - SQLLexer.WHERE = 3
 *   
 *   This class converts those numeric codes to human-readable names like
 *   "SELECT", "FROM", "WHERE" for better logging and debugging.
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 * DEVELOPER INSTRUCTIONS - ADD NEW TOKEN TYPES HERE:
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * When you add new grammar rules to SQLLexer.g4, follow these steps:
 * 
 * STEP 1: Add new rule to SQLLexer.g4
 *         Example:
 *         lexer grammar SQLLexer;
 *         DISTINCT: 'DISTINCT' | 'distinct';
 *         UNION: 'UNION' | 'union';       <-- NEW RULE
 *         ALL: 'ALL' | 'all';             <-- NEW RULE
 * 
 * STEP 2: Generate new lexer from grammar
 *         Run this command in your project root:
 *         
 *         mvn clean generate-sources
 *         
 *         This creates/updates: target/generated-sources/antlr4/com/sqlcompiler/parser/SQLLexer.java
 *         The new token constants will be added automatically.
 * 
 * STEP 3: Compile the project
 *         Run:
 *         
 *         mvn compile
 *         
 * STEP 4: Add mapping in THIS CLASS
 *         Add new case statements in the getTokenName() method below:
 *         
 *         Example:
 *         case SQLLexer.UNION: return "UNION";
 *         case SQLLexer.ALL: return "ALL";
 * 
 * STEP 5: Refresh IDE
 *         Right-click project → Maven → Reload projects (or similar for your IDE)
 * 
 * STEP 6: Test
 *         Run SQLLexerApp and test your new tokens
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 * HOW TO USE THIS CLASS:
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * In any Java class where you need token type names:
 * 
 *   Example 1: Get token name directly
 *   ────────────────────────────────────
 *   String tokenName = SQLTokenTypeMapper.getTokenName(tokenType);
 *   System.out.println("Token type: " + tokenName);
 * 
 *   Example 2: In a loop processing tokens
 *   ──────────────────────────────────────
 *   for (Token token : tokens.getTokens()) {
 *       String name = SQLTokenTypeMapper.getTokenName(token.getType());
 *       System.out.println(name + ": " + token.getText());
 *   }
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 * TOKEN CATEGORIES:
 * ═══════════════════════════════════════════════════════════════════════════════
 * 
 * This mapper includes the following token categories from SQLLexer.g4:
 * 
 * 1. SQL KEYWORDS
 *    - Data Manipulation: SELECT, INSERT, UPDATE, DELETE
 *    - Data Definition: CREATE, DROP, ALTER, TABLE
 *    - Clauses: FROM, WHERE, GROUP, BY, HAVING, ORDER, LIMIT, OFFSET
 *    - Join Types: JOIN, INNER, LEFT, RIGHT
 *    - Other: AND, OR, NOT, DISTINCT, AS, NULL
 * 
 * 2. OPERATORS
 *    - Comparison: =, !=, <>, <, >, <=, >=
 *    - Arithmetic: +, -, *, /, %
 *    - Logical: AND, OR, NOT
 *    - Pattern Matching: LIKE, IN, BETWEEN, IS
 * 
 * 3. DELIMITERS
 *    - Parentheses: (, )
 *    - Punctuation: comma, semicolon, dot
 * 
 * 4. LITERALS
 *    - IDENTIFIER (variable names, table names, column names)
 *    - INTEGER (whole numbers)
 *    - FLOAT (decimal numbers)
 *    - STRING (text values in quotes)
 * 
 * ═══════════════════════════════════════════════════════════════════════════════
 */
public class SQLTokenTypeMapper {

    /**
     * Maps ANTLR token type codes to human-readable token type names
     * 
     * This is the main method you will update when adding new tokens to the lexer.
     * Each case statement maps one token type constant to its string representation.
     * 
     * IMPORTANT: Keep token names synchronized with SQLLexer.g4
     * 
     * @param tokenType The integer token type code from ANTLR (e.g., SQLLexer.SELECT)
     * @return The human-readable token type name (e.g., "SELECT")
     */
    public static String getTokenName(int tokenType) {
        switch (tokenType) {

            // ═══════════════════════════════════════════════════════════════
            // SQL KEYWORDS - Data Manipulation Language (DML)
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.SELECT:
                return "SELECT";
            case SQLLexer.INSERT:
                return "INSERT";
            case SQLLexer.UPDATE:
                return "UPDATE";
            case SQLLexer.DELETE:
                return "DELETE";

            // ═══════════════════════════════════════════════════════════════
            // SQL KEYWORDS - Data Definition Language (DDL)
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.CREATE:
                return "CREATE";
            case SQLLexer.DROP:
                return "DROP";
            case SQLLexer.ALTER:
                return "ALTER";
            case SQLLexer.TABLE:
                return "TABLE";
            // case SQLLexer.ADD:
            //     return "ADD";

            // ═══════════════════════════════════════════════════════════════
            // SQL KEYWORDS - SELECT Clause Keywords
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.FROM:
                return "FROM";
            case SQLLexer.WHERE:
                return "WHERE";
            case SQLLexer.GROUP:
                return "GROUP";
            case SQLLexer.BY:
                return "BY";
            case SQLLexer.HAVING:
                return "HAVING";
            case SQLLexer.ORDER:
                return "ORDER";
            // case SQLLexer.LIMIT:
            //     return "LIMIT";
            case SQLLexer.OFFSET:
                return "OFFSET";
            case SQLLexer.DISTINCT:
                return "DISTINCT";
            case SQLLexer.ASC:
                return "ASC";
            case SQLLexer.DESC:
                return "DESC";

            // ═══════════════════════════════════════════════════════════════
            // SQL KEYWORDS - INSERT/UPDATE/DELETE Related
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.INTO:
                return "INTO";
            case SQLLexer.VALUES:
                return "VALUES";
            case SQLLexer.SET:
                return "SET";

            // ═══════════════════════════════════════════════════════════════
            // SQL KEYWORDS - JOIN Related
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.JOIN:
                return "JOIN";
            case SQLLexer.INNER:
                return "INNER";
            case SQLLexer.LEFT:
                return "LEFT";
            case SQLLexer.RIGHT:
                return "RIGHT";
            case SQLLexer.ON:
                return "ON";

            // ═══════════════════════════════════════════════════════════════
            // SQL KEYWORDS - Logical and Comparison
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.AND:
                return "AND";
            case SQLLexer.OR:
                return "OR";
            case SQLLexer.NOT:
                return "NOT";

            // ═══════════════════════════════════════════════════════════════
            // SQL KEYWORDS - Aliases and References
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.AS:
                return "AS";
            // case SQLLexer.NULL_KEYWORD:
            //     return "NULL";

            // ═══════════════════════════════════════════════════════════════
            // SQL KEYWORDS - Constraint Related
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.CONSTRAINT:
                return "CONSTRAINT";
            case SQLLexer.PRIMARY:
                return "PRIMARY";
            case SQLLexer.KEY:
                return "KEY";
            case SQLLexer.FOREIGN:
                return "FOREIGN";
            case SQLLexer.REFERENCES:
                return "REFERENCES";
            case SQLLexer.UNIQUE:
                return "UNIQUE";
            case SQLLexer.CHECK:
                return "CHECK";
            case SQLLexer.DEFAULT:
                return "DEFAULT";

            // ═══════════════════════════════════════════════════════════════
            // SQL KEYWORDS - Pattern Matching and Conditions
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.LIKE:
                return "LIKE";
            case SQLLexer.IN:
                return "IN";
            case SQLLexer.BETWEEN:
                return "BETWEEN";
            case SQLLexer.IS:
                return "IS";

            // ═══════════════════════════════════════════════════════════════
            // COMPARISON OPERATORS
            // ═══════════════════════════════════════════════════════════════
            // case SQLLexer.EQUALS:
            //     return "EQUALS (=)";
            // case SQLLexer.NOT_EQUALS:
            //     return "NOT_EQUALS (!=)";
            // case SQLLexer.LESS:
            //     return "LESS (<)";
            // case SQLLexer.GREATER:
            //     return "GREATER (>)";
            // case SQLLexer.LESS_EQUALS:
            //     return "LESS_EQUALS (<=)";
            // case SQLLexer.GREATER_EQUALS:
            //     return "GREATER_EQUALS (>=)";

            // ═══════════════════════════════════════════════════════════════
            // ARITHMETIC OPERATORS
            // ═══════════════════════════════════════════════════════════════
            // case SQLLexer.PLUS:
            //     return "PLUS (+)";
            // case SQLLexer.MINUS:
            //     return "MINUS (-)";
            // case SQLLexer.MULTIPLY:
            //     return "MULTIPLY (*)";
            // case SQLLexer.DIVIDE:
            //     return "DIVIDE (/)";
            // case SQLLexer.MODULO:
            //     return "MODULO (%)";

            // ═══════════════════════════════════════════════════════════════
            // DELIMITERS - Parentheses and Punctuation
            // ═══════════════════════════════════════════════════════════════
            // case SQLLexer.LPAREN:
            //     return "LPAREN (";
            // case SQLLexer.RPAREN:
            //     return "RPAREN )";
            // case SQLLexer.COMMA:
            //     return "COMMA ,";
            // case SQLLexer.SEMICOLON:
            //     return "SEMICOLON ;";
            // case SQLLexer.DOT:
            //     return "DOT .";

            // ═══════════════════════════════════════════════════════════════
            // LITERALS - Identifiers and Values
            // ═══════════════════════════════════════════════════════════════
            // case SQLLexer.IDENTIFIER:
            //     return "IDENTIFIER";
            // case SQLLexer.INTEGER:
            //     return "INTEGER";
            // case SQLLexer.FLOAT:
            //     return "FLOAT";
            // case SQLLexer.STRING:
            //     return "STRING";

            // ═══════════════════════════════════════════════════════════════
            // DEFAULT - Unknown Token Type
            // ═══════════════════════════════════════════════════════════════
            default:
                return "UNKNOWN (Type Code: " + tokenType + ")";
        }
    }

    /**
     * Checks if a token type is a keyword
     * 
     * Useful for syntax highlighting or categorizing tokens
     * 
     * @param tokenType The token type to check
     * @return true if token is a SQL keyword, false otherwise
     */
    public static boolean isKeyword(int tokenType) {
        return tokenType >= SQLLexer.SELECT && tokenType <= SQLLexer.IS;
    }

    /**
     * Checks if a token type is an operator
     * 
     * @param tokenType The token type to check
     * @return true if token is an operator, false otherwise
     */
    // public static boolean isOperator(int tokenType) {
    //     return (tokenType >= SQLLexer.EQUALS && tokenType <= SQLLexer.MODULO);
    // }

    /**
     * Checks if a token type is a literal
     * 
     * @param tokenType The token type to check
     * @return true if token is a literal (identifier, integer, float, or string)
     */
    // public static boolean isLiteral(int tokenType) {
    //     return tokenType == SQLLexer.IDENTIFIER ||
    //             tokenType == SQLLexer.INTEGER ||
    //             tokenType == SQLLexer.FLOAT ||
    //             tokenType == SQLLexer.STRING;
    // }
}