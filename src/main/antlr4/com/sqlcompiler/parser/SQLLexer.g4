// Define a grammar called SqlLexer
lexer grammar SQLLexer;

// =============================================
// SECTION 1: SKIP RULES (Must be first)
// =============================================
WS: [ \t\r\n]+ -> skip;
LINE_COMMENT: '--' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;

// =============================================
// SECTION 2: MULTI-CHARACTER OPERATORS (Before single-char)
// =============================================
PLUS_EQUAL: '+=';
MINUS_EQUAL: '-=';
STAR_EQUAL: '*=';
SLASH_EQUAL: '/=';
PERCENT_EQUAL: '%=';
AMPERSAND_EQUAL: '&=';
CARET_EQUAL: '^=';
PIPE_EQUAL: '|=';

PIPE_PIPE: '||';
EQUAL_EQUAL: '==';
LESS_EQUAL: '<=';
GREATER_EQUAL: '>=';
NOT_EQUAL1: '<>';
NOT_EQUAL2: '!=';
NOT_GREATER: '!>';
NOT_LESS: '!<';

// =============================================
// SECTION 3: SINGLE-CHARACTER SYMBOLS
// =============================================
SEMICOLON: ';';
COMMA: ',';
DOT: '.';
LPAREN: '(';
RPAREN: ')';
EQUALS: '=';
GREATER: '>';
LESS: '<';
STAR: '*';
SLASH: '/';
PERCENT_SIGN: '%';
PLUS: '+';
MINUS: '-';
TILDE: '~';

// =============================================
// SECTION 4: KEYWORDS (Alphabetically grouped)
// =============================================

// A
ACTION: A C T I O N;
ADD: A D D;
ALL: A L L;
ALLOW_PAGE_LOCKS: A L L O W '_' P A G E '_' L O C K S;
ALLOW_ROW_LOCKS: A L L O W '_' R O W '_' L O C K S;
ALTER: A L T E R;
ALWAYS: A L W A Y S;
AND: A N D;
ANY: A N Y;
AS: A S;
ASC: A S C;
AUTO_CLOSE: A U T O '_' C L O S E;
AUTO_CREATE_STATISTICS: A U T O '_' C R E A T E '_' S T A T I S T I C S;
AUTO_INCREMENT: A U T O '_' I N C R E M E N T;
AUTO_SHRINK: A U T O '_' S H R I N K;
AUTO_UPDATE_STATISTICS: A U T O '_' U P D A T E '_' S T A T I S T I C S;
AVG: A V G;

// B
BEGIN: B E G I N;
BETWEEN: B E T W E E N;
BIGINT: B I G I N T;
BINARY: B I N A R Y;
BIT: B I T;
BOOLEAN: B O O L E A N;
BREAK: B R E A K;
BULK: B U L K;
BULK_LOGGED: B U L K '_' L O G G E D;
BY: B Y;

// C
CALLED: C A L L E D;
CALLER: C A L L E R;
CASCADE: C A S C A D E;
CASE: C A S E;
CAST: C A S T;
CATCH: C A T C H;
CHAR: C H A R;
CHARINDEX: C H A R I N D E X;
CHECK: C H E C K;
CLOSE: C L O S E;
CLUSTERED: C L U S T E R E D;
COLLATE: C O L L A T E;
COLUMN: C O L U M N;
COMMIT: C O M M I T;
CONCAT: C O N C A T;
CONSTRAINT: C O N S T R A I N T;
CONTINUE: C O N T I N U E;
CONVERT: C O N V E R T;
COUNT: C O U N T;
CREATE: C R E A T E;
CROSS: C R O S S;
CURRENT: C U R R E N T;
CURRENT_TIMESTAMP: C U R R E N T '_' T I M E S T A M P;

// D
DATA_COMPRESSION: D A T A '_' C O M P R E S S I O N;
DATABASE: D A T A B A S E;
DATE: D A T E;
DATEADD: D A T E A D D;
DATEDIFF: D A T E D I F F;
DATEPART: D A T E P A R T;
DATETIME: D A T E T I M E;
DAY: D A Y;
DEALLOCATE: D E A L L O C A T E;
DECIMAL: D E C I M A L;
DECLARE: D E C L A R E;
DEFAULT: D E F A U L T;
DELETE: D E L E T E;
DELETED: D E L E T E D;
DENSE_RANK: D E N S E '_' R A N K;
DENY: D E N Y;
DESC: D E S C;
DISABLE: D I S A B L E;
DISTINCT: D I S T I N C T;
DROP: D R O P;

