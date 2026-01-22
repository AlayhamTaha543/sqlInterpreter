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
    : ( selectStatement
      | insertStatement
      | bulkInsertStatement
      | updateStatement
      | deleteStatement
      | mergeStatement
      | createStatement
      | alterStatement
      | dropStatement
      | renameStatement
      | truncateStatement
      | useStatement                   
      // Cursor statements
      | declareCursorStatement
      | openCursorStatement
      | closeCursorStatement
      | fetchStatement
      | deallocateCursorStatement
      // Transaction control
      | beginTransactionStatement
      | commitTransactionStatement
      | rollbackTransactionStatement
      | savepointStatement
      // Control flow
      | tryCatchStatement
      | printStatement
      | raiseErrorStatement
      | declareStatement
      | setStatement
      | ifStatement
      | whileStatement
      | returnStatement
      ) SEMICOLON?
    ;

// Root rule for parsing - includes EOF
sqlStatements
    : batch (GO INTEGER? batch)* EOF
    ;

batch
    : sqlStatement*
    ;

// =============================================
// SELECT STATEMENT - Complete Implementation
// =============================================

selectStatement
    : queryExpression orderByClause? offsetFetchClause?
    ;

queryExpression
    : querySpecification (setOperator querySpecification)*
    | LPAREN queryExpression RPAREN
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
    : TOP (INTEGER | LPAREN expression RPAREN) (PERCENT)? (WITH TIES)?
    ;

// -------------------------
// DISTINCT CLAUSE
// -------------------------
distinctClause
    : DISTINCT
    | ALL
    ;
/* =====================================================
 RENAME STATEMENT (ONLY WHAT YOU ASKED)
 * =====================================================
 */


renameStatement
    : RENAME TABLE renameTableItem (COMMA renameTableItem)* SEMICOLON?
    ;


renameTableItem
    : qualifiedName TO qualifiedName
    ;


qualifiedName
    : (databaseName DOT)? (schemaName DOT)? objectName
    ;


databaseName
    : identifier
    ;



objectName
    : identifier
    ;


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

joinType
    : INNER
    | LEFT OUTER?
    | RIGHT OUTER?
    | FULL OUTER?
    | CROSS
    ;

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
whereCurrentOfClause
    : WHERE CURRENT OF (GLOBAL? identifier | USER_VARIABLE)
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
    | CURRENT_TIMESTAMP
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
    | expression AMPERSAND expression                          
    | expression PIPE expression                             
    | expression CARET expression  
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
    | UNBOUNDED PRECEDING                                    
    | UNBOUNDED FOLLOWING 
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
    | systemFunction 
    ;

aggregateFunction
    : (COUNT | SUM | AVG | MIN | MAX) LPAREN (DISTINCT | ALL)? (expression | STAR) RPAREN
    ;
//  System functions (COALESCE, NULLIF, IIF, etc.)
systemFunction
    : COALESCE LPAREN expressionList RPAREN
    | NULLIF LPAREN expression COMMA expression RPAREN
    | IIF LPAREN searchCondition COMMA expression COMMA expression RPAREN
    | ISNULL LPAREN expression COMMA expression RPAREN
    | ISNUMERIC LPAREN expression RPAREN
    | NEWID LPAREN RPAREN
    | SCOPE_IDENTITY LPAREN RPAREN
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
    | DATEADD LPAREN identifier  COMMA expression COMMA expression RPAREN
    | DATEDIFF LPAREN identifier  COMMA expression COMMA expression RPAREN
    | DATEPART LPAREN identifier  COMMA expression RPAREN
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
    : (databaseName DOT)? (schemaName DOT)? identifier
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
    | NAME | SIZE | OWNER | FILE | SCHEMA | INPUT | OUTPUT | ACTION | MONTH | DAY | YEAR
    | TRANSACTION | TRIGGER | LOGIN | PERMISSION | DATABASE | GO
    | SOURCE      
    | DESC        
    | ASC         
    | DATE        
    | TIME        
    | TIMESTAMP   
    // | COMMENT     
    // | STATUS      
    // | LEVEL       
    | COUNT       
    ;

