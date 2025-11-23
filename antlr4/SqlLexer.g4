// Define a grammar called Hello
grammar SqlLexer;

// Rule: a 'greeting' is the word 'hello' followed by an 'ID'
greeting : 'hello' ID;

// Rule: an 'ID' is a sequence of one or more letters
ID : [a-zA-Z]+ ;

// Rule: skip whitespace (spaces, tabs, newlines)
WS : [ \t\r\n]+ -> skip;