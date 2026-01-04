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
 * UPDATED FOR: String Mode Tokenization
 *   This version includes support for granular string tokens produced by
 *   STRING_MODE_SINGLE and STRING_MODE_DOUBLE modes in the lexer.
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
            // SQL KEYWORDS - SELECT AND FILTERING
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.SELECT:
                return "SELECT";
            case SQLLexer.FROM:
                return "FROM";
            case SQLLexer.WHERE:
                return "WHERE";
            case SQLLexer.HAVING:
                return "HAVING";
            case SQLLexer.DISTINCT:
                return "DISTINCT";
            case SQLLexer.TOP:
                return "TOP";
            case SQLLexer.GROUP:
                return "GROUP";
            case SQLLexer.BY:
                return "BY";
            case SQLLexer.ORDER:
                return "ORDER";
            case SQLLexer.OFFSET:
                return "OFFSET";
            case SQLLexer.FETCH:
                return "FETCH";
            case SQLLexer.NEXT:
                return "NEXT";
            case SQLLexer.FIRST:
                return "FIRST";
            case SQLLexer.ONLY:
                return "ONLY";

            // ═══════════════════════════════════════════════════════════════
            // DATA MANIPULATION LANGUAGE (DML)
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.INSERT:
                return "INSERT";
            case SQLLexer.INTO:
                return "INTO";
            case SQLLexer.UPDATE:
                return "UPDATE";
            case SQLLexer.DELETE:
                return "DELETE";
            case SQLLexer.VALUES:
                return "VALUES";
            case SQLLexer.MERGE:
                return "MERGE";
            case SQLLexer.MATCHED:
                return "MATCHED";
            case SQLLexer.OUTPUT:
                return "OUTPUT";

            // ═══════════════════════════════════════════════════════════════
            // DATA DEFINITION LANGUAGE (DDL)
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.CREATE:
                return "CREATE";
            case SQLLexer.ALTER:
                return "ALTER";
            case SQLLexer.DROP:
                return "DROP";
            case SQLLexer.TABLE:
                return "TABLE";
            case SQLLexer.VIEW:
                return "VIEW";
            case SQLLexer.PROCEDURE:
                return "PROCEDURE";
            case SQLLexer.FUNCTION:
                return "FUNCTION";
            case SQLLexer.INDEX:
                return "INDEX";
            case SQLLexer.SCHEMA:
                return "SCHEMA";
            case SQLLexer.DATABASE:
                return "DATABASE";
            case SQLLexer.TRIGGER:
                return "TRIGGER";

            // ═══════════════════════════════════════════════════════════════
            // DATA TYPES - Integer Types
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.INT:
                return "INT";
            case SQLLexer.BIGINT:
                return "BIGINT";
            case SQLLexer.SMALLINT:
                return "SMALLINT";
            case SQLLexer.TINYINT:
                return "TINYINT";

            // ═══════════════════════════════════════════════════════════════
            // DATA TYPES - Character/String Types
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.VARCHAR:
                return "VARCHAR";
            case SQLLexer.NVARCHAR:
                return "NVARCHAR";
            case SQLLexer.CHAR:
                return "CHAR";
            case SQLLexer.NCHAR:
                return "NCHAR";
            case SQLLexer.TEXT:
                return "TEXT";
            case SQLLexer.NTEXT:
                return "NTEXT";

            // ═══════════════════════════════════════════════════════════════
            // DATA TYPES - Date/Time Types
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.DATETIME:
                return "DATETIME";
            case SQLLexer.DATE:
                return "DATE";
            case SQLLexer.TIME:
                return "TIME";
            case SQLLexer.TIMESTAMP:
                return "TIMESTAMP";

            // ═══════════════════════════════════════════════════════════════
            // DATA TYPES - Numeric/Decimal Types
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.BIT:
                return "BIT";
            case SQLLexer.DECIMAL:
                return "DECIMAL";
            case SQLLexer.NUMERIC:
                return "NUMERIC";
            case SQLLexer.FLOAT:
                return "FLOAT";
            case SQLLexer.REAL:
                return "REAL";
            case SQLLexer.MONEY:
                return "MONEY";
            case SQLLexer.SMALLMONEY:
                return "SMALLMONEY";

            // ═══════════════════════════════════════════════════════════════
            // DATA TYPES - Binary and Special Types
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.BINARY:
                return "BINARY";
            case SQLLexer.VARBINARY:
                return "VARBINARY";
            case SQLLexer.IMAGE:
                return "IMAGE";
            case SQLLexer.UNIQUEIDENTIFIER:
                return "UNIQUEIDENTIFIER";
            case SQLLexer.XML:
                return "XML";
            case SQLLexer.SQL_VARIANT:
                return "SQL_VARIANT";

            // ═══════════════════════════════════════════════════════════════
            // TABLE CONSTRAINTS
            // ═══════════════════════════════════════════════════════════════
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
            case SQLLexer.CONSTRAINT:
                return "CONSTRAINT";
            case SQLLexer.IDENTITY:
                return "IDENTITY";
            case SQLLexer.CLUSTERED:
                return "CLUSTERED";
            case SQLLexer.NONCLUSTERED:
                return "NONCLUSTERED";

            // ═══════════════════════════════════════════════════════════════
            // JOIN OPERATIONS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.JOIN:
                return "JOIN";
            case SQLLexer.INNER:
                return "INNER";
            case SQLLexer.OUTER:
                return "OUTER";
            case SQLLexer.LEFT:
                return "LEFT";
            case SQLLexer.RIGHT:
                return "RIGHT";
            case SQLLexer.FULL:
                return "FULL";
            case SQLLexer.CROSS:
                return "CROSS";
            case SQLLexer.ON:
                return "ON";
            case SQLLexer.USING:
                return "USING";

            // ═══════════════════════════════════════════════════════════════
            // SET OPERATIONS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.UNION:
                return "UNION";
            case SQLLexer.EXCEPT:
                return "EXCEPT";
            case SQLLexer.INTERSECT:
                return "INTERSECT";
            case SQLLexer.ALL:
                return "ALL";

            // ═══════════════════════════════════════════════════════════════
            // LOGICAL OPERATORS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.AND:
                return "AND";
            case SQLLexer.OR:
                return "OR";
            case SQLLexer.NOT:
                return "NOT";
            case SQLLexer.LIKE:
                return "LIKE";
            case SQLLexer.IN:
                return "IN";
            case SQLLexer.BETWEEN:
                return "BETWEEN";
            case SQLLexer.EXISTS:
                return "EXISTS";
            case SQLLexer.IS:
                return "IS";
            case SQLLexer.NULL:
                return "NULL";
            case SQLLexer.ANY:
                return "ANY";
            case SQLLexer.SOME:
                return "SOME";

            // ═══════════════════════════════════════════════════════════════
            // AGGREGATE FUNCTIONS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.COUNT:
                return "COUNT";
            case SQLLexer.SUM:
                return "SUM";
            case SQLLexer.AVG:
                return "AVG";
            case SQLLexer.MIN:
                return "MIN";
            case SQLLexer.MAX:
                return "MAX";

            // ═══════════════════════════════════════════════════════════════
            // STRING FUNCTIONS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.LEN:
                return "LEN";
            case SQLLexer.SUBSTRING:
                return "SUBSTRING";
            case SQLLexer.LTRIM:
                return "LTRIM";
            case SQLLexer.RTRIM:
                return "RTRIM";
            case SQLLexer.UPPER:
                return "UPPER";
            case SQLLexer.LOWER:
                return "LOWER";
            case SQLLexer.REPLACE:
                return "REPLACE";
            case SQLLexer.CONCAT:
                return "CONCAT";
            case SQLLexer.CHARINDEX:
                return "CHARINDEX";
            case SQLLexer.PATINDEX:
                return "PATINDEX";

            // ═══════════════════════════════════════════════════════════════
            // DATE FUNCTIONS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.GETDATE:
                return "GETDATE";
            case SQLLexer.GETUTCDATE:
                return "GETUTCDATE";
            case SQLLexer.DATEADD:
                return "DATEADD";
            case SQLLexer.DATEDIFF:
                return "DATEDIFF";
            case SQLLexer.DATEPART:
                return "DATEPART";
            case SQLLexer.YEAR:
                return "YEAR";
            case SQLLexer.MONTH:
                return "MONTH";
            case SQLLexer.DAY:
                return "DAY";

            // ═══════════════════════════════════════════════════════════════
            // CONVERSION FUNCTIONS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.CAST:
                return "CAST";
            case SQLLexer.CONVERT:
                return "CONVERT";
            case SQLLexer.TRY_CAST:
                return "TRY_CAST";
            case SQLLexer.TRY_CONVERT:
                return "TRY_CONVERT";

            // ═══════════════════════════════════════════════════════════════
            // WINDOW FUNCTIONS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.OVER:
                return "OVER";
            case SQLLexer.PARTITION:
                return "PARTITION";
            case SQLLexer.ROWS:
                return "ROWS";
            case SQLLexer.RANGE:
                return "RANGE";
            case SQLLexer.PRECEDING:
                return "PRECEDING";
            case SQLLexer.FOLLOWING:
                return "FOLLOWING";
            case SQLLexer.CURRENT:
                return "CURRENT";
            case SQLLexer.ROW:
                return "ROW";
            case SQLLexer.LAG:
                return "LAG";
            case SQLLexer.LEAD:
                return "LEAD";
            case SQLLexer.FIRST_VALUE:
                return "FIRST_VALUE";
            case SQLLexer.LAST_VALUE:
                return "LAST_VALUE";

            // ═══════════════════════════════════════════════════════════════
            // PROGRAMMING CONSTRUCTS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.DECLARE:
                return "DECLARE";
            case SQLLexer.SET:
                return "SET";
            case SQLLexer.BEGIN:
                return "BEGIN";
            case SQLLexer.END:
                return "END";
            case SQLLexer.IF:
                return "IF";
            case SQLLexer.ELSE:
                return "ELSE";
            case SQLLexer.WHILE:
                return "WHILE";
            case SQLLexer.BREAK:
                return "BREAK";
            case SQLLexer.CONTINUE:
                return "CONTINUE";
            case SQLLexer.CASE:
                return "CASE";
            case SQLLexer.WHEN:
                return "WHEN";
            case SQLLexer.THEN:
                return "THEN";
            case SQLLexer.RETURN:
                return "RETURN";

            // ═══════════════════════════════════════════════════════════════
            // TRANSACTION CONTROL
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.TRANSACTION:
                return "TRANSACTION";
            case SQLLexer.COMMIT:
                return "COMMIT";
            case SQLLexer.ROLLBACK:
                return "ROLLBACK";
            case SQLLexer.SAVEPOINT:
                return "SAVEPOINT";
            case SQLLexer.SAVE:
                return "SAVE";
            case SQLLexer.TRY:
                return "TRY";
            case SQLLexer.CATCH:
                return "CATCH";
            case SQLLexer.THROW:
                return "THROW";

            // ═══════════════════════════════════════════════════════════════
            // STORED PROCEDURE EXECUTION
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.EXEC:
                return "EXEC";
            case SQLLexer.EXECUTE:
                return "EXECUTE";
            case SQLLexer.OPEN:
                return "OPEN";
            case SQLLexer.CLOSE:
                return "CLOSE";
            case SQLLexer.DEALLOCATE:
                return "DEALLOCATE";

            // ═══════════════════════════════════════════════════════════════
            // OUTPUT AND DEBUGGING
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.PRINT:
                return "PRINT";
            case SQLLexer.RAISERROR:
                return "RAISERROR";

            // ═══════════════════════════════════════════════════════════════
            // DATABASE OPERATIONS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.USE:
                return "USE";
            case SQLLexer.GO:
                return "GO";
            case SQLLexer.AS:
                return "AS";
            case SQLLexer.WITH:
                return "WITH";
            case SQLLexer.OPTION:
                return "OPTION";
            case SQLLexer.RECOMPILE:
                return "RECOMPILE";

            // ═══════════════════════════════════════════════════════════════
            // SECURITY AND PERMISSIONS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.GRANT:
                return "GRANT";
            case SQLLexer.REVOKE:
                return "REVOKE";
            case SQLLexer.DENY:
                return "DENY";
            case SQLLexer.LOGIN:
                return "LOGIN";
            case SQLLexer.USER:
                return "USER";
            case SQLLexer.ROLE:
                return "ROLE";
            case SQLLexer.PERMISSION:
                return "PERMISSION";

            // ═══════════════════════════════════════════════════════════════
            // SORTING DIRECTIONS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.ASC:
                return "ASC";
            case SQLLexer.DESC:
                return "DESC";

            // ═══════════════════════════════════════════════════════════════
            // BOOLEAN VALUES
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.TRUE:
                return "TRUE";
            case SQLLexer.FALSE:
                return "FALSE";

            // ═══════════════════════════════════════════════════════════════
            // IDENTIFIERS AND VARIABLES
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.SYSTEM_VARIABLE:
                return "SYSTEM_VARIABLE";
            case SQLLexer.USER_VARIABLE:
                return "USER_VARIABLE";
            case SQLLexer.DELIMITED_IDENTIFIER_BRACKET:
                return "DELIMITED_IDENTIFIER_BRACKET";
            case SQLLexer.DELIMITED_IDENTIFIER_QUOTE:
                return "DELIMITED_IDENTIFIER_QUOTE";
            case SQLLexer.DELIMITED_IDENTIFIER_BACKTICK:
                return "DELIMITED_IDENTIFIER_BACKTICK";
            case SQLLexer.IDENTIFIER:
                return "IDENTIFIER";

            // ═══════════════════════════════════════════════════════════════
            // LITERALS - Numeric
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.INTEGER:
                return "INTEGER";
            case SQLLexer.FLOATN:
                return "FLOATN";

            // ═══════════════════════════════════════════════════════════════
            // TASK 3: STRING LITERALS - Single Quote Mode
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.STRING_START_SINGLE:
                return "STRING_START_SINGLE (')";
            case SQLLexer.STRING_END_SINGLE:
                return "STRING_END_SINGLE (')";
            case SQLLexer.STRING_SINGLE_ESCAPED_QUOTE:
                return "STRING_SINGLE_ESCAPED_QUOTE ('')";
            case SQLLexer.STRING_SINGLE_BACKSLASH_ESCAPE:
                return "STRING_SINGLE_BACKSLASH_ESCAPE";
            case SQLLexer.STRING_SINGLE_LINE_CONTINUATION:
                return "STRING_SINGLE_LINE_CONTINUATION";
            case SQLLexer.STRING_SINGLE_NEWLINE:
                return "STRING_SINGLE_NEWLINE";
            case SQLLexer.STRING_SINGLE_CHAR:
                return "STRING_SINGLE_CHAR";
            case SQLLexer.STRING_SINGLE_ANY:
                return "STRING_SINGLE_ANY";

            // ═══════════════════════════════════════════════════════════════
            // TASK 3: STRING LITERALS - Double Quote Mode
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.STRING_START_DOUBLE:
                return "STRING_START_DOUBLE (\")";
            case SQLLexer.STRING_END_DOUBLE:
                return "STRING_END_DOUBLE (\")";
            case SQLLexer.STRING_DOUBLE_ESCAPED_QUOTE:
                return "STRING_DOUBLE_ESCAPED_QUOTE (\"\")";
            case SQLLexer.STRING_DOUBLE_BACKSLASH_ESCAPE:
                return "STRING_DOUBLE_BACKSLASH_ESCAPE";
            case SQLLexer.STRING_DOUBLE_LINE_CONTINUATION:
                return "STRING_DOUBLE_LINE_CONTINUATION";
            case SQLLexer.STRING_DOUBLE_NEWLINE:
                return "STRING_DOUBLE_NEWLINE";
            case SQLLexer.STRING_DOUBLE_CHAR:
                return "STRING_DOUBLE_CHAR";
            case SQLLexer.STRING_DOUBLE_ANY:
                return "STRING_DOUBLE_ANY";

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
     * @param tokenType The token type to check
     * @return true if token is a SQL keyword
     */
    public static boolean isKeyword(int tokenType) {
        return (tokenType >= SQLLexer.SELECT && tokenType <= SQLLexer.FALSE) ||
               tokenType == SQLLexer.NULL ||
               tokenType == SQLLexer.TRUE ||
               tokenType == SQLLexer.FALSE;
    }

    /**
     * Checks if a token type is an operator
     * 
     * @param tokenType The token type to check
     * @return true if token is an operator
     */
    public static boolean isOperator(int tokenType) {
        return tokenType == SQLLexer.AND ||
               tokenType == SQLLexer.OR ||
               tokenType == SQLLexer.NOT ||
               tokenType == SQLLexer.LIKE ||
               tokenType == SQLLexer.IN ||
               tokenType == SQLLexer.BETWEEN ||
               tokenType == SQLLexer.EXISTS ||
               tokenType == SQLLexer.IS;
    }

    /**
     * Checks if a token type is a numeric literal
     * 
     * @param tokenType The token type to check
     * @return true if token is numeric
     */
    public static boolean isNumericLiteral(int tokenType) {
        return tokenType == SQLLexer.INTEGER || tokenType == SQLLexer.FLOATN;
    }

    /**
     * Checks if a token type is a string literal component
     * 
     * @param tokenType The token type to check
     * @return true if token is part of a string literal
     */
    public static boolean isStringLiteralComponent(int tokenType) {
        return tokenType == SQLLexer.STRING_START_SINGLE ||
               tokenType == SQLLexer.STRING_END_SINGLE ||
               tokenType == SQLLexer.STRING_SINGLE_ESCAPED_QUOTE ||
               tokenType == SQLLexer.STRING_SINGLE_BACKSLASH_ESCAPE ||
               tokenType == SQLLexer.STRING_SINGLE_LINE_CONTINUATION ||
               tokenType == SQLLexer.STRING_SINGLE_NEWLINE ||
               tokenType == SQLLexer.STRING_SINGLE_CHAR ||
               tokenType == SQLLexer.STRING_SINGLE_ANY ||
               tokenType == SQLLexer.STRING_START_DOUBLE ||
               tokenType == SQLLexer.STRING_END_DOUBLE ||
               tokenType == SQLLexer.STRING_DOUBLE_ESCAPED_QUOTE ||
               tokenType == SQLLexer.STRING_DOUBLE_BACKSLASH_ESCAPE ||
               tokenType == SQLLexer.STRING_DOUBLE_LINE_CONTINUATION ||
               tokenType == SQLLexer.STRING_DOUBLE_NEWLINE ||
               tokenType == SQLLexer.STRING_DOUBLE_CHAR ||
               tokenType == SQLLexer.STRING_DOUBLE_ANY;
    }

    /**
     * Checks if a token type is a literal
     * 
     * @param tokenType The token type to check
     * @return true if token is a literal
     */
    public static boolean isLiteral(int tokenType) {
        return tokenType == SQLLexer.IDENTIFIER ||
               isNumericLiteral(tokenType) ||
               isStringLiteralComponent(tokenType);
    }

    /**
     * Checks if a token type is an identifier or variable
     * 
     * @param tokenType The token type to check
     * @return true if token is an identifier or variable type
     */
    public static boolean isIdentifierOrVariable(int tokenType) {
        return tokenType == SQLLexer.IDENTIFIER ||
               tokenType == SQLLexer.SYSTEM_VARIABLE ||
               tokenType == SQLLexer.USER_VARIABLE ||
               tokenType == SQLLexer.DELIMITED_IDENTIFIER_BRACKET ||
               tokenType == SQLLexer.DELIMITED_IDENTIFIER_QUOTE ||
               tokenType == SQLLexer.DELIMITED_IDENTIFIER_BACKTICK;
    }

    /**
     * Checks if a token type is a variable (user or system)
     * 
     * @param tokenType The token type to check
     * @return true if token is a variable type
     */
    public static boolean isVariable(int tokenType) {
        return tokenType == SQLLexer.SYSTEM_VARIABLE ||
               tokenType == SQLLexer.USER_VARIABLE;
    }

    /**
     * Checks if a token type is a data type keyword
     * 
     * @param tokenType The token type to check
     * @return true if token is a data type
     */
    public static boolean isDataType(int tokenType) {
        return tokenType == SQLLexer.INT ||
               tokenType == SQLLexer.BIGINT ||
               tokenType == SQLLexer.SMALLINT ||
               tokenType == SQLLexer.TINYINT ||
               tokenType == SQLLexer.VARCHAR ||
               tokenType == SQLLexer.NVARCHAR ||
               tokenType == SQLLexer.CHAR ||
               tokenType == SQLLexer.NCHAR ||
               tokenType == SQLLexer.TEXT ||
               tokenType == SQLLexer.NTEXT ||
               tokenType == SQLLexer.DATETIME ||
               tokenType == SQLLexer.DATE ||
               tokenType == SQLLexer.TIME ||
               tokenType == SQLLexer.TIMESTAMP ||
               tokenType == SQLLexer.BIT ||
               tokenType == SQLLexer.DECIMAL ||
               tokenType == SQLLexer.NUMERIC ||
               tokenType == SQLLexer.FLOAT ||
               tokenType == SQLLexer.REAL ||
               tokenType == SQLLexer.MONEY ||
               tokenType == SQLLexer.SMALLMONEY ||
               tokenType == SQLLexer.BINARY ||
               tokenType == SQLLexer.VARBINARY ||
               tokenType == SQLLexer.IMAGE ||
               tokenType == SQLLexer.UNIQUEIDENTIFIER ||
               tokenType == SQLLexer.XML ||
               tokenType == SQLLexer.SQL_VARIANT;
    }

    /**
     * Checks if a token type is an aggregate function
     * 
     * @param tokenType The token type to check
     * @return true if token is an aggregate function
     */
    public static boolean isAggregateFunction(int tokenType) {
        return tokenType == SQLLexer.COUNT ||
               tokenType == SQLLexer.SUM ||
               tokenType == SQLLexer.AVG ||
               tokenType == SQLLexer.MIN ||
               tokenType == SQLLexer.MAX;
    }

    /**
     * Checks if a token type is a string start marker
     * 
     * @param tokenType The token type to check
     * @return true if token starts a string
     */
    public static boolean isStringStart(int tokenType) {
        return tokenType == SQLLexer.STRING_START_SINGLE ||
               tokenType == SQLLexer.STRING_START_DOUBLE;
    }

    /**
     * Checks if a token type is a string end marker
     * 
     * @param tokenType The token type to check
     * @return true if token ends a string
     */
    public static boolean isStringEnd(int tokenType) {
        return tokenType == SQLLexer.STRING_END_SINGLE ||
               tokenType == SQLLexer.STRING_END_DOUBLE;
    }
}             