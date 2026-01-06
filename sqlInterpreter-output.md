# 📁 PROJECT EXPORT FOR LLMs

## 📊 Project Information

- **Project Name**: `sqlInterpreter`
- **Generated On**: 2026-01-05 08:40:47 (Asia/Damascus / GMT+03:00)
- **Total Files Processed**: 17
- **Export Tool**: Easy Whole Project to Single Text File for LLMs v1.1.0
- **Tool Author**: Jota / José Guilherme Pandolfi

### ⚙️ Export Configuration

| Setting | Value |
|---------|-------|
| Language | `en` |
| Max File Size | `1 MB` |
| Include Hidden Files | `false` |
| Output Format | `both` |

## 🌳 Project Structure

```
├── 📁 src/
│   └── 📁 main/
│       ├── 📁 antlr4/
│       │   └── 📁 com/
│       │       └── 📁 sqlcompiler/
│       │           └── 📁 parser/
│       │               ├── 📄 SQLLexer.g4 (15.83 KB)
│       │               └── 📄 SQLParser.g4 (1.39 KB)
│       └── 📁 java/
│           └── 📁 com/
│               └── 📁 sqlcompiler/
│                   ├── 📁 compiler/
│                   │   └── 📄 SQLLexerApp.java (10.83 KB)
│                   └── 📁 parser/
│                       └── 📄 SQLTokenTypeMapper.java (32.41 KB)
├── 📁 target/
│   ├── 📁 classes/
│   │   ├── 📁 com/
│   │   │   └── 📁 sqlcompiler/
│   │   │       ├── 📁 compiler/
│   │   │       │   └── 📄 SQLLexerApp.class (7.4 KB)
│   │   │       └── 📁 parser/
│   │   │           ├── 📄 SQLLexer.class (36.93 KB)
│   │   │           ├── 📄 SQLLexer.interp (62.86 KB)
│   │   │           └── 📄 SQLTokenTypeMapper.class (6.97 KB)
│   │   └── 📄 SQLLexer.tokens (1.94 KB)
│   ├── 📁 generated-sources/
│   │   ├── 📁 annotations/
│   │   └── 📁 antlr4/
│   │       ├── 📁 com/
│   │       │   └── 📁 sqlcompiler/
│   │       │       └── 📁 parser/
│   │       │           ├── 📄 SQLLexer.interp (62.86 KB)
│   │       │           └── 📄 SQLLexer.java (96.43 KB)
│   │       └── 📄 SQLLexer.tokens (1.94 KB)
│   ├── 📁 generated-test-sources/
│   │   └── 📁 test-annotations/
│   ├── 📁 maven-status/
│   │   ├── 📁 antlr4/
│   │   └── 📁 maven-compiler-plugin/
│   │       └── 📁 compile/
│   │           └── 📁 default-compile/
│   │               ├── 📄 createdFiles.lst (129 B)
│   │               └── 📄 inputFiles.lst (315 B)
│   └── 📁 test-classes/
├── 📄 dependency-reduced-pom.xml (4.38 KB)
├── 📄 pom.xml (6.81 KB)
└── 📄 test.sql (29 B)
```

## 📑 Table of Contents

**Project Files:**