dataType
    : (INT | BIGINT | SMALLINT | TINYINT) (UNSIGNED | SIGNED)?
    | BOOLEAN
    | VARCHAR (LPAREN INTEGER RPAREN)? 
    | NVARCHAR (LPAREN (INTEGER | MAX) RPAREN)?
    | CHAR (LPAREN INTEGER RPAREN)? 
    | NCHAR (LPAREN INTEGER RPAREN)?
    | TEXT | NTEXT | DATETIME | DATE | TIME | TIMESTAMP | BIT
    | DECIMAL (LPAREN INTEGER (COMMA INTEGER)? RPAREN)? (UNSIGNED)?
    | FLOAT (LPAREN INTEGER RPAREN)? | REAL | MONEY | SMALLMONEY
    | BINARY (LPAREN INTEGER RPAREN)? 
    | VARBINARY (LPAREN (INTEGER | MAX) RPAREN)?
    | IMAGE | UNIQUEIDENTIFIER | XML | SQL_VARIANT
    | ENUM LPAREN STRING (COMMA STRING)* RPAREN
    | POINT (NOT NULL)? (SRID INTEGER)?
    ;

literal
    : STRING | INTEGER | FLOATN | NULL | TRUE | FALSE
    ;

comparisonOperator
    : EQUALS | GREATER | LESS | LESS_EQUAL | GREATER_EQUAL 
    | NOT_EQUAL1 | NOT_EQUAL2 | NOT_LESS | NOT_GREATER
    ;

unaryOperator
    : PLUS | MINUS | NOT
    ;

setOperator
    : UNION ALL? | EXCEPT | INTERSECT
    ;

// =============================================
// INSERT STATEMENT - FULL Transact-SQL Support (All 22 Examples)
// =============================================

insertStatement
    : withClause? // 11. WITH CTE
      INSERT topClause? // 9-10. TOP
      INTO? // INTO optional
      targetSpecification // Table/view/variable/remote/rowset
      columnList? // Optional columns
      outputClause? // 12. OUTPUT
      insertSource // VALUES / SELECT / EXEC / DEFAULT VALUES
      tableHint? // 19. WITH (TABLOCK)
      optionClause? // 21. OPTION (...)
      SEMICOLON? // 22. Semicolon
    ;

// Supporting rules for INSERT
withClause
    : WITH RECURSIVE? cteExpression (COMMA cteExpression)*
    ;

cteExpression
    : identifier columnAliases? AS LPAREN queryExpression RPAREN
    ;

columnAliases
    : LPAREN identifier (COMMA identifier)* RPAREN
    ;

targetSpecification
    : (server=identifier DOT)? (db=identifier DOT)? (schema=identifier DOT)? table=identifier // Remote + normal
    | rowsetFunction
    | USER_VARIABLE // Table variable (example 17)
    ;

rowsetFunction
    : OPENROWSET LPAREN STRING COMMA STRING COMMA STRING RPAREN
    | OPENQUERY LPAREN identifier COMMA STRING RPAREN
    ;

columnList
    : LPAREN columnName (COMMA columnName)* RPAREN
    ;

outputClause
    : OUTPUT outputExpressionList (INTO outputTarget columnAliases?)?
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
    : hintItem (COMMA hintItem)*
    ;
hintItem
    : TABLOCK
    | NOLOCK
    | READPAST
    | ROWLOCK
    | PAGLOCK
    | UPDLOCK
    | XLOCK
    | identifier
    ;
insertSource
    : valuesClause
    | queryExpression
    | executeStatement
    | dmlTableSource
    | DEFAULT VALUES // Example 7
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
// UPDATE STATEMENT - VERSION 2
// =============================================

updateStatement
    : withClause?
      UPDATE topClause?
      updateTarget
      SET updateSetClause (COMMA updateSetClause)*
      outputClause?
      fromClause?
      whereClause?
      whereCurrentOfClause?
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
    : tableName DOT columnName // T1.Price
    | columnName // Salary
    | USER_VARIABLE // @variable
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
// DELETE STATEMENT - Complete Working Version
// =============================================

deleteStatement
    : withClause? DELETE 
      topClause?
      fromDeleteTarget?
      deleteTarget
      tableHint?                    // For hints after target table
      outputClause?
      fromTableSources?
      whereClause?
      whereCurrentOfClause?
      orderByClause?                // MySQL ORDER BY
      limitClause?                  // MySQL LIMIT
      optionClause?
      SEMICOLON?
    ;

fromDeleteTarget
    : FROM
    ;

// Multi-target: DELETE t1, t2, t3
deleteTarget
    : deleteTargetItem (COMMA deleteTargetItem)*
    ;

