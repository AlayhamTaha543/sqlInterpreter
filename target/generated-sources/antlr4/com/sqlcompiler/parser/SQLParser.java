// Generated from com/sqlcompiler/parser/SQLParser.g4 by ANTLR 4.13.2
package com.sqlcompiler.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STAR=1, COMMA=2, EQ=3, LT=4, GT=5, LE=6, GE=7, NE=8, SELECT=9, FROM=10, 
		WHERE=11, HAVING=12, DISTINCT=13, TOP=14, GROUP=15, BY=16, ORDER=17, OFFSET=18, 
		FETCH=19, NEXT=20, FIRST=21, ONLY=22, INSERT=23, INTO=24, UPDATE=25, DELETE=26, 
		VALUES=27, MERGE=28, MATCHED=29, OUTPUT=30, CREATE=31, ALTER=32, DROP=33, 
		TABLE=34, VIEW=35, PROCEDURE=36, FUNCTION=37, INDEX=38, SCHEMA=39, DATABASE=40, 
		TRIGGER=41, INT=42, BIGINT=43, SMALLINT=44, TINYINT=45, VARCHAR=46, NVARCHAR=47, 
		CHAR=48, NCHAR=49, TEXT=50, NTEXT=51, DATETIME=52, DATE=53, TIME=54, TIMESTAMP=55, 
		BIT=56, DECIMAL=57, NUMERIC=58, FLOAT=59, REAL=60, MONEY=61, SMALLMONEY=62, 
		BINARY=63, VARBINARY=64, IMAGE=65, UNIQUEIDENTIFIER=66, XML=67, SQL_VARIANT=68, 
		PRIMARY=69, KEY=70, FOREIGN=71, REFERENCES=72, UNIQUE=73, CHECK=74, DEFAULT=75, 
		CONSTRAINT=76, IDENTITY=77, CLUSTERED=78, NONCLUSTERED=79, JOIN=80, INNER=81, 
		OUTER=82, LEFT=83, RIGHT=84, FULL=85, CROSS=86, ON=87, USING=88, UNION=89, 
		EXCEPT=90, INTERSECT=91, ALL=92, AND=93, OR=94, NOT=95, LIKE=96, IN=97, 
		BETWEEN=98, EXISTS=99, IS=100, NULL=101, ANY=102, SOME=103, COUNT=104, 
		SUM=105, AVG=106, MIN=107, MAX=108, LEN=109, SUBSTRING=110, LTRIM=111, 
		RTRIM=112, UPPER=113, LOWER=114, REPLACE=115, CONCAT=116, CHARINDEX=117, 
		PATINDEX=118, GETDATE=119, GETUTCDATE=120, DATEADD=121, DATEDIFF=122, 
		DATEPART=123, YEAR=124, MONTH=125, DAY=126, CAST=127, CONVERT=128, TRY_CAST=129, 
		TRY_CONVERT=130, OVER=131, PARTITION=132, ROWS=133, RANGE=134, PRECEDING=135, 
		FOLLOWING=136, CURRENT=137, ROW=138, LAG=139, LEAD=140, FIRST_VALUE=141, 
		LAST_VALUE=142, DECLARE=143, SET=144, BEGIN=145, END=146, IF=147, ELSE=148, 
		WHILE=149, BREAK=150, CONTINUE=151, CASE=152, WHEN=153, THEN=154, RETURN=155, 
		TRANSACTION=156, COMMIT=157, ROLLBACK=158, SAVEPOINT=159, SAVE=160, TRY=161, 
		CATCH=162, THROW=163, EXEC=164, EXECUTE=165, OPEN=166, CLOSE=167, DEALLOCATE=168, 
		PRINT=169, RAISERROR=170, USE=171, GO=172, AS=173, WITH=174, OPTION=175, 
		RECOMPILE=176, GRANT=177, REVOKE=178, DENY=179, LOGIN=180, USER=181, ROLE=182, 
		PERMISSION=183, ASC=184, DESC=185, TRUE=186, FALSE=187, SYSTEM_VARIABLE=188, 
		USER_VARIABLE=189, DELIMITED_IDENTIFIER_BRACKET=190, DELIMITED_IDENTIFIER_QUOTE=191, 
		DELIMITED_IDENTIFIER_BACKTICK=192, IDENTIFIER=193, INTEGER=194, FLOATN=195, 
		STRING_START_SINGLE=196, STRING_START_DOUBLE=197, STRING_END_SINGLE=198, 
		STRING_SINGLE_ESCAPED_QUOTE=199, STRING_SINGLE_BACKSLASH_ESCAPE=200, STRING_SINGLE_LINE_CONTINUATION=201, 
		STRING_SINGLE_NEWLINE=202, STRING_SINGLE_CHAR=203, STRING_SINGLE_ANY=204, 
		STRING_END_DOUBLE=205, STRING_DOUBLE_ESCAPED_QUOTE=206, STRING_DOUBLE_BACKSLASH_ESCAPE=207, 
		STRING_DOUBLE_LINE_CONTINUATION=208, STRING_DOUBLE_NEWLINE=209, STRING_DOUBLE_CHAR=210, 
		STRING_DOUBLE_ANY=211, STRING=212;
	public static final int
		RULE_sqlStatement = 0, RULE_selectStatement = 1, RULE_selectList = 2, 
		RULE_tableName = 3, RULE_columnName = 4, RULE_whereClause = 5, RULE_condition = 6, 
		RULE_comparisonOperator = 7, RULE_literal = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"sqlStatement", "selectStatement", "selectList", "tableName", "columnName", 
			"whereClause", "condition", "comparisonOperator", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "','", "'='", "'<'", "'>'", "'<='", "'>='", "'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "STAR", "COMMA", "EQ", "LT", "GT", "LE", "GE", "NE", "SELECT", 
			"FROM", "WHERE", "HAVING", "DISTINCT", "TOP", "GROUP", "BY", "ORDER", 
			"OFFSET", "FETCH", "NEXT", "FIRST", "ONLY", "INSERT", "INTO", "UPDATE", 
			"DELETE", "VALUES", "MERGE", "MATCHED", "OUTPUT", "CREATE", "ALTER", 
			"DROP", "TABLE", "VIEW", "PROCEDURE", "FUNCTION", "INDEX", "SCHEMA", 
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
			"INTEGER", "FLOATN", "STRING_START_SINGLE", "STRING_START_DOUBLE", "STRING_END_SINGLE", 
			"STRING_SINGLE_ESCAPED_QUOTE", "STRING_SINGLE_BACKSLASH_ESCAPE", "STRING_SINGLE_LINE_CONTINUATION", 
			"STRING_SINGLE_NEWLINE", "STRING_SINGLE_CHAR", "STRING_SINGLE_ANY", "STRING_END_DOUBLE", 
			"STRING_DOUBLE_ESCAPED_QUOTE", "STRING_DOUBLE_BACKSLASH_ESCAPE", "STRING_DOUBLE_LINE_CONTINUATION", 
			"STRING_DOUBLE_NEWLINE", "STRING_DOUBLE_CHAR", "STRING_DOUBLE_ANY", "STRING"
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
	public String getGrammarFileName() { return "SQLParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SqlStatementContext extends ParserRuleContext {
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SQLParser.EOF, 0); }
		public SqlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSqlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSqlStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLParserVisitor ) return ((SQLParserVisitor<? extends T>)visitor).visitSqlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlStatementContext sqlStatement() throws RecognitionException {
		SqlStatementContext _localctx = new SqlStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sqlStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			selectStatement();
			setState(19);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectStatementContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(SQLParser.SELECT, 0); }
		public SelectListContext selectList() {
			return getRuleContext(SelectListContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSelectStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLParserVisitor ) return ((SQLParserVisitor<? extends T>)visitor).visitSelectStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(SELECT);
			setState(22);
			selectList();
			setState(23);
			match(FROM);
			setState(24);
			tableName();
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(25);
				whereClause();
				}
			}

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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectListContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(SQLParser.STAR, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public SelectListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSelectList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSelectList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLParserVisitor ) return ((SQLParserVisitor<? extends T>)visitor).visitSelectList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectListContext selectList() throws RecognitionException {
		SelectListContext _localctx = new SelectListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_selectList);
		int _la;
		try {
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				match(STAR);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				columnName();
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(30);
					match(COMMA);
					setState(31);
					columnName();
					}
					}
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLParser.IDENTIFIER, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLParserVisitor ) return ((SQLParserVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLParser.IDENTIFIER, 0); }
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitColumnName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLParserVisitor ) return ((SQLParserVisitor<? extends T>)visitor).visitColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLParserVisitor ) return ((SQLParserVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(WHERE);
			setState(44);
			condition();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLParser.IDENTIFIER, 0); }
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLParserVisitor ) return ((SQLParserVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(IDENTIFIER);
			setState(47);
			comparisonOperator();
			setState(48);
			literal();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SQLParser.EQ, 0); }
		public TerminalNode LT() { return getToken(SQLParser.LT, 0); }
		public TerminalNode GT() { return getToken(SQLParser.GT, 0); }
		public TerminalNode LE() { return getToken(SQLParser.LE, 0); }
		public TerminalNode GE() { return getToken(SQLParser.GE, 0); }
		public TerminalNode NE() { return getToken(SQLParser.NE, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLParserVisitor ) return ((SQLParserVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 504L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SQLParser.STRING, 0); }
		public TerminalNode FLOATN() { return getToken(SQLParser.FLOATN, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLParserVisitor ) return ((SQLParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !(_la==FLOATN || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		"\u0004\u0001\u00d47\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001b\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002!\b\u0002\n\u0002\f\u0002"+
		"$\t\u0002\u0003\u0002&\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0000"+
		"\u0000\t\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000\u0002\u0001\u0000"+
		"\u0003\b\u0002\u0000\u00c3\u00c3\u00d4\u00d40\u0000\u0012\u0001\u0000"+
		"\u0000\u0000\u0002\u0015\u0001\u0000\u0000\u0000\u0004%\u0001\u0000\u0000"+
		"\u0000\u0006\'\u0001\u0000\u0000\u0000\b)\u0001\u0000\u0000\u0000\n+\u0001"+
		"\u0000\u0000\u0000\f.\u0001\u0000\u0000\u0000\u000e2\u0001\u0000\u0000"+
		"\u0000\u00104\u0001\u0000\u0000\u0000\u0012\u0013\u0003\u0002\u0001\u0000"+
		"\u0013\u0014\u0005\u0000\u0000\u0001\u0014\u0001\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0005\t\u0000\u0000\u0016\u0017\u0003\u0004\u0002\u0000\u0017"+
		"\u0018\u0005\n\u0000\u0000\u0018\u001a\u0003\u0006\u0003\u0000\u0019\u001b"+
		"\u0003\n\u0005\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001a\u001b\u0001"+
		"\u0000\u0000\u0000\u001b\u0003\u0001\u0000\u0000\u0000\u001c&\u0005\u0001"+
		"\u0000\u0000\u001d\"\u0003\b\u0004\u0000\u001e\u001f\u0005\u0002\u0000"+
		"\u0000\u001f!\u0003\b\u0004\u0000 \u001e\u0001\u0000\u0000\u0000!$\u0001"+
		"\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000"+
		"#&\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%\u001c\u0001\u0000"+
		"\u0000\u0000%\u001d\u0001\u0000\u0000\u0000&\u0005\u0001\u0000\u0000\u0000"+
		"\'(\u0005\u00c1\u0000\u0000(\u0007\u0001\u0000\u0000\u0000)*\u0005\u00c1"+
		"\u0000\u0000*\t\u0001\u0000\u0000\u0000+,\u0005\u000b\u0000\u0000,-\u0003"+
		"\f\u0006\u0000-\u000b\u0001\u0000\u0000\u0000./\u0005\u00c1\u0000\u0000"+
		"/0\u0003\u000e\u0007\u000001\u0003\u0010\b\u00001\r\u0001\u0000\u0000"+
		"\u000023\u0007\u0000\u0000\u00003\u000f\u0001\u0000\u0000\u000045\u0007"+
		"\u0001\u0000\u00005\u0011\u0001\u0000\u0000\u0000\u0003\u001a\"%";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}