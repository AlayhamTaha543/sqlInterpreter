parser grammar SQLParser;
<<<<<<< HEAD

options {
    tokenVocab = SQLLexer;
}

/* =========================================================
 * ENTRY POINT
 * ========================================================= */

sqlStatements
    : sqlStatement* EOF
    ;

sqlStatement
    : selectStatement
    | insertStatement
    | updateStatement
    | deleteStatement
    | createStatement
    | alterStatement
    | dropStatement
    ;

/* =========================================================
 * SELECT STATEMENT
 * ========================================================= */

selectStatement
    : queryExpression orderByClause? offsetFetchClause?
    ;

/* ---------- QUERY EXPRESSION (UNION / INTERSECT / EXCEPT) ---------- */

queryExpression
    : queryTerm (setOperator queryTerm)*
    ;

queryTerm
    : queryPrimary
    ;

queryPrimary
    : querySpecification
    | '(' queryExpression ')'
    ;

/* ---------- QUERY SPECIFICATION ---------- */

=======
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
    : ( selectStatement
      | insertStatement
      | bulkInsertStatement          
      | updateStatement
      | deleteStatement
      | createStatement
      | alterStatement
      | dropStatement
      ) SEMICOLON?
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
    | LPAREN queryExpression RPAREN
    | queryExpression setOperator queryExpression
    ;
>>>>>>> main
querySpecification
    : SELECT topClause? distinctClause? selectList
      fromClause?
      whereClause?
      groupByClause?
      havingClause?
    ;
<<<<<<< HEAD

/* ---------- TOP / DISTINCT ---------- */

topClause
    : TOP INTEGER (PERCENT)? (WITH TIES)?
    ;

=======
// -------------------------
// TOP CLAUSE
// -------------------------
topClause
    : TOP (INTEGER | LPAREN expression RPAREN) (PERCENT)? (WITH TIES)?
    ;
// -------------------------
// DISTINCT CLAUSE
// -------------------------
>>>>>>> main
distinctClause
    : DISTINCT
    | ALL
    ;
<<<<<<< HEAD

/* ---------- SELECT LIST ---------- */

selectList
    : '*'
    | selectListElement (',' selectListElement)*
    ;

selectListElement
    : expression (AS? columnAlias)?
    | tableName '.' '*'
    ;

/* =========================================================
 * FROM + JOIN
 * ========================================================= */

fromClause
    : FROM tableSource (',' tableSource)*
    ;

tableSource
    : tableSourceItem joinPart*
    ;

tableSourceItem
    : tableName (AS? tableAlias)?
    | '(' queryExpression ')' (AS? tableAlias)?
    ;

joinPart
    : joinType? JOIN tableSourceItem joinCondition?
    ;

=======
// -------------------------
// SELECT LIST
// -------------------------
selectList
    : selectListElement (COMMA selectListElement)*
    | STAR
    ;
selectListElement
    : expression (AS? columnAlias)?
    | tableName DOT STAR
    | STAR
    ;
// =============================================
// FROM CLAUSE WITH JOIN OPERATIONS
// =============================================
fromClause
    : FROM tableSource (COMMA tableSource)*
    ;
tableSource
    : tableSourceItem joinPart*
    ;
tableSourceItem
    : tableName (AS? tableAlias)?
    | LPAREN queryExpression RPAREN (AS? tableAlias)?
    | LPAREN tableSource RPAREN
    ;
// -------------------------
// JOIN OPERATIONS (INNER, LEFT, RIGHT, FULL, CROSS)
// -------------------------
joinPart
    : joinType? JOIN tableSourceItem joinCondition?
    ;
>>>>>>> main
joinType
    : INNER
    | LEFT OUTER?
    | RIGHT OUTER?
    | FULL OUTER?
    | CROSS
    ;
<<<<<<< HEAD

joinCondition
    : ON searchCondition
    ;

/* =========================================================
 * GROUP BY
 * ========================================================= */

groupByClause
    : GROUP BY groupByItem (',' groupByItem)*
    ;

groupByItem
    : expression
    ;

/* =========================================================
 * WHERE / HAVING
 * ========================================================= */

whereClause
    : WHERE searchCondition
    ;

havingClause
    : HAVING searchCondition
    ;

/* ---------- SEARCH CONDITION (AND / OR / NOT) ---------- */

searchCondition
    : orCondition
    ;