deleteTargetItem
    : tableAlias
    | deleteQualifiedTableName
    | USER_VARIABLE
    | rowsetFunction
    ;

deleteQualifiedTableName
    : (identifier DOT)? (identifier DOT)? identifier (AS? tableAlias)?
    ;

fromTableSources
    : FROM deleteTableSources
    ;

// Comma-separated tables (old style) and joins
deleteTableSources
    : deleteTableSource (COMMA deleteTableSource)*
    ;

deleteTableSource
    : deleteTableSourceItem tableHint?
    | LPAREN selectStatement RPAREN (AS? tableAlias)?
    | deleteTableSource deleteJoinClause
    ;

deleteTableSourceItem
    : deleteQualifiedTableName
    ;

deleteJoinClause
    : joinType? JOIN deleteTableSourceItem (AS? tableAlias)? ON searchCondition
    ;

// MySQL extensions
limitClause
    : LIMIT INTEGER (OFFSET INTEGER)?
    ;
    
// Reuse existing rules:
// - withClause (from INSERT)
// - topClause (from SELECT)
// - tableHint (from INSERT)
// - outputClause (from INSERT)
// - orderByClause (from SELECT)
// - optionClause (from INSERT)
// - joinType (from SELECT)



// =============================================
// MERGE STATEMENT 
// =============================================

mergeStatement
    : withClause?                        // Optional CTE
      MERGE
      INTO mergeTarget
      USING mergeSource
      ON searchCondition
      mergeWhenClause+                  // One or more WHEN clauses
      optionClause?
      SEMICOLON?
    ;

// Target and Source definitions
mergeTarget
    : tableName (AS? tableAlias)?
    ;

mergeSource
    : tableName (AS? tableAlias)?
    | LPAREN queryExpression RPAREN (AS? tableAlias)?
    ;

// WHEN Clauses
mergeWhenClause
    : mergeWhenMatched
    | mergeWhenNotMatched
    ;

// WHEN MATCHED
mergeWhenMatched
    : WHEN MATCHED (AND searchCondition)? THEN mergeMatchedAction
    ;

// WHEN NOT MATCHED
mergeWhenNotMatched
    : WHEN NOT MATCHED (AND searchCondition)? THEN mergeNotMatchedAction
    ;

// Actions
mergeMatchedAction
    : UPDATE SET mergeSetClause (COMMA mergeSetClause)*
    | DELETE
    ;

mergeSetClause
    : fullColumnName EQUALS expression
    ;

mergeNotMatchedAction
    : INSERT (LPAREN columnName (COMMA columnName)* RPAREN)?
      VALUES LPAREN expressionList RPAREN
    ; 


// =============================================
// CREATE STATEMENT
// =============================================

createStatement
    : CREATE TABLE tableName
        LPAREN
            (tableElement (COMMA tableElement)*)?
        RPAREN
    | CREATE VIEW tableName AS queryExpression
    | CREATE (OR ALTER)? (PROCEDURE | PROC) procedureName
        parameterList?
        (WITH procedureOption (COMMA procedureOption)*)?
        (FOR REPLICATION)?
        AS
        (BEGIN statementList END? | statement | EXTERNAL NAME STRING)
    | CREATE FUNCTION identifier LPAREN parameterList? RPAREN RETURN dataType AS BEGIN statementList RETURN expression END
    | CREATE INDEX identifier ON tableName LPAREN columnName (COMMA columnName)* RPAREN
    ;
// =============================================
// TABLE ELEMENTS AND CONSTRAINTS
// =============================================

tableElement
    : columnDefinition
    | tableConstraint
    ;

tableConstraint
    : (CONSTRAINT identifier)?                                      
      PRIMARY KEY (CLUSTERED | NONCLUSTERED)?                       
      LPAREN columnName (COMMA columnName)* RPAREN
      indexOptions?                                                 
    | (CONSTRAINT identifier)?                                      
      UNIQUE (CLUSTERED | NONCLUSTERED)?                            
      LPAREN columnName (COMMA columnName)* RPAREN
      indexOptions?                                                 
    | (CONSTRAINT identifier)?                                      
      FOREIGN KEY LPAREN columnName (COMMA columnName)* RPAREN 
        REFERENCES tableName (LPAREN columnName (COMMA columnName)* RPAREN)?
        (onDeleteClause? onUpdateClause?)
    | (CONSTRAINT identifier)?                                      
      CHECK LPAREN searchCondition RPAREN
    | INDEX identifier (CLUSTERED | NONCLUSTERED)?                  
      LPAREN columnName (COMMA columnName)* RPAREN
      indexOptions?                                                 
    | SPATIAL INDEX identifier 
      LPAREN columnName (COMMA columnName)* RPAREN
    ;


