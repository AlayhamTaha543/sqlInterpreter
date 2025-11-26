// Define a grammar called SqlLexer
lexer grammar SQLLexer;

// =============================================
// SQL KEYWORDS - RESERVED WORDS its worked by yara
// =============================================

SELECT: S E L E C T;      // Used to select data from database
FROM: F R O M;            // Specifies the table to select from
WHERE: W H E R E;         // Filters records based on conditions
HAVING: H A V I N G;      // Filters groups after GROUP BY
DISTINCT: D I S T I N C T; // Returns unique values only
TOP: T O P;               // Limits the number of rows returned
GROUP: G R O U P;         // Groups rows that have the same values
BY: B Y;                  // Used with GROUP BY, ORDER BY
ORDER: O R D E R;         // Sorts the result set
OFFSET: O F F S E T;      // Skips specified number of rows
FETCH: F E T C H;         // Fetches specified number of rows
NEXT: N E X T;            // Used with FETCH
FIRST: F I R S T;         // Used with FETCH
ONLY: O N L Y;            // Used with FETCH

// -------------------------
// DATA MANIPULATION LANGUAGE 
// -------------------------
INSERT: I N S E R T;      // Inserts new data into a table
INTO: I N T O;            // Specifies table for INSERT
UPDATE: U P D A T E;      // Modifies existing data
DELETE: D E L E T E;      // Removes data from table
VALUES: V A L U E S;      // Specifies values for INSERT
MERGE: M E R G E;         // Performs INSERT, UPDATE, DELETE in one statement
MATCHED: M A T C H E D;   // Used with MERGE for matched conditions
OUTPUT: O U T P U T;      // Returns information from DML operations

// -------------------------
// DATA DEFINITION LANGUAGE 
// -------------------------
CREATE: C R E A T E;      // Creates database objects
ALTER: A L T E R;         // Modifies database objects
DROP: D R O P;            // Deletes database objects
TABLE: T A B L E;         // Creates/modifies tables
VIEW: V I E W;            // Creates/modifies views
PROCEDURE: P R O C E D U R E; // Creates stored procedures
FUNCTION: F U N C T I O N;   // Creates user-defined functions
INDEX: I N D E X;         // Creates indexes on tables
SCHEMA: S C H E M A;      // Creates database schema
DATABASE: D A T A B A S E; // Creates database
TRIGGER: T R I G G E R;   // Creates triggers

// -------------------------
// DATA TYPES
// -------------------------
INT: I N T;               // Integer data type
BIGINT: B I G I N T;      // Large integer data type
SMALLINT: S M A L L I N T; // Small integer data type
TINYINT: T I N Y I N T;   // Very small integer data type
VARCHAR: V A R C H A R;   // Variable-length character data
NVARCHAR: N V A R C H A R; // Unicode variable-length character data
CHAR: C H A R;            // Fixed-length character data
NCHAR: N C H A R;         // Unicode fixed-length character data
TEXT: T E X T;            // Large text data
NTEXT: N T E X T;         // Large Unicode text data
DATETIME: D A T E T I M E; // Date and time data
DATE: D A T E;            // Date data only
TIME: T I M E;            // Time data only
TIMESTAMP: T I M E S T A M P; // Timestamp data
BIT: B I T;               // Boolean data type (0/1)
DECIMAL: D E C I M A L;   // Exact numeric data type
NUMERIC: N U M E R I C;   // Exact numeric data type
FLOAT: F L O A T;         // Approximate numeric data type
REAL: R E A L;            // Floating point number
MONEY: M O N E Y;         // Monetary data type
SMALLMONEY: S M A L L M O N E Y; // Small monetary data type
BINARY: B I N A R Y;      // Binary data
VARBINARY: V A R B I N A R Y; // Variable-length binary data
IMAGE: I M A G E;         // Image data type
UNIQUEIDENTIFIER: U N I Q U E I D E N T I F I E R; // GUID data type
XML: X M L;               // XML data type
SQL_VARIANT: S Q L '_' V A R I A N T; // Can store any data type

