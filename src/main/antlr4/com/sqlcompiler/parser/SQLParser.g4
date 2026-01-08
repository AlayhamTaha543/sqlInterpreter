parser grammar SQLParser;

options {
    tokenVocab = SQLLexer;
}

// =============================================
// MAIN QUERY STRUCTURE
// =============================================

/**
 * Entry point for SQL statements
 */
sqlStatement
    : selectStatement
    | insertStatement
    | updateStatement
    | deleteStatement
    | createStatement
    | alterStatement
    | dropStatement
    ;

// Root rule for parsing - includes EOF
sqlStatements
    : sqlStatement* EOF
    ;

// =============================================
// SELECT STATEMENT - Complete Implementation
// =============================================

selectStatement
    : queryExpression orderByClause? offsetFetchClause?
    ;

queryExpression
    : querySpecification
    | '(' queryExpression ')'
    | queryExpression setOperator queryExpression
    ;

querySpecification
    : SELECT topClause? distinctClause? selectList
      fromClause?
      whereClause?
      groupByClause?
      havingClause?
    ;

// -------------------------
// TOP CLAUSE
// -------------------------
topClause
    : TOP (INTEGER | '(' expression ')') (PERCENT)? (WITH TIES)?
    ;

// -------------------------
// DISTINCT CLAUSE
// -------------------------
distinctClause
    : DISTINCT
    | ALL
    ;

// -------------------------
// SELECT LIST
// -------------------------
selectList
    : selectListElement (',' selectListElement)*
    | '*'
    ;

selectListElement
    : expression (AS? columnAlias)?
    | tableName '.' '*'
    | '*'
    ;

// =============================================
// FROM CLAUSE WITH JOIN OPERATIONS
// =============================================

fromClause
    : FROM tableSource (',' tableSource)*
    ;

tableSource
    : tableSourceItem joinPart*
    ;

tableSourceItem
    : tableName (AS? tableAlias)?
    | '(' queryExpression ')' (AS? tableAlias)?
    | '(' tableSource ')'
    ;

// -------------------------
// JOIN OPERATIONS (INNER, LEFT, RIGHT, FULL, CROSS)
// -------------------------
joinPart
    : joinType? JOIN tableSourceItem joinCondition?
    ;

joinType
    : INNER
    | LEFT OUTER?
    | RIGHT OUTER?
    | FULL OUTER?
    | CROSS
    ;

joinCondition
    : ON searchCondition
    | USING '(' columnName (',' columnName)* ')'
    ;

// =============================================
// WHERE CLAUSE - WITH AND/OR/NOT LOGIC
// =============================================

whereClause
    : WHERE searchCondition
    ;

// =============================================
// SEARCH CONDITIONS (WHERE, HAVING, ON, CASE)
// =============================================

/**
 * Search conditions support:
 * - AND / OR / NOT logical operators
 * - Parentheses for grouping
 * - All predicates (comparison, IN, BETWEEN, LIKE, IS NULL, EXISTS)
 */
searchCondition
    : searchCondition AND searchCondition      // AND operator
    | searchCondition OR searchCondition       // OR operator
    | NOT searchCondition                      // NOT operator
    | '(' searchCondition ')'                  // Grouping
    | predicate                                // Base predicates
    ;

// =============================================
// PREDICATES (IN, BETWEEN, LIKE, IS NULL, EXISTS)
// =============================================

predicate
    : expression comparisonOperator expression                              // a = b, a > b, etc.
    | expression IS NOT? NULL                                               // IS NULL / IS NOT NULL
    | expression NOT? BETWEEN expression AND expression                     // BETWEEN x AND y
    | expression NOT? IN '(' (queryExpression | expressionList) ')'        // IN (subquery or list)
    | expression NOT? IN '(' ')'                                           // IN (empty list)
    | expression NOT? LIKE expression (ESCAPE STRING)?                      // LIKE pattern
    | EXISTS '(' queryExpression ')'                                        // EXISTS (subquery)
    | expression NOT? IN IDENTIFIER                                         // IN variable
    | expression                                                            // Simple boolean expression
    ;

// =============================================
// GROUP BY CLAUSE
// =============================================

groupByClause
    : GROUP BY groupByItem (',' groupByItem)*
    ;

groupByItem
    : expression
    ;

// =============================================
// HAVING CLAUSE
// =============================================

havingClause
    : HAVING searchCondition
    ;

// =============================================
// ORDER BY CLAUSE
// =============================================

orderByClause
    : ORDER BY orderByExpression (',' orderByExpression)*
    ;

orderByExpression
    : expression (ASC | DESC)?
    ;

// =============================================
// OFFSET/FETCH CLAUSE (Pagination)
// =============================================

offsetFetchClause
    : OFFSET expression (ROW | ROWS)
      (FETCH (FIRST | NEXT) expression (ROW | ROWS) ONLY)?
    ;

