parser grammar SQLParser;

options {
    tokenVocab = SQLLexer;
}

sqlStatement
    : selectStatement EOF
    ;

selectStatement
    : SELECT selectList FROM tableName whereClause?
    ;

selectList
    : STAR
    | columnName (COMMA columnName)*
    ;

tableName
    : IDENTIFIER
    ;

columnName
    : IDENTIFIER
    ;

whereClause
    : WHERE condition
    ;

condition
    : IDENTIFIER comparisonOperator literal
    ;

comparisonOperator
    : EQ | LT | GT | LE | GE | NE
    ;

literal
    : STRING
    | FLOATN
    ;