orCondition
    : andCondition (OR andCondition)*
    ;

andCondition
    : notCondition (AND notCondition)*
    ;

notCondition
    : NOT? predicate
    ;

/* ---------- PREDICATES ---------- */

predicate
    : '(' searchCondition ')'
    | expression comparisonOperator expression
    | expression IS NOT? NULL
    | expression NOT? BETWEEN expression AND expression
    | expression NOT? IN '(' expressionList ')'
    | expression NOT? IN '(' queryExpression ')'
    | expression NOT? LIKE expression
    | EXISTS '(' queryExpression ')'
    ;

/* =========================================================
 * EXPRESSIONS (WITH PRECEDENCE)
 * ========================================================= */

expression
    : additiveExpression
    ;

additiveExpression
    : multiplicativeExpression (('+' | '-') multiplicativeExpression)*
    ;

multiplicativeExpression
    : unaryExpression (('*' | '/' | '%') unaryExpression)*
    ;

unaryExpression
    : unaryOperator unaryExpression
    | primaryExpression
    ;

primaryExpression
    : literal
    | columnReference
    | functionCall
    | caseExpression
    | '(' expression ')'
    ;

expressionList
    : expression (',' expression)*
    ;

/* =========================================================
 * CASE
 * ========================================================= */

caseExpression
    : CASE whenClause+ (ELSE expression)? END
    ;

whenClause
    : WHEN searchCondition THEN expression
    ;

/* =========================================================
 * FUNCTIONS
 * ========================================================= */

functionCall
    : functionName '(' (expressionList)? ')'
    ;

/* =========================================================
 * ORDER BY / OFFSET
 * ========================================================= */

orderByClause
    : ORDER BY orderByExpression (',' orderByExpression)*
    ;

orderByExpression
    : expression (ASC | DESC)?
    ;

=======
joinCondition
    : ON searchCondition
    | USING LPAREN columnName (COMMA columnName)* RPAREN
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
searchCondition
    : searchCondition AND searchCondition
    | searchCondition OR searchCondition
    | NOT searchCondition
    | LPAREN searchCondition RPAREN
    | predicate
    ;
// =============================================
// PREDICATES
// =============================================
predicate
    : expression comparisonOperator expression
    | expression IS NOT? NULL
    | expression NOT? BETWEEN expression AND expression
    | expression NOT? IN LPAREN (queryExpression | expressionList) RPAREN
    | expression NOT? IN LPAREN RPAREN
    | expression NOT? LIKE expression (ESCAPE STRING)?
    | EXISTS LPAREN queryExpression RPAREN
    | expression NOT? IN IDENTIFIER
    | expression
    ;
// =============================================
// GROUP BY / HAVING / ORDER BY / OFFSET FETCH
// =============================================
groupByClause
    : GROUP BY groupByItem (COMMA groupByItem)*
    ;
groupByItem
    : expression
    ;
havingClause
    : HAVING searchCondition
    ;
orderByClause
    : ORDER BY orderByExpression (COMMA orderByExpression)*
    ;
orderByExpression
    : expression (ASC | DESC)?
    ;
>>>>>>> main
offsetFetchClause
    : OFFSET expression (ROW | ROWS)
      (FETCH (FIRST | NEXT) expression (ROW | ROWS) ONLY)?
    ;
<<<<<<< HEAD

/* =========================================================
 * SET OPERATORS
 * ========================================================= */

setOperator
    : UNION ALL?
    | INTERSECT
    | EXCEPT
    ;

/* =========================================================
 * REFERENCES & IDENTIFIERS
 * ========================================================= */

columnReference
    : (tableName '.')? columnName
    ;

tableName
    : IDENTIFIER
    ;

columnName
    : IDENTIFIER
    ;

columnAlias
    : IDENTIFIER
    | STRING
    ;

tableAlias
    : IDENTIFIER
    ;

functionName
    : IDENTIFIER
    ;

/* =========================================================
 * LITERALS & OPERATORS
 * ========================================================= */

literal
    : STRING
    | INTEGER
    | FLOATN
    | NULL
    | TRUE
    | FALSE
    ;

comparisonOperator
    : '='
    | '<'
    | '>'
    | '<='
    | '>='
    | '<>'
    | '!='
    ;

unaryOperator
    : '+'
    | '-'
    | NOT
    ;

/* =========================================================
 * OTHER STATEMENTS (BASIC)
 * ========================================================= */

