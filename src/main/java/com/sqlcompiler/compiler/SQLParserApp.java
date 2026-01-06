package com.sqlcompiler.compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import com.sqlcompiler.parser.SQLLexer;
import com.sqlcompiler.parser.SQLParser;
import java.util.Scanner;

/**
 * IMPORTANT: Before running this class, execute these Maven commands:
 * 1. mvn clean generate-sources
 * 2. mvn compile
 * 
 * This will generate the SQLParser.java and SQLLexer.java files
 * Generated files location: target/generated-sources/antlr4/
 */

/**
 * SQL Parser Testing Application
 * Tests the SQL parser grammar by parsing SQL input and displaying the parse tree
 */
public class SQLParserApp {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║          SQL PARSER TESTING APPLICATION                        ║");
        System.out.println("║          Using ANTLR4 Version 4.13.2                          ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        // Options for input mode
        System.out.println("Choose input mode:");
        System.out.println("1. Interactive mode (type SQL queries)");
        System.out.println("2. Test predefined SQL queries");
        System.out.println("3. Read SQL script from test.sql");
        System.out.print("\nEnter choice (1, 2, or 3): ");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            interactiveMode(scanner);
        } else if (choice.equals("2")) {
            testPredefinedQueries();
        } else if (choice.equals("3")) {
            readFromTestSql();
        } else {
            System.out.println("Invalid choice. Running test mode by default...\n");
            testPredefinedQueries();
        }