// E
ELSE: E L S E;
ENABLE: E N A B L E;
ENCRYPTION: E N C R Y P T I O N;
END: E N D;
ENUM: E N U M;
ESCAPE: E S C A P E;
EXCEPT: E X C E P T;
EXEC: E X E C;
EXECUTE: E X E C U T E;
EXISTS: E X I S T S;
EXTERNAL: E X T E R N A L;

// F
FALSE: F A L S E;
FETCH: F E T C H;
FILE: F I L E;
FILEGROUP: F I L E G R O U P;
FILEGROWTH: F I L E G R O W T H;
FILENAME: F I L E N A M E;
FILLFACTOR: F I L L F A C T O R;
FIRST: F I R S T;
FIRST_VALUE: F I R S T '_' V A L U E;
FLOAT: F L O A T;
FOLLOWING: F O L L O W I N G;
FOR: F O R;
FOREIGN: F O R E I G N;
FROM: F R O M;
FULL: F U L L;
FUNCTION: F U N C T I O N;

// G
GB: G B;
GENERATED: G E N E R A T E D;
GETDATE: G E T D A T E;
GETUTCDATE: G E T U T C D A T E;
GO: G O;
GRANT: G R A N T;
GROUP: G R O U P;

// H
HAVING: H A V I N G;

// I
IDENTITY: I D E N T I T Y;
IF: I F;
IGNORE_DUP_KEY: I G N O R E '_' D U P '_' K E Y;
IMAGE: I M A G E;
IN: I N;
INDEX: I N D E X;
INNER: I N N E R;
INPUT: I N P U T;
INSERT: I N S E R T;
INSERTED: I N S E R T E D;
INT: I N T;
INTERSECT: I N T E R S E C T;
INTO: I N T O;
IS: I S;

// J
JOIN: J O I N;

// K
KB: K B;
KEY: K E Y;

// L
LAG: L A G;
LAST_VALUE: L A S T '_' V A L U E;
LEAD: L E A D;
LEFT: L E F T;
LEN: L E N;
LIKE: L I K E;
LOGIN: L O G I N;
LOWER: L O W E R;
LTRIM: L T R I M;

// M
MATCHED: M A T C H E D;
MAX: M A X;
MAXM: M A X;
MAXDOP: M A X D O P;
MAXSIZE: M A X S I Z E;
MB: M B;
MERGE: M E R G E;
MIN: M I N;
MODIFY: M O D I F Y;
MONEY: M O N E Y;
MONTH: M O N T H;
MULTI_USER: M U L T I '_' U S E R;

// N
NAME: N A M E;
NCHAR: N C H A R;
NEXT: N E X T;
NO: N O;
NOCHECK: N O C H E C K;
NONCLUSTERED: N O N C L U S T E R E D;
NONE: N O N E;
NOT: N O T;
NTEXT: N T E X T;
NTILE: N T I L E;
NULL: N U L L;
NUMERIC: N U M E R I C;
NVARCHAR: N V A R C H A R;

// O
OFF: O F F;
OFFLINE: O F F L I N E;
OFFSET: O F F S E T;
ON: O N;
ONLINE: O N L I N E;
ONLY: O N L Y;
OPEN: O P E N;
OPENQUERY: O P E N Q U E R Y;
OPENROWSET: O P E N R O W S E T;
OPTION: O P T I O N;
OR: O R;
ORDER: O R D E R;
OUTER: O U T E R;
OUTPUT: O U T P U T;
OVER: O V E R;
OWNER: O W N E R;