insertStatement
    : INSERT INTO tableName '(' columnName (',' columnName)* ')'
      VALUES '(' expressionList ')'
    ;

updateStatement
    : UPDATE tableName SET columnName '=' expression
      whereClause?
    ;

deleteStatement
    : DELETE FROM tableName whereClause?
    ;

createStatement
    : CREATE TABLE tableName '(' columnName dataType ')'
    ;

alterStatement
    : ALTER TABLE tableName
    ;

dropStatement
    : DROP TABLE tableName
    ;

/* =========================================================
 * DATA TYPES (BASIC)
 * ========================================================= */

dataType
    : INT
    | VARCHAR
    | DATE
=======
// =============================================
// EXPRESSIONS
// =============================================
expression
    : literal
    | columnReference
    | DEFAULT
    | functionCall
    | caseExpression
    | subquery
    | USER_VARIABLE
    | SYSTEM_VARIABLE
    | LPAREN expression RPAREN
    | unaryOperator expression
    | expression (STAR | SLASH | PERCENT_SIGN) expression
    | expression (PLUS | MINUS) expression
    | expression (PIPE_PIPE | PLUS) expression
    | expression comparisonOperator expression
    | castExpression
    | windowFunction
    ;
expressionList
    : expression (COMMA expression)*
    ;
subquery
    : LPAREN queryExpression RPAREN
    ;
// =============================================
// CASE / CAST / WINDOW / FUNCTIONS
// =============================================
caseExpression
    : CASE expression? whenClause+ (ELSE expression)? END
    ;
whenClause
    : WHEN searchCondition THEN expression
    ;
castExpression
    : CAST LPAREN expression AS dataType RPAREN
    | CONVERT LPAREN dataType COMMA expression (COMMA INTEGER)? RPAREN
    | TRY_CAST LPAREN expression AS dataType RPAREN
    | TRY_CONVERT LPAREN dataType COMMA expression (COMMA INTEGER)? RPAREN
    ;
windowFunction
    : (aggregateFunction | rankingFunction | analyticFunction) OVER LPAREN windowSpecification RPAREN
    ;
windowSpecification
    : (PARTITION BY expressionList)?
      (ORDER BY orderByExpression (COMMA orderByExpression)*)?
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
    : ROW_NUMBER LPAREN RPAREN
    | RANK LPAREN RPAREN
    | DENSE_RANK LPAREN RPAREN
    | NTILE LPAREN expression RPAREN
    ;
analyticFunction
    : LAG LPAREN expression (COMMA INTEGER (COMMA expression)?)? RPAREN
    | LEAD LPAREN expression (COMMA INTEGER (COMMA expression)?)? RPAREN
    | FIRST_VALUE LPAREN expression RPAREN
    | LAST_VALUE LPAREN expression RPAREN
    ;
functionCall
    : aggregateFunction
    | scalarFunction
    | dateFunction
    | stringFunction
    | conversionFunction
    ;
aggregateFunction
    : (COUNT | SUM | AVG | MIN | MAX) LPAREN (DISTINCT | ALL)? (expression | STAR) RPAREN
    ;
scalarFunction
    : functionName LPAREN (expression (COMMA expression)*)? RPAREN
    ;
stringFunction
    : LEN LPAREN expression RPAREN
    | SUBSTRING LPAREN expression COMMA expression COMMA expression RPAREN
    | LTRIM LPAREN expression RPAREN
    | RTRIM LPAREN expression RPAREN
    | UPPER LPAREN expression RPAREN
    | LOWER LPAREN expression RPAREN
    | REPLACE LPAREN expression COMMA expression COMMA expression RPAREN
    | CONCAT LPAREN expression (COMMA expression)+ RPAREN
    | CHARINDEX LPAREN expression COMMA expression (COMMA expression)? RPAREN
    | PATINDEX LPAREN expression COMMA expression RPAREN
    ;
dateFunction
    : GETDATE LPAREN RPAREN
    | GETUTCDATE LPAREN RPAREN
    | DATEADD LPAREN IDENTIFIER COMMA expression COMMA expression RPAREN
    | DATEDIFF LPAREN IDENTIFIER COMMA expression COMMA expression RPAREN
    | DATEPART LPAREN IDENTIFIER COMMA expression RPAREN
    | YEAR LPAREN expression RPAREN
    | MONTH LPAREN expression RPAREN
    | DAY LPAREN expression RPAREN
    ;