        scanner.close();
    }

    /**
     * Reads and parses SQL queries from the test.sql file in the root folder
     */
    private static void readFromTestSql() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("FILE MODE - Reading from test.sql");
        System.out.println("=".repeat(60) + "\n");

        try {
            java.nio.file.Path filePath = java.nio.file.Paths.get("test.sql");
            if (!java.nio.file.Files.exists(filePath)) {
                System.err.println("Error: test.sql file not found in the root folder.");
                return;
            }

            String content = java.nio.file.Files.readString(filePath);
            parseSQLQuery(content);

        } catch (java.io.IOException e) {
            System.err.println("Error reading test.sql: " + e.getMessage());
        }
    }

    /**
     * Interactive mode - allows user to input SQL queries one by one
     */
    private static void interactiveMode(Scanner scanner) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("INTERACTIVE MODE - Enter SQL queries to parse");
        System.out.println("Type 'exit' to quit");
        System.out.println("=".repeat(60) + "\n");

        while (true) {
            System.out.print("\nSQL> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("\nExiting parser tester. Goodbye!");
                break;
            }

            if (input.isEmpty()) {
                System.out.println("Please enter a SQL query.");
                continue;
            }

            parseSQLQuery(input);
        }
    }

    /**
     * Test predefined SQL queries with various features
     */
    private static void testPredefinedQueries() {
        String[] testQueries = {
            // Basic SELECT
            "SELECT * FROM employees",
            
            // WHERE with AND/OR/NOT
            "SELECT * FROM employees WHERE department = 'IT' AND salary > 50000 OR NOT active = 1",
            
            // IN, BETWEEN, LIKE
            "SELECT * FROM products WHERE category IN ('Electronics', 'Computers') AND price BETWEEN 100 AND 500",
            
            // IS NULL, EXISTS
            "SELECT * FROM customers WHERE email IS NOT NULL AND EXISTS (SELECT 1 FROM orders WHERE customer_id = customers.id)",
            
            // JOIN operations
            "SELECT e.name, d.department FROM employees e INNER JOIN departments d ON e.dept_id = d.id",
            
            // GROUP BY and HAVING
            "SELECT department, AVG(salary) as avg_sal FROM employees GROUP BY department HAVING AVG(salary) > 50000",
            
            // ORDER BY
            "SELECT * FROM products ORDER BY price DESC, name ASC",
            
            // TOP with PERCENT and TIES
            "SELECT TOP 10 PERCENT WITH TIES * FROM sales ORDER BY amount DESC",
            
            // OFFSET/FETCH
            "SELECT * FROM customers ORDER BY id OFFSET 10 ROWS FETCH NEXT 20 ROWS ONLY",
            
            // DISTINCT
            "SELECT DISTINCT country FROM customers",
            
            // CASE expression
            "SELECT name, CASE WHEN salary > 80000 THEN 'High' WHEN salary > 50000 THEN 'Medium' ELSE 'Low' END as salary_grade FROM employees",
            
            // Subquery
            "SELECT * FROM employees WHERE salary > (SELECT AVG(salary) FROM employees)",
            
            // Complex query with multiple features
            "SELECT DISTINCT TOP 5 e.name, d.department, e.salary FROM employees e LEFT JOIN departments d ON e.dept_id = d.id WHERE e.salary BETWEEN 40000 AND 100000 AND e.department NOT IN ('HR', 'Legal') GROUP BY e.name, d.department, e.salary HAVING COUNT(*) > 1 ORDER BY e.salary DESC"
        };

        System.out.println("\n" + "=".repeat(60));
        System.out.println("TEST MODE - Predefined SQL Queries");
        System.out.println("=".repeat(60) + "\n");

        for (int i = 0; i < testQueries.length; i++) {
            System.out.println("\n" + "-".repeat(60));
            System.out.println("Query " + (i + 1) + ":");
            System.out.println("-".repeat(60));
            parseSQLQuery(testQueries[i]);
        }
    }

    /**
     * Parses a SQL query and displays the parse tree
     */
    private static void parseSQLQuery(String sqlQuery) {
        try {
            // Step 1: Create input stream from SQL query string
            CharStream input = CharStreams.fromString(sqlQuery);

            // Step 2: Create lexer instance
            SQLLexer lexer = new SQLLexer(input);
            
            // Add error listener to catch lexer errors
            lexer.removeErrorListeners();
            lexer.addErrorListener(new CustomErrorListener());

            // Step 3: Create token stream
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Step 4: Create parser instance
            SQLParser parser = new SQLParser(tokens);
            
            // Add error listener to catch parser errors
            parser.removeErrorListeners();
            parser.addErrorListener(new CustomErrorListener());

            // Step 5: Parse the input starting from the entry rule
            // Use 'sqlStatements' as the entry point (or 'selectStatement' for SELECT-only)
            ParseTree tree = parser.sqlStatements();

            // Display input query
            System.out.println("\nInput Query: " + sqlQuery);
            
            // Check for syntax errors
            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.out.println("\n❌ PARSING FAILED - Syntax errors detected");
                return;
            }
            
            System.out.println("\n✓ PARSING SUCCESSFUL");
            
            // Display parse tree
            System.out.println("\nParse Tree:");
            System.out.println("-".repeat(70));
            System.out.println(tree.toStringTree(parser));
            
            // Display formatted parse tree
            System.out.println("\n\nFormatted Parse Tree:");
            System.out.println("-".repeat(70));
            printTree(tree, parser, 0);

        } catch (Exception e) {
            System.err.println("\n❌ Error parsing query: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Recursively prints the parse tree in a formatted way
     */
    private static void printTree(ParseTree tree, Parser parser, int indent) {
        // Create indentation
        String indentStr = "  ".repeat(indent);
        
        if (tree instanceof TerminalNode) {
            // Terminal node (leaf) - print the token
            TerminalNode terminal = (TerminalNode) tree;
            if (terminal.getSymbol().getType() != Token.EOF) {
                System.out.println(indentStr + "├─ " + terminal.getText());
            }
        } else if (tree instanceof RuleContext) {
            // Rule node (internal) - print the rule name
            RuleContext context = (RuleContext) tree;
            String ruleName = parser.getRuleNames()[context.getRuleIndex()];
            System.out.println(indentStr + "└─ " + ruleName);
            
            // Recursively print children
            for (int i = 0; i < tree.getChildCount(); i++) {
                printTree(tree.getChild(i), parser, indent + 1);
            }
        }
    }

    /**
     * Custom error listener to display syntax errors in a user-friendly format
     */
    static class CustomErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                                Object offendingSymbol,
                                int line,
                                int charPositionInLine,
                                String msg,
                                RecognitionException e) {
            System.err.println("\n❌ Syntax Error at line " + line + ":" + charPositionInLine);
            System.err.println("   " + msg);
            
            if (offendingSymbol instanceof Token) {
                Token token = (Token) offendingSymbol;
                System.err.println("   Offending token: '" + token.getText() + "'");
            }
        }
    }
}