// P
PAD_INDEX: P A D '_' I N D E X;
PAGE: P A G E;
PARTITION: P A R T I T I O N;
PATINDEX: P A T I N D E X;
PERCENT: P E R C E N T;
PERMISSION: P E R M I S S I O N;
PERSISTED: P E R S I S T E D;
POINT: P O I N T;
PRECEDING: P R E C E D I N G;
PRIMARY: P R I M A R Y;
PRINT: P R I N T;
PROC: P R O C;
PROCEDURE: P R O C E D U R E;

// R
RAISERROR: R A I S E R R O R;
RANGE: R A N G E;
RANK: R A N K;
READ_ONLY: R E A D '_' O N L Y;
READ_WRITE: R E A D '_' W R I T E;
REAL: R E A L;
REBUILD: R E B U I L D;
RECOMPILE: R E C O M P I L E;
RECOVERY: R E C O V E R Y;
REFERENCES: R E F E R E N C E S;
REMOVE: R E M O V E;
RENAME: R E N A M E;
REORGANIZE: R E O R G A N I Z E;
REPLACE: R E P L A C E;
REPLICATION: R E P L I C A T I O N;
RESTRICT: R E S T R I C T;
RETURN: R E T U R N;
RETURNS: R E T U R N S;
REVOKE: R E V O K E;
RIGHT: R I G H T;
ROLE: R O L E;
ROLLBACK: R O L L B A C K;
ROW: R O W;
ROW_NUMBER: R O W '_' N U M B E R;
ROWGUIDCOL: R O W G U I D C O L;
ROWS: R O W S;
RTRIM: R T R I M;

// S
SAVE: S A V E;
SAVEPOINT: S A V E P O I N T;
SCHEMA: S C H E M A;
SCHEMABINDING: S C H E M A B I N D I N G;
SELECT: S E L E C T;
SELF: S E L F;
SET: S E T;
SIGNED: S I G N E D;
SIMPLE: S I M P L E;
SINGLE_USER: S I N G L E '_' U S E R;
SIZE: S I Z E;
SMALLINT: S M A L L I N T;
SMALLMONEY: S M A L L M O N E Y;
SOME: S O M E;
SORT_IN_TEMPDB: S O R T '_' I N '_' T E M P D B;
SPATIAL: S P A T I A L;
SQL_VARIANT: S Q L '_' V A R I A N T;
SRID: S R I D;
STATISTICS_NORECOMPUTE: S T A T I S T I C S '_' N O R E C O M P U T E;
STORED: S T O R E D;
SUBSTRING: S U B S T R I N G;
SUM: S U M;
SWITCH: S W I T C H;

// T
TABLE: T A B L E;
TEXT: T E X T;
THEN: T H E N;
THROW: T H R O W;
TIES: T I E S;
TIME: T I M E;
TIMESTAMP: T I M E S T A M P;
TINYINT: T I N Y I N T;
TO: T O;
TOP: T O P;
TRANSACTION: T R A N S A C T I O N;
TRIGGER: T R I G G E R;
TRUE: T R U E;
TRY: T R Y;
TRY_CAST: T R Y '_' C A S T;
TRY_CONVERT: T R Y '_' C O N V E R T;
TYPE: T Y P E;

// U
UNION: U N I O N;
UNIQUE: U N I Q U E;
UNIQUEIDENTIFIER: U N I Q U E I D E N T I F I E R;
UNLIMITED: U N L I M I T E D;
UNSIGNED: U N S I G N E D;
UPDATE: U P D A T E;
UPPER: U P P E R;
USE: U S E;
USER: U S E R;
USING: U S I N G;

// V
VALUES: V A L U E S;
VARBINARY: V A R B I N A R Y;
VARCHAR: V A R C H A R;
VIEW: V I E W;
VIEW_METADATA: V I E W '_' M E T A D A T A;
VIRTUAL: V I R T U A L;

// W
WHEN: W H E N;
WHERE: W H E R E;
WHILE: W H I L E;
WITH: W I T H;
WRITE: W R I T E;

// X
XML: X M L;

// Y
YEAR: Y E A R;

// =============================================
// SECTION 5: IDENTIFIERS AND VARIABLES
// =============================================