conversionFunction
    : castExpression
    ;
// =============================================
// COLUMN AND TABLE REFERENCES
// =============================================
columnReference
    : (tableName DOT)? columnName
    | (schemaName DOT tableName DOT)? columnName
    ;
tableName
    : (schemaName DOT)? identifier
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
// IDENTIFIERS & DATA TYPES & LITERALS
// =============================================
identifier
    : IDENTIFIER
    | DELIMITED_IDENTIFIER_BRACKET
    | DELIMITED_IDENTIFIER_QUOTE
    | DELIMITED_IDENTIFIER_BACKTICK
    | nonReservedKeyword
    ;
nonReservedKeyword
    : KEY | ROLE | USER | TYPE | OPTION | PARTITION | RANGE | ROWS | ROW | WRITE
    ;
dataType
    : INT | BIGINT | SMALLINT | TINYINT
    | VARCHAR (LPAREN INTEGER RPAREN)? | NVARCHAR (LPAREN INTEGER | MAX RPAREN)?
    | CHAR (LPAREN INTEGER RPAREN)? | NCHAR (LPAREN INTEGER RPAREN)?
    | TEXT | NTEXT | DATETIME | DATE | TIME | TIMESTAMP | BIT
    | DECIMAL (LPAREN INTEGER (COMMA INTEGER)? RPAREN)? | NUMERIC (LPAREN INTEGER (COMMA INTEGER)? RPAREN)?
    | FLOAT (LPAREN INTEGER RPAREN)? | REAL | MONEY | SMALLMONEY
    | BINARY (LPAREN INTEGER RPAREN)? | VARBINARY (LPAREN INTEGER | MAX RPAREN)?
    | IMAGE | UNIQUEIDENTIFIER | XML | SQL_VARIANT
    ;
literal
    : STRING | INTEGER | FLOATN | NULL | TRUE | FALSE
    ;
comparisonOperator
    : EQUALS | GREATER | LESS | LESS_EQUAL | GREATER_EQUAL | NOT_EQUAL1 | NOT_EQUAL2 | NOT_LESS | NOT_GREATER
    ;
unaryOperator
    : PLUS | MINUS | MINUS | NOT
    ;
setOperator
    : UNION ALL? | EXCEPT | INTERSECT
    ;

// =============================================
// INSERT STATEMENT - FULL Transact-SQL Support (All 22 Examples)
// =============================================
insertStatement
    : withClause?                                 // 11. WITH CTE
      INSERT topClause?                           // 9-10. TOP
      INTO?                                       // INTO optional
      targetSpecification                         // Table/view/variable/remote/rowset
      columnList?                                 // Optional columns
      outputClause?                               // 12. OUTPUT
      insertSource                                // VALUES / SELECT / EXEC / DEFAULT VALUES
      tableHint?                                  // 19. WITH (TABLOCK)
      optionClause?                               // 21. OPTION (...)
      SEMICOLON?                                        // 22. Semicolon
    ;

// Supporting rules for INSERT
withClause
    : WITH cteExpression (COMMA cteExpression)*
    ;
cteExpression
    : identifier columnAliases? AS LPAREN queryExpression RPAREN
    ;
columnAliases
    : LPAREN identifier (COMMA identifier)* RPAREN
    ;
targetSpecification
    : (server=identifier DOT)? (db=identifier DOT)? (schema=identifier DOT)? table=identifier   // Remote + normal
    | rowsetFunction
    | USER_VARIABLE                                          // Table variable (example 17)
    ;
rowsetFunction
    : OPENROWSET LPAREN STRING COMMA STRING COMMA STRING RPAREN
    | OPENQUERY LPAREN identifier COMMA STRING RPAREN
    ;
columnList
    : LPAREN columnName (COMMA columnName)* RPAREN
    ;
outputClause
    : OUTPUT outputExpressionList (INTO outputTarget columnAliases? )?
    ;
outputExpressionList
    : outputExpression (COMMA outputExpression)*
    ;
outputExpression
    : (INSERTED | DELETED) DOT (identifier | STAR)
    | expression (AS? identifier)?
    ;
outputTarget
    : USER_VARIABLE
    | tableName
    ;
tableHint
    : WITH LPAREN hintList RPAREN
    ;
hintList
    : identifier (COMMA identifier)*
    ;
