// Generated from /home/alayham/Documents/sql/sqlInterpreter/src/main/antlr4/com/sqlcompiler/parser/DeprecatedSQLPraser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DeprecatedSQLPraserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

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
	public static final int
		RULE_deprecated = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"deprecated"
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

	@Override
	public String getGrammarFileName() { return "DeprecatedSQLPraser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DeprecatedSQLPraserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeprecatedContext extends ParserRuleContext {
		public DeprecatedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deprecated; }
	}

	public final DeprecatedContext deprecated() throws RecognitionException {
		DeprecatedContext _localctx = new DeprecatedContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_deprecated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u00bc\u0005\u0002\u0000\u0007\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0003\u0000\u0002\u0001"+
		"\u0000\u0000\u0000\u0002\u0003\u0001\u0000\u0000\u0000\u0003\u0001\u0001"+
		"\u0000\u0000\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}