// -------------------------
// TABLE CONSTRAINTS
// -------------------------
PRIMARY: P R I M A R Y;   // Primary key constraint
KEY: K E Y;               // Used with PRIMARY, FOREIGN
FOREIGN: F O R E I G N;   // Foreign key constraint
REFERENCES: R E F E R E N C E S; // References another table
UNIQUE: U N I Q U E;      // Ensures all values are unique
CHECK: C H E C K;         // Limits value range in column
DEFAULT: D E F A U L T;   // Sets default value for column
CONSTRAINT: C O N S T R A I N T; // Defines constraints
IDENTITY: I D E N T I T Y; // Auto-incrementing column
CLUSTERED: C L U S T E R E D; // Clustered index
NONCLUSTERED: N O N C L U S T E R E D; // Non-clustered index

// -------------------------
// JOIN OPERATIONS
// -------------------------
JOIN: J O I N;            // Joins two tables
INNER: I N N E R;         // Inner join (default)
OUTER: O U T E R;         // Outer join
LEFT: L E F T;            // Left join
RIGHT: R I G H T;         // Right join
FULL: F U L L;            // Full outer join
CROSS: C R O S S;         // Cross join
ON: O N;                  // Specifies join condition
USING: U S I N G;         // Specifies columns for natural join

// -------------------------
// SET OPERATIONS
// -------------------------
UNION: U N I O N;         // Combines result sets
EXCEPT: E X C E P T;      // Returns distinct rows from first query not in second
INTERSECT: I N T E R S E C T; // Returns distinct rows common to both queries
ALL: A L L;               // Includes duplicates in set operations

// -------------------------
// LOGICAL OPERATORS
// -------------------------
AND: A N D;               // Logical AND
OR: O R;                  // Logical OR
NOT: N O T;               // Logical NOT
LIKE: L I K E;            // Pattern matching operator
IN: I N;                  // Checks if value is in list
BETWEEN: B E T W E E N;   // Checks if value is within range
EXISTS: E X I S T S;      // Checks if subquery returns any rows
IS: I S;                  // Used with NULL for null checks
NULL: N U L L;            // Represents missing/unknown value
ANY: A N Y;               // Compares value to any value in list
SOME: S O M E;            // Synonym for ANY

// -------------------------
// AGGREGATE FUNCTIONS
// -------------------------
COUNT: C O U N T;         // Counts number of rows
SUM: S U M;               // Sums numeric values
AVG: A V G;               // Calculates average
MIN: M I N;               // Finds minimum value
MAX: M A X;               // Finds maximum value

// -------------------------
// STRING FUNCTIONS
// -------------------------
LEN: L E N;               // Returns length of string
SUBSTRING: S U B S T R I N G; // Extracts substring from string
// Reuse `LEFT` and `RIGHT` from JOIN OPERATIONS above; no duplicate definitions here
LTRIM: L T R I M;         // Removes leading spaces
RTRIM: R T R I M;         // Removes trailing spaces
UPPER: U P P E R;         // Converts to uppercase
LOWER: L O W E R;         // Converts to lowercase
REPLACE: R E P L A C E;   // Replaces occurrences of substring
CONCAT: C O N C A T;      // Concatenates strings
CHARINDEX: C H A R I N D E X; // Finds substring position
PATINDEX: P A T I N D E X; // Finds pattern position

// -------------------------
// DATE FUNCTIONS
// -------------------------
GETDATE: G E T D A T E;   // Returns current date and time
GETUTCDATE: G E T U T C D A T E; // Returns current UTC date and time
DATEADD: D A T E A D D;   // Adds interval to date
DATEDIFF: D A T E D I F F; // Difference between two dates
DATEPART: D A T E P A R T; // Returns specific part of date
YEAR: Y E A R;            // Returns year of date
MONTH: M O N T H;          // Returns month of date
DAY: D A Y;               // Returns day of date

