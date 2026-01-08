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
    | bulkInsertStatement          // Added for BULK INSERT (example 20)
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
searchCondition
    : searchCondition AND searchCondition
    | searchCondition OR searchCondition
    | NOT searchCondition
    | '(' searchCondition ')'
    | predicate
    ;
// =============================================
// PREDICATES
// =============================================
predicate
    : expression comparisonOperator expression
    | expression IS NOT? NULL
    | expression NOT? BETWEEN expression AND expression
    | expression NOT? IN '(' (queryExpression | expressionList) ')'
    | expression NOT? IN '(' ')'
    | expression NOT? LIKE expression (ESCAPE STRING)?
    | EXISTS '(' queryExpression ')'
    | expression NOT? IN IDENTIFIER
    | expression
    ;
// =============================================
// GROUP BY / HAVING / ORDER BY / OFFSET FETCH
// =============================================
groupByClause
    : GROUP BY groupByItem (',' groupByItem)*
    ;
groupByItem
    : expression
    ;
havingClause
    : HAVING searchCondition
    ;
orderByClause
    : ORDER BY orderByExpression (',' orderByExpression)*
    ;
orderByExpression
    : expression (ASC | DESC)?
    ;
offsetFetchClause
    : OFFSET expression (ROW | ROWS)
      (FETCH (FIRST | NEXT) expression (ROW | ROWS) ONLY)?
    ;
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
    | '(' expression ')'
    | unaryOperator expression
    | expression ('*' | '/' | '%') expression
    | expression ('+' | '-') expression
    | expression ('||' | '+') expression
    | expression comparisonOperator expression
    | castExpression
    | windowFunction
    ;
expressionList
    : expression (',' expression)*
    ;
subquery
    : '(' queryExpression ')'
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
    : CAST '(' expression AS dataType ')'
    | CONVERT '(' dataType ',' expression (',' INTEGER)? ')'
    | TRY_CAST '(' expression AS dataType ')'
    | TRY_CONVERT '(' dataType ',' expression (',' INTEGER)? ')'
    ;
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
    : KEY | ROLE | USER | TYPE | OPTION | PARTITION | RANGE | ROWS | ROW
    ;
dataType
    : INT | BIGINT | SMALLINT | TINYINT
    | VARCHAR ('(' INTEGER ')')? | NVARCHAR ('(' INTEGER | MAX ')')?
    | CHAR ('(' INTEGER ')')? | NCHAR ('(' INTEGER ')')?
    | TEXT | NTEXT | DATETIME | DATE | TIME | TIMESTAMP | BIT
    | DECIMAL ('(' INTEGER (',' INTEGER)? ')')? | NUMERIC ('(' INTEGER (',' INTEGER)? ')')?
    | FLOAT ('(' INTEGER ')')? | REAL | MONEY | SMALLMONEY
    | BINARY ('(' INTEGER ')')? | VARBINARY ('(' INTEGER | MAX ')')?
    | IMAGE | UNIQUEIDENTIFIER | XML | SQL_VARIANT
    ;
literal
    : STRING | INTEGER | FLOATN | NULL | TRUE | FALSE
    ;
comparisonOperator
    : '=' | '>' | '<' | '<=' | '>=' | '<>' | '!=' | '!<' | '!>'
    ;
unaryOperator
    : '+' | '-' | '~' | NOT
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
      ';'?                                        // 22. Semicolon
    ;

// Supporting rules for INSERT
withClause
    : WITH cteExpression (',' cteExpression)*
    ;
cteExpression
    : identifier columnAliases? AS '(' queryExpression ')'
    ;
columnAliases
    : '(' identifier (',' identifier)* ')'
    ;
targetSpecification
    : (server=identifier '.')? (db=identifier '.')? (schema=identifier '.')? table=identifier   // Remote + normal
    | rowsetFunction
    | USER_VARIABLE                                          // Table variable (example 17)
    ;
rowsetFunction
    : OPENROWSET '(' STRING ',' STRING ',' STRING ')'
    | OPENQUERY '(' identifier ',' STRING ')'
    ;
columnList
    : '(' columnName (',' columnName)* ')'
    ;
outputClause
    : OUTPUT outputExpressionList (INTO outputTarget columnAliases? )?
    ;
outputExpressionList
    : outputExpression (',' outputExpression)*
    ;
outputExpression
    : (INSERTED | DELETED) '.' (identifier | '*')
    | expression (AS? identifier)?
    ;
outputTarget
    : USER_VARIABLE
    | tableName
    ;
tableHint
    : WITH '(' hintList ')'
    ;
hintList
    : identifier (',' identifier)*
    ;
insertSource
    : valuesClause
    | queryExpression
    | executeStatement
    | dmlTableSource
    | DEFAULT VALUES                                 // Example 7
    ;
valuesClause
    : VALUES valueRow (',' valueRow)*
    ;
valueRow
    : '(' expressionList ')'
    | '(' ')'
    ;
executeStatement
    : (EXEC | EXECUTE)? (procedureCall | STRING)
    ;
procedureCall
    : (schemaName '.')? identifier
    ;
dmlTableSource
    : '(' (deleteStatement | updateStatement) outputClause ')' (AS? identifier)?
    ;
optionClause
    : OPTION '(' queryHint (',' queryHint)* ')'
    ;
queryHint
    : identifier ('=' STRING)?
    | RECOMPILE
    ;

// =============================================
// BULK INSERT (Example 20)
// =============================================
bulkInsertStatement
    : BULK INSERT targetSpecification
      FROM STRING
      (WITH '(' bulkOption (',' bulkOption)* ')')?
    ;
bulkOption
    : identifier ('=' (INTEGER | STRING))?
    ;

// =============================================
// UPDATE / DELETE / CREATE / ALTER / DROP (unchanged)
// =============================================
updateStatement
    : UPDATE tableName SET columnName '=' expression (',' columnName '=' expression)*
      whereClause?
    ;
deleteStatement
    : DELETE FROM? tableName whereClause?
    ;
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
alterStatement
    : ALTER TABLE tableName (ADD columnDefinition | DROP COLUMN columnName)
    ;
dropStatement
    : DROP (TABLE | VIEW | PROCEDURE | FUNCTION | INDEX) identifier
    ;