indexOptions
    : WITH LPAREN indexOption (COMMA indexOption)* RPAREN
    ;

indexOption
    : PAD_INDEX EQUALS (ON | OFF)
    | FILLFACTOR EQUALS INTEGER
    | IGNORE_DUP_KEY EQUALS (ON | OFF)
    | STATISTICS_NORECOMPUTE EQUALS (ON | OFF)
    | ALLOW_ROW_LOCKS EQUALS (ON | OFF)
    | ALLOW_PAGE_LOCKS EQUALS (ON | OFF)
    | DATA_COMPRESSION EQUALS (NONE | ROW | PAGE)
    ;

onDeleteClause
    : ON DELETE referenceAction
    ;

onUpdateClause
    : ON UPDATE referenceAction
    ;

referenceAction
    : CASCADE
    | SET NULL
    | SET DEFAULT
    | RESTRICT
    | NO ACTION
    ;

// =============================================
// STATEMENT LIST
// =============================================
statementList
    : statement (SEMICOLON statement)*
    ;
statement
    : selectStatement 
      | insertStatement 
      | bulkInsertStatement
      | updateStatement 
      | deleteStatement 
      | mergeStatement
      | createStatement              
      | alterStatement               
      | dropStatement                
      | truncateStatement            
      | declareStatement 
      | setStatement 
      | ifStatement 
      | whileStatement 
      | returnStatement
      | tryCatchStatement
      | printStatement
      | raiseErrorStatement
      | beginTransactionStatement
      | commitTransactionStatement
      | rollbackTransactionStatement
      | savepointStatement
      | openCursorStatement
      | closeCursorStatement
      | fetchStatement
      | deallocateCursorStatement
      | PRINT expression
      | EXECUTE (procedureCall | STRING)
      | expression
    ;

declareStatement
    : DECLARE USER_VARIABLE dataType (EQUALS expression)?
    ;

setStatement
    : SET USER_VARIABLE EQUALS expression
    ;

ifStatement
    : IF searchCondition 
      (BEGIN statementList END | sqlStatement)
      (ELSE (BEGIN statementList END | sqlStatement))?
    ;

whileStatement
    : WHILE searchCondition BEGIN statementList END
    ;

returnStatement
    : RETURN expression?
    ;
declareCursorStatement
    : DECLARE identifier CURSOR
      cursorOptions?
      FOR queryExpression
      (FOR (READ ONLY | UPDATE (OF columnName (COMMA columnName)*)?))?
    ;

cursorOptions
    : cursorOption+
    ;

cursorOption
    : LOCAL
    | GLOBAL
    | FORWARD_ONLY
    | SCROLL
    | STATIC
    | KEYSET
    | DYNAMIC
    | FAST_FORWARD
    | READ_ONLY
    | SCROLL_LOCKS
    | OPTIMISTIC
    | TYPE_WARNING
    ;

openCursorStatement
    : OPEN (GLOBAL? identifier | USER_VARIABLE)
    ;

closeCursorStatement
    : CLOSE (GLOBAL? identifier | USER_VARIABLE)
    ;

deallocateCursorStatement
    : DEALLOCATE (GLOBAL? identifier | USER_VARIABLE)
    ;

fetchStatement
    : FETCH fetchOrientation? (FROM | IN)?
      (GLOBAL? identifier | USER_VARIABLE)
      (INTO USER_VARIABLE (COMMA USER_VARIABLE)*)?
    ;

fetchOrientation
    : NEXT
    | PRIOR
    | FIRST
    | LAST
    | ABSOLUTE expression
    | RELATIVE expression
    ;
    // =============================================
// ➕ NEW: TRANSACTION CONTROL STATEMENTS
// Location: After cursor statements
// =============================================

beginTransactionStatement
    : BEGIN (TRAN | TRANSACTION) (identifier | USER_VARIABLE)?
      (WITH MARK STRING?)?
    ;

commitTransactionStatement
    : COMMIT (TRAN | TRANSACTION | WORK)? (identifier | USER_VARIABLE)?
    ;

rollbackTransactionStatement
    : ROLLBACK (TRAN | TRANSACTION | WORK)? (identifier | USER_VARIABLE)?
      (TO (SAVEPOINT)? (identifier | USER_VARIABLE))?
    ;