// =============================================
// EXPRESSIONS
// =============================================

expression
    : literal                                           // Literals (strings, numbers, NULL)
    | columnReference                                   // Column references
    | functionCall                                      // Function calls
    | caseExpression                                    // CASE expressions
    | subquery                                          // Subqueries
    | USER_VARIABLE                                     // User variables (@var)
    | SYSTEM_VARIABLE                                   // System variables (@@var)
    | '(' expression ')'                                // Parenthesized expressions
    | unaryOperator expression                          // Unary operators (+, -, ~, NOT)
    | expression ('*' | '/' | '%') expression          // Multiplicative
    | expression ('+' | '-') expression                 // Additive
    | expression ('||' | '+') expression                // String concatenation
    | expression comparisonOperator expression          // Comparison
    | castExpression                                    // CAST/CONVERT
    | windowFunction                                    // Window functions
    ;

expressionList
    : expression (',' expression)*
    ;

// -------------------------
// SUBQUERIES
// -------------------------
subquery
    : '(' queryExpression ')'
    ;

// =============================================
// CASE EXPRESSION
// =============================================

caseExpression
    : CASE expression? whenClause+ (ELSE expression)? END
    ;

whenClause
    : WHEN searchCondition THEN expression
    ;

// =============================================
// CAST AND CONVERT
// =============================================

castExpression
    : CAST '(' expression AS dataType ')'
    | CONVERT '(' dataType ',' expression (',' INTEGER)? ')'
    | TRY_CAST '(' expression AS dataType ')'
    | TRY_CONVERT '(' dataType ',' expression (',' INTEGER)? ')'
    ;

// =============================================
// WINDOW FUNCTIONS
// =============================================

windowFunction
    : (aggregateFunction | rankingFunction | analyticFunction) OVER '(' windowSpecification ')'
    ;

windowSpecification
    : (PARTITION BY expressionList)?
      (ORDER BY orderByExpression (',' orderByExpression)*)?
      windowFrame?
    ;

windowFrame
    : (ROWS | RANGE) windowFrameBound
    | (ROWS | RANGE) BETWEEN windowFrameBound AND windowFrameBound
    ;

windowFrameBound
    : CURRENT ROW
    | PRECEDING
    | FOLLOWING
    | INTEGER PRECEDING
    | INTEGER FOLLOWING
    ;

rankingFunction
    : ROW_NUMBER '(' ')'
    | RANK '(' ')'
    | DENSE_RANK '(' ')'
    | NTILE '(' expression ')'
    ;

analyticFunction
    : LAG '(' expression (',' INTEGER (',' expression)?)? ')'
    | LEAD '(' expression (',' INTEGER (',' expression)?)? ')'
    | FIRST_VALUE '(' expression ')'
    | LAST_VALUE '(' expression ')'
    ;

// =============================================
// FUNCTION CALLS
// =============================================

functionCall
    : aggregateFunction
    | scalarFunction
    | dateFunction
    | stringFunction
    | conversionFunction
    ;

aggregateFunction
    : (COUNT | SUM | AVG | MIN | MAX) '(' (DISTINCT | ALL)? (expression | '*') ')'
    ;

scalarFunction
    : functionName '(' (expression (',' expression)*)? ')'
    ;

stringFunction
    : LEN '(' expression ')'
    | SUBSTRING '(' expression ',' expression ',' expression ')'
    | LTRIM '(' expression ')'
    | RTRIM '(' expression ')'
    | UPPER '(' expression ')'
    | LOWER '(' expression ')'
    | REPLACE '(' expression ',' expression ',' expression ')'
    | CONCAT '(' expression (',' expression)+ ')'
    | CHARINDEX '(' expression ',' expression (',' expression)? ')'
    | PATINDEX '(' expression ',' expression ')'
    ;

dateFunction
    : GETDATE '(' ')'
    | GETUTCDATE '(' ')'
    | DATEADD '(' IDENTIFIER ',' expression ',' expression ')'
    | DATEDIFF '(' IDENTIFIER ',' expression ',' expression ')'
    | DATEPART '(' IDENTIFIER ',' expression ')'
    | YEAR '(' expression ')'
    | MONTH '(' expression ')'
    | DAY '(' expression ')'
    ;

conversionFunction
    : castExpression
    ;

// =============================================
// COLUMN AND TABLE REFERENCES
// =============================================

columnReference
    : (tableName '.')? columnName
    | (schemaName '.' tableName '.')? columnName
    ;

tableName
    : (schemaName '.')? identifier
    ;

columnName
    : identifier
    ;

columnAlias
    : identifier
    | STRING
    ;

tableAlias
    : identifier
    ;

schemaName
    : identifier
    ;

functionName
    : identifier
    ;

// =============================================
// IDENTIFIERS
// =============================================