- [📄 src/main/java/com/sqlcompiler/compiler/SQLLexerApp.java](#📄-src-main-java-com-sqlcompiler-compiler-sqllexerapp-java)
- [📄 src/main/java/com/sqlcompiler/parser/SQLTokenTypeMapper.java](#📄-src-main-java-com-sqlcompiler-parser-sqltokentypemapper-java)
- [📄 target/generated-sources/antlr4/com/sqlcompiler/parser/SQLLexer.java](#📄-target-generated-sources-antlr4-com-sqlcompiler-parser-sqllexer-java)
- [📄 dependency-reduced-pom.xml](#📄-dependency-reduced-pom-xml)
- [📄 pom.xml](#📄-pom-xml)
- [📄 test.sql](#📄-test-sql)

---

## 📈 Project Statistics

| Metric | Count |
|--------|-------|
| Total Files | 17 |
| Total Directories | 31 |
| Text Files | 6 |
| Binary Files | 11 |
| Total Size | 349.42 KB |

### 📄 File Types Distribution

| Extension | Count |
|-----------|-------|
| `.java` | 3 |
| `.class` | 3 |
| `.g4` | 2 |
| `.interp` | 2 |
| `.tokens` | 2 |
| `.lst` | 2 |
| `.xml` | 2 |
| `.sql` | 1 |

## 💻 File Code Contents

## 🚫 Binary/Excluded Files

The following files were not included in the text content:

- `src/main/antlr4/com/sqlcompiler/parser/SQLLexer.g4`
- `src/main/antlr4/com/sqlcompiler/parser/SQLParser.g4`

### <a id="📄-src-main-java-com-sqlcompiler-compiler-sqllexerapp-java"></a>📄 `src/main/java/com/sqlcompiler/compiler/SQLLexerApp.java`

**File Info:**
- **Size**: 10.83 KB
- **Extension**: `.java`
- **Language**: `java`
- **Location**: `src/main/java/com/sqlcompiler/compiler/SQLLexerApp.java`
- **Relative Path**: `src/main/java/com/sqlcompiler/compiler`
- **Created**: 2026-01-04 11:42:30 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-04 13:17:35 (Asia/Damascus / GMT+03:00)
- **MD5**: `420a5de64f95fe9c09be27d13491a639`
- **SHA256**: `9878e06dcb5cddd7c26038a12c5f3754ac7afd66171b94acecbeb36325243930`
- **Encoding**: UTF-8

**File code content:**

```java
package com.sqlcompiler.compiler;

import org.antlr.v4.runtime.*;
// import org.antlr.v4.runtime.atn.PredictionMode;
import com.sqlcompiler.parser.SQLLexer;
import com.sqlcompiler.parser.SQLTokenTypeMapper;
import java.util.Scanner;

/**
 * IMPORTANT: Before running this class, execute these Maven commands:
 * 1. mvn clean generate-sources
 * 2. mvn compile
 * 
 * This will generate the SQLLexer.java file from SQLLexer.g4
 * Generated files location: target/generated-sources/antlr4/
 */

/**
 * SQL Lexer Testing Application
 * Tests the SQL lexer grammar by tokenizing SQL input
 */
public class SQLLexerApp {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║          SQL LEXER TOKENIZATION TESTER                         ║");
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
     * Reads and tokenizes SQL queries from the test.sql file in the root folder
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
            tokenizeSQLQuery(content);

        } catch (java.io.IOException e) {
            System.err.println("Error reading test.sql: " + e.getMessage());
        }
    }

    /**
     * Interactive mode - allows user to input SQL queries one by one
     * 
     * In this mode, users can:
     * 1. Enter any SQL query they want to test
     * 2. See the tokens generated by the lexer immediately
     * 3. Type 'exit' to quit the application
     * 
     * This is useful for testing specific SQL queries or debugging the lexer
     * 
     * @param scanner Scanner object to read user input from console
     */
    private static void interactiveMode(Scanner scanner) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("INTERACTIVE MODE - Enter SQL queries to tokenize");
        System.out.println("Type 'exit' to quit");
        System.out.println("=".repeat(60) + "\n");

        while (true) {
            System.out.print("\nSQL> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("\nExiting lexer tester. Goodbye!");
                break;
            }

            if (input.isEmpty()) {
                System.out.println("Please enter a SQL query.");
                continue;
            }

            tokenizeSQLQuery(input);
        }
    }

    /**
     * Test predefined SQL queries
     * 
     * This method runs 10 sample SQL queries through the lexer to demonstrate
     * that the lexer correctly tokenizes various SQL statement types:
     * - SELECT queries with WHERE, GROUP BY, ORDER BY, LIMIT clauses
     * - INSERT statements with column lists and values
     * - UPDATE statements with SET clauses
     * - DELETE statements
     * - CREATE TABLE statements
     * - JOIN operations with different join types
     * 
     * This is useful for:
     * 1. Verifying that the lexer grammar works for common SQL patterns
     * 2. Demonstrating the capabilities of the lexer
     * 3. Regression testing to ensure changes don't break existing functionality
     */
    private static void testPredefinedQueries() {
        // Sample SQL queries covering different SQL statement types
        String[] testQueries = {
            "SELECT * FROM employees",
            "SELECT id, name, salary FROM employees WHERE department = 'IT'",
            "SELECT name, AVG(salary) FROM employees GROUP BY department HAVING AVG(salary) > 50000",
            "INSERT INTO users (id, name, email) VALUES (1, 'John Doe', 'john@example.com')",
            "UPDATE employees SET salary = 65000 WHERE id = 5",
            "DELETE FROM employees WHERE department = 'HR'",
            "CREATE TABLE employees (id INT, name VARCHAR(100), salary FLOAT)",
            "SELECT * FROM orders WHERE date BETWEEN '2024-01-01' AND '2024-12-31'",
            "SELECT e.name, d.department FROM employees e JOIN departments d ON e.dept_id = d.id",
            "SELECT DISTINCT country FROM customers ORDER BY country ASC LIMIT 10"
        };

        System.out.println("\n" + "=".repeat(60));
        System.out.println("TEST MODE - Predefined SQL Queries");
        System.out.println("=".repeat(60) + "\n");

        for (int i = 0; i < testQueries.length; i++) {
            System.out.println("\n" + "-".repeat(60));
            System.out.println("Query " + (i + 1) + ":");
            System.out.println("-".repeat(60));
            tokenizeSQLQuery(testQueries[i]);
        }
    }

    /**
     * Tokenizes a SQL query and displays the tokens generated by the lexer
     * 
     * This is the core method that:
     * 1. Takes a SQL query string as input
     * 2. Creates an ANTLR CharStream from the input
     * 3. Creates an SQLLexer instance with the input stream
     * 4. Generates all tokens from the query
     * 5. Displays each token with its type, value, and position
     * 
     * Process Flow:
     *   Input SQL Query
     *        ↓
     *   CharStreams.fromString() → Creates input stream
     *        ↓
     *   SQLLexer(input) → Creates lexer from grammar
     *        ↓
     *   CommonTokenStream → Collects all tokens
     *        ↓
     *   Display results in formatted table
     * 
     * @param sqlQuery The SQL query string to tokenize
     *                 Example: "SELECT * FROM employees WHERE id = 1"
     */
    private static void tokenizeSQLQuery(String sqlQuery) {
        try {
            // Step 1: Create input stream from SQL query string
            // CharStreams provides an input stream that ANTLR can read
            CharStream input = CharStreams.fromString(sqlQuery);

            // Step 2: Create lexer instance
            // The lexer uses the SQLLexer.g4 grammar rules to recognize tokens
            SQLLexer lexer = new SQLLexer(input);

            // Step 3: Set prediction mode for better performance
            // SLL = Stronger LL prediction (faster but less powerful)
            // This is optimized for typical SQL queries
            // lexer.getInterpreter().setPredictionMode(PredictionMode.SLL);

            // Step 4: Create token stream
            // CommonTokenStream collects all tokens from the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Step 5: Fill the token stream (force lexer to tokenize entire input)
            // This ensures all tokens are generated before we process them
            tokens.fill();

            // Display input query
            System.out.println("\nInput Query: " + sqlQuery);
            System.out.println("\nTokens Generated:");
            System.out.println(String.format("%-5s | %-20s | %-15s | %s", "Line", "Token Type", "Value", "Range"));
            System.out.println("-".repeat(70));

            int tokenCount = 0;

            // Step 6: Iterate through all tokens and display their information
            for (Token token : tokens.getTokens()) {
                // Skip EOF (End of File) token as it's not a real token
                if (token.getType() == Token.EOF) {
                    break;
                }

                // Get human-readable token type name (e.g., "SELECT" instead of "1")
                String tokenType = getTokenTypeName(lexer, token.getType());
                
                // Get the actual text of the token from the input
                String tokenValue = token.getText();
                
                // Get line number (which line in input this token appears)
                int line = token.getLine();
                
                // Get column (character position in the line)
                int column = token.getCharPositionInLine();
                
                // Calculate token length for range display
                int tokenLength = tokenValue.length();

                // Display formatted token information
                System.out.println(String.format("%-5d | %-20s | %-15s | [%d:%d-%d]",
                        line, tokenType, tokenValue, column, column, column + tokenLength));

                tokenCount++;
            }

            System.out.println("-".repeat(70));
            System.out.println("Total Tokens: " + tokenCount);

        } catch (Exception e) {
            // Handle any errors that occur during tokenization
            System.err.println("Error tokenizing query: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Gets the human-readable name of a token type
     * 
     * This method now delegates to the SQLTokenTypeMapper utility class.
     * All token type mappings are now centralized in SQLTokenTypeMapper.
     * 
     * IMPORTANT FOR DEVELOPERS:
     * When adding new tokens to the lexer grammar (SQLLexer.g4),
     * add the corresponding case statement in SQLTokenTypeMapper.getTokenName()
     * Do NOT add it here!
     * 
     * @param lexer The SQLLexer instance (no longer used, kept for backward compatibility)
     * @param tokenType The token type code from ANTLR
     * @return The human-readable token type name
     */
    private static String getTokenTypeName(SQLLexer lexer, int tokenType) {
        return SQLTokenTypeMapper.getTokenName(tokenType);
    }
}

```

---

### <a id="📄-src-main-java-com-sqlcompiler-parser-sqltokentypemapper-java"></a>📄 `src/main/java/com/sqlcompiler/parser/SQLTokenTypeMapper.java`

**File Info:**
- **Size**: 32.41 KB
- **Extension**: `.java`
- **Language**: `java`
- **Location**: `src/main/java/com/sqlcompiler/parser/SQLTokenTypeMapper.java`
- **Relative Path**: `src/main/java/com/sqlcompiler/parser`
- **Created**: 2026-01-04 13:01:02 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-05 08:39:39 (Asia/Damascus / GMT+03:00)
- **MD5**: `06b7eefc9c7436b6b8d85818d846bba7`
- **SHA256**: `95679923cbaef127e0d771ace6571880d3135d6ca1f6ebd8a09524bbf11bd8b2`
- **Encoding**: UTF-8

**File code content:**

```java
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
            // STRING LITERALS
            // ═══════════════════════════════════════════════════════════════
            case SQLLexer.STRING:
                return "STRING";

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
        return tokenType == SQLLexer.STRING;
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
        return tokenType == SQLLexer.STRING;
    }

    /**
     * Checks if a token type is a string end marker
     * 
     * @param tokenType The token type to check
     * @return true if token ends a string
     */
    public static boolean isStringEnd(int tokenType) {
        return tokenType == SQLLexer.STRING;
    }
}
```

---

## 🚫 Binary/Excluded Files

The following files were not included in the text content:

- `target/classes/com/sqlcompiler/compiler/SQLLexerApp.class`

## 🚫 Binary/Excluded Files

The following files were not included in the text content:

- `target/classes/com/sqlcompiler/parser/SQLLexer.class`
- `target/classes/com/sqlcompiler/parser/SQLLexer.interp`
- `target/classes/com/sqlcompiler/parser/SQLTokenTypeMapper.class`

## 🚫 Binary/Excluded Files

The following files were not included in the text content:

- `target/classes/SQLLexer.tokens`

### <a id="📄-target-generated-sources-antlr4-com-sqlcompiler-parser-sqllexer-java"></a>📄 `target/generated-sources/antlr4/com/sqlcompiler/parser/SQLLexer.java`

**File Info:**
- **Size**: 96.43 KB
- **Extension**: `.java`
- **Language**: `java`
- **Location**: `target/generated-sources/antlr4/com/sqlcompiler/parser/SQLLexer.java`
- **Relative Path**: `target/generated-sources/antlr4/com/sqlcompiler/parser`
- **Created**: 2026-01-04 13:14:31 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-05 08:37:07 (Asia/Damascus / GMT+03:00)
- **MD5**: `a9b2c105ccf7d16e5fe7ee089bc69352`
- **SHA256**: `3ac019b5bd398f53cc5936eb0aaad12ee2d5145f866b79e4c126f2f74508d92b`
- **Encoding**: ASCII

**File code content:**

```java
// Generated from com/sqlcompiler/parser/SQLLexer.g4 by ANTLR 4.13.2
package com.sqlcompiler.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELECT=1, FROM=2, WHERE=3, HAVING=4, DISTINCT=5, TOP=6, GROUP=7, BY=8, 
		ORDER=9, OFFSET=10, FETCH=11, NEXT=12, FIRST=13, ONLY=14, INSERT=15, INTO=16, 
		UPDATE=17, DELETE=18, VALUES=19, MERGE=20, MATCHED=21, OUTPUT=22, CREATE=23, 
		ALTER=24, DROP=25, TABLE=26, VIEW=27, PROCEDURE=28, FUNCTION=29, INDEX=30, 
		SCHEMA=31, DATABASE=32, TRIGGER=33, INT=34, BIGINT=35, SMALLINT=36, TINYINT=37, 
		VARCHAR=38, NVARCHAR=39, CHAR=40, NCHAR=41, TEXT=42, NTEXT=43, DATETIME=44, 
		DATE=45, TIME=46, TIMESTAMP=47, BIT=48, DECIMAL=49, NUMERIC=50, FLOAT=51, 
		REAL=52, MONEY=53, SMALLMONEY=54, BINARY=55, VARBINARY=56, IMAGE=57, UNIQUEIDENTIFIER=58, 
		XML=59, SQL_VARIANT=60, PRIMARY=61, KEY=62, FOREIGN=63, REFERENCES=64, 
		UNIQUE=65, CHECK=66, DEFAULT=67, CONSTRAINT=68, IDENTITY=69, CLUSTERED=70, 
		NONCLUSTERED=71, JOIN=72, INNER=73, OUTER=74, LEFT=75, RIGHT=76, FULL=77, 
		CROSS=78, ON=79, USING=80, UNION=81, EXCEPT=82, INTERSECT=83, ALL=84, 
		AND=85, OR=86, NOT=87, LIKE=88, IN=89, BETWEEN=90, EXISTS=91, IS=92, NULL=93, 
		ANY=94, SOME=95, COUNT=96, SUM=97, AVG=98, MIN=99, MAX=100, LEN=101, SUBSTRING=102, 
		LTRIM=103, RTRIM=104, UPPER=105, LOWER=106, REPLACE=107, CONCAT=108, CHARINDEX=109, 
		PATINDEX=110, GETDATE=111, GETUTCDATE=112, DATEADD=113, DATEDIFF=114, 
		DATEPART=115, YEAR=116, MONTH=117, DAY=118, CAST=119, CONVERT=120, TRY_CAST=121, 
		TRY_CONVERT=122, OVER=123, PARTITION=124, ROWS=125, RANGE=126, PRECEDING=127, 
		FOLLOWING=128, CURRENT=129, ROW=130, LAG=131, LEAD=132, FIRST_VALUE=133, 
		LAST_VALUE=134, DECLARE=135, SET=136, BEGIN=137, END=138, IF=139, ELSE=140, 
		WHILE=141, BREAK=142, CONTINUE=143, CASE=144, WHEN=145, THEN=146, RETURN=147, 
		TRANSACTION=148, COMMIT=149, ROLLBACK=150, SAVEPOINT=151, SAVE=152, TRY=153, 
		CATCH=154, THROW=155, EXEC=156, EXECUTE=157, OPEN=158, CLOSE=159, DEALLOCATE=160, 
		PRINT=161, RAISERROR=162, USE=163, GO=164, AS=165, WITH=166, OPTION=167, 
		RECOMPILE=168, GRANT=169, REVOKE=170, DENY=171, LOGIN=172, USER=173, ROLE=174, 
		PERMISSION=175, ASC=176, DESC=177, TRUE=178, FALSE=179, SYSTEM_VARIABLE=180, 
		USER_VARIABLE=181, DELIMITED_IDENTIFIER_BRACKET=182, DELIMITED_IDENTIFIER_QUOTE=183, 
		DELIMITED_IDENTIFIER_BACKTICK=184, IDENTIFIER=185, INTEGER=186, FLOATN=187, 
		STRING=188;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SELECT", "FROM", "WHERE", "HAVING", "DISTINCT", "TOP", "GROUP", "BY", 
			"ORDER", "OFFSET", "FETCH", "NEXT", "FIRST", "ONLY", "INSERT", "INTO", 
			"UPDATE", "DELETE", "VALUES", "MERGE", "MATCHED", "OUTPUT", "CREATE", 
			"ALTER", "DROP", "TABLE", "VIEW", "PROCEDURE", "FUNCTION", "INDEX", "SCHEMA", 
			"DATABASE", "TRIGGER", "INT", "BIGINT", "SMALLINT", "TINYINT", "VARCHAR", 
			"NVARCHAR", "CHAR", "NCHAR", "TEXT", "NTEXT", "DATETIME", "DATE", "TIME", 
			"TIMESTAMP", "BIT", "DECIMAL", "NUMERIC", "FLOAT", "REAL", "MONEY", "SMALLMONEY", 
			"BINARY", "VARBINARY", "IMAGE", "UNIQUEIDENTIFIER", "XML", "SQL_VARIANT", 
			"PRIMARY", "KEY", "FOREIGN", "REFERENCES", "UNIQUE", "CHECK", "DEFAULT", 
			"CONSTRAINT", "IDENTITY", "CLUSTERED", "NONCLUSTERED", "JOIN", "INNER", 
			"OUTER", "LEFT", "RIGHT", "FULL", "CROSS", "ON", "USING", "UNION", "EXCEPT", 
			"INTERSECT", "ALL", "AND", "OR", "NOT", "LIKE", "IN", "BETWEEN", "EXISTS", 
			"IS", "NULL", "ANY", "SOME", "COUNT", "SUM", "AVG", "MIN", "MAX", "LEN", 
			"SUBSTRING", "LTRIM", "RTRIM", "UPPER", "LOWER", "REPLACE", "CONCAT", 
			"CHARINDEX", "PATINDEX", "GETDATE", "GETUTCDATE", "DATEADD", "DATEDIFF", 
			"DATEPART", "YEAR", "MONTH", "DAY", "CAST", "CONVERT", "TRY_CAST", "TRY_CONVERT", 
			"OVER", "PARTITION", "ROWS", "RANGE", "PRECEDING", "FOLLOWING", "CURRENT", 
			"ROW", "LAG", "LEAD", "FIRST_VALUE", "LAST_VALUE", "DECLARE", "SET", 
			"BEGIN", "END", "IF", "ELSE", "WHILE", "BREAK", "CONTINUE", "CASE", "WHEN", 
			"THEN", "RETURN", "TRANSACTION", "COMMIT", "ROLLBACK", "SAVEPOINT", "SAVE", 
			"TRY", "CATCH", "THROW", "EXEC", "EXECUTE", "OPEN", "CLOSE", "DEALLOCATE", 
			"PRINT", "RAISERROR", "USE", "GO", "AS", "WITH", "OPTION", "RECOMPILE", 
			"GRANT", "REVOKE", "DENY", "LOGIN", "USER", "ROLE", "PERMISSION", "ASC", 
			"DESC", "TRUE", "FALSE", "SYSTEM_VARIABLE", "USER_VARIABLE", "DELIMITED_IDENTIFIER_BRACKET", 
			"DELIMITED_IDENTIFIER_QUOTE", "DELIMITED_IDENTIFIER_BACKTICK", "IDENTIFIER", 
			"INTEGER", "FLOATN", "STRING", "SINGLE_QUOTED_STRING", "DOUBLE_QUOTED_STRING", 
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SELECT", "FROM", "WHERE", "HAVING", "DISTINCT", "TOP", "GROUP", 
			"BY", "ORDER", "OFFSET", "FETCH", "NEXT", "FIRST", "ONLY", "INSERT", 
			"INTO", "UPDATE", "DELETE", "VALUES", "MERGE", "MATCHED", "OUTPUT", "CREATE", 
			"ALTER", "DROP", "TABLE", "VIEW", "PROCEDURE", "FUNCTION", "INDEX", "SCHEMA", 
			"DATABASE", "TRIGGER", "INT", "BIGINT", "SMALLINT", "TINYINT", "VARCHAR", 
			"NVARCHAR", "CHAR", "NCHAR", "TEXT", "NTEXT", "DATETIME", "DATE", "TIME", 
			"TIMESTAMP", "BIT", "DECIMAL", "NUMERIC", "FLOAT", "REAL", "MONEY", "SMALLMONEY", 
			"BINARY", "VARBINARY", "IMAGE", "UNIQUEIDENTIFIER", "XML", "SQL_VARIANT", 
			"PRIMARY", "KEY", "FOREIGN", "REFERENCES", "UNIQUE", "CHECK", "DEFAULT", 
			"CONSTRAINT", "IDENTITY", "CLUSTERED", "NONCLUSTERED", "JOIN", "INNER", 
			"OUTER", "LEFT", "RIGHT", "FULL", "CROSS", "ON", "USING", "UNION", "EXCEPT", 
			"INTERSECT", "ALL", "AND", "OR", "NOT", "LIKE", "IN", "BETWEEN", "EXISTS", 
			"IS", "NULL", "ANY", "SOME", "COUNT", "SUM", "AVG", "MIN", "MAX", "LEN", 
			"SUBSTRING", "LTRIM", "RTRIM", "UPPER", "LOWER", "REPLACE", "CONCAT", 
			"CHARINDEX", "PATINDEX", "GETDATE", "GETUTCDATE", "DATEADD", "DATEDIFF", 
			"DATEPART", "YEAR", "MONTH", "DAY", "CAST", "CONVERT", "TRY_CAST", "TRY_CONVERT", 
			"OVER", "PARTITION", "ROWS", "RANGE", "PRECEDING", "FOLLOWING", "CURRENT", 
			"ROW", "LAG", "LEAD", "FIRST_VALUE", "LAST_VALUE", "DECLARE", "SET", 
			"BEGIN", "END", "IF", "ELSE", "WHILE", "BREAK", "CONTINUE", "CASE", "WHEN", 
			"THEN", "RETURN", "TRANSACTION", "COMMIT", "ROLLBACK", "SAVEPOINT", "SAVE", 
			"TRY", "CATCH", "THROW", "EXEC", "EXECUTE", "OPEN", "CLOSE", "DEALLOCATE", 
			"PRINT", "RAISERROR", "USE", "GO", "AS", "WITH", "OPTION", "RECOMPILE", 
			"GRANT", "REVOKE", "DENY", "LOGIN", "USER", "ROLE", "PERMISSION", "ASC", 
			"DESC", "TRUE", "FALSE", "SYSTEM_VARIABLE", "USER_VARIABLE", "DELIMITED_IDENTIFIER_BRACKET", 
			"DELIMITED_IDENTIFIER_QUOTE", "DELIMITED_IDENTIFIER_BACKTICK", "IDENTIFIER", 
			"INTEGER", "FLOATN", "STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SQLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u00bc\u06f6\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!"+
		"\u0007!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002"+
		"&\u0007&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002"+
		"+\u0007+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u0002"+
		"0\u00070\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u0002"+
		"5\u00075\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002"+
		":\u0007:\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002"+
		"?\u0007?\u0002@\u0007@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002"+
		"D\u0007D\u0002E\u0007E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002"+
		"I\u0007I\u0002J\u0007J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002"+
		"N\u0007N\u0002O\u0007O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002"+
		"S\u0007S\u0002T\u0007T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002"+
		"X\u0007X\u0002Y\u0007Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002"+
		"]\u0007]\u0002^\u0007^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002"+
		"b\u0007b\u0002c\u0007c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002"+
		"g\u0007g\u0002h\u0007h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002"+
		"l\u0007l\u0002m\u0007m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002"+
		"q\u0007q\u0002r\u0007r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002"+
		"v\u0007v\u0002w\u0007w\u0002x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002"+
		"{\u0007{\u0002|\u0007|\u0002}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f"+
		"\u0002\u0080\u0007\u0080\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082"+
		"\u0002\u0083\u0007\u0083\u0002\u0084\u0007\u0084\u0002\u0085\u0007\u0085"+
		"\u0002\u0086\u0007\u0086\u0002\u0087\u0007\u0087\u0002\u0088\u0007\u0088"+
		"\u0002\u0089\u0007\u0089\u0002\u008a\u0007\u008a\u0002\u008b\u0007\u008b"+
		"\u0002\u008c\u0007\u008c\u0002\u008d\u0007\u008d\u0002\u008e\u0007\u008e"+
		"\u0002\u008f\u0007\u008f\u0002\u0090\u0007\u0090\u0002\u0091\u0007\u0091"+
		"\u0002\u0092\u0007\u0092\u0002\u0093\u0007\u0093\u0002\u0094\u0007\u0094"+
		"\u0002\u0095\u0007\u0095\u0002\u0096\u0007\u0096\u0002\u0097\u0007\u0097"+
		"\u0002\u0098\u0007\u0098\u0002\u0099\u0007\u0099\u0002\u009a\u0007\u009a"+
		"\u0002\u009b\u0007\u009b\u0002\u009c\u0007\u009c\u0002\u009d\u0007\u009d"+
		"\u0002\u009e\u0007\u009e\u0002\u009f\u0007\u009f\u0002\u00a0\u0007\u00a0"+
		"\u0002\u00a1\u0007\u00a1\u0002\u00a2\u0007\u00a2\u0002\u00a3\u0007\u00a3"+
		"\u0002\u00a4\u0007\u00a4\u0002\u00a5\u0007\u00a5\u0002\u00a6\u0007\u00a6"+
		"\u0002\u00a7\u0007\u00a7\u0002\u00a8\u0007\u00a8\u0002\u00a9\u0007\u00a9"+
		"\u0002\u00aa\u0007\u00aa\u0002\u00ab\u0007\u00ab\u0002\u00ac\u0007\u00ac"+
		"\u0002\u00ad\u0007\u00ad\u0002\u00ae\u0007\u00ae\u0002\u00af\u0007\u00af"+
		"\u0002\u00b0\u0007\u00b0\u0002\u00b1\u0007\u00b1\u0002\u00b2\u0007\u00b2"+
		"\u0002\u00b3\u0007\u00b3\u0002\u00b4\u0007\u00b4\u0002\u00b5\u0007\u00b5"+
		"\u0002\u00b6\u0007\u00b6\u0002\u00b7\u0007\u00b7\u0002\u00b8\u0007\u00b8"+
		"\u0002\u00b9\u0007\u00b9\u0002\u00ba\u0007\u00ba\u0002\u00bb\u0007\u00bb"+
		"\u0002\u00bc\u0007\u00bc\u0002\u00bd\u0007\u00bd\u0002\u00be\u0007\u00be"+
		"\u0002\u00bf\u0007\u00bf\u0002\u00c0\u0007\u00c0\u0002\u00c1\u0007\u00c1"+
		"\u0002\u00c2\u0007\u00c2\u0002\u00c3\u0007\u00c3\u0002\u00c4\u0007\u00c4"+
		"\u0002\u00c5\u0007\u00c5\u0002\u00c6\u0007\u00c6\u0002\u00c7\u0007\u00c7"+
		"\u0002\u00c8\u0007\u00c8\u0002\u00c9\u0007\u00c9\u0002\u00ca\u0007\u00ca"+
		"\u0002\u00cb\u0007\u00cb\u0002\u00cc\u0007\u00cc\u0002\u00cd\u0007\u00cd"+
		"\u0002\u00ce\u0007\u00ce\u0002\u00cf\u0007\u00cf\u0002\u00d0\u0007\u00d0"+
		"\u0002\u00d1\u0007\u00d1\u0002\u00d2\u0007\u00d2\u0002\u00d3\u0007\u00d3"+
		"\u0002\u00d4\u0007\u00d4\u0002\u00d5\u0007\u00d5\u0002\u00d6\u0007\u00d6"+
		"\u0002\u00d7\u0007\u00d7\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001!\u0001"+
		"!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0001"+
		"/\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00011\u00011\u00012\u00012\u00012\u0001"+
		"2\u00012\u00012\u00013\u00013\u00013\u00013\u00013\u00014\u00014\u0001"+
		"4\u00014\u00014\u00014\u00015\u00015\u00015\u00015\u00015\u00015\u0001"+
		"5\u00015\u00015\u00015\u00015\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00017\u00018\u00018\u00018\u00018\u00018\u00018\u00019\u00019\u0001"+
		"9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"+
		"9\u00019\u00019\u00019\u00019\u0001:\u0001:\u0001:\u0001:\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001=\u0001"+
		"=\u0001=\u0001=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001"+
		"?\u0001?\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001A\u0001"+
		"A\u0001A\u0001A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0001B\u0001B\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001"+
		"C\u0001C\u0001C\u0001C\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001"+
		"D\u0001D\u0001D\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001"+
		"E\u0001E\u0001E\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001"+
		"F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001G\u0001G\u0001G\u0001G\u0001"+
		"G\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001I\u0001I\u0001I\u0001"+
		"I\u0001I\u0001I\u0001J\u0001J\u0001J\u0001J\u0001J\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001L\u0001L\u0001L\u0001L\u0001L\u0001M\u0001"+
		"M\u0001M\u0001M\u0001M\u0001M\u0001N\u0001N\u0001N\u0001O\u0001O\u0001"+
		"O\u0001O\u0001O\u0001O\u0001P\u0001P\u0001P\u0001P\u0001P\u0001P\u0001"+
		"Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001S\u0001S\u0001S\u0001"+
		"S\u0001T\u0001T\u0001T\u0001T\u0001U\u0001U\u0001U\u0001V\u0001V\u0001"+
		"V\u0001V\u0001W\u0001W\u0001W\u0001W\u0001W\u0001X\u0001X\u0001X\u0001"+
		"Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Z\u0001Z\u0001"+
		"Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001[\u0001[\u0001[\u0001\\\u0001\\\u0001"+
		"\\\u0001\\\u0001\\\u0001]\u0001]\u0001]\u0001]\u0001^\u0001^\u0001^\u0001"+
		"^\u0001^\u0001_\u0001_\u0001_\u0001_\u0001_\u0001_\u0001`\u0001`\u0001"+
		"`\u0001`\u0001a\u0001a\u0001a\u0001a\u0001b\u0001b\u0001b\u0001b\u0001"+
		"c\u0001c\u0001c\u0001c\u0001d\u0001d\u0001d\u0001d\u0001e\u0001e\u0001"+
		"e\u0001e\u0001e\u0001e\u0001e\u0001e\u0001e\u0001e\u0001f\u0001f\u0001"+
		"f\u0001f\u0001f\u0001f\u0001g\u0001g\u0001g\u0001g\u0001g\u0001g\u0001"+
		"h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001i\u0001i\u0001i\u0001i\u0001"+
		"i\u0001i\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001"+
		"k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001l\u0001l\u0001l\u0001"+
		"l\u0001l\u0001l\u0001l\u0001l\u0001l\u0001l\u0001m\u0001m\u0001m\u0001"+
		"m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001n\u0001n\u0001n\u0001n\u0001"+
		"n\u0001n\u0001n\u0001n\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001"+
		"o\u0001o\u0001o\u0001o\u0001o\u0001p\u0001p\u0001p\u0001p\u0001p\u0001"+
		"p\u0001p\u0001p\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001"+
		"q\u0001q\u0001r\u0001r\u0001r\u0001r\u0001r\u0001r\u0001r\u0001r\u0001"+
		"r\u0001s\u0001s\u0001s\u0001s\u0001s\u0001t\u0001t\u0001t\u0001t\u0001"+
		"t\u0001t\u0001u\u0001u\u0001u\u0001u\u0001v\u0001v\u0001v\u0001v\u0001"+
		"v\u0001w\u0001w\u0001w\u0001w\u0001w\u0001w\u0001w\u0001w\u0001x\u0001"+
		"x\u0001x\u0001x\u0001x\u0001x\u0001x\u0001x\u0001x\u0001y\u0001y\u0001"+
		"y\u0001y\u0001y\u0001y\u0001y\u0001y\u0001y\u0001y\u0001y\u0001y\u0001"+
		"z\u0001z\u0001z\u0001z\u0001z\u0001{\u0001{\u0001{\u0001{\u0001{\u0001"+
		"{\u0001{\u0001{\u0001{\u0001{\u0001|\u0001|\u0001|\u0001|\u0001|\u0001"+
		"}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001~\u0001~\u0001~\u0001~\u0001"+
		"~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001\u007f\u0001\u007f\u0001\u007f"+
		"\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f"+
		"\u0001\u007f\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080"+
		"\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0081\u0001\u0081\u0001\u0081"+
		"\u0001\u0081\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0083"+
		"\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0084\u0001\u0084"+
		"\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084"+
		"\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0085\u0001\u0085"+
		"\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085"+
		"\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0086\u0001\u0086\u0001\u0086"+
		"\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0087"+
		"\u0001\u0087\u0001\u0087\u0001\u0087\u0001\u0088\u0001\u0088\u0001\u0088"+
		"\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0089\u0001\u0089\u0001\u0089"+
		"\u0001\u0089\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008b\u0001\u008b"+
		"\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008c\u0001\u008c\u0001\u008c"+
		"\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008d\u0001\u008d\u0001\u008d"+
		"\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008e\u0001\u008e\u0001\u008e"+
		"\u0001\u008e\u0001\u008e\u0001\u008e\u0001\u008e\u0001\u008e\u0001\u008e"+
		"\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u0090"+
		"\u0001\u0090\u0001\u0090\u0001\u0090\u0001\u0090\u0001\u0091\u0001\u0091"+
		"\u0001\u0091\u0001\u0091\u0001\u0091\u0001\u0092\u0001\u0092\u0001\u0092"+
		"\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0093\u0001\u0093"+
		"\u0001\u0093\u0001\u0093\u0001\u0093\u0001\u0093\u0001\u0093\u0001\u0093"+
		"\u0001\u0093\u0001\u0093\u0001\u0093\u0001\u0093\u0001\u0094\u0001\u0094"+
		"\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0095"+
		"\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0095"+
		"\u0001\u0095\u0001\u0095\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096"+
		"\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096"+
		"\u0001\u0097\u0001\u0097\u0001\u0097\u0001\u0097\u0001\u0097\u0001\u0098"+
		"\u0001\u0098\u0001\u0098\u0001\u0098\u0001\u0099\u0001\u0099\u0001\u0099"+
		"\u0001\u0099\u0001\u0099\u0001\u0099\u0001\u009a\u0001\u009a\u0001\u009a"+
		"\u0001\u009a\u0001\u009a\u0001\u009a\u0001\u009b\u0001\u009b\u0001\u009b"+
		"\u0001\u009b\u0001\u009b\u0001\u009c\u0001\u009c\u0001\u009c\u0001\u009c"+
		"\u0001\u009c\u0001\u009c\u0001\u009c\u0001\u009c\u0001\u009d\u0001\u009d"+
		"\u0001\u009d\u0001\u009d\u0001\u009d\u0001\u009e\u0001\u009e\u0001\u009e"+
		"\u0001\u009e\u0001\u009e\u0001\u009e\u0001\u009f\u0001\u009f\u0001\u009f"+
		"\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f"+
		"\u0001\u009f\u0001\u009f\u0001\u00a0\u0001\u00a0\u0001\u00a0\u0001\u00a0"+
		"\u0001\u00a0\u0001\u00a0\u0001\u00a1\u0001\u00a1\u0001\u00a1\u0001\u00a1"+
		"\u0001\u00a1\u0001\u00a1\u0001\u00a1\u0001\u00a1\u0001\u00a1\u0001\u00a1"+
		"\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a3\u0001\u00a3"+
		"\u0001\u00a3\u0001\u00a4\u0001\u00a4\u0001\u00a4\u0001\u00a5\u0001\u00a5"+
		"\u0001\u00a5\u0001\u00a5\u0001\u00a5\u0001\u00a6\u0001\u00a6\u0001\u00a6"+
		"\u0001\u00a6\u0001\u00a6\u0001\u00a6\u0001\u00a6\u0001\u00a7\u0001\u00a7"+
		"\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7"+
		"\u0001\u00a7\u0001\u00a7\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0001\u00a8"+
		"\u0001\u00a8\u0001\u00a8\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9"+
		"\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00aa\u0001\u00aa\u0001\u00aa"+
		"\u0001\u00aa\u0001\u00aa\u0001\u00ab\u0001\u00ab\u0001\u00ab\u0001\u00ab"+
		"\u0001\u00ab\u0001\u00ab\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ac"+
		"\u0001\u00ac\u0001\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ad"+
		"\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00ae"+
		"\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00af"+
		"\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00b0\u0001\u00b0\u0001\u00b0"+
		"\u0001\u00b0\u0001\u00b0\u0001\u00b1\u0001\u00b1\u0001\u00b1\u0001\u00b1"+
		"\u0001\u00b1\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2"+
		"\u0001\u00b2\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3"+
		"\u0005\u00b3\u0660\b\u00b3\n\u00b3\f\u00b3\u0663\t\u00b3\u0001\u00b4\u0001"+
		"\u00b4\u0001\u00b4\u0005\u00b4\u0668\b\u00b4\n\u00b4\f\u00b4\u066b\t\u00b4"+
		"\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0005\u00b5\u0671\b\u00b5"+
		"\n\u00b5\f\u00b5\u0674\t\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b6\u0001"+
		"\u00b6\u0001\u00b6\u0001\u00b6\u0005\u00b6\u067c\b\u00b6\n\u00b6\f\u00b6"+
		"\u067f\t\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b7\u0001\u00b7\u0001\u00b7"+
		"\u0001\u00b7\u0005\u00b7\u0687\b\u00b7\n\u00b7\f\u00b7\u068a\t\u00b7\u0001"+
		"\u00b7\u0001\u00b7\u0001\u00b8\u0001\u00b8\u0005\u00b8\u0690\b\u00b8\n"+
		"\u00b8\f\u00b8\u0693\t\u00b8\u0001\u00b9\u0004\u00b9\u0696\b\u00b9\u000b"+
		"\u00b9\f\u00b9\u0697\u0001\u00ba\u0004\u00ba\u069b\b\u00ba\u000b\u00ba"+
		"\f\u00ba\u069c\u0001\u00ba\u0001\u00ba\u0004\u00ba\u06a1\b\u00ba\u000b"+
		"\u00ba\f\u00ba\u06a2\u0001\u00bb\u0001\u00bb\u0003\u00bb\u06a7\b\u00bb"+
		"\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc"+
		"\u0005\u00bc\u06af\b\u00bc\n\u00bc\f\u00bc\u06b2\t\u00bc\u0001\u00bc\u0001"+
		"\u00bc\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0005\u00bd\u06bc\b\u00bd\n\u00bd\f\u00bd\u06bf\t\u00bd\u0001\u00bd"+
		"\u0001\u00bd\u0001\u00be\u0001\u00be\u0001\u00bf\u0001\u00bf\u0001\u00c0"+
		"\u0001\u00c0\u0001\u00c1\u0001\u00c1\u0001\u00c2\u0001\u00c2\u0001\u00c3"+
		"\u0001\u00c3\u0001\u00c4\u0001\u00c4\u0001\u00c5\u0001\u00c5\u0001\u00c6"+
		"\u0001\u00c6\u0001\u00c7\u0001\u00c7\u0001\u00c8\u0001\u00c8\u0001\u00c9"+
		"\u0001\u00c9\u0001\u00ca\u0001\u00ca\u0001\u00cb\u0001\u00cb\u0001\u00cc"+
		"\u0001\u00cc\u0001\u00cd\u0001\u00cd\u0001\u00ce\u0001\u00ce\u0001\u00cf"+
		"\u0001\u00cf\u0001\u00d0\u0001\u00d0\u0001\u00d1\u0001\u00d1\u0001\u00d2"+
		"\u0001\u00d2\u0001\u00d3\u0001\u00d3\u0001\u00d4\u0001\u00d4\u0001\u00d5"+
		"\u0001\u00d5\u0001\u00d6\u0001\u00d6\u0001\u00d7\u0001\u00d7\u0000\u0000"+
		"\u00d8\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%"+
		"K&M\'O(Q)S*U+W,Y-[.]/_0a1c2e3g4i5k6m7o8q9s:u;w<y={>}?\u007f@\u0081A\u0083"+
		"B\u0085C\u0087D\u0089E\u008bF\u008dG\u008fH\u0091I\u0093J\u0095K\u0097"+
		"L\u0099M\u009bN\u009dO\u009fP\u00a1Q\u00a3R\u00a5S\u00a7T\u00a9U\u00ab"+
		"V\u00adW\u00afX\u00b1Y\u00b3Z\u00b5[\u00b7\\\u00b9]\u00bb^\u00bd_\u00bf"+
		"`\u00c1a\u00c3b\u00c5c\u00c7d\u00c9e\u00cbf\u00cdg\u00cfh\u00d1i\u00d3"+
		"j\u00d5k\u00d7l\u00d9m\u00dbn\u00ddo\u00dfp\u00e1q\u00e3r\u00e5s\u00e7"+
		"t\u00e9u\u00ebv\u00edw\u00efx\u00f1y\u00f3z\u00f5{\u00f7|\u00f9}\u00fb"+
		"~\u00fd\u007f\u00ff\u0080\u0101\u0081\u0103\u0082\u0105\u0083\u0107\u0084"+
		"\u0109\u0085\u010b\u0086\u010d\u0087\u010f\u0088\u0111\u0089\u0113\u008a"+
		"\u0115\u008b\u0117\u008c\u0119\u008d\u011b\u008e\u011d\u008f\u011f\u0090"+
		"\u0121\u0091\u0123\u0092\u0125\u0093\u0127\u0094\u0129\u0095\u012b\u0096"+
		"\u012d\u0097\u012f\u0098\u0131\u0099\u0133\u009a\u0135\u009b\u0137\u009c"+
		"\u0139\u009d\u013b\u009e\u013d\u009f\u013f\u00a0\u0141\u00a1\u0143\u00a2"+
		"\u0145\u00a3\u0147\u00a4\u0149\u00a5\u014b\u00a6\u014d\u00a7\u014f\u00a8"+
		"\u0151\u00a9\u0153\u00aa\u0155\u00ab\u0157\u00ac\u0159\u00ad\u015b\u00ae"+
		"\u015d\u00af\u015f\u00b0\u0161\u00b1\u0163\u00b2\u0165\u00b3\u0167\u00b4"+
		"\u0169\u00b5\u016b\u00b6\u016d\u00b7\u016f\u00b8\u0171\u00b9\u0173\u00ba"+
		"\u0175\u00bb\u0177\u00bc\u0179\u0000\u017b\u0000\u017d\u0000\u017f\u0000"+
		"\u0181\u0000\u0183\u0000\u0185\u0000\u0187\u0000\u0189\u0000\u018b\u0000"+
		"\u018d\u0000\u018f\u0000\u0191\u0000\u0193\u0000\u0195\u0000\u0197\u0000"+
		"\u0199\u0000\u019b\u0000\u019d\u0000\u019f\u0000\u01a1\u0000\u01a3\u0000"+
		"\u01a5\u0000\u01a7\u0000\u01a9\u0000\u01ab\u0000\u01ad\u0000\u01af\u0000"+
		"\u0001\u0000!\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u0000\\\\\u0002"+
		"\u0000\"\"\\\\\u0002\u0000\\\\``\u0001\u000009\u0002\u0000\'\'\\\\\u0002"+
		"\u0000AAaa\u0002\u0000BBbb\u0002\u0000CCcc\u0002\u0000DDdd\u0002\u0000"+
		"EEee\u0002\u0000FFff\u0002\u0000GGgg\u0002\u0000HHhh\u0002\u0000IIii\u0002"+
		"\u0000JJjj\u0002\u0000KKkk\u0002\u0000LLll\u0002\u0000MMmm\u0002\u0000"+
		"NNnn\u0002\u0000OOoo\u0002\u0000PPpp\u0002\u0000QQqq\u0002\u0000RRrr\u0002"+
		"\u0000SSss\u0002\u0000TTtt\u0002\u0000UUuu\u0002\u0000VVvv\u0002\u0000"+
		"WWww\u0002\u0000XXxx\u0002\u0000YYyy\u0002\u0000ZZzz\u06ec\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000"+
		"\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u0000"+
		"5\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001"+
		"\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000"+
		"\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000"+
		"C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001"+
		"\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000"+
		"\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000"+
		"Q\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001"+
		"\u0000\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000"+
		"\u0000\u0000[\u0001\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000"+
		"_\u0001\u0000\u0000\u0000\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001"+
		"\u0000\u0000\u0000\u0000e\u0001\u0000\u0000\u0000\u0000g\u0001\u0000\u0000"+
		"\u0000\u0000i\u0001\u0000\u0000\u0000\u0000k\u0001\u0000\u0000\u0000\u0000"+
		"m\u0001\u0000\u0000\u0000\u0000o\u0001\u0000\u0000\u0000\u0000q\u0001"+
		"\u0000\u0000\u0000\u0000s\u0001\u0000\u0000\u0000\u0000u\u0001\u0000\u0000"+
		"\u0000\u0000w\u0001\u0000\u0000\u0000\u0000y\u0001\u0000\u0000\u0000\u0000"+
		"{\u0001\u0000\u0000\u0000\u0000}\u0001\u0000\u0000\u0000\u0000\u007f\u0001"+
		"\u0000\u0000\u0000\u0000\u0081\u0001\u0000\u0000\u0000\u0000\u0083\u0001"+
		"\u0000\u0000\u0000\u0000\u0085\u0001\u0000\u0000\u0000\u0000\u0087\u0001"+
		"\u0000\u0000\u0000\u0000\u0089\u0001\u0000\u0000\u0000\u0000\u008b\u0001"+
		"\u0000\u0000\u0000\u0000\u008d\u0001\u0000\u0000\u0000\u0000\u008f\u0001"+
		"\u0000\u0000\u0000\u0000\u0091\u0001\u0000\u0000\u0000\u0000\u0093\u0001"+
		"\u0000\u0000\u0000\u0000\u0095\u0001\u0000\u0000\u0000\u0000\u0097\u0001"+
		"\u0000\u0000\u0000\u0000\u0099\u0001\u0000\u0000\u0000\u0000\u009b\u0001"+
		"\u0000\u0000\u0000\u0000\u009d\u0001\u0000\u0000\u0000\u0000\u009f\u0001"+
		"\u0000\u0000\u0000\u0000\u00a1\u0001\u0000\u0000\u0000\u0000\u00a3\u0001"+
		"\u0000\u0000\u0000\u0000\u00a5\u0001\u0000\u0000\u0000\u0000\u00a7\u0001"+
		"\u0000\u0000\u0000\u0000\u00a9\u0001\u0000\u0000\u0000\u0000\u00ab\u0001"+
		"\u0000\u0000\u0000\u0000\u00ad\u0001\u0000\u0000\u0000\u0000\u00af\u0001"+
		"\u0000\u0000\u0000\u0000\u00b1\u0001\u0000\u0000\u0000\u0000\u00b3\u0001"+
		"\u0000\u0000\u0000\u0000\u00b5\u0001\u0000\u0000\u0000\u0000\u00b7\u0001"+
		"\u0000\u0000\u0000\u0000\u00b9\u0001\u0000\u0000\u0000\u0000\u00bb\u0001"+
		"\u0000\u0000\u0000\u0000\u00bd\u0001\u0000\u0000\u0000\u0000\u00bf\u0001"+
		"\u0000\u0000\u0000\u0000\u00c1\u0001\u0000\u0000\u0000\u0000\u00c3\u0001"+
		"\u0000\u0000\u0000\u0000\u00c5\u0001\u0000\u0000\u0000\u0000\u00c7\u0001"+
		"\u0000\u0000\u0000\u0000\u00c9\u0001\u0000\u0000\u0000\u0000\u00cb\u0001"+
		"\u0000\u0000\u0000\u0000\u00cd\u0001\u0000\u0000\u0000\u0000\u00cf\u0001"+
		"\u0000\u0000\u0000\u0000\u00d1\u0001\u0000\u0000\u0000\u0000\u00d3\u0001"+
		"\u0000\u0000\u0000\u0000\u00d5\u0001\u0000\u0000\u0000\u0000\u00d7\u0001"+
		"\u0000\u0000\u0000\u0000\u00d9\u0001\u0000\u0000\u0000\u0000\u00db\u0001"+
		"\u0000\u0000\u0000\u0000\u00dd\u0001\u0000\u0000\u0000\u0000\u00df\u0001"+
		"\u0000\u0000\u0000\u0000\u00e1\u0001\u0000\u0000\u0000\u0000\u00e3\u0001"+
		"\u0000\u0000\u0000\u0000\u00e5\u0001\u0000\u0000\u0000\u0000\u00e7\u0001"+
		"\u0000\u0000\u0000\u0000\u00e9\u0001\u0000\u0000\u0000\u0000\u00eb\u0001"+
		"\u0000\u0000\u0000\u0000\u00ed\u0001\u0000\u0000\u0000\u0000\u00ef\u0001"+
		"\u0000\u0000\u0000\u0000\u00f1\u0001\u0000\u0000\u0000\u0000\u00f3\u0001"+
		"\u0000\u0000\u0000\u0000\u00f5\u0001\u0000\u0000\u0000\u0000\u00f7\u0001"+
		"\u0000\u0000\u0000\u0000\u00f9\u0001\u0000\u0000\u0000\u0000\u00fb\u0001"+
		"\u0000\u0000\u0000\u0000\u00fd\u0001\u0000\u0000\u0000\u0000\u00ff\u0001"+
		"\u0000\u0000\u0000\u0000\u0101\u0001\u0000\u0000\u0000\u0000\u0103\u0001"+
		"\u0000\u0000\u0000\u0000\u0105\u0001\u0000\u0000\u0000\u0000\u0107\u0001"+
		"\u0000\u0000\u0000\u0000\u0109\u0001\u0000\u0000\u0000\u0000\u010b\u0001"+
		"\u0000\u0000\u0000\u0000\u010d\u0001\u0000\u0000\u0000\u0000\u010f\u0001"+
		"\u0000\u0000\u0000\u0000\u0111\u0001\u0000\u0000\u0000\u0000\u0113\u0001"+
		"\u0000\u0000\u0000\u0000\u0115\u0001\u0000\u0000\u0000\u0000\u0117\u0001"+
		"\u0000\u0000\u0000\u0000\u0119\u0001\u0000\u0000\u0000\u0000\u011b\u0001"+
		"\u0000\u0000\u0000\u0000\u011d\u0001\u0000\u0000\u0000\u0000\u011f\u0001"+
		"\u0000\u0000\u0000\u0000\u0121\u0001\u0000\u0000\u0000\u0000\u0123\u0001"+
		"\u0000\u0000\u0000\u0000\u0125\u0001\u0000\u0000\u0000\u0000\u0127\u0001"+
		"\u0000\u0000\u0000\u0000\u0129\u0001\u0000\u0000\u0000\u0000\u012b\u0001"+
		"\u0000\u0000\u0000\u0000\u012d\u0001\u0000\u0000\u0000\u0000\u012f\u0001"+
		"\u0000\u0000\u0000\u0000\u0131\u0001\u0000\u0000\u0000\u0000\u0133\u0001"+
		"\u0000\u0000\u0000\u0000\u0135\u0001\u0000\u0000\u0000\u0000\u0137\u0001"+
		"\u0000\u0000\u0000\u0000\u0139\u0001\u0000\u0000\u0000\u0000\u013b\u0001"+
		"\u0000\u0000\u0000\u0000\u013d\u0001\u0000\u0000\u0000\u0000\u013f\u0001"+
		"\u0000\u0000\u0000\u0000\u0141\u0001\u0000\u0000\u0000\u0000\u0143\u0001"+
		"\u0000\u0000\u0000\u0000\u0145\u0001\u0000\u0000\u0000\u0000\u0147\u0001"+
		"\u0000\u0000\u0000\u0000\u0149\u0001\u0000\u0000\u0000\u0000\u014b\u0001"+
		"\u0000\u0000\u0000\u0000\u014d\u0001\u0000\u0000\u0000\u0000\u014f\u0001"+
		"\u0000\u0000\u0000\u0000\u0151\u0001\u0000\u0000\u0000\u0000\u0153\u0001"+
		"\u0000\u0000\u0000\u0000\u0155\u0001\u0000\u0000\u0000\u0000\u0157\u0001"+
		"\u0000\u0000\u0000\u0000\u0159\u0001\u0000\u0000\u0000\u0000\u015b\u0001"+
		"\u0000\u0000\u0000\u0000\u015d\u0001\u0000\u0000\u0000\u0000\u015f\u0001"+
		"\u0000\u0000\u0000\u0000\u0161\u0001\u0000\u0000\u0000\u0000\u0163\u0001"+
		"\u0000\u0000\u0000\u0000\u0165\u0001\u0000\u0000\u0000\u0000\u0167\u0001"+
		"\u0000\u0000\u0000\u0000\u0169\u0001\u0000\u0000\u0000\u0000\u016b\u0001"+
		"\u0000\u0000\u0000\u0000\u016d\u0001\u0000\u0000\u0000\u0000\u016f\u0001"+
		"\u0000\u0000\u0000\u0000\u0171\u0001\u0000\u0000\u0000\u0000\u0173\u0001"+
		"\u0000\u0000\u0000\u0000\u0175\u0001\u0000\u0000\u0000\u0000\u0177\u0001"+
		"\u0000\u0000\u0000\u0001\u01b1\u0001\u0000\u0000\u0000\u0003\u01b8\u0001"+
		"\u0000\u0000\u0000\u0005\u01bd\u0001\u0000\u0000\u0000\u0007\u01c3\u0001"+
		"\u0000\u0000\u0000\t\u01ca\u0001\u0000\u0000\u0000\u000b\u01d3\u0001\u0000"+
		"\u0000\u0000\r\u01d7\u0001\u0000\u0000\u0000\u000f\u01dd\u0001\u0000\u0000"+
		"\u0000\u0011\u01e0\u0001\u0000\u0000\u0000\u0013\u01e6\u0001\u0000\u0000"+
		"\u0000\u0015\u01ed\u0001\u0000\u0000\u0000\u0017\u01f3\u0001\u0000\u0000"+
		"\u0000\u0019\u01f8\u0001\u0000\u0000\u0000\u001b\u01fe\u0001\u0000\u0000"+
		"\u0000\u001d\u0203\u0001\u0000\u0000\u0000\u001f\u020a\u0001\u0000\u0000"+
		"\u0000!\u020f\u0001\u0000\u0000\u0000#\u0216\u0001\u0000\u0000\u0000%"+
		"\u021d\u0001\u0000\u0000\u0000\'\u0224\u0001\u0000\u0000\u0000)\u022a"+
		"\u0001\u0000\u0000\u0000+\u0232\u0001\u0000\u0000\u0000-\u0239\u0001\u0000"+
		"\u0000\u0000/\u0240\u0001\u0000\u0000\u00001\u0246\u0001\u0000\u0000\u0000"+
		"3\u024b\u0001\u0000\u0000\u00005\u0251\u0001\u0000\u0000\u00007\u0256"+
		"\u0001\u0000\u0000\u00009\u0260\u0001\u0000\u0000\u0000;\u0269\u0001\u0000"+
		"\u0000\u0000=\u026f\u0001\u0000\u0000\u0000?\u0276\u0001\u0000\u0000\u0000"+
		"A\u027f\u0001\u0000\u0000\u0000C\u0287\u0001\u0000\u0000\u0000E\u028b"+
		"\u0001\u0000\u0000\u0000G\u0292\u0001\u0000\u0000\u0000I\u029b\u0001\u0000"+
		"\u0000\u0000K\u02a3\u0001\u0000\u0000\u0000M\u02ab\u0001\u0000\u0000\u0000"+
		"O\u02b4\u0001\u0000\u0000\u0000Q\u02b9\u0001\u0000\u0000\u0000S\u02bf"+
		"\u0001\u0000\u0000\u0000U\u02c4\u0001\u0000\u0000\u0000W\u02ca\u0001\u0000"+
		"\u0000\u0000Y\u02d3\u0001\u0000\u0000\u0000[\u02d8\u0001\u0000\u0000\u0000"+
		"]\u02dd\u0001\u0000\u0000\u0000_\u02e7\u0001\u0000\u0000\u0000a\u02eb"+
		"\u0001\u0000\u0000\u0000c\u02f3\u0001\u0000\u0000\u0000e\u02fb\u0001\u0000"+
		"\u0000\u0000g\u0301\u0001\u0000\u0000\u0000i\u0306\u0001\u0000\u0000\u0000"+
		"k\u030c\u0001\u0000\u0000\u0000m\u0317\u0001\u0000\u0000\u0000o\u031e"+
		"\u0001\u0000\u0000\u0000q\u0328\u0001\u0000\u0000\u0000s\u032e\u0001\u0000"+
		"\u0000\u0000u\u033f\u0001\u0000\u0000\u0000w\u0343\u0001\u0000\u0000\u0000"+
		"y\u034f\u0001\u0000\u0000\u0000{\u0357\u0001\u0000\u0000\u0000}\u035b"+
		"\u0001\u0000\u0000\u0000\u007f\u0363\u0001\u0000\u0000\u0000\u0081\u036e"+
		"\u0001\u0000\u0000\u0000\u0083\u0375\u0001\u0000\u0000\u0000\u0085\u037b"+
		"\u0001\u0000\u0000\u0000\u0087\u0383\u0001\u0000\u0000\u0000\u0089\u038e"+
		"\u0001\u0000\u0000\u0000\u008b\u0397\u0001\u0000\u0000\u0000\u008d\u03a1"+
		"\u0001\u0000\u0000\u0000\u008f\u03ae\u0001\u0000\u0000\u0000\u0091\u03b3"+
		"\u0001\u0000\u0000\u0000\u0093\u03b9\u0001\u0000\u0000\u0000\u0095\u03bf"+
		"\u0001\u0000\u0000\u0000\u0097\u03c4\u0001\u0000\u0000\u0000\u0099\u03ca"+
		"\u0001\u0000\u0000\u0000\u009b\u03cf\u0001\u0000\u0000\u0000\u009d\u03d5"+
		"\u0001\u0000\u0000\u0000\u009f\u03d8\u0001\u0000\u0000\u0000\u00a1\u03de"+
		"\u0001\u0000\u0000\u0000\u00a3\u03e4\u0001\u0000\u0000\u0000\u00a5\u03eb"+
		"\u0001\u0000\u0000\u0000\u00a7\u03f5\u0001\u0000\u0000\u0000\u00a9\u03f9"+
		"\u0001\u0000\u0000\u0000\u00ab\u03fd\u0001\u0000\u0000\u0000\u00ad\u0400"+
		"\u0001\u0000\u0000\u0000\u00af\u0404\u0001\u0000\u0000\u0000\u00b1\u0409"+
		"\u0001\u0000\u0000\u0000\u00b3\u040c\u0001\u0000\u0000\u0000\u00b5\u0414"+
		"\u0001\u0000\u0000\u0000\u00b7\u041b\u0001\u0000\u0000\u0000\u00b9\u041e"+
		"\u0001\u0000\u0000\u0000\u00bb\u0423\u0001\u0000\u0000\u0000\u00bd\u0427"+
		"\u0001\u0000\u0000\u0000\u00bf\u042c\u0001\u0000\u0000\u0000\u00c1\u0432"+
		"\u0001\u0000\u0000\u0000\u00c3\u0436\u0001\u0000\u0000\u0000\u00c5\u043a"+
		"\u0001\u0000\u0000\u0000\u00c7\u043e\u0001\u0000\u0000\u0000\u00c9\u0442"+
		"\u0001\u0000\u0000\u0000\u00cb\u0446\u0001\u0000\u0000\u0000\u00cd\u0450"+
		"\u0001\u0000\u0000\u0000\u00cf\u0456\u0001\u0000\u0000\u0000\u00d1\u045c"+
		"\u0001\u0000\u0000\u0000\u00d3\u0462\u0001\u0000\u0000\u0000\u00d5\u0468"+
		"\u0001\u0000\u0000\u0000\u00d7\u0470\u0001\u0000\u0000\u0000\u00d9\u0477"+
		"\u0001\u0000\u0000\u0000\u00db\u0481\u0001\u0000\u0000\u0000\u00dd\u048a"+
		"\u0001\u0000\u0000\u0000\u00df\u0492\u0001\u0000\u0000\u0000\u00e1\u049d"+
		"\u0001\u0000\u0000\u0000\u00e3\u04a5\u0001\u0000\u0000\u0000\u00e5\u04ae"+
		"\u0001\u0000\u0000\u0000\u00e7\u04b7\u0001\u0000\u0000\u0000\u00e9\u04bc"+
		"\u0001\u0000\u0000\u0000\u00eb\u04c2\u0001\u0000\u0000\u0000\u00ed\u04c6"+
		"\u0001\u0000\u0000\u0000\u00ef\u04cb\u0001\u0000\u0000\u0000\u00f1\u04d3"+
		"\u0001\u0000\u0000\u0000\u00f3\u04dc\u0001\u0000\u0000\u0000\u00f5\u04e8"+
		"\u0001\u0000\u0000\u0000\u00f7\u04ed\u0001\u0000\u0000\u0000\u00f9\u04f7"+
		"\u0001\u0000\u0000\u0000\u00fb\u04fc\u0001\u0000\u0000\u0000\u00fd\u0502"+
		"\u0001\u0000\u0000\u0000\u00ff\u050c\u0001\u0000\u0000\u0000\u0101\u0516"+
		"\u0001\u0000\u0000\u0000\u0103\u051e\u0001\u0000\u0000\u0000\u0105\u0522"+
		"\u0001\u0000\u0000\u0000\u0107\u0526\u0001\u0000\u0000\u0000\u0109\u052b"+
		"\u0001\u0000\u0000\u0000\u010b\u0537\u0001\u0000\u0000\u0000\u010d\u0542"+
		"\u0001\u0000\u0000\u0000\u010f\u054a\u0001\u0000\u0000\u0000\u0111\u054e"+
		"\u0001\u0000\u0000\u0000\u0113\u0554\u0001\u0000\u0000\u0000\u0115\u0558"+
		"\u0001\u0000\u0000\u0000\u0117\u055b\u0001\u0000\u0000\u0000\u0119\u0560"+
		"\u0001\u0000\u0000\u0000\u011b\u0566\u0001\u0000\u0000\u0000\u011d\u056c"+
		"\u0001\u0000\u0000\u0000\u011f\u0575\u0001\u0000\u0000\u0000\u0121\u057a"+
		"\u0001\u0000\u0000\u0000\u0123\u057f\u0001\u0000\u0000\u0000\u0125\u0584"+
		"\u0001\u0000\u0000\u0000\u0127\u058b\u0001\u0000\u0000\u0000\u0129\u0597"+
		"\u0001\u0000\u0000\u0000\u012b\u059e\u0001\u0000\u0000\u0000\u012d\u05a7"+
		"\u0001\u0000\u0000\u0000\u012f\u05b1\u0001\u0000\u0000\u0000\u0131\u05b6"+
		"\u0001\u0000\u0000\u0000\u0133\u05ba\u0001\u0000\u0000\u0000\u0135\u05c0"+
		"\u0001\u0000\u0000\u0000\u0137\u05c6\u0001\u0000\u0000\u0000\u0139\u05cb"+
		"\u0001\u0000\u0000\u0000\u013b\u05d3\u0001\u0000\u0000\u0000\u013d\u05d8"+
		"\u0001\u0000\u0000\u0000\u013f\u05de\u0001\u0000\u0000\u0000\u0141\u05e9"+
		"\u0001\u0000\u0000\u0000\u0143\u05ef\u0001\u0000\u0000\u0000\u0145\u05f9"+
		"\u0001\u0000\u0000\u0000\u0147\u05fd\u0001\u0000\u0000\u0000\u0149\u0600"+
		"\u0001\u0000\u0000\u0000\u014b\u0603\u0001\u0000\u0000\u0000\u014d\u0608"+
		"\u0001\u0000\u0000\u0000\u014f\u060f\u0001\u0000\u0000\u0000\u0151\u0619"+
		"\u0001\u0000\u0000\u0000\u0153\u061f\u0001\u0000\u0000\u0000\u0155\u0626"+
		"\u0001\u0000\u0000\u0000\u0157\u062b\u0001\u0000\u0000\u0000\u0159\u0631"+
		"\u0001\u0000\u0000\u0000\u015b\u0636\u0001\u0000\u0000\u0000\u015d\u063b"+
		"\u0001\u0000\u0000\u0000\u015f\u0646\u0001\u0000\u0000\u0000\u0161\u064a"+
		"\u0001\u0000\u0000\u0000\u0163\u064f\u0001\u0000\u0000\u0000\u0165\u0654"+
		"\u0001\u0000\u0000\u0000\u0167\u065a\u0001\u0000\u0000\u0000\u0169\u0664"+
		"\u0001\u0000\u0000\u0000\u016b\u066c\u0001\u0000\u0000\u0000\u016d\u0677"+
		"\u0001\u0000\u0000\u0000\u016f\u0682\u0001\u0000\u0000\u0000\u0171\u068d"+
		"\u0001\u0000\u0000\u0000\u0173\u0695\u0001\u0000\u0000\u0000\u0175\u069a"+
		"\u0001\u0000\u0000\u0000\u0177\u06a6\u0001\u0000\u0000\u0000\u0179\u06a8"+
		"\u0001\u0000\u0000\u0000\u017b\u06b5\u0001\u0000\u0000\u0000\u017d\u06c2"+
		"\u0001\u0000\u0000\u0000\u017f\u06c4\u0001\u0000\u0000\u0000\u0181\u06c6"+
		"\u0001\u0000\u0000\u0000\u0183\u06c8\u0001\u0000\u0000\u0000\u0185\u06ca"+
		"\u0001\u0000\u0000\u0000\u0187\u06cc\u0001\u0000\u0000\u0000\u0189\u06ce"+
		"\u0001\u0000\u0000\u0000\u018b\u06d0\u0001\u0000\u0000\u0000\u018d\u06d2"+
		"\u0001\u0000\u0000\u0000\u018f\u06d4\u0001\u0000\u0000\u0000\u0191\u06d6"+
		"\u0001\u0000\u0000\u0000\u0193\u06d8\u0001\u0000\u0000\u0000\u0195\u06da"+
		"\u0001\u0000\u0000\u0000\u0197\u06dc\u0001\u0000\u0000\u0000\u0199\u06de"+
		"\u0001\u0000\u0000\u0000\u019b\u06e0\u0001\u0000\u0000\u0000\u019d\u06e2"+
		"\u0001\u0000\u0000\u0000\u019f\u06e4\u0001\u0000\u0000\u0000\u01a1\u06e6"+
		"\u0001\u0000\u0000\u0000\u01a3\u06e8\u0001\u0000\u0000\u0000\u01a5\u06ea"+
		"\u0001\u0000\u0000\u0000\u01a7\u06ec\u0001\u0000\u0000\u0000\u01a9\u06ee"+
		"\u0001\u0000\u0000\u0000\u01ab\u06f0\u0001\u0000\u0000\u0000\u01ad\u06f2"+
		"\u0001\u0000\u0000\u0000\u01af\u06f4\u0001\u0000\u0000\u0000\u01b1\u01b2"+
		"\u0003\u01a1\u00d0\u0000\u01b2\u01b3\u0003\u0185\u00c2\u0000\u01b3\u01b4"+
		"\u0003\u0193\u00c9\u0000\u01b4\u01b5\u0003\u0185\u00c2\u0000\u01b5\u01b6"+
		"\u0003\u0181\u00c0\u0000\u01b6\u01b7\u0003\u01a3\u00d1\u0000\u01b7\u0002"+
		"\u0001\u0000\u0000\u0000\u01b8\u01b9\u0003\u0187\u00c3\u0000\u01b9\u01ba"+
		"\u0003\u019f\u00cf\u0000\u01ba\u01bb\u0003\u0199\u00cc\u0000\u01bb\u01bc"+
		"\u0003\u0195\u00ca\u0000\u01bc\u0004\u0001\u0000\u0000\u0000\u01bd\u01be"+
		"\u0003\u01a9\u00d4\u0000\u01be\u01bf\u0003\u018b\u00c5\u0000\u01bf\u01c0"+
		"\u0003\u0185\u00c2\u0000\u01c0\u01c1\u0003\u019f\u00cf\u0000\u01c1\u01c2"+
		"\u0003\u0185\u00c2\u0000\u01c2\u0006\u0001\u0000\u0000\u0000\u01c3\u01c4"+
		"\u0003\u018b\u00c5\u0000\u01c4\u01c5\u0003\u017d\u00be\u0000\u01c5\u01c6"+
		"\u0003\u01a7\u00d3\u0000\u01c6\u01c7\u0003\u018d\u00c6\u0000\u01c7\u01c8"+
		"\u0003\u0197\u00cb\u0000\u01c8\u01c9\u0003\u0189\u00c4\u0000\u01c9\b\u0001"+
		"\u0000\u0000\u0000\u01ca\u01cb\u0003\u0183\u00c1\u0000\u01cb\u01cc\u0003"+
		"\u018d\u00c6\u0000\u01cc\u01cd\u0003\u01a1\u00d0\u0000\u01cd\u01ce\u0003"+
		"\u01a3\u00d1\u0000\u01ce\u01cf\u0003\u018d\u00c6\u0000\u01cf\u01d0\u0003"+
		"\u0197\u00cb\u0000\u01d0\u01d1\u0003\u0181\u00c0\u0000\u01d1\u01d2\u0003"+
		"\u01a3\u00d1\u0000\u01d2\n\u0001\u0000\u0000\u0000\u01d3\u01d4\u0003\u01a3"+
		"\u00d1\u0000\u01d4\u01d5\u0003\u0199\u00cc\u0000\u01d5\u01d6\u0003\u019b"+
		"\u00cd\u0000\u01d6\f\u0001\u0000\u0000\u0000\u01d7\u01d8\u0003\u0189\u00c4"+
		"\u0000\u01d8\u01d9\u0003\u019f\u00cf\u0000\u01d9\u01da\u0003\u0199\u00cc"+
		"\u0000\u01da\u01db\u0003\u01a5\u00d2\u0000\u01db\u01dc\u0003\u019b\u00cd"+
		"\u0000\u01dc\u000e\u0001\u0000\u0000\u0000\u01dd\u01de\u0003\u017f\u00bf"+
		"\u0000\u01de\u01df\u0003\u01ad\u00d6\u0000\u01df\u0010\u0001\u0000\u0000"+
		"\u0000\u01e0\u01e1\u0003\u0199\u00cc\u0000\u01e1\u01e2\u0003\u019f\u00cf"+
		"\u0000\u01e2\u01e3\u0003\u0183\u00c1\u0000\u01e3\u01e4\u0003\u0185\u00c2"+
		"\u0000\u01e4\u01e5\u0003\u019f\u00cf\u0000\u01e5\u0012\u0001\u0000\u0000"+
		"\u0000\u01e6\u01e7\u0003\u0199\u00cc\u0000\u01e7\u01e8\u0003\u0187\u00c3"+
		"\u0000\u01e8\u01e9\u0003\u0187\u00c3\u0000\u01e9\u01ea\u0003\u01a1\u00d0"+
		"\u0000\u01ea\u01eb\u0003\u0185\u00c2\u0000\u01eb\u01ec\u0003\u01a3\u00d1"+
		"\u0000\u01ec\u0014\u0001\u0000\u0000\u0000\u01ed\u01ee\u0003\u0187\u00c3"+
		"\u0000\u01ee\u01ef\u0003\u0185\u00c2\u0000\u01ef\u01f0\u0003\u01a3\u00d1"+
		"\u0000\u01f0\u01f1\u0003\u0181\u00c0\u0000\u01f1\u01f2\u0003\u018b\u00c5"+
		"\u0000\u01f2\u0016\u0001\u0000\u0000\u0000\u01f3\u01f4\u0003\u0197\u00cb"+
		"\u0000\u01f4\u01f5\u0003\u0185\u00c2\u0000\u01f5\u01f6\u0003\u01ab\u00d5"+
		"\u0000\u01f6\u01f7\u0003\u01a3\u00d1\u0000\u01f7\u0018\u0001\u0000\u0000"+
		"\u0000\u01f8\u01f9\u0003\u0187\u00c3\u0000\u01f9\u01fa\u0003\u018d\u00c6"+
		"\u0000\u01fa\u01fb\u0003\u019f\u00cf\u0000\u01fb\u01fc\u0003\u01a1\u00d0"+
		"\u0000\u01fc\u01fd\u0003\u01a3\u00d1\u0000\u01fd\u001a\u0001\u0000\u0000"+
		"\u0000\u01fe\u01ff\u0003\u0199\u00cc\u0000\u01ff\u0200\u0003\u0197\u00cb"+
		"\u0000\u0200\u0201\u0003\u0193\u00c9\u0000\u0201\u0202\u0003\u01ad\u00d6"+
		"\u0000\u0202\u001c\u0001\u0000\u0000\u0000\u0203\u0204\u0003\u018d\u00c6"+
		"\u0000\u0204\u0205\u0003\u0197\u00cb\u0000\u0205\u0206\u0003\u01a1\u00d0"+
		"\u0000\u0206\u0207\u0003\u0185\u00c2\u0000\u0207\u0208\u0003\u019f\u00cf"+
		"\u0000\u0208\u0209\u0003\u01a3\u00d1\u0000\u0209\u001e\u0001\u0000\u0000"+
		"\u0000\u020a\u020b\u0003\u018d\u00c6\u0000\u020b\u020c\u0003\u0197\u00cb"+
		"\u0000\u020c\u020d\u0003\u01a3\u00d1\u0000\u020d\u020e\u0003\u0199\u00cc"+
		"\u0000\u020e \u0001\u0000\u0000\u0000\u020f\u0210\u0003\u01a5\u00d2\u0000"+
		"\u0210\u0211\u0003\u019b\u00cd\u0000\u0211\u0212\u0003\u0183\u00c1\u0000"+
		"\u0212\u0213\u0003\u017d\u00be\u0000\u0213\u0214\u0003\u01a3\u00d1\u0000"+
		"\u0214\u0215\u0003\u0185\u00c2\u0000\u0215\"\u0001\u0000\u0000\u0000\u0216"+
		"\u0217\u0003\u0183\u00c1\u0000\u0217\u0218\u0003\u0185\u00c2\u0000\u0218"+
		"\u0219\u0003\u0193\u00c9\u0000\u0219\u021a\u0003\u0185\u00c2\u0000\u021a"+
		"\u021b\u0003\u01a3\u00d1\u0000\u021b\u021c\u0003\u0185\u00c2\u0000\u021c"+
		"$\u0001\u0000\u0000\u0000\u021d\u021e\u0003\u01a7\u00d3\u0000\u021e\u021f"+
		"\u0003\u017d\u00be\u0000\u021f\u0220\u0003\u0193\u00c9\u0000\u0220\u0221"+
		"\u0003\u01a5\u00d2\u0000\u0221\u0222\u0003\u0185\u00c2\u0000\u0222\u0223"+
		"\u0003\u01a1\u00d0\u0000\u0223&\u0001\u0000\u0000\u0000\u0224\u0225\u0003"+
		"\u0195\u00ca\u0000\u0225\u0226\u0003\u0185\u00c2\u0000\u0226\u0227\u0003"+
		"\u019f\u00cf\u0000\u0227\u0228\u0003\u0189\u00c4\u0000\u0228\u0229\u0003"+
		"\u0185\u00c2\u0000\u0229(\u0001\u0000\u0000\u0000\u022a\u022b\u0003\u0195"+
		"\u00ca\u0000\u022b\u022c\u0003\u017d\u00be\u0000\u022c\u022d\u0003\u01a3"+
		"\u00d1\u0000\u022d\u022e\u0003\u0181\u00c0\u0000\u022e\u022f\u0003\u018b"+
		"\u00c5\u0000\u022f\u0230\u0003\u0185\u00c2\u0000\u0230\u0231\u0003\u0183"+
		"\u00c1\u0000\u0231*\u0001\u0000\u0000\u0000\u0232\u0233\u0003\u0199\u00cc"+
		"\u0000\u0233\u0234\u0003\u01a5\u00d2\u0000\u0234\u0235\u0003\u01a3\u00d1"+
		"\u0000\u0235\u0236\u0003\u019b\u00cd\u0000\u0236\u0237\u0003\u01a5\u00d2"+
		"\u0000\u0237\u0238\u0003\u01a3\u00d1\u0000\u0238,\u0001\u0000\u0000\u0000"+
		"\u0239\u023a\u0003\u0181\u00c0\u0000\u023a\u023b\u0003\u019f\u00cf\u0000"+
		"\u023b\u023c\u0003\u0185\u00c2\u0000\u023c\u023d\u0003\u017d\u00be\u0000"+
		"\u023d\u023e\u0003\u01a3\u00d1\u0000\u023e\u023f\u0003\u0185\u00c2\u0000"+
		"\u023f.\u0001\u0000\u0000\u0000\u0240\u0241\u0003\u017d\u00be\u0000\u0241"+
		"\u0242\u0003\u0193\u00c9\u0000\u0242\u0243\u0003\u01a3\u00d1\u0000\u0243"+
		"\u0244\u0003\u0185\u00c2\u0000\u0244\u0245\u0003\u019f\u00cf\u0000\u0245"+
		"0\u0001\u0000\u0000\u0000\u0246\u0247\u0003\u0183\u00c1\u0000\u0247\u0248"+
		"\u0003\u019f\u00cf\u0000\u0248\u0249\u0003\u0199\u00cc\u0000\u0249\u024a"+
		"\u0003\u019b\u00cd\u0000\u024a2\u0001\u0000\u0000\u0000\u024b\u024c\u0003"+
		"\u01a3\u00d1\u0000\u024c\u024d\u0003\u017d\u00be\u0000\u024d\u024e\u0003"+
		"\u017f\u00bf\u0000\u024e\u024f\u0003\u0193\u00c9\u0000\u024f\u0250\u0003"+
		"\u0185\u00c2\u0000\u02504\u0001\u0000\u0000\u0000\u0251\u0252\u0003\u01a7"+
		"\u00d3\u0000\u0252\u0253\u0003\u018d\u00c6\u0000\u0253\u0254\u0003\u0185"+
		"\u00c2\u0000\u0254\u0255\u0003\u01a9\u00d4\u0000\u02556\u0001\u0000\u0000"+
		"\u0000\u0256\u0257\u0003\u019b\u00cd\u0000\u0257\u0258\u0003\u019f\u00cf"+
		"\u0000\u0258\u0259\u0003\u0199\u00cc\u0000\u0259\u025a\u0003\u0181\u00c0"+
		"\u0000\u025a\u025b\u0003\u0185\u00c2\u0000\u025b\u025c\u0003\u0183\u00c1"+
		"\u0000\u025c\u025d\u0003\u01a5\u00d2\u0000\u025d\u025e\u0003\u019f\u00cf"+
		"\u0000\u025e\u025f\u0003\u0185\u00c2\u0000\u025f8\u0001\u0000\u0000\u0000"+
		"\u0260\u0261\u0003\u0187\u00c3\u0000\u0261\u0262\u0003\u01a5\u00d2\u0000"+
		"\u0262\u0263\u0003\u0197\u00cb\u0000\u0263\u0264\u0003\u0181\u00c0\u0000"+
		"\u0264\u0265\u0003\u01a3\u00d1\u0000\u0265\u0266\u0003\u018d\u00c6\u0000"+
		"\u0266\u0267\u0003\u0199\u00cc\u0000\u0267\u0268\u0003\u0197\u00cb\u0000"+
		"\u0268:\u0001\u0000\u0000\u0000\u0269\u026a\u0003\u018d\u00c6\u0000\u026a"+
		"\u026b\u0003\u0197\u00cb\u0000\u026b\u026c\u0003\u0183\u00c1\u0000\u026c"+
		"\u026d\u0003\u0185\u00c2\u0000\u026d\u026e\u0003\u01ab\u00d5\u0000\u026e"+
		"<\u0001\u0000\u0000\u0000\u026f\u0270\u0003\u01a1\u00d0\u0000\u0270\u0271"+
		"\u0003\u0181\u00c0\u0000\u0271\u0272\u0003\u018b\u00c5\u0000\u0272\u0273"+
		"\u0003\u0185\u00c2\u0000\u0273\u0274\u0003\u0195\u00ca\u0000\u0274\u0275"+
		"\u0003\u017d\u00be\u0000\u0275>\u0001\u0000\u0000\u0000\u0276\u0277\u0003"+
		"\u0183\u00c1\u0000\u0277\u0278\u0003\u017d\u00be\u0000\u0278\u0279\u0003"+
		"\u01a3\u00d1\u0000\u0279\u027a\u0003\u017d\u00be\u0000\u027a\u027b\u0003"+
		"\u017f\u00bf\u0000\u027b\u027c\u0003\u017d\u00be\u0000\u027c\u027d\u0003"+
		"\u01a1\u00d0\u0000\u027d\u027e\u0003\u0185\u00c2\u0000\u027e@\u0001\u0000"+
		"\u0000\u0000\u027f\u0280\u0003\u01a3\u00d1\u0000\u0280\u0281\u0003\u019f"+
		"\u00cf\u0000\u0281\u0282\u0003\u018d\u00c6\u0000\u0282\u0283\u0003\u0189"+
		"\u00c4\u0000\u0283\u0284\u0003\u0189\u00c4\u0000\u0284\u0285\u0003\u0185"+
		"\u00c2\u0000\u0285\u0286\u0003\u019f\u00cf\u0000\u0286B\u0001\u0000\u0000"+
		"\u0000\u0287\u0288\u0003\u018d\u00c6\u0000\u0288\u0289\u0003\u0197\u00cb"+
		"\u0000\u0289\u028a\u0003\u01a3\u00d1\u0000\u028aD\u0001\u0000\u0000\u0000"+
		"\u028b\u028c\u0003\u017f\u00bf\u0000\u028c\u028d\u0003\u018d\u00c6\u0000"+
		"\u028d\u028e\u0003\u0189\u00c4\u0000\u028e\u028f\u0003\u018d\u00c6\u0000"+
		"\u028f\u0290\u0003\u0197\u00cb\u0000\u0290\u0291\u0003\u01a3\u00d1\u0000"+
		"\u0291F\u0001\u0000\u0000\u0000\u0292\u0293\u0003\u01a1\u00d0\u0000\u0293"+
		"\u0294\u0003\u0195\u00ca\u0000\u0294\u0295\u0003\u017d\u00be\u0000\u0295"+
		"\u0296\u0003\u0193\u00c9\u0000\u0296\u0297\u0003\u0193\u00c9\u0000\u0297"+
		"\u0298\u0003\u018d\u00c6\u0000\u0298\u0299\u0003\u0197\u00cb\u0000\u0299"+
		"\u029a\u0003\u01a3\u00d1\u0000\u029aH\u0001\u0000\u0000\u0000\u029b\u029c"+
		"\u0003\u01a3\u00d1\u0000\u029c\u029d\u0003\u018d\u00c6\u0000\u029d\u029e"+
		"\u0003\u0197\u00cb\u0000\u029e\u029f\u0003\u01ad\u00d6\u0000\u029f\u02a0"+
		"\u0003\u018d\u00c6\u0000\u02a0\u02a1\u0003\u0197\u00cb\u0000\u02a1\u02a2"+
		"\u0003\u01a3\u00d1\u0000\u02a2J\u0001\u0000\u0000\u0000\u02a3\u02a4\u0003"+
		"\u01a7\u00d3\u0000\u02a4\u02a5\u0003\u017d\u00be\u0000\u02a5\u02a6\u0003"+
		"\u019f\u00cf\u0000\u02a6\u02a7\u0003\u0181\u00c0\u0000\u02a7\u02a8\u0003"+
		"\u018b\u00c5\u0000\u02a8\u02a9\u0003\u017d\u00be\u0000\u02a9\u02aa\u0003"+
		"\u019f\u00cf\u0000\u02aaL\u0001\u0000\u0000\u0000\u02ab\u02ac\u0003\u0197"+
		"\u00cb\u0000\u02ac\u02ad\u0003\u01a7\u00d3\u0000\u02ad\u02ae\u0003\u017d"+
		"\u00be\u0000\u02ae\u02af\u0003\u019f\u00cf\u0000\u02af\u02b0\u0003\u0181"+
		"\u00c0\u0000\u02b0\u02b1\u0003\u018b\u00c5\u0000\u02b1\u02b2\u0003\u017d"+
		"\u00be\u0000\u02b2\u02b3\u0003\u019f\u00cf\u0000\u02b3N\u0001\u0000\u0000"+
		"\u0000\u02b4\u02b5\u0003\u0181\u00c0\u0000\u02b5\u02b6\u0003\u018b\u00c5"+
		"\u0000\u02b6\u02b7\u0003\u017d\u00be\u0000\u02b7\u02b8\u0003\u019f\u00cf"+
		"\u0000\u02b8P\u0001\u0000\u0000\u0000\u02b9\u02ba\u0003\u0197\u00cb\u0000"+
		"\u02ba\u02bb\u0003\u0181\u00c0\u0000\u02bb\u02bc\u0003\u018b\u00c5\u0000"+
		"\u02bc\u02bd\u0003\u017d\u00be\u0000\u02bd\u02be\u0003\u019f\u00cf\u0000"+
		"\u02beR\u0001\u0000\u0000\u0000\u02bf\u02c0\u0003\u01a3\u00d1\u0000\u02c0"+
		"\u02c1\u0003\u0185\u00c2\u0000\u02c1\u02c2\u0003\u01ab\u00d5\u0000\u02c2"+
		"\u02c3\u0003\u01a3\u00d1\u0000\u02c3T\u0001\u0000\u0000\u0000\u02c4\u02c5"+
		"\u0003\u0197\u00cb\u0000\u02c5\u02c6\u0003\u01a3\u00d1\u0000\u02c6\u02c7"+
		"\u0003\u0185\u00c2\u0000\u02c7\u02c8\u0003\u01ab\u00d5\u0000\u02c8\u02c9"+
		"\u0003\u01a3\u00d1\u0000\u02c9V\u0001\u0000\u0000\u0000\u02ca\u02cb\u0003"+
		"\u0183\u00c1\u0000\u02cb\u02cc\u0003\u017d\u00be\u0000\u02cc\u02cd\u0003"+
		"\u01a3\u00d1\u0000\u02cd\u02ce\u0003\u0185\u00c2\u0000\u02ce\u02cf\u0003"+
		"\u01a3\u00d1\u0000\u02cf\u02d0\u0003\u018d\u00c6\u0000\u02d0\u02d1\u0003"+
		"\u0195\u00ca\u0000\u02d1\u02d2\u0003\u0185\u00c2\u0000\u02d2X\u0001\u0000"+
		"\u0000\u0000\u02d3\u02d4\u0003\u0183\u00c1\u0000\u02d4\u02d5\u0003\u017d"+
		"\u00be\u0000\u02d5\u02d6\u0003\u01a3\u00d1\u0000\u02d6\u02d7\u0003\u0185"+
		"\u00c2\u0000\u02d7Z\u0001\u0000\u0000\u0000\u02d8\u02d9\u0003\u01a3\u00d1"+
		"\u0000\u02d9\u02da\u0003\u018d\u00c6\u0000\u02da\u02db\u0003\u0195\u00ca"+
		"\u0000\u02db\u02dc\u0003\u0185\u00c2\u0000\u02dc\\\u0001\u0000\u0000\u0000"+
		"\u02dd\u02de\u0003\u01a3\u00d1\u0000\u02de\u02df\u0003\u018d\u00c6\u0000"+
		"\u02df\u02e0\u0003\u0195\u00ca\u0000\u02e0\u02e1\u0003\u0185\u00c2\u0000"+
		"\u02e1\u02e2\u0003\u01a1\u00d0\u0000\u02e2\u02e3\u0003\u01a3\u00d1\u0000"+
		"\u02e3\u02e4\u0003\u017d\u00be\u0000\u02e4\u02e5\u0003\u0195\u00ca\u0000"+
		"\u02e5\u02e6\u0003\u019b\u00cd\u0000\u02e6^\u0001\u0000\u0000\u0000\u02e7"+
		"\u02e8\u0003\u017f\u00bf\u0000\u02e8\u02e9\u0003\u018d\u00c6\u0000\u02e9"+
		"\u02ea\u0003\u01a3\u00d1\u0000\u02ea`\u0001\u0000\u0000\u0000\u02eb\u02ec"+
		"\u0003\u0183\u00c1\u0000\u02ec\u02ed\u0003\u0185\u00c2\u0000\u02ed\u02ee"+
		"\u0003\u0181\u00c0\u0000\u02ee\u02ef\u0003\u018d\u00c6\u0000\u02ef\u02f0"+
		"\u0003\u0195\u00ca\u0000\u02f0\u02f1\u0003\u017d\u00be\u0000\u02f1\u02f2"+
		"\u0003\u0193\u00c9\u0000\u02f2b\u0001\u0000\u0000\u0000\u02f3\u02f4\u0003"+
		"\u0197\u00cb\u0000\u02f4\u02f5\u0003\u01a5\u00d2\u0000\u02f5\u02f6\u0003"+
		"\u0195\u00ca\u0000\u02f6\u02f7\u0003\u0185\u00c2\u0000\u02f7\u02f8\u0003"+
		"\u019f\u00cf\u0000\u02f8\u02f9\u0003\u018d\u00c6\u0000\u02f9\u02fa\u0003"+
		"\u0181\u00c0\u0000\u02fad\u0001\u0000\u0000\u0000\u02fb\u02fc\u0003\u0187"+
		"\u00c3\u0000\u02fc\u02fd\u0003\u0193\u00c9\u0000\u02fd\u02fe\u0003\u0199"+
		"\u00cc\u0000\u02fe\u02ff\u0003\u017d\u00be\u0000\u02ff\u0300\u0003\u01a3"+
		"\u00d1\u0000\u0300f\u0001\u0000\u0000\u0000\u0301\u0302\u0003\u019f\u00cf"+
		"\u0000\u0302\u0303\u0003\u0185\u00c2\u0000\u0303\u0304\u0003\u017d\u00be"+
		"\u0000\u0304\u0305\u0003\u0193\u00c9\u0000\u0305h\u0001\u0000\u0000\u0000"+
		"\u0306\u0307\u0003\u0195\u00ca\u0000\u0307\u0308\u0003\u0199\u00cc\u0000"+
		"\u0308\u0309\u0003\u0197\u00cb\u0000\u0309\u030a\u0003\u0185\u00c2\u0000"+
		"\u030a\u030b\u0003\u01ad\u00d6\u0000\u030bj\u0001\u0000\u0000\u0000\u030c"+
		"\u030d\u0003\u01a1\u00d0\u0000\u030d\u030e\u0003\u0195\u00ca\u0000\u030e"+
		"\u030f\u0003\u017d\u00be\u0000\u030f\u0310\u0003\u0193\u00c9\u0000\u0310"+
		"\u0311\u0003\u0193\u00c9\u0000\u0311\u0312\u0003\u0195\u00ca\u0000\u0312"+
		"\u0313\u0003\u0199\u00cc\u0000\u0313\u0314\u0003\u0197\u00cb\u0000\u0314"+
		"\u0315\u0003\u0185\u00c2\u0000\u0315\u0316\u0003\u01ad\u00d6\u0000\u0316"+
		"l\u0001\u0000\u0000\u0000\u0317\u0318\u0003\u017f\u00bf\u0000\u0318\u0319"+
		"\u0003\u018d\u00c6\u0000\u0319\u031a\u0003\u0197\u00cb\u0000\u031a\u031b"+
		"\u0003\u017d\u00be\u0000\u031b\u031c\u0003\u019f\u00cf\u0000\u031c\u031d"+
		"\u0003\u01ad\u00d6\u0000\u031dn\u0001\u0000\u0000\u0000\u031e\u031f\u0003"+
		"\u01a7\u00d3\u0000\u031f\u0320\u0003\u017d\u00be\u0000\u0320\u0321\u0003"+
		"\u019f\u00cf\u0000\u0321\u0322\u0003\u017f\u00bf\u0000\u0322\u0323\u0003"+
		"\u018d\u00c6\u0000\u0323\u0324\u0003\u0197\u00cb\u0000\u0324\u0325\u0003"+
		"\u017d\u00be\u0000\u0325\u0326\u0003\u019f\u00cf\u0000\u0326\u0327\u0003"+
		"\u01ad\u00d6\u0000\u0327p\u0001\u0000\u0000\u0000\u0328\u0329\u0003\u018d"+
		"\u00c6\u0000\u0329\u032a\u0003\u0195\u00ca\u0000\u032a\u032b\u0003\u017d"+
		"\u00be\u0000\u032b\u032c\u0003\u0189\u00c4\u0000\u032c\u032d\u0003\u0185"+
		"\u00c2\u0000\u032dr\u0001\u0000\u0000\u0000\u032e\u032f\u0003\u01a5\u00d2"+
		"\u0000\u032f\u0330\u0003\u0197\u00cb\u0000\u0330\u0331\u0003\u018d\u00c6"+
		"\u0000\u0331\u0332\u0003\u019d\u00ce\u0000\u0332\u0333\u0003\u01a5\u00d2"+
		"\u0000\u0333\u0334\u0003\u0185\u00c2\u0000\u0334\u0335\u0003\u018d\u00c6"+
		"\u0000\u0335\u0336\u0003\u0183\u00c1\u0000\u0336\u0337\u0003\u0185\u00c2"+
		"\u0000\u0337\u0338\u0003\u0197\u00cb\u0000\u0338\u0339\u0003\u01a3\u00d1"+
		"\u0000\u0339\u033a\u0003\u018d\u00c6\u0000\u033a\u033b\u0003\u0187\u00c3"+
		"\u0000\u033b\u033c\u0003\u018d\u00c6\u0000\u033c\u033d\u0003\u0185\u00c2"+
		"\u0000\u033d\u033e\u0003\u019f\u00cf\u0000\u033et\u0001\u0000\u0000\u0000"+
		"\u033f\u0340\u0003\u01ab\u00d5\u0000\u0340\u0341\u0003\u0195\u00ca\u0000"+
		"\u0341\u0342\u0003\u0193\u00c9\u0000\u0342v\u0001\u0000\u0000\u0000\u0343"+
		"\u0344\u0003\u01a1\u00d0\u0000\u0344\u0345\u0003\u019d\u00ce\u0000\u0345"+
		"\u0346\u0003\u0193\u00c9\u0000\u0346\u0347\u0005_\u0000\u0000\u0347\u0348"+
		"\u0003\u01a7\u00d3\u0000\u0348\u0349\u0003\u017d\u00be\u0000\u0349\u034a"+
		"\u0003\u019f\u00cf\u0000\u034a\u034b\u0003\u018d\u00c6\u0000\u034b\u034c"+
		"\u0003\u017d\u00be\u0000\u034c\u034d\u0003\u0197\u00cb\u0000\u034d\u034e"+
		"\u0003\u01a3\u00d1\u0000\u034ex\u0001\u0000\u0000\u0000\u034f\u0350\u0003"+
		"\u019b\u00cd\u0000\u0350\u0351\u0003\u019f\u00cf\u0000\u0351\u0352\u0003"+
		"\u018d\u00c6\u0000\u0352\u0353\u0003\u0195\u00ca\u0000\u0353\u0354\u0003"+
		"\u017d\u00be\u0000\u0354\u0355\u0003\u019f\u00cf\u0000\u0355\u0356\u0003"+
		"\u01ad\u00d6\u0000\u0356z\u0001\u0000\u0000\u0000\u0357\u0358\u0003\u0191"+
		"\u00c8\u0000\u0358\u0359\u0003\u0185\u00c2\u0000\u0359\u035a\u0003\u01ad"+
		"\u00d6\u0000\u035a|\u0001\u0000\u0000\u0000\u035b\u035c\u0003\u0187\u00c3"+
		"\u0000\u035c\u035d\u0003\u0199\u00cc\u0000\u035d\u035e\u0003\u019f\u00cf"+
		"\u0000\u035e\u035f\u0003\u0185\u00c2\u0000\u035f\u0360\u0003\u018d\u00c6"+
		"\u0000\u0360\u0361\u0003\u0189\u00c4\u0000\u0361\u0362\u0003\u0197\u00cb"+
		"\u0000\u0362~\u0001\u0000\u0000\u0000\u0363\u0364\u0003\u019f\u00cf\u0000"+
		"\u0364\u0365\u0003\u0185\u00c2\u0000\u0365\u0366\u0003\u0187\u00c3\u0000"+
		"\u0366\u0367\u0003\u0185\u00c2\u0000\u0367\u0368\u0003\u019f\u00cf\u0000"+
		"\u0368\u0369\u0003\u0185\u00c2\u0000\u0369\u036a\u0003\u0197\u00cb\u0000"+
		"\u036a\u036b\u0003\u0181\u00c0\u0000\u036b\u036c\u0003\u0185\u00c2\u0000"+
		"\u036c\u036d\u0003\u01a1\u00d0\u0000\u036d\u0080\u0001\u0000\u0000\u0000"+
		"\u036e\u036f\u0003\u01a5\u00d2\u0000\u036f\u0370\u0003\u0197\u00cb\u0000"+
		"\u0370\u0371\u0003\u018d\u00c6\u0000\u0371\u0372\u0003\u019d\u00ce\u0000"+
		"\u0372\u0373\u0003\u01a5\u00d2\u0000\u0373\u0374\u0003\u0185\u00c2\u0000"+
		"\u0374\u0082\u0001\u0000\u0000\u0000\u0375\u0376\u0003\u0181\u00c0\u0000"+
		"\u0376\u0377\u0003\u018b\u00c5\u0000\u0377\u0378\u0003\u0185\u00c2\u0000"+
		"\u0378\u0379\u0003\u0181\u00c0\u0000\u0379\u037a\u0003\u0191\u00c8\u0000"+
		"\u037a\u0084\u0001\u0000\u0000\u0000\u037b\u037c\u0003\u0183\u00c1\u0000"+
		"\u037c\u037d\u0003\u0185\u00c2\u0000\u037d\u037e\u0003\u0187\u00c3\u0000"+
		"\u037e\u037f\u0003\u017d\u00be\u0000\u037f\u0380\u0003\u01a5\u00d2\u0000"+
		"\u0380\u0381\u0003\u0193\u00c9\u0000\u0381\u0382\u0003\u01a3\u00d1\u0000"+
		"\u0382\u0086\u0001\u0000\u0000\u0000\u0383\u0384\u0003\u0181\u00c0\u0000"+
		"\u0384\u0385\u0003\u0199\u00cc\u0000\u0385\u0386\u0003\u0197\u00cb\u0000"+
		"\u0386\u0387\u0003\u01a1\u00d0\u0000\u0387\u0388\u0003\u01a3\u00d1\u0000"+
		"\u0388\u0389\u0003\u019f\u00cf\u0000\u0389\u038a\u0003\u017d\u00be\u0000"+
		"\u038a\u038b\u0003\u018d\u00c6\u0000\u038b\u038c\u0003\u0197\u00cb\u0000"+
		"\u038c\u038d\u0003\u01a3\u00d1\u0000\u038d\u0088\u0001\u0000\u0000\u0000"+
		"\u038e\u038f\u0003\u018d\u00c6\u0000\u038f\u0390\u0003\u0183\u00c1\u0000"+
		"\u0390\u0391\u0003\u0185\u00c2\u0000\u0391\u0392\u0003\u0197\u00cb\u0000"+
		"\u0392\u0393\u0003\u01a3\u00d1\u0000\u0393\u0394\u0003\u018d\u00c6\u0000"+
		"\u0394\u0395\u0003\u01a3\u00d1\u0000\u0395\u0396\u0003\u01ad\u00d6\u0000"+
		"\u0396\u008a\u0001\u0000\u0000\u0000\u0397\u0398\u0003\u0181\u00c0\u0000"+
		"\u0398\u0399\u0003\u0193\u00c9\u0000\u0399\u039a\u0003\u01a5\u00d2\u0000"+
		"\u039a\u039b\u0003\u01a1\u00d0\u0000\u039b\u039c\u0003\u01a3\u00d1\u0000"+
		"\u039c\u039d\u0003\u0185\u00c2\u0000\u039d\u039e\u0003\u019f\u00cf\u0000"+
		"\u039e\u039f\u0003\u0185\u00c2\u0000\u039f\u03a0\u0003\u0183\u00c1\u0000"+
		"\u03a0\u008c\u0001\u0000\u0000\u0000\u03a1\u03a2\u0003\u0197\u00cb\u0000"+
		"\u03a2\u03a3\u0003\u0199\u00cc\u0000\u03a3\u03a4\u0003\u0197\u00cb\u0000"+
		"\u03a4\u03a5\u0003\u0181\u00c0\u0000\u03a5\u03a6\u0003\u0193\u00c9\u0000"+
		"\u03a6\u03a7\u0003\u01a5\u00d2\u0000\u03a7\u03a8\u0003\u01a1\u00d0\u0000"+
		"\u03a8\u03a9\u0003\u01a3\u00d1\u0000\u03a9\u03aa\u0003\u0185\u00c2\u0000"+
		"\u03aa\u03ab\u0003\u019f\u00cf\u0000\u03ab\u03ac\u0003\u0185\u00c2\u0000"+
		"\u03ac\u03ad\u0003\u0183\u00c1\u0000\u03ad\u008e\u0001\u0000\u0000\u0000"+
		"\u03ae\u03af\u0003\u018f\u00c7\u0000\u03af\u03b0\u0003\u0199\u00cc\u0000"+
		"\u03b0\u03b1\u0003\u018d\u00c6\u0000\u03b1\u03b2\u0003\u0197\u00cb\u0000"+
		"\u03b2\u0090\u0001\u0000\u0000\u0000\u03b3\u03b4\u0003\u018d\u00c6\u0000"+
		"\u03b4\u03b5\u0003\u0197\u00cb\u0000\u03b5\u03b6\u0003\u0197\u00cb\u0000"+
		"\u03b6\u03b7\u0003\u0185\u00c2\u0000\u03b7\u03b8\u0003\u019f\u00cf\u0000"+
		"\u03b8\u0092\u0001\u0000\u0000\u0000\u03b9\u03ba\u0003\u0199\u00cc\u0000"+
		"\u03ba\u03bb\u0003\u01a5\u00d2\u0000\u03bb\u03bc\u0003\u01a3\u00d1\u0000"+
		"\u03bc\u03bd\u0003\u0185\u00c2\u0000\u03bd\u03be\u0003\u019f\u00cf\u0000"+
		"\u03be\u0094\u0001\u0000\u0000\u0000\u03bf\u03c0\u0003\u0193\u00c9\u0000"+
		"\u03c0\u03c1\u0003\u0185\u00c2\u0000\u03c1\u03c2\u0003\u0187\u00c3\u0000"+
		"\u03c2\u03c3\u0003\u01a3\u00d1\u0000\u03c3\u0096\u0001\u0000\u0000\u0000"+
		"\u03c4\u03c5\u0003\u019f\u00cf\u0000\u03c5\u03c6\u0003\u018d\u00c6\u0000"+
		"\u03c6\u03c7\u0003\u0189\u00c4\u0000\u03c7\u03c8\u0003\u018b\u00c5\u0000"+
		"\u03c8\u03c9\u0003\u01a3\u00d1\u0000\u03c9\u0098\u0001\u0000\u0000\u0000"+
		"\u03ca\u03cb\u0003\u0187\u00c3\u0000\u03cb\u03cc\u0003\u01a5\u00d2\u0000"+
		"\u03cc\u03cd\u0003\u0193\u00c9\u0000\u03cd\u03ce\u0003\u0193\u00c9\u0000"+
		"\u03ce\u009a\u0001\u0000\u0000\u0000\u03cf\u03d0\u0003\u0181\u00c0\u0000"+
		"\u03d0\u03d1\u0003\u019f\u00cf\u0000\u03d1\u03d2\u0003\u0199\u00cc\u0000"+
		"\u03d2\u03d3\u0003\u01a1\u00d0\u0000\u03d3\u03d4\u0003\u01a1\u00d0\u0000"+
		"\u03d4\u009c\u0001\u0000\u0000\u0000\u03d5\u03d6\u0003\u0199\u00cc\u0000"+
		"\u03d6\u03d7\u0003\u0197\u00cb\u0000\u03d7\u009e\u0001\u0000\u0000\u0000"+
		"\u03d8\u03d9\u0003\u01a5\u00d2\u0000\u03d9\u03da\u0003\u01a1\u00d0\u0000"+
		"\u03da\u03db\u0003\u018d\u00c6\u0000\u03db\u03dc\u0003\u0197\u00cb\u0000"+
		"\u03dc\u03dd\u0003\u0189\u00c4\u0000\u03dd\u00a0\u0001\u0000\u0000\u0000"+
		"\u03de\u03df\u0003\u01a5\u00d2\u0000\u03df\u03e0\u0003\u0197\u00cb\u0000"+
		"\u03e0\u03e1\u0003\u018d\u00c6\u0000\u03e1\u03e2\u0003\u0199\u00cc\u0000"+
		"\u03e2\u03e3\u0003\u0197\u00cb\u0000\u03e3\u00a2\u0001\u0000\u0000\u0000"+
		"\u03e4\u03e5\u0003\u0185\u00c2\u0000\u03e5\u03e6\u0003\u01ab\u00d5\u0000"+
		"\u03e6\u03e7\u0003\u0181\u00c0\u0000\u03e7\u03e8\u0003\u0185\u00c2\u0000"+
		"\u03e8\u03e9\u0003\u019b\u00cd\u0000\u03e9\u03ea\u0003\u01a3\u00d1\u0000"+
		"\u03ea\u00a4\u0001\u0000\u0000\u0000\u03eb\u03ec\u0003\u018d\u00c6\u0000"+
		"\u03ec\u03ed\u0003\u0197\u00cb\u0000\u03ed\u03ee\u0003\u01a3\u00d1\u0000"+
		"\u03ee\u03ef\u0003\u0185\u00c2\u0000\u03ef\u03f0\u0003\u019f\u00cf\u0000"+
		"\u03f0\u03f1\u0003\u01a1\u00d0\u0000\u03f1\u03f2\u0003\u0185\u00c2\u0000"+
		"\u03f2\u03f3\u0003\u0181\u00c0\u0000\u03f3\u03f4\u0003\u01a3\u00d1\u0000"+
		"\u03f4\u00a6\u0001\u0000\u0000\u0000\u03f5\u03f6\u0003\u017d\u00be\u0000"+
		"\u03f6\u03f7\u0003\u0193\u00c9\u0000\u03f7\u03f8\u0003\u0193\u00c9\u0000"+
		"\u03f8\u00a8\u0001\u0000\u0000\u0000\u03f9\u03fa\u0003\u017d\u00be\u0000"+
		"\u03fa\u03fb\u0003\u0197\u00cb\u0000\u03fb\u03fc\u0003\u0183\u00c1\u0000"+
		"\u03fc\u00aa\u0001\u0000\u0000\u0000\u03fd\u03fe\u0003\u0199\u00cc\u0000"+
		"\u03fe\u03ff\u0003\u019f\u00cf\u0000\u03ff\u00ac\u0001\u0000\u0000\u0000"+
		"\u0400\u0401\u0003\u0197\u00cb\u0000\u0401\u0402\u0003\u0199\u00cc\u0000"+
		"\u0402\u0403\u0003\u01a3\u00d1\u0000\u0403\u00ae\u0001\u0000\u0000\u0000"+
		"\u0404\u0405\u0003\u0193\u00c9\u0000\u0405\u0406\u0003\u018d\u00c6\u0000"+
		"\u0406\u0407\u0003\u0191\u00c8\u0000\u0407\u0408\u0003\u0185\u00c2\u0000"+
		"\u0408\u00b0\u0001\u0000\u0000\u0000\u0409\u040a\u0003\u018d\u00c6\u0000"+
		"\u040a\u040b\u0003\u0197\u00cb\u0000\u040b\u00b2\u0001\u0000\u0000\u0000"+
		"\u040c\u040d\u0003\u017f\u00bf\u0000\u040d\u040e\u0003\u0185\u00c2\u0000"+
		"\u040e\u040f\u0003\u01a3\u00d1\u0000\u040f\u0410\u0003\u01a9\u00d4\u0000"+
		"\u0410\u0411\u0003\u0185\u00c2\u0000\u0411\u0412\u0003\u0185\u00c2\u0000"+
		"\u0412\u0413\u0003\u0197\u00cb\u0000\u0413\u00b4\u0001\u0000\u0000\u0000"+
		"\u0414\u0415\u0003\u0185\u00c2\u0000\u0415\u0416\u0003\u01ab\u00d5\u0000"+
		"\u0416\u0417\u0003\u018d\u00c6\u0000\u0417\u0418\u0003\u01a1\u00d0\u0000"+
		"\u0418\u0419\u0003\u01a3\u00d1\u0000\u0419\u041a\u0003\u01a1\u00d0\u0000"+
		"\u041a\u00b6\u0001\u0000\u0000\u0000\u041b\u041c\u0003\u018d\u00c6\u0000"+
		"\u041c\u041d\u0003\u01a1\u00d0\u0000\u041d\u00b8\u0001\u0000\u0000\u0000"+
		"\u041e\u041f\u0003\u0197\u00cb\u0000\u041f\u0420\u0003\u01a5\u00d2\u0000"+
		"\u0420\u0421\u0003\u0193\u00c9\u0000\u0421\u0422\u0003\u0193\u00c9\u0000"+
		"\u0422\u00ba\u0001\u0000\u0000\u0000\u0423\u0424\u0003\u017d\u00be\u0000"+
		"\u0424\u0425\u0003\u0197\u00cb\u0000\u0425\u0426\u0003\u01ad\u00d6\u0000"+
		"\u0426\u00bc\u0001\u0000\u0000\u0000\u0427\u0428\u0003\u01a1\u00d0\u0000"+
		"\u0428\u0429\u0003\u0199\u00cc\u0000\u0429\u042a\u0003\u0195\u00ca\u0000"+
		"\u042a\u042b\u0003\u0185\u00c2\u0000\u042b\u00be\u0001\u0000\u0000\u0000"+
		"\u042c\u042d\u0003\u0181\u00c0\u0000\u042d\u042e\u0003\u0199\u00cc\u0000"+
		"\u042e\u042f\u0003\u01a5\u00d2\u0000\u042f\u0430\u0003\u0197\u00cb\u0000"+
		"\u0430\u0431\u0003\u01a3\u00d1\u0000\u0431\u00c0\u0001\u0000\u0000\u0000"+
		"\u0432\u0433\u0003\u01a1\u00d0\u0000\u0433\u0434\u0003\u01a5\u00d2\u0000"+
		"\u0434\u0435\u0003\u0195\u00ca\u0000\u0435\u00c2\u0001\u0000\u0000\u0000"+
		"\u0436\u0437\u0003\u017d\u00be\u0000\u0437\u0438\u0003\u01a7\u00d3\u0000"+
		"\u0438\u0439\u0003\u0189\u00c4\u0000\u0439\u00c4\u0001\u0000\u0000\u0000"+
		"\u043a\u043b\u0003\u0195\u00ca\u0000\u043b\u043c\u0003\u018d\u00c6\u0000"+
		"\u043c\u043d\u0003\u0197\u00cb\u0000\u043d\u00c6\u0001\u0000\u0000\u0000"+
		"\u043e\u043f\u0003\u0195\u00ca\u0000\u043f\u0440\u0003\u017d\u00be\u0000"+
		"\u0440\u0441\u0003\u01ab\u00d5\u0000\u0441\u00c8\u0001\u0000\u0000\u0000"+
		"\u0442\u0443\u0003\u0193\u00c9\u0000\u0443\u0444\u0003\u0185\u00c2\u0000"+
		"\u0444\u0445\u0003\u0197\u00cb\u0000\u0445\u00ca\u0001\u0000\u0000\u0000"+
		"\u0446\u0447\u0003\u01a1\u00d0\u0000\u0447\u0448\u0003\u01a5\u00d2\u0000"+
		"\u0448\u0449\u0003\u017f\u00bf\u0000\u0449\u044a\u0003\u01a1\u00d0\u0000"+
		"\u044a\u044b\u0003\u01a3\u00d1\u0000\u044b\u044c\u0003\u019f\u00cf\u0000"+
		"\u044c\u044d\u0003\u018d\u00c6\u0000\u044d\u044e\u0003\u0197\u00cb\u0000"+
		"\u044e\u044f\u0003\u0189\u00c4\u0000\u044f\u00cc\u0001\u0000\u0000\u0000"+
		"\u0450\u0451\u0003\u0193\u00c9\u0000\u0451\u0452\u0003\u01a3\u00d1\u0000"+
		"\u0452\u0453\u0003\u019f\u00cf\u0000\u0453\u0454\u0003\u018d\u00c6\u0000"+
		"\u0454\u0455\u0003\u0195\u00ca\u0000\u0455\u00ce\u0001\u0000\u0000\u0000"+
		"\u0456\u0457\u0003\u019f\u00cf\u0000\u0457\u0458\u0003\u01a3\u00d1\u0000"+
		"\u0458\u0459\u0003\u019f\u00cf\u0000\u0459\u045a\u0003\u018d\u00c6\u0000"+
		"\u045a\u045b\u0003\u0195\u00ca\u0000\u045b\u00d0\u0001\u0000\u0000\u0000"+
		"\u045c\u045d\u0003\u01a5\u00d2\u0000\u045d\u045e\u0003\u019b\u00cd\u0000"+
		"\u045e\u045f\u0003\u019b\u00cd\u0000\u045f\u0460\u0003\u0185\u00c2\u0000"+
		"\u0460\u0461\u0003\u019f\u00cf\u0000\u0461\u00d2\u0001\u0000\u0000\u0000"+
		"\u0462\u0463\u0003\u0193\u00c9\u0000\u0463\u0464\u0003\u0199\u00cc\u0000"+
		"\u0464\u0465\u0003\u01a9\u00d4\u0000\u0465\u0466\u0003\u0185\u00c2\u0000"+
		"\u0466\u0467\u0003\u019f\u00cf\u0000\u0467\u00d4\u0001\u0000\u0000\u0000"+
		"\u0468\u0469\u0003\u019f\u00cf\u0000\u0469\u046a\u0003\u0185\u00c2\u0000"+
		"\u046a\u046b\u0003\u019b\u00cd\u0000\u046b\u046c\u0003\u0193\u00c9\u0000"+
		"\u046c\u046d\u0003\u017d\u00be\u0000\u046d\u046e\u0003\u0181\u00c0\u0000"+
		"\u046e\u046f\u0003\u0185\u00c2\u0000\u046f\u00d6\u0001\u0000\u0000\u0000"+
		"\u0470\u0471\u0003\u0181\u00c0\u0000\u0471\u0472\u0003\u0199\u00cc\u0000"+
		"\u0472\u0473\u0003\u0197\u00cb\u0000\u0473\u0474\u0003\u0181\u00c0\u0000"+
		"\u0474\u0475\u0003\u017d\u00be\u0000\u0475\u0476\u0003\u01a3\u00d1\u0000"+
		"\u0476\u00d8\u0001\u0000\u0000\u0000\u0477\u0478\u0003\u0181\u00c0\u0000"+
		"\u0478\u0479\u0003\u018b\u00c5\u0000\u0479\u047a\u0003\u017d\u00be\u0000"+
		"\u047a\u047b\u0003\u019f\u00cf\u0000\u047b\u047c\u0003\u018d\u00c6\u0000"+
		"\u047c\u047d\u0003\u0197\u00cb\u0000\u047d\u047e\u0003\u0183\u00c1\u0000"+
		"\u047e\u047f\u0003\u0185\u00c2\u0000\u047f\u0480\u0003\u01ab\u00d5\u0000"+
		"\u0480\u00da\u0001\u0000\u0000\u0000\u0481\u0482\u0003\u019b\u00cd\u0000"+
		"\u0482\u0483\u0003\u017d\u00be\u0000\u0483\u0484\u0003\u01a3\u00d1\u0000"+
		"\u0484\u0485\u0003\u018d\u00c6\u0000\u0485\u0486\u0003\u0197\u00cb\u0000"+
		"\u0486\u0487\u0003\u0183\u00c1\u0000\u0487\u0488\u0003\u0185\u00c2\u0000"+
		"\u0488\u0489\u0003\u01ab\u00d5\u0000\u0489\u00dc\u0001\u0000\u0000\u0000"+
		"\u048a\u048b\u0003\u0189\u00c4\u0000\u048b\u048c\u0003\u0185\u00c2\u0000"+
		"\u048c\u048d\u0003\u01a3\u00d1\u0000\u048d\u048e\u0003\u0183\u00c1\u0000"+
		"\u048e\u048f\u0003\u017d\u00be\u0000\u048f\u0490\u0003\u01a3\u00d1\u0000"+
		"\u0490\u0491\u0003\u0185\u00c2\u0000\u0491\u00de\u0001\u0000\u0000\u0000"+
		"\u0492\u0493\u0003\u0189\u00c4\u0000\u0493\u0494\u0003\u0185\u00c2\u0000"+
		"\u0494\u0495\u0003\u01a3\u00d1\u0000\u0495\u0496\u0003\u01a5\u00d2\u0000"+
		"\u0496\u0497\u0003\u01a3\u00d1\u0000\u0497\u0498\u0003\u0181\u00c0\u0000"+
		"\u0498\u0499\u0003\u0183\u00c1\u0000\u0499\u049a\u0003\u017d\u00be\u0000"+
		"\u049a\u049b\u0003\u01a3\u00d1\u0000\u049b\u049c\u0003\u0185\u00c2\u0000"+
		"\u049c\u00e0\u0001\u0000\u0000\u0000\u049d\u049e\u0003\u0183\u00c1\u0000"+
		"\u049e\u049f\u0003\u017d\u00be\u0000\u049f\u04a0\u0003\u01a3\u00d1\u0000"+
		"\u04a0\u04a1\u0003\u0185\u00c2\u0000\u04a1\u04a2\u0003\u017d\u00be\u0000"+
		"\u04a2\u04a3\u0003\u0183\u00c1\u0000\u04a3\u04a4\u0003\u0183\u00c1\u0000"+
		"\u04a4\u00e2\u0001\u0000\u0000\u0000\u04a5\u04a6\u0003\u0183\u00c1\u0000"+
		"\u04a6\u04a7\u0003\u017d\u00be\u0000\u04a7\u04a8\u0003\u01a3\u00d1\u0000"+
		"\u04a8\u04a9\u0003\u0185\u00c2\u0000\u04a9\u04aa\u0003\u0183\u00c1\u0000"+
		"\u04aa\u04ab\u0003\u018d\u00c6\u0000\u04ab\u04ac\u0003\u0187\u00c3\u0000"+
		"\u04ac\u04ad\u0003\u0187\u00c3\u0000\u04ad\u00e4\u0001\u0000\u0000\u0000"+
		"\u04ae\u04af\u0003\u0183\u00c1\u0000\u04af\u04b0\u0003\u017d\u00be\u0000"+
		"\u04b0\u04b1\u0003\u01a3\u00d1\u0000\u04b1\u04b2\u0003\u0185\u00c2\u0000"+
		"\u04b2\u04b3\u0003\u019b\u00cd\u0000\u04b3\u04b4\u0003\u017d\u00be\u0000"+
		"\u04b4\u04b5\u0003\u019f\u00cf\u0000\u04b5\u04b6\u0003\u01a3\u00d1\u0000"+
		"\u04b6\u00e6\u0001\u0000\u0000\u0000\u04b7\u04b8\u0003\u01ad\u00d6\u0000"+
		"\u04b8\u04b9\u0003\u0185\u00c2\u0000\u04b9\u04ba\u0003\u017d\u00be\u0000"+
		"\u04ba\u04bb\u0003\u019f\u00cf\u0000\u04bb\u00e8\u0001\u0000\u0000\u0000"+
		"\u04bc\u04bd\u0003\u0195\u00ca\u0000\u04bd\u04be\u0003\u0199\u00cc\u0000"+
		"\u04be\u04bf\u0003\u0197\u00cb\u0000\u04bf\u04c0\u0003\u01a3\u00d1\u0000"+
		"\u04c0\u04c1\u0003\u018b\u00c5\u0000\u04c1\u00ea\u0001\u0000\u0000\u0000"+
		"\u04c2\u04c3\u0003\u0183\u00c1\u0000\u04c3\u04c4\u0003\u017d\u00be\u0000"+
		"\u04c4\u04c5\u0003\u01ad\u00d6\u0000\u04c5\u00ec\u0001\u0000\u0000\u0000"+
		"\u04c6\u04c7\u0003\u0181\u00c0\u0000\u04c7\u04c8\u0003\u017d\u00be\u0000"+
		"\u04c8\u04c9\u0003\u01a1\u00d0\u0000\u04c9\u04ca\u0003\u01a3\u00d1\u0000"+
		"\u04ca\u00ee\u0001\u0000\u0000\u0000\u04cb\u04cc\u0003\u0181\u00c0\u0000"+
		"\u04cc\u04cd\u0003\u0199\u00cc\u0000\u04cd\u04ce\u0003\u0197\u00cb\u0000"+
		"\u04ce\u04cf\u0003\u01a7\u00d3\u0000\u04cf\u04d0\u0003\u0185\u00c2\u0000"+
		"\u04d0\u04d1\u0003\u019f\u00cf\u0000\u04d1\u04d2\u0003\u01a3\u00d1\u0000"+
		"\u04d2\u00f0\u0001\u0000\u0000\u0000\u04d3\u04d4\u0003\u01a3\u00d1\u0000"+
		"\u04d4\u04d5\u0003\u019f\u00cf\u0000\u04d5\u04d6\u0003\u01ad\u00d6\u0000"+
		"\u04d6\u04d7\u0005_\u0000\u0000\u04d7\u04d8\u0003\u0181\u00c0\u0000\u04d8"+
		"\u04d9\u0003\u017d\u00be\u0000\u04d9\u04da\u0003\u01a1\u00d0\u0000\u04da"+
		"\u04db\u0003\u01a3\u00d1\u0000\u04db\u00f2\u0001\u0000\u0000\u0000\u04dc"+
		"\u04dd\u0003\u01a3\u00d1\u0000\u04dd\u04de\u0003\u019f\u00cf\u0000\u04de"+
		"\u04df\u0003\u01ad\u00d6\u0000\u04df\u04e0\u0005_\u0000\u0000\u04e0\u04e1"+
		"\u0003\u0181\u00c0\u0000\u04e1\u04e2\u0003\u0199\u00cc\u0000\u04e2\u04e3"+
		"\u0003\u0197\u00cb\u0000\u04e3\u04e4\u0003\u01a7\u00d3\u0000\u04e4\u04e5"+
		"\u0003\u0185\u00c2\u0000\u04e5\u04e6\u0003\u019f\u00cf\u0000\u04e6\u04e7"+
		"\u0003\u01a3\u00d1\u0000\u04e7\u00f4\u0001\u0000\u0000\u0000\u04e8\u04e9"+
		"\u0003\u0199\u00cc\u0000\u04e9\u04ea\u0003\u01a7\u00d3\u0000\u04ea\u04eb"+
		"\u0003\u0185\u00c2\u0000\u04eb\u04ec\u0003\u019f\u00cf\u0000\u04ec\u00f6"+
		"\u0001\u0000\u0000\u0000\u04ed\u04ee\u0003\u019b\u00cd\u0000\u04ee\u04ef"+
		"\u0003\u017d\u00be\u0000\u04ef\u04f0\u0003\u019f\u00cf\u0000\u04f0\u04f1"+
		"\u0003\u01a3\u00d1\u0000\u04f1\u04f2\u0003\u018d\u00c6\u0000\u04f2\u04f3"+
		"\u0003\u01a3\u00d1\u0000\u04f3\u04f4\u0003\u018d\u00c6\u0000\u04f4\u04f5"+
		"\u0003\u0199\u00cc\u0000\u04f5\u04f6\u0003\u0197\u00cb\u0000\u04f6\u00f8"+
		"\u0001\u0000\u0000\u0000\u04f7\u04f8\u0003\u019f\u00cf\u0000\u04f8\u04f9"+
		"\u0003\u0199\u00cc\u0000\u04f9\u04fa\u0003\u01a9\u00d4\u0000\u04fa\u04fb"+
		"\u0003\u01a1\u00d0\u0000\u04fb\u00fa\u0001\u0000\u0000\u0000\u04fc\u04fd"+
		"\u0003\u019f\u00cf\u0000\u04fd\u04fe\u0003\u017d\u00be\u0000\u04fe\u04ff"+
		"\u0003\u0197\u00cb\u0000\u04ff\u0500\u0003\u0189\u00c4\u0000\u0500\u0501"+
		"\u0003\u0185\u00c2\u0000\u0501\u00fc\u0001\u0000\u0000\u0000\u0502\u0503"+
		"\u0003\u019b\u00cd\u0000\u0503\u0504\u0003\u019f\u00cf\u0000\u0504\u0505"+
		"\u0003\u0185\u00c2\u0000\u0505\u0506\u0003\u0181\u00c0\u0000\u0506\u0507"+
		"\u0003\u0185\u00c2\u0000\u0507\u0508\u0003\u0183\u00c1\u0000\u0508\u0509"+
		"\u0003\u018d\u00c6\u0000\u0509\u050a\u0003\u0197\u00cb\u0000\u050a\u050b"+
		"\u0003\u0189\u00c4\u0000\u050b\u00fe\u0001\u0000\u0000\u0000\u050c\u050d"+
		"\u0003\u0187\u00c3\u0000\u050d\u050e\u0003\u0199\u00cc\u0000\u050e\u050f"+
		"\u0003\u0193\u00c9\u0000\u050f\u0510\u0003\u0193\u00c9\u0000\u0510\u0511"+
		"\u0003\u0199\u00cc\u0000\u0511\u0512\u0003\u01a9\u00d4\u0000\u0512\u0513"+
		"\u0003\u018d\u00c6\u0000\u0513\u0514\u0003\u0197\u00cb\u0000\u0514\u0515"+
		"\u0003\u0189\u00c4\u0000\u0515\u0100\u0001\u0000\u0000\u0000\u0516\u0517"+
		"\u0003\u0181\u00c0\u0000\u0517\u0518\u0003\u01a5\u00d2\u0000\u0518\u0519"+
		"\u0003\u019f\u00cf\u0000\u0519\u051a\u0003\u019f\u00cf\u0000\u051a\u051b"+
		"\u0003\u0185\u00c2\u0000\u051b\u051c\u0003\u0197\u00cb\u0000\u051c\u051d"+
		"\u0003\u01a3\u00d1\u0000\u051d\u0102\u0001\u0000\u0000\u0000\u051e\u051f"+
		"\u0003\u019f\u00cf\u0000\u051f\u0520\u0003\u0199\u00cc\u0000\u0520\u0521"+
		"\u0003\u01a9\u00d4\u0000\u0521\u0104\u0001\u0000\u0000\u0000\u0522\u0523"+
		"\u0003\u0193\u00c9\u0000\u0523\u0524\u0003\u017d\u00be\u0000\u0524\u0525"+
		"\u0003\u0189\u00c4\u0000\u0525\u0106\u0001\u0000\u0000\u0000\u0526\u0527"+
		"\u0003\u0193\u00c9\u0000\u0527\u0528\u0003\u0185\u00c2\u0000\u0528\u0529"+
		"\u0003\u017d\u00be\u0000\u0529\u052a\u0003\u0183\u00c1\u0000\u052a\u0108"+
		"\u0001\u0000\u0000\u0000\u052b\u052c\u0003\u0187\u00c3\u0000\u052c\u052d"+
		"\u0003\u018d\u00c6\u0000\u052d\u052e\u0003\u019f\u00cf\u0000\u052e\u052f"+
		"\u0003\u01a1\u00d0\u0000\u052f\u0530\u0003\u01a3\u00d1\u0000\u0530\u0531"+
		"\u0005_\u0000\u0000\u0531\u0532\u0003\u01a7\u00d3\u0000\u0532\u0533\u0003"+
		"\u017d\u00be\u0000\u0533\u0534\u0003\u0193\u00c9\u0000\u0534\u0535\u0003"+
		"\u01a5\u00d2\u0000\u0535\u0536\u0003\u0185\u00c2\u0000\u0536\u010a\u0001"+
		"\u0000\u0000\u0000\u0537\u0538\u0003\u0193\u00c9\u0000\u0538\u0539\u0003"+
		"\u017d\u00be\u0000\u0539\u053a\u0003\u01a1\u00d0\u0000\u053a\u053b\u0003"+
		"\u01a3\u00d1\u0000\u053b\u053c\u0005_\u0000\u0000\u053c\u053d\u0003\u01a7"+
		"\u00d3\u0000\u053d\u053e\u0003\u017d\u00be\u0000\u053e\u053f\u0003\u0193"+
		"\u00c9\u0000\u053f\u0540\u0003\u01a5\u00d2\u0000\u0540\u0541\u0003\u0185"+
		"\u00c2\u0000\u0541\u010c\u0001\u0000\u0000\u0000\u0542\u0543\u0003\u0183"+
		"\u00c1\u0000\u0543\u0544\u0003\u0185\u00c2\u0000\u0544\u0545\u0003\u0181"+
		"\u00c0\u0000\u0545\u0546\u0003\u0193\u00c9\u0000\u0546\u0547\u0003\u017d"+
		"\u00be\u0000\u0547\u0548\u0003\u019f\u00cf\u0000\u0548\u0549\u0003\u0185"+
		"\u00c2\u0000\u0549\u010e\u0001\u0000\u0000\u0000\u054a\u054b\u0003\u01a1"+
		"\u00d0\u0000\u054b\u054c\u0003\u0185\u00c2\u0000\u054c\u054d\u0003\u01a3"+
		"\u00d1\u0000\u054d\u0110\u0001\u0000\u0000\u0000\u054e\u054f\u0003\u017f"+
		"\u00bf\u0000\u054f\u0550\u0003\u0185\u00c2\u0000\u0550\u0551\u0003\u0189"+
		"\u00c4\u0000\u0551\u0552\u0003\u018d\u00c6\u0000\u0552\u0553\u0003\u0197"+
		"\u00cb\u0000\u0553\u0112\u0001\u0000\u0000\u0000\u0554\u0555\u0003\u0185"+
		"\u00c2\u0000\u0555\u0556\u0003\u0197\u00cb\u0000\u0556\u0557\u0003\u0183"+
		"\u00c1\u0000\u0557\u0114\u0001\u0000\u0000\u0000\u0558\u0559\u0003\u018d"+
		"\u00c6\u0000\u0559\u055a\u0003\u0187\u00c3\u0000\u055a\u0116\u0001\u0000"+
		"\u0000\u0000\u055b\u055c\u0003\u0185\u00c2\u0000\u055c\u055d\u0003\u0193"+
		"\u00c9\u0000\u055d\u055e\u0003\u01a1\u00d0\u0000\u055e\u055f\u0003\u0185"+
		"\u00c2\u0000\u055f\u0118\u0001\u0000\u0000\u0000\u0560\u0561\u0003\u01a9"+
		"\u00d4\u0000\u0561\u0562\u0003\u018b\u00c5\u0000\u0562\u0563\u0003\u018d"+
		"\u00c6\u0000\u0563\u0564\u0003\u0193\u00c9\u0000\u0564\u0565\u0003\u0185"+
		"\u00c2\u0000\u0565\u011a\u0001\u0000\u0000\u0000\u0566\u0567\u0003\u017f"+
		"\u00bf\u0000\u0567\u0568\u0003\u019f\u00cf\u0000\u0568\u0569\u0003\u0185"+
		"\u00c2\u0000\u0569\u056a\u0003\u017d\u00be\u0000\u056a\u056b\u0003\u0191"+
		"\u00c8\u0000\u056b\u011c\u0001\u0000\u0000\u0000\u056c\u056d\u0003\u0181"+
		"\u00c0\u0000\u056d\u056e\u0003\u0199\u00cc\u0000\u056e\u056f\u0003\u0197"+
		"\u00cb\u0000\u056f\u0570\u0003\u01a3\u00d1\u0000\u0570\u0571\u0003\u018d"+
		"\u00c6\u0000\u0571\u0572\u0003\u0197\u00cb\u0000\u0572\u0573\u0003\u01a5"+
		"\u00d2\u0000\u0573\u0574\u0003\u0185\u00c2\u0000\u0574\u011e\u0001\u0000"+
		"\u0000\u0000\u0575\u0576\u0003\u0181\u00c0\u0000\u0576\u0577\u0003\u017d"+
		"\u00be\u0000\u0577\u0578\u0003\u01a1\u00d0\u0000\u0578\u0579\u0003\u0185"+
		"\u00c2\u0000\u0579\u0120\u0001\u0000\u0000\u0000\u057a\u057b\u0003\u01a9"+
		"\u00d4\u0000\u057b\u057c\u0003\u018b\u00c5\u0000\u057c\u057d\u0003\u0185"+
		"\u00c2\u0000\u057d\u057e\u0003\u0197\u00cb\u0000\u057e\u0122\u0001\u0000"+
		"\u0000\u0000\u057f\u0580\u0003\u01a3\u00d1\u0000\u0580\u0581\u0003\u018b"+
		"\u00c5\u0000\u0581\u0582\u0003\u0185\u00c2\u0000\u0582\u0583\u0003\u0197"+
		"\u00cb\u0000\u0583\u0124\u0001\u0000\u0000\u0000\u0584\u0585\u0003\u019f"+
		"\u00cf\u0000\u0585\u0586\u0003\u0185\u00c2\u0000\u0586\u0587\u0003\u01a3"+
		"\u00d1\u0000\u0587\u0588\u0003\u01a5\u00d2\u0000\u0588\u0589\u0003\u019f"+
		"\u00cf\u0000\u0589\u058a\u0003\u0197\u00cb\u0000\u058a\u0126\u0001\u0000"+
		"\u0000\u0000\u058b\u058c\u0003\u01a3\u00d1\u0000\u058c\u058d\u0003\u019f"+
		"\u00cf\u0000\u058d\u058e\u0003\u017d\u00be\u0000\u058e\u058f\u0003\u0197"+
		"\u00cb\u0000\u058f\u0590\u0003\u01a1\u00d0\u0000\u0590\u0591\u0003\u017d"+
		"\u00be\u0000\u0591\u0592\u0003\u0181\u00c0\u0000\u0592\u0593\u0003\u01a3"+
		"\u00d1\u0000\u0593\u0594\u0003\u018d\u00c6\u0000\u0594\u0595\u0003\u0199"+
		"\u00cc\u0000\u0595\u0596\u0003\u0197\u00cb\u0000\u0596\u0128\u0001\u0000"+
		"\u0000\u0000\u0597\u0598\u0003\u0181\u00c0\u0000\u0598\u0599\u0003\u0199"+
		"\u00cc\u0000\u0599\u059a\u0003\u0195\u00ca\u0000\u059a\u059b\u0003\u0195"+
		"\u00ca\u0000\u059b\u059c\u0003\u018d\u00c6\u0000\u059c\u059d\u0003\u01a3"+
		"\u00d1\u0000\u059d\u012a\u0001\u0000\u0000\u0000\u059e\u059f\u0003\u019f"+
		"\u00cf\u0000\u059f\u05a0\u0003\u0199\u00cc\u0000\u05a0\u05a1\u0003\u0193"+
		"\u00c9\u0000\u05a1\u05a2\u0003\u0193\u00c9\u0000\u05a2\u05a3\u0003\u017f"+
		"\u00bf\u0000\u05a3\u05a4\u0003\u017d\u00be\u0000\u05a4\u05a5\u0003\u0181"+
		"\u00c0\u0000\u05a5\u05a6\u0003\u0191\u00c8\u0000\u05a6\u012c\u0001\u0000"+
		"\u0000\u0000\u05a7\u05a8\u0003\u01a1\u00d0\u0000\u05a8\u05a9\u0003\u017d"+
		"\u00be\u0000\u05a9\u05aa\u0003\u01a7\u00d3\u0000\u05aa\u05ab\u0003\u0185"+
		"\u00c2\u0000\u05ab\u05ac\u0003\u019b\u00cd\u0000\u05ac\u05ad\u0003\u0199"+
		"\u00cc\u0000\u05ad\u05ae\u0003\u018d\u00c6\u0000\u05ae\u05af\u0003\u0197"+
		"\u00cb\u0000\u05af\u05b0\u0003\u01a3\u00d1\u0000\u05b0\u012e\u0001\u0000"+
		"\u0000\u0000\u05b1\u05b2\u0003\u01a1\u00d0\u0000\u05b2\u05b3\u0003\u017d"+
		"\u00be\u0000\u05b3\u05b4\u0003\u01a7\u00d3\u0000\u05b4\u05b5\u0003\u0185"+
		"\u00c2\u0000\u05b5\u0130\u0001\u0000\u0000\u0000\u05b6\u05b7\u0003\u01a3"+
		"\u00d1\u0000\u05b7\u05b8\u0003\u019f\u00cf\u0000\u05b8\u05b9\u0003\u01ad"+
		"\u00d6\u0000\u05b9\u0132\u0001\u0000\u0000\u0000\u05ba\u05bb\u0003\u0181"+
		"\u00c0\u0000\u05bb\u05bc\u0003\u017d\u00be\u0000\u05bc\u05bd\u0003\u01a3"+
		"\u00d1\u0000\u05bd\u05be\u0003\u0181\u00c0\u0000\u05be\u05bf\u0003\u018b"+
		"\u00c5\u0000\u05bf\u0134\u0001\u0000\u0000\u0000\u05c0\u05c1\u0003\u01a3"+
		"\u00d1\u0000\u05c1\u05c2\u0003\u018b\u00c5\u0000\u05c2\u05c3\u0003\u019f"+
		"\u00cf\u0000\u05c3\u05c4\u0003\u0199\u00cc\u0000\u05c4\u05c5\u0003\u01a9"+
		"\u00d4\u0000\u05c5\u0136\u0001\u0000\u0000\u0000\u05c6\u05c7\u0003\u0185"+
		"\u00c2\u0000\u05c7\u05c8\u0003\u01ab\u00d5\u0000\u05c8\u05c9\u0003\u0185"+
		"\u00c2\u0000\u05c9\u05ca\u0003\u0181\u00c0\u0000\u05ca\u0138\u0001\u0000"+
		"\u0000\u0000\u05cb\u05cc\u0003\u0185\u00c2\u0000\u05cc\u05cd\u0003\u01ab"+
		"\u00d5\u0000\u05cd\u05ce\u0003\u0185\u00c2\u0000\u05ce\u05cf\u0003\u0181"+
		"\u00c0\u0000\u05cf\u05d0\u0003\u01a5\u00d2\u0000\u05d0\u05d1\u0003\u01a3"+
		"\u00d1\u0000\u05d1\u05d2\u0003\u0185\u00c2\u0000\u05d2\u013a\u0001\u0000"+
		"\u0000\u0000\u05d3\u05d4\u0003\u0199\u00cc\u0000\u05d4\u05d5\u0003\u019b"+
		"\u00cd\u0000\u05d5\u05d6\u0003\u0185\u00c2\u0000\u05d6\u05d7\u0003\u0197"+
		"\u00cb\u0000\u05d7\u013c\u0001\u0000\u0000\u0000\u05d8\u05d9\u0003\u0181"+
		"\u00c0\u0000\u05d9\u05da\u0003\u0193\u00c9\u0000\u05da\u05db\u0003\u0199"+
		"\u00cc\u0000\u05db\u05dc\u0003\u01a1\u00d0\u0000\u05dc\u05dd\u0003\u0185"+
		"\u00c2\u0000\u05dd\u013e\u0001\u0000\u0000\u0000\u05de\u05df\u0003\u0183"+
		"\u00c1\u0000\u05df\u05e0\u0003\u0185\u00c2\u0000\u05e0\u05e1\u0003\u017d"+
		"\u00be\u0000\u05e1\u05e2\u0003\u0193\u00c9\u0000\u05e2\u05e3\u0003\u0193"+
		"\u00c9\u0000\u05e3\u05e4\u0003\u0199\u00cc\u0000\u05e4\u05e5\u0003\u0181"+
		"\u00c0\u0000\u05e5\u05e6\u0003\u017d\u00be\u0000\u05e6\u05e7\u0003\u01a3"+
		"\u00d1\u0000\u05e7\u05e8\u0003\u0185\u00c2\u0000\u05e8\u0140\u0001\u0000"+
		"\u0000\u0000\u05e9\u05ea\u0003\u019b\u00cd\u0000\u05ea\u05eb\u0003\u019f"+
		"\u00cf\u0000\u05eb\u05ec\u0003\u018d\u00c6\u0000\u05ec\u05ed\u0003\u0197"+
		"\u00cb\u0000\u05ed\u05ee\u0003\u01a3\u00d1\u0000\u05ee\u0142\u0001\u0000"+
		"\u0000\u0000\u05ef\u05f0\u0003\u019f\u00cf\u0000\u05f0\u05f1\u0003\u017d"+
		"\u00be\u0000\u05f1\u05f2\u0003\u018d\u00c6\u0000\u05f2\u05f3\u0003\u01a1"+
		"\u00d0\u0000\u05f3\u05f4\u0003\u0185\u00c2\u0000\u05f4\u05f5\u0003\u019f"+
		"\u00cf\u0000\u05f5\u05f6\u0003\u019f\u00cf\u0000\u05f6\u05f7\u0003\u0199"+
		"\u00cc\u0000\u05f7\u05f8\u0003\u019f\u00cf\u0000\u05f8\u0144\u0001\u0000"+
		"\u0000\u0000\u05f9\u05fa\u0003\u01a5\u00d2\u0000\u05fa\u05fb\u0003\u01a1"+
		"\u00d0\u0000\u05fb\u05fc\u0003\u0185\u00c2\u0000\u05fc\u0146\u0001\u0000"+
		"\u0000\u0000\u05fd\u05fe\u0003\u0189\u00c4\u0000\u05fe\u05ff\u0003\u0199"+
		"\u00cc\u0000\u05ff\u0148\u0001\u0000\u0000\u0000\u0600\u0601\u0003\u017d"+
		"\u00be\u0000\u0601\u0602\u0003\u01a1\u00d0\u0000\u0602\u014a\u0001\u0000"+
		"\u0000\u0000\u0603\u0604\u0003\u01a9\u00d4\u0000\u0604\u0605\u0003\u018d"+
		"\u00c6\u0000\u0605\u0606\u0003\u01a3\u00d1\u0000\u0606\u0607\u0003\u018b"+
		"\u00c5\u0000\u0607\u014c\u0001\u0000\u0000\u0000\u0608\u0609\u0003\u0199"+
		"\u00cc\u0000\u0609\u060a\u0003\u019b\u00cd\u0000\u060a\u060b\u0003\u01a3"+
		"\u00d1\u0000\u060b\u060c\u0003\u018d\u00c6\u0000\u060c\u060d\u0003\u0199"+
		"\u00cc\u0000\u060d\u060e\u0003\u0197\u00cb\u0000\u060e\u014e\u0001\u0000"+
		"\u0000\u0000\u060f\u0610\u0003\u019f\u00cf\u0000\u0610\u0611\u0003\u0185"+
		"\u00c2\u0000\u0611\u0612\u0003\u0181\u00c0\u0000\u0612\u0613\u0003\u0199"+
		"\u00cc\u0000\u0613\u0614\u0003\u0195\u00ca\u0000\u0614\u0615\u0003\u019b"+
		"\u00cd\u0000\u0615\u0616\u0003\u018d\u00c6\u0000\u0616\u0617\u0003\u0193"+
		"\u00c9\u0000\u0617\u0618\u0003\u0185\u00c2\u0000\u0618\u0150\u0001\u0000"+
		"\u0000\u0000\u0619\u061a\u0003\u0189\u00c4\u0000\u061a\u061b\u0003\u019f"+
		"\u00cf\u0000\u061b\u061c\u0003\u017d\u00be\u0000\u061c\u061d\u0003\u0197"+
		"\u00cb\u0000\u061d\u061e\u0003\u01a3\u00d1\u0000\u061e\u0152\u0001\u0000"+
		"\u0000\u0000\u061f\u0620\u0003\u019f\u00cf\u0000\u0620\u0621\u0003\u0185"+
		"\u00c2\u0000\u0621\u0622\u0003\u01a7\u00d3\u0000\u0622\u0623\u0003\u0199"+
		"\u00cc\u0000\u0623\u0624\u0003\u0191\u00c8\u0000\u0624\u0625\u0003\u0185"+
		"\u00c2\u0000\u0625\u0154\u0001\u0000\u0000\u0000\u0626\u0627\u0003\u0183"+
		"\u00c1\u0000\u0627\u0628\u0003\u0185\u00c2\u0000\u0628\u0629\u0003\u0197"+
		"\u00cb\u0000\u0629\u062a\u0003\u01ad\u00d6\u0000\u062a\u0156\u0001\u0000"+
		"\u0000\u0000\u062b\u062c\u0003\u0193\u00c9\u0000\u062c\u062d\u0003\u0199"+
		"\u00cc\u0000\u062d\u062e\u0003\u0189\u00c4\u0000\u062e\u062f\u0003\u018d"+
		"\u00c6\u0000\u062f\u0630\u0003\u0197\u00cb\u0000\u0630\u0158\u0001\u0000"+
		"\u0000\u0000\u0631\u0632\u0003\u01a5\u00d2\u0000\u0632\u0633\u0003\u01a1"+
		"\u00d0\u0000\u0633\u0634\u0003\u0185\u00c2\u0000\u0634\u0635\u0003\u019f"+
		"\u00cf\u0000\u0635\u015a\u0001\u0000\u0000\u0000\u0636\u0637\u0003\u019f"+
		"\u00cf\u0000\u0637\u0638\u0003\u0199\u00cc\u0000\u0638\u0639\u0003\u0193"+
		"\u00c9\u0000\u0639\u063a\u0003\u0185\u00c2\u0000\u063a\u015c\u0001\u0000"+
		"\u0000\u0000\u063b\u063c\u0003\u019b\u00cd\u0000\u063c\u063d\u0003\u0185"+
		"\u00c2\u0000\u063d\u063e\u0003\u019f\u00cf\u0000\u063e\u063f\u0003\u0195"+
		"\u00ca\u0000\u063f\u0640\u0003\u018d\u00c6\u0000\u0640\u0641\u0003\u01a1"+
		"\u00d0\u0000\u0641\u0642\u0003\u01a1\u00d0\u0000\u0642\u0643\u0003\u018d"+
		"\u00c6\u0000\u0643\u0644\u0003\u0199\u00cc\u0000\u0644\u0645\u0003\u0197"+
		"\u00cb\u0000\u0645\u015e\u0001\u0000\u0000\u0000\u0646\u0647\u0003\u017d"+
		"\u00be\u0000\u0647\u0648\u0003\u01a1\u00d0\u0000\u0648\u0649\u0003\u0181"+
		"\u00c0\u0000\u0649\u0160\u0001\u0000\u0000\u0000\u064a\u064b\u0003\u0183"+
		"\u00c1\u0000\u064b\u064c\u0003\u0185\u00c2\u0000\u064c\u064d\u0003\u01a1"+
		"\u00d0\u0000\u064d\u064e\u0003\u0181\u00c0\u0000\u064e\u0162\u0001\u0000"+
		"\u0000\u0000\u064f\u0650\u0003\u01a3\u00d1\u0000\u0650\u0651\u0003\u019f"+
		"\u00cf\u0000\u0651\u0652\u0003\u01a5\u00d2\u0000\u0652\u0653\u0003\u0185"+
		"\u00c2\u0000\u0653\u0164\u0001\u0000\u0000\u0000\u0654\u0655\u0003\u0187"+
		"\u00c3\u0000\u0655\u0656\u0003\u017d\u00be\u0000\u0656\u0657\u0003\u0193"+
		"\u00c9\u0000\u0657\u0658\u0003\u01a1\u00d0\u0000\u0658\u0659\u0003\u0185"+
		"\u00c2\u0000\u0659\u0166\u0001\u0000\u0000\u0000\u065a\u065b\u0005@\u0000"+
		"\u0000\u065b\u065c\u0005@\u0000\u0000\u065c\u065d\u0001\u0000\u0000\u0000"+
		"\u065d\u0661\u0007\u0000\u0000\u0000\u065e\u0660\u0007\u0001\u0000\u0000"+
		"\u065f\u065e\u0001\u0000\u0000\u0000\u0660\u0663\u0001\u0000\u0000\u0000"+
		"\u0661\u065f\u0001\u0000\u0000\u0000\u0661\u0662\u0001\u0000\u0000\u0000"+
		"\u0662\u0168\u0001\u0000\u0000\u0000\u0663\u0661\u0001\u0000\u0000\u0000"+
		"\u0664\u0665\u0005@\u0000\u0000\u0665\u0669\u0007\u0000\u0000\u0000\u0666"+
		"\u0668\u0007\u0001\u0000\u0000\u0667\u0666\u0001\u0000\u0000\u0000\u0668"+
		"\u066b\u0001\u0000\u0000\u0000\u0669\u0667\u0001\u0000\u0000\u0000\u0669"+
		"\u066a\u0001\u0000\u0000\u0000\u066a\u016a\u0001\u0000\u0000\u0000\u066b"+
		"\u0669\u0001\u0000\u0000\u0000\u066c\u0672\u0005[\u0000\u0000\u066d\u0671"+
		"\b\u0002\u0000\u0000\u066e\u066f\u0005\\\u0000\u0000\u066f\u0671\u0005"+
		"]\u0000\u0000\u0670\u066d\u0001\u0000\u0000\u0000\u0670\u066e\u0001\u0000"+
		"\u0000\u0000\u0671\u0674\u0001\u0000\u0000\u0000\u0672\u0670\u0001\u0000"+
		"\u0000\u0000\u0672\u0673\u0001\u0000\u0000\u0000\u0673\u0675\u0001\u0000"+
		"\u0000\u0000\u0674\u0672\u0001\u0000\u0000\u0000\u0675\u0676\u0005]\u0000"+
		"\u0000\u0676\u016c\u0001\u0000\u0000\u0000\u0677\u067d\u0005\"\u0000\u0000"+
		"\u0678\u067c\b\u0003\u0000\u0000\u0679\u067a\u0005\\\u0000\u0000\u067a"+
		"\u067c\u0005\"\u0000\u0000\u067b\u0678\u0001\u0000\u0000\u0000\u067b\u0679"+
		"\u0001\u0000\u0000\u0000\u067c\u067f\u0001\u0000\u0000\u0000\u067d\u067b"+
		"\u0001\u0000\u0000\u0000\u067d\u067e\u0001\u0000\u0000\u0000\u067e\u0680"+
		"\u0001\u0000\u0000\u0000\u067f\u067d\u0001\u0000\u0000\u0000\u0680\u0681"+
		"\u0005\"\u0000\u0000\u0681\u016e\u0001\u0000\u0000\u0000\u0682\u0688\u0005"+
		"`\u0000\u0000\u0683\u0687\b\u0004\u0000\u0000\u0684\u0685\u0005\\\u0000"+
		"\u0000\u0685\u0687\u0005`\u0000\u0000\u0686\u0683\u0001\u0000\u0000\u0000"+
		"\u0686\u0684\u0001\u0000\u0000\u0000\u0687\u068a\u0001\u0000\u0000\u0000"+
		"\u0688\u0686\u0001\u0000\u0000\u0000\u0688\u0689\u0001\u0000\u0000\u0000"+
		"\u0689\u068b\u0001\u0000\u0000\u0000\u068a\u0688\u0001\u0000\u0000\u0000"+
		"\u068b\u068c\u0005`\u0000\u0000\u068c\u0170\u0001\u0000\u0000\u0000\u068d"+
		"\u0691\u0007\u0000\u0000\u0000\u068e\u0690\u0007\u0001\u0000\u0000\u068f"+
		"\u068e\u0001\u0000\u0000\u0000\u0690\u0693\u0001\u0000\u0000\u0000\u0691"+
		"\u068f\u0001\u0000\u0000\u0000\u0691\u0692\u0001\u0000\u0000\u0000\u0692"+
		"\u0172\u0001\u0000\u0000\u0000\u0693\u0691\u0001\u0000\u0000\u0000\u0694"+
		"\u0696\u0007\u0005\u0000\u0000\u0695\u0694\u0001\u0000\u0000\u0000\u0696"+
		"\u0697\u0001\u0000\u0000\u0000\u0697\u0695\u0001\u0000\u0000\u0000\u0697"+
		"\u0698\u0001\u0000\u0000\u0000\u0698\u0174\u0001\u0000\u0000\u0000\u0699"+
		"\u069b\u0007\u0005\u0000\u0000\u069a\u0699\u0001\u0000\u0000\u0000\u069b"+
		"\u069c\u0001\u0000\u0000\u0000\u069c\u069a\u0001\u0000\u0000\u0000\u069c"+
		"\u069d\u0001\u0000\u0000\u0000\u069d\u069e\u0001\u0000\u0000\u0000\u069e"+
		"\u06a0\u0005.\u0000\u0000\u069f\u06a1\u0007\u0005\u0000\u0000\u06a0\u069f"+
		"\u0001\u0000\u0000\u0000\u06a1\u06a2\u0001\u0000\u0000\u0000\u06a2\u06a0"+
		"\u0001\u0000\u0000\u0000\u06a2\u06a3\u0001\u0000\u0000\u0000\u06a3\u0176"+
		"\u0001\u0000\u0000\u0000\u06a4\u06a7\u0003\u0179\u00bc\u0000\u06a5\u06a7"+
		"\u0003\u017b\u00bd\u0000\u06a6\u06a4\u0001\u0000\u0000\u0000\u06a6\u06a5"+
		"\u0001\u0000\u0000\u0000\u06a7\u0178\u0001\u0000\u0000\u0000\u06a8\u06b0"+
		"\u0005\'\u0000\u0000\u06a9\u06aa\u0005\\\u0000\u0000\u06aa\u06af\t\u0000"+
		"\u0000\u0000\u06ab\u06ac\u0005\'\u0000\u0000\u06ac\u06af\u0005\'\u0000"+
		"\u0000\u06ad\u06af\b\u0006\u0000\u0000\u06ae\u06a9\u0001\u0000\u0000\u0000"+
		"\u06ae\u06ab\u0001\u0000\u0000\u0000\u06ae\u06ad\u0001\u0000\u0000\u0000"+
		"\u06af\u06b2\u0001\u0000\u0000\u0000\u06b0\u06ae\u0001\u0000\u0000\u0000"+
		"\u06b0\u06b1\u0001\u0000\u0000\u0000\u06b1\u06b3\u0001\u0000\u0000\u0000"+
		"\u06b2\u06b0\u0001\u0000\u0000\u0000\u06b3\u06b4\u0005\'\u0000\u0000\u06b4"+
		"\u017a\u0001\u0000\u0000\u0000\u06b5\u06bd\u0005\"\u0000\u0000\u06b6\u06b7"+
		"\u0005\\\u0000\u0000\u06b7\u06bc\t\u0000\u0000\u0000\u06b8\u06b9\u0005"+
		"\"\u0000\u0000\u06b9\u06bc\u0005\"\u0000\u0000\u06ba\u06bc\b\u0003\u0000"+
		"\u0000\u06bb\u06b6\u0001\u0000\u0000\u0000\u06bb\u06b8\u0001\u0000\u0000"+
		"\u0000\u06bb\u06ba\u0001\u0000\u0000\u0000\u06bc\u06bf\u0001\u0000\u0000"+
		"\u0000\u06bd\u06bb\u0001\u0000\u0000\u0000\u06bd\u06be\u0001\u0000\u0000"+
		"\u0000\u06be\u06c0\u0001\u0000\u0000\u0000\u06bf\u06bd\u0001\u0000\u0000"+
		"\u0000\u06c0\u06c1\u0005\"\u0000\u0000\u06c1\u017c\u0001\u0000\u0000\u0000"+
		"\u06c2\u06c3\u0007\u0007\u0000\u0000\u06c3\u017e\u0001\u0000\u0000\u0000"+
		"\u06c4\u06c5\u0007\b\u0000\u0000\u06c5\u0180\u0001\u0000\u0000\u0000\u06c6"+
		"\u06c7\u0007\t\u0000\u0000\u06c7\u0182\u0001\u0000\u0000\u0000\u06c8\u06c9"+
		"\u0007\n\u0000\u0000\u06c9\u0184\u0001\u0000\u0000\u0000\u06ca\u06cb\u0007"+
		"\u000b\u0000\u0000\u06cb\u0186\u0001\u0000\u0000\u0000\u06cc\u06cd\u0007"+
		"\f\u0000\u0000\u06cd\u0188\u0001\u0000\u0000\u0000\u06ce\u06cf\u0007\r"+
		"\u0000\u0000\u06cf\u018a\u0001\u0000\u0000\u0000\u06d0\u06d1\u0007\u000e"+
		"\u0000\u0000\u06d1\u018c\u0001\u0000\u0000\u0000\u06d2\u06d3\u0007\u000f"+
		"\u0000\u0000\u06d3\u018e\u0001\u0000\u0000\u0000\u06d4\u06d5\u0007\u0010"+
		"\u0000\u0000\u06d5\u0190\u0001\u0000\u0000\u0000\u06d6\u06d7\u0007\u0011"+
		"\u0000\u0000\u06d7\u0192\u0001\u0000\u0000\u0000\u06d8\u06d9\u0007\u0012"+
		"\u0000\u0000\u06d9\u0194\u0001\u0000\u0000\u0000\u06da\u06db\u0007\u0013"+
		"\u0000\u0000\u06db\u0196\u0001\u0000\u0000\u0000\u06dc\u06dd\u0007\u0014"+
		"\u0000\u0000\u06dd\u0198\u0001\u0000\u0000\u0000\u06de\u06df\u0007\u0015"+
		"\u0000\u0000\u06df\u019a\u0001\u0000\u0000\u0000\u06e0\u06e1\u0007\u0016"+
		"\u0000\u0000\u06e1\u019c\u0001\u0000\u0000\u0000\u06e2\u06e3\u0007\u0017"+
		"\u0000\u0000\u06e3\u019e\u0001\u0000\u0000\u0000\u06e4\u06e5\u0007\u0018"+
		"\u0000\u0000\u06e5\u01a0\u0001\u0000\u0000\u0000\u06e6\u06e7\u0007\u0019"+
		"\u0000\u0000\u06e7\u01a2\u0001\u0000\u0000\u0000\u06e8\u06e9\u0007\u001a"+
		"\u0000\u0000\u06e9\u01a4\u0001\u0000\u0000\u0000\u06ea\u06eb\u0007\u001b"+
		"\u0000\u0000\u06eb\u01a6\u0001\u0000\u0000\u0000\u06ec\u06ed\u0007\u001c"+
		"\u0000\u0000\u06ed\u01a8\u0001\u0000\u0000\u0000\u06ee\u06ef\u0007\u001d"+
		"\u0000\u0000\u06ef\u01aa\u0001\u0000\u0000\u0000\u06f0\u06f1\u0007\u001e"+
		"\u0000\u0000\u06f1\u01ac\u0001\u0000\u0000\u0000\u06f2\u06f3\u0007\u001f"+
		"\u0000\u0000\u06f3\u01ae\u0001\u0000\u0000\u0000\u06f4\u06f5\u0007 \u0000"+
		"\u0000\u06f5\u01b0\u0001\u0000\u0000\u0000\u0012\u0000\u0661\u0669\u0670"+
		"\u0672\u067b\u067d\u0686\u0688\u0691\u0697\u069c\u06a2\u06a6\u06ae\u06b0"+
		"\u06bb\u06bd\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
```

---

## 🚫 Binary/Excluded Files

The following files were not included in the text content:

- `target/generated-sources/antlr4/com/sqlcompiler/parser/SQLLexer.interp`

## 🚫 Binary/Excluded Files

The following files were not included in the text content:

- `target/generated-sources/antlr4/SQLLexer.tokens`

## 🚫 Binary/Excluded Files

The following files were not included in the text content:

- `target/maven-status/maven-compiler-plugin/compile/default-compile/createdFiles.lst`
- `target/maven-status/maven-compiler-plugin/compile/default-compile/inputFiles.lst`

### <a id="📄-dependency-reduced-pom-xml"></a>📄 `dependency-reduced-pom.xml`

**File Info:**
- **Size**: 4.38 KB
- **Extension**: `.xml`
- **Language**: `xml`
- **Location**: `dependency-reduced-pom.xml`
- **Relative Path**: `root`
- **Created**: 2026-01-04 11:42:30 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-04 11:42:30 (Asia/Damascus / GMT+03:00)
- **MD5**: `6a4b72fe0e9d04986a1ceac13fc174c5`
- **SHA256**: `4b057e36de77c59d1393b7395e59819a85cfad7e748349d90490a017bc73823f`
- **Encoding**: ASCII

**File code content:**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.sqlcompiler</groupId>
  <artifactId>sql-compiler</artifactId>
  <name>SQL Compiler with ANTLR4</name>
  <version>1.0-SNAPSHOT</version>
  <description>A SQL compiler implementation using ANTLR4</description>
  <build>
    <plugins>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>3.1.0</version>
        <configuration>
          <mainClass>com.sqlcompiler.compiler.SQLLexerApp</mainClass>
        </configuration>
      </plugin>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.11.0</version>
        <configuration>
          <source>11</source>
          <target>11</target>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.antlr</groupId>
        <artifactId>antlr4-maven-plugin</artifactId>
        <version>${antlr4.maven.plugin.version}</version>
        <executions>
          <execution>
            <goals>
              <goal>antlr4</goal>
            </goals>
          </execution>
        </executions>
        <configuration>
          <visitor>true</visitor>
          <listener>true</listener>
          <outputDirectory>target/generated-sources/antlr4</outputDirectory>
        </configuration>
      </plugin>
      <plugin>
        <artifactId>maven-assembly-plugin</artifactId>
        <version>3.6.0</version>
        <configuration>
          <archive>
            <manifest>
              <mainClass>com.sqlcompiler.compiler.SQLCompiler</mainClass>
            </manifest>
          </archive>
          <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
          </descriptorRefs>
        </configuration>
      </plugin>
      <plugin>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.5.0</version>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
            <configuration>
              <transformers>
                <transformer>
                  <mainClass>com.sqlcompiler.compiler.SQLCompiler</mainClass>
                </transformer>
              </transformers>
            </configuration>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.0.0</version>
      </plugin>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>build-helper-maven-plugin</artifactId>
        <version>3.4.0</version>
        <executions>
          <execution>
            <phase>generate-sources</phase>
            <goals>
              <goal>add-source</goal>
            </goals>
            <configuration>
              <sources>
                <source>target/generated-sources/antlr4</source>
              </sources>
            </configuration>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>3.1.0</version>
        <configuration>
          <mainClass>com.sqlcompiler.compiler.SQLLexerApp</mainClass>
        </configuration>
      </plugin>
    </plugins>
  </build>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13.2</version>
      <scope>test</scope>
      <exclusions>
        <exclusion>
          <artifactId>hamcrest-core</artifactId>
          <groupId>org.hamcrest</groupId>
        </exclusion>
      </exclusions>
    </dependency>
  </dependencies>
  <properties>
    <maven.compiler.source>11</maven.compiler.source>
    <antlr4.version>4.13.2</antlr4.version>
    <antlr4.maven.plugin.version>4.13.2</antlr4.maven.plugin.version>
    <antlr4.listener>true</antlr4.listener>
    <maven.compiler.target>11</maven.compiler.target>
    <antlr4.visitor>true</antlr4.visitor>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
</project>

```

---

### <a id="📄-pom-xml"></a>📄 `pom.xml`

**File Info:**
- **Size**: 6.81 KB
- **Extension**: `.xml`
- **Language**: `xml`
- **Location**: `pom.xml`
- **Relative Path**: `root`
- **Created**: 2026-01-04 11:42:30 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-05 06:15:18 (Asia/Damascus / GMT+03:00)
- **MD5**: `977db52cb840af6efa26b77c0683534c`
- **SHA256**: `c1aaf935e464f4316c5a1bb988da772bf8239a9f30af998af6c38014aa1b3ada`
- **Encoding**: ASCII

**File code content:**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.sqlcompiler</groupId>
    <artifactId>sql-compiler</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>
    <name>SQL Compiler with ANTLR4</name>
    <description>A SQL compiler implementation using ANTLR4</description>

    <!-- Properties -->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <antlr4.version>4.13.2</antlr4.version>
        <antlr4.maven.plugin.version>4.13.2</antlr4.maven.plugin.version>
        <antlr4.visitor>true</antlr4.visitor>
        <antlr4.listener>true</antlr4.listener>
    </properties>

    <!-- Dependencies -->
    <dependencies>
        <!-- ANTLR4 Runtime -->
        <dependency>
            <groupId>org.antlr</groupId>
            <artifactId>antlr4-runtime</artifactId>
            <version>${antlr4.version}</version>
        </dependency>
        <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.32</version> <!-- update to latest stable -->
        <scope>provided</scope>
        </dependency>
        <!-- JUnit for Testing -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>

        <!-- Optional: Logging Framework (SLF4J + Logback) -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.9</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.4.11</version>
        </dependency>
    </dependencies>

    <!-- Build Configuration -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <mainClass>com.sqlcompiler.compiler.SQLLexerApp</mainClass>
                </configuration>
            </plugin>
            <!-- Java Compiler Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>

            <!-- ANTLR4 Maven Plugin -->
            <plugin>
                <groupId>org.antlr</groupId>
                <artifactId>antlr4-maven-plugin</artifactId>
                <version>${antlr4.maven.plugin.version}</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>antlr4</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <visitor>true</visitor>
                    <listener>true</listener>
                    <outputDirectory>target/generated-sources/antlr4</outputDirectory>
                </configuration>
            </plugin>

            <!-- Maven Assembly Plugin (Optional: for creating JAR with dependencies) -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <version>3.6.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>com.sqlcompiler.compiler.SQLCompiler</mainClass>
                        </manifest>
                    </archive>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
            </plugin>

            <!-- Maven Shade Plugin (Alternative for creating fat JAR) -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.5.0</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>com.sqlcompiler.compiler.SQLCompiler</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>

            <!-- Surefire Plugin for Running Tests -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0</version>
            </plugin>
            <!-- Build Helper Maven Plugin -->
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>build-helper-maven-plugin</artifactId>
                <version>3.4.0</version>
                <executions>
                    <execution>
                        <phase>generate-sources</phase>
                        <goals>
                            <goal>add-source</goal>
                        </goals>
                        <configuration>
                            <sources>
                                <source>target/generated-sources/antlr4</source>
                            </sources>
                        </configuration>
                    </execution>
                </executions>
            </plugin>

            <!-- Also add the Exec Maven Plugin for easy running -->
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <mainClass>com.sqlcompiler.compiler.SQLLexerApp</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

---

### <a id="📄-test-sql"></a>📄 `test.sql`

**File Info:**
- **Size**: 29 B
- **Extension**: `.sql`
- **Language**: `sql`
- **Location**: `test.sql`
- **Relative Path**: `root`
- **Created**: 2026-01-04 13:13:29 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-04 13:23:20 (Asia/Damascus / GMT+03:00)
- **MD5**: `ce37873007a5ca369bc4da60a301c208`
- **SHA256**: `1211de011d4ba0152c3001c32735b28fec6968abf334434d92f164228c1f5364`
- **Encoding**: ASCII

**File code content:**

```sql
SELECT 'with \'backslash\''  
```

---