// -------------------------
// CONVERSION FUNCTIONS
// -------------------------
CAST: C A S T;            // Converts one data type to another
CONVERT: C O N V E R T;   // Converts one data type to another (SQL Server)
TRY_CAST: T R Y '_' C A S T; // Safe cast that returns NULL on failure
TRY_CONVERT: T R Y '_' C O N V E R T; // Safe convert that returns NULL on failure

// -------------------------
// WINDOW FUNCTIONS
// -------------------------
OVER: O V E R;            // Defines window for window functions
PARTITION: P A R T I T I O N; // Partitions window
ROWS: R O W S;            // Defines window frame in rows
RANGE: R A N G E;         // Defines window frame in range
PRECEDING: P R E C E D I N G; // Preceding rows in window
FOLLOWING: F O L L O W I N G; // Following rows in window
CURRENT: C U R R E N T;   // Current row in window
ROW: R O W;               // Single row
LAG: L A G;               // Accesses previous row
LEAD: L E A D;            // Accesses next row
FIRST_VALUE: F I R S T '_' V A L U E; // First value in window
LAST_VALUE: L A S T '_' V A L U E; // Last value in window

// -------------------------
// PROGRAMMING CONSTRUCTS
// -------------------------
DECLARE: D E C L A R E;   // Declares variables
SET: S E T;               // Sets variable values
BEGIN: B E G I N;         // Begins a block of statements
END: E N D;               // Ends a block of statements
IF: I F;                  // Conditional statement
ELSE: E L S E;            // Alternative condition
WHILE: W H I L E;         // Loop construct
BREAK: B R E A K;         // Exits loop
CONTINUE: C O N T I N U E; // Continues to next iteration
CASE: C A S E;            // Case statement for conditional logic
WHEN: W H E N;            // Used with CASE
THEN: T H E N;            // Used with CASE
RETURN: R E T U R N;      // Returns from procedure/function

// -------------------------
// TRANSACTION CONTROL
// -------------------------
TRANSACTION: T R A N S A C T I O N; // Database transaction
COMMIT: C O M M I T;      // Saves transaction changes
ROLLBACK: R O L L B A C K; // Undoes transaction changes
SAVEPOINT: S A V E P O I N T; // Creates savepoint in transaction
SAVE: S A V E;            // Used with SAVEPOINT
TRY: T R Y;               // Begins try block for error handling
CATCH: C A T C H;         // Catches exceptions in try block
THROW: T H R O W;         // Throws exception

// -------------------------
// STORED PROCEDURE EXECUTION
// -------------------------
EXEC: E X E C;            // Executes stored procedure
EXECUTE: E X E C U T E;   // Executes stored procedure (full form)
OPEN: O P E N;            // Opens cursor
CLOSE: C L O S E;         // Closes cursor
DEALLOCATE: D E A L L O C A T E; // Deallocates cursor

// -------------------------
// OUTPUT AND DEBUGGING
// -------------------------
PRINT: P R I N T;         // Prints message
RAISERROR: R A I S E R R O R; // Raises error message

// -------------------------
// DATABASE OPERATIONS
// -------------------------
USE: U S E;               // Selects database to use
GO: G O;                  // Batch separator in SQL Server
AS: A S;                  // Creates alias for column or table
WITH: W I T H;            // Common Table Expression (CTE)
OPTION: O P T I O N;      // Specifies query hints
RECOMPILE: R E C O M P I L E; // Forces recompilation

// -------------------------
// SECURITY AND PERMISSIONS
// -------------------------
GRANT: G R A N T;         // Grants permissions
REVOKE: R E V O K E;      // Revokes permissions
DENY: D E N Y;            // Denies permissions
LOGIN: L O G I N;         // Database login
USER: U S E R;            // Database user
ROLE: R O L E;            // Database role
PERMISSION: P E R M I S S I O N; // Permission

// -------------------------
//  SORTING DIRECTIONS
// -------------------------
ASC: A S C;               // Ascending sort order
DESC: D E S C;            // Descending sort order

// -------------------------
//  BOOLEAN VALUES
// -------------------------

TRUE: T R U E;            // Boolean true value
FALSE: F A L S E;         // Boolean false value

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

// ============================================= 