identifier
    : IDENTIFIER
    | DELIMITED_IDENTIFIER_BRACKET
    | DELIMITED_IDENTIFIER_QUOTE
    | DELIMITED_IDENTIFIER_BACKTICK
    | nonReservedKeyword
    ;

// Allow certain keywords as identifiers in contexts where they're unambiguous
nonReservedKeyword
    : KEY
    | ROLE
    | USER
    | TYPE
    | OPTION
    | PARTITION
    | RANGE
    | ROWS
    | ROW
    ;

// =============================================
// DATA TYPES
// =============================================

dataType
    : INT
    | BIGINT
    | SMALLINT
    | TINYINT
    | VARCHAR ('(' INTEGER ')')?
    | NVARCHAR ('(' INTEGER | MAX ')')?
    | CHAR ('(' INTEGER ')')?
    | NCHAR ('(' INTEGER ')')?
    | TEXT
    | NTEXT
    | DATETIME
    | DATE
    | TIME
    | TIMESTAMP
    | BIT
    | DECIMAL ('(' INTEGER (',' INTEGER)? ')')?
    | NUMERIC ('(' INTEGER (',' INTEGER)? ')')?
    | FLOAT ('(' INTEGER ')')?
    | REAL
    | MONEY
    | SMALLMONEY
    | BINARY ('(' INTEGER ')')?
    | VARBINARY ('(' INTEGER | MAX ')')?
    | IMAGE
    | UNIQUEIDENTIFIER
    | XML
    | SQL_VARIANT
    ;

// =============================================
// LITERALS
// =============================================

literal
    : STRING                    // String literals
    | INTEGER                   // Integer literals
    | FLOATN                    // Float/Decimal literals
    | NULL                      // NULL literal
    | TRUE                      // Boolean TRUE
    | FALSE                     // Boolean FALSE
    ;

// =============================================
// OPERATORS
// =============================================

comparisonOperator
    : '='
    | '>'
    | '<'
    | '<='
    | '>='
    | '<>'
    | '!='
    | '!<'
    | '!>'
    ;

unaryOperator
    : '+'
    | '-'
    | '~'
    | NOT
    ;

setOperator
    : UNION ALL?
    | EXCEPT
    | INTERSECT
    ;

// =============================================
// INSERT STATEMENT
// =============================================

insertStatement
    : INSERT INTO tableName ('(' columnName (',' columnName)* ')')?
      (VALUES '(' expressionList ')' (',' '(' expressionList ')')* | queryExpression)
    ;

// =============================================
// UPDATE STATEMENT
// =============================================

updateStatement
    : UPDATE tableName SET columnName '=' expression (',' columnName '=' expression)*
      whereClause?
    ;

// =============================================
// DELETE STATEMENT
// =============================================

deleteStatement
    : DELETE FROM? tableName whereClause?
    ;

// =============================================
// CREATE STATEMENT
// =============================================

createStatement
    : CREATE TABLE tableName '(' columnDefinition (',' columnDefinition)* ')'
    | CREATE VIEW tableName AS queryExpression
    | CREATE PROCEDURE identifier ('(' parameterList ')')? AS BEGIN statementList END
    | CREATE FUNCTION identifier '(' parameterList? ')' RETURN dataType AS BEGIN statementList RETURN expression END
    | CREATE INDEX identifier ON tableName '(' columnName (',' columnName)* ')'
    ;

statementList
    : (selectStatement | insertStatement | updateStatement | deleteStatement | declareStatement | setStatement | ifStatement | whileStatement | returnStatement)+
    ;

declareStatement
    : DECLARE USER_VARIABLE dataType ('=' expression)?
    ;

setStatement
    : SET USER_VARIABLE '=' expression
    ;

ifStatement
    : IF searchCondition BEGIN statementList END (ELSE BEGIN statementList END)?
    ;

whileStatement
    : WHILE searchCondition BEGIN statementList END
    ;

returnStatement
    : RETURN expression?
    ;

columnDefinition
    : columnName dataType columnConstraint*
    ;

columnConstraint
    : PRIMARY KEY
    | FOREIGN KEY REFERENCES tableName ('(' columnName ')')?
    | UNIQUE
    | NOT? NULL
    | CHECK '(' searchCondition ')'
    | DEFAULT expression
    | IDENTITY ('(' INTEGER ',' INTEGER ')')?
    ;

parameterList
    : parameter (',' parameter)*
    ;

parameter
    : USER_VARIABLE dataType
    ;

// =============================================
// ALTER STATEMENT
// =============================================

alterStatement
    : ALTER TABLE tableName (ADD columnDefinition | DROP COLUMN columnName)
    ;

// =============================================
// DROP STATEMENT
// =============================================

dropStatement
    : DROP (TABLE | VIEW | PROCEDURE | FUNCTION | INDEX) identifier
    ;