insertSource
    : valuesClause
    | queryExpression
    | executeStatement
    | dmlTableSource
    | DEFAULT VALUES                                 // Example 7
    ;
valuesClause
    : VALUES valueRow (COMMA valueRow)*
    ;
valueRow
    : LPAREN expressionList RPAREN
    | LPAREN RPAREN
    ;
executeStatement
    : (EXEC | EXECUTE)? (procedureCall | STRING)
    ;
procedureCall
    : (schemaName DOT)? identifier
    ;
dmlTableSource
    : LPAREN (deleteStatement | updateStatement) outputClause RPAREN (AS? identifier)?
    ;
optionClause
    : OPTION LPAREN queryHint (COMMA queryHint)* RPAREN
    ;
queryHint
    : identifier (EQUALS STRING)?
    | RECOMPILE
    ;

// =============================================
// BULK INSERT (Example 20)
// =============================================
bulkInsertStatement
    : BULK INSERT targetSpecification
      FROM STRING
      (WITH LPAREN bulkOption (COMMA bulkOption)* RPAREN)?
    ;
bulkOption
    : identifier (EQUALS (INTEGER | STRING))?
    ;
// =============================================
// UPDATE STATEMENT -  VERSION 2
// =============================================

updateStatement
    : withClause?
      UPDATE topClause?
      updateTarget
      SET updateSetClause (COMMA updateSetClause)*
      outputClause?
      fromClause?
      whereClause?
      optionClause?
      SEMICOLON?
    ;

updateTarget
    : tableName
    | USER_VARIABLE
    ;

updateSetClause
    : fullColumnName assignmentOperator expression
    ;

fullColumnName
    : tableName DOT columnName    // T1.Price
    | columnName                   // Salary
    | USER_VARIABLE                // @variable
    ;

assignmentOperator
    : EQUALS 
    | PLUS_EQUAL 
    | MINUS_EQUAL 
    | STAR_EQUAL 
    | SLASH_EQUAL 
    | PERCENT_EQUAL 
    | AMPERSAND_EQUAL 
    | CARET_EQUAL 
    | PIPE_EQUAL
    ;



// =============================================
// DELETE STATEMENT -Version 1
// =============================================

deleteStatement
    : DELETE  deleteTarget?
      (topClause)?
      (FROM)? 
      tableSource (COMMA tableSource)*  
      whereClause?
      (SEMICOLON)?
    ;

deleteTarget
    : tableAlias
    ;

tableSources
    : tableSource (COMMA tableSource)*
    ;



joinClause
    : (INNER? JOIN | LEFT (OUTER)? JOIN | RIGHT (OUTER)? JOIN | FULL (OUTER)? JOIN | CROSS JOIN)
      tableSource 
      ON searchCondition
    ;
createStatement
    : CREATE TABLE tableName LPAREN columnDefinition (COMMA columnDefinition)* RPAREN
    | CREATE VIEW tableName AS queryExpression
    | CREATE PROCEDURE identifier (LPAREN parameterList RPAREN)? AS BEGIN statementList END
    | CREATE FUNCTION identifier LPAREN parameterList? RPAREN RETURN dataType AS BEGIN statementList RETURN expression END
    | CREATE INDEX identifier ON tableName LPAREN columnName (COMMA columnName)* RPAREN
    ;
statementList
    : (selectStatement | insertStatement | updateStatement | deleteStatement | declareStatement | setStatement | ifStatement | whileStatement | returnStatement)+
    ;
declareStatement
    : DECLARE USER_VARIABLE dataType (EQUALS expression)?
    ;
setStatement
    : SET USER_VARIABLE EQUALS expression
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
    | FOREIGN KEY REFERENCES tableName (LPAREN columnName RPAREN)?
    | UNIQUE
    | NOT? NULL
    | CHECK LPAREN searchCondition RPAREN
    | DEFAULT expression
    | IDENTITY (LPAREN INTEGER COMMA INTEGER RPAREN)?
    ;
parameterList
    : parameter (COMMA parameter)*
    ;
parameter
    : USER_VARIABLE dataType
    ;
alterStatement
    : ALTER TABLE tableName (ADD columnDefinition | DROP COLUMN columnName)
    ;
dropStatement
    : DROP (TABLE | VIEW | PROCEDURE | FUNCTION | INDEX) identifier
>>>>>>> main
    ;
