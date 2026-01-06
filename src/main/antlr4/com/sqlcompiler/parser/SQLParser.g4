parser grammar SQLParser;

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

querySpecification
    : SELECT topClause? distinctClause? selectList
      fromClause?
      whereClause?
      groupByClause?
      havingClause?
    ;

/* ---------- TOP / DISTINCT ---------- */

topClause
    : TOP INTEGER (PERCENT)? (WITH TIES)?
    ;

distinctClause
    : DISTINCT
    | ALL
    ;

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

joinType
    : INNER
    | LEFT OUTER?
    | RIGHT OUTER?
    | FULL OUTER?
    | CROSS
    ;

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

offsetFetchClause
    : OFFSET expression (ROW | ROWS)
      (FETCH (FIRST | NEXT) expression (ROW | ROWS) ONLY)?
    ;

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
    ;