savepointStatement
    : SAVE (TRAN | TRANSACTION) (identifier | USER_VARIABLE)
    ;

// =============================================
// ➕ NEW: TRY-CATCH BLOCK
// Location: After transaction statements
// =============================================

tryCatchStatement
    : BEGIN TRY
        statementList
      END TRY
      BEGIN CATCH
        statementList
      END CATCH
    ;

// =============================================
// ➕ NEW: PRINT AND RAISERROR
// Location: After TRY-CATCH
// =============================================

printStatement
    : PRINT (expression | USER_VARIABLE | STRING)
    ;

raiseErrorStatement
    : RAISERROR LPAREN
        (INTEGER | STRING | USER_VARIABLE) COMMA
        INTEGER COMMA
        INTEGER
        (COMMA expression)*
      RPAREN
      (WITH raiseErrorOption (COMMA raiseErrorOption)*)?
    ;

raiseErrorOption
    : LOG
    | NOWAIT
    | SETERROR
    ;

// =============================================
// COLUMN DEFINITION - FIXED VERSION  
// =============================================

columnDefinition
    : columnName dataType columnAttribute*
    ;

columnAttribute
    : PRIMARY KEY
    | FOREIGN KEY REFERENCES tableName (LPAREN columnName RPAREN)?
    | UNIQUE
    | NOT NULL
    | NULL
    | CHECK LPAREN searchCondition RPAREN
    | DEFAULT defaultValue
    | ON UPDATE CURRENT_TIMESTAMP
    | IDENTITY (LPAREN INTEGER COMMA INTEGER RPAREN)?
    | AUTO_INCREMENT
    | GENERATED ALWAYS AS LPAREN expression RPAREN storageType?
    ;

defaultValue
    : expression
    | CURRENT_TIMESTAMP
    ;

storageType
    : STORED
    | VIRTUAL
    ;

parameterList
    : parameter (COMMA parameter)*
    ;

parameter
    : (direction=(IN | OUT | OUTPUT | READONLY))?
      USER_VARIABLE
      dataType
      (EQUALS expression)? // default value
    ;

// =============================================
// ALTER AND DROP STATEMENTS
// =============================================

alterStatement
    : ALTER TABLE tableName (ADD columnDefinition | DROP COLUMN columnName)
    ;

// =============================================
// DROP STATEMENT - Enhanced Version
// =============================================

dropStatement
    : dropDatabase
    | dropSchema
    | dropTable
    | dropView
    | dropProcedure
    | dropFunction
    | dropIndex
    | dropTrigger
    ;

dropDatabase
    : DROP DATABASE ifExists? databaseName
    ;

dropSchema
    : DROP SCHEMA ifExists? schemaName
    ;

dropTable: 
    DROP TEMPORARY? TABLE ifExists?  tableName (COMMA tableName)* dropBehavior?
    ;
dropBehavior:
    CASCADE | RESTRICT
    ;

dropView
    : DROP VIEW ifExists? tableName (COMMA tableName)*
    ;

dropProcedure
    : DROP PROCEDURE ifExists? procedureName (COMMA procedureName)*
    ;

dropFunction
    : DROP FUNCTION ifExists? functionName (COMMA functionName)*
    ;

dropIndex
    : DROP INDEX ifExists? indexName ON tableName
    | DROP INDEX tableName DOT indexName
    ;

dropTrigger
    : DROP TRIGGER ifExists? triggerName (COMMA triggerName)*
    ;

ifExists
    : IF EXISTS
    ;

procedureName
    : (schemaName DOT)? identifier
    ;
procedureOption
    : ENCRYPTION
    | RECOMPILE
    | EXECUTE AS (CALLER | SELF | OWNER | STRING)
    | SCHEMABINDING
    ;



indexName
    : (schemaName DOT)? identifier
    | (tableName DOT)? identifier
    ;

triggerName
    : (schemaName DOT)? identifier
    ;
   
// =============================================
// TRUNCATE STATEMENT
// =============================================

truncateStatement
    : TRUNCATE truncateTarget
    ;

truncateTarget
    : TABLE tableName truncateOption?
    ;

truncateOption
    : CONTINUE IDENTITY
    | RESTART IDENTITY
    ;
///////////////////////////////use statement///////////////////////////////
useStatement
    : USE databaseName
    ;