/**
 * SYSTEM VARIABLES (Priority: Highest)
 * 
 * System variables are global variables maintained by the SQL Server/Database.
 * Examples: @@VERSION, @@ERROR, @@ROWCOUNT, @@IDENTITY, @@server_name
 * 
 * Pattern: @@ followed by identifier characters
 * These must be recognized BEFORE regular variables to avoid conflicts
 */
SYSTEM_VARIABLE: '@@' [A-Za-z_][A-Za-z0-9_]*;

/**
 * USER VARIABLES (Priority: High)
 * 
 * User variables are session-specific variables that can be set by users.
 * Examples: @comment, @variable_name, @email, @user_id
 * 
 * Pattern: @ followed by identifier characters
 * These must be recognized BEFORE delimited identifiers starting with brackets
 */
USER_VARIABLE: '@' [A-Za-z_][A-Za-z0-9_]*;

/**
 * DELIMITED IDENTIFIERS - Square Brackets
 * 
 * Square bracket delimiters allow special characters in identifiers.
 * Commonly used in SQL Server.
 * Examples: [ColumnName], [User ID], [2024 Data], [Order #1]
 * 
 * Pattern: [ any characters except ] ] or ]]
 * This allows spaces, special characters, and even reserved keywords
 */
DELIMITED_IDENTIFIER_BRACKET: '[' (~[\]\r\n] | ']'']')* ']';

/**
 * DELIMITED IDENTIFIERS - Double Quotes
 * 
 * Double quote delimiters allow special characters in identifiers.
 * Compliant with ANSI SQL standard.
 * Examples: "ColumnName", "User ID", "2024 Data"
 * 
 * Pattern: " any characters except " or ""
 */
DELIMITED_IDENTIFIER_QUOTE: '"' (~["\r\n] | '""')* '"';

/**
 * DELIMITED IDENTIFIERS - Backticks
 * 
 * Backtick delimiters allow special characters in identifiers.
 * Commonly used in MySQL.
 * Examples: `table_name`, `column_name`, `user ID`
 * 
 * Pattern: ` any characters except ` or ``
 */
DELIMITED_IDENTIFIER_BACKTICK: '`' (~[`\r\n] | '``')* '`';

// =============================================
// SECTION 6: LITERALS
// =============================================

/**
 * NUMERIC LITERALS - Float/Decimal
 * 
 * Pattern: digits, dot, digits
 * Must come BEFORE INTEGER to match longer pattern first
 */
FLOATN: [0-9]+ '.' [0-9]+;

/**
 * NUMERIC LITERALS - Integer
 * 
 * Pattern: one or more digits
 */
INTEGER: [0-9]+;

/**
 * STRING LITERALS
 * 
 * Handles:
 * - Single-quoted strings with '' escaping (ANSI SQL standard)
 * - Optional N prefix for Unicode strings (NVARCHAR literals)
 * - Multi-line strings (implicitly supported)
 */
STRING: 'N'? '\'' (~'\'' | '\'\'')* '\'';

/**
 * REGULAR IDENTIFIERS (Priority: Lowest)
 * 
 * Standard identifiers without delimiters.
 * Alphanumeric characters and underscores only.
 * Cannot start with a digit (to avoid conflicts with numbers).
 * Examples: users, employee_name, table1, Column, ORDER_ID
 * 
 * Pattern:
 * - First character: letter or underscore
 * - Remaining characters: letters, digits, or underscores
 * 
 * This rule MUST come LAST to avoid matching partial identifiers
 * before system variables and user variables are recognized
 */
IDENTIFIER: [A-Za-z_][A-Za-z0-9_]*;

// =============================================
// FRAGMENTS
// =============================================
fragment A: [aA];
fragment B: [bB];
fragment C: [cC];
fragment D: [dD];
fragment E: [eE];
fragment F: [fF];
fragment G: [gG];
fragment H: [hH];
fragment I: [iI];
fragment J: [jJ];
fragment K: [kK];
fragment L: [lL];
fragment M: [mM];
fragment N: [nN];
fragment O: [oO];
fragment P: [pP];
fragment Q: [qQ];
fragment R: [rR];
fragment S: [sS];
fragment T: [tT];
fragment U: [uU];
fragment V: [vV];
fragment W: [wW];
fragment X: [xX];
fragment Y: [yY];
fragment Z: [zZ];