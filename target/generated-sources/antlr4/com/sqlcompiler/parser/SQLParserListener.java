// Generated from com/sqlcompiler/parser/SQLParser.g4 by ANTLR 4.13.2
package com.sqlcompiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLParser}.
 */
public interface SQLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlStatement(SQLParser.SqlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlStatement(SQLParser.SqlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#sqlStatements}.
	 * @param ctx the parse tree
	 */
	void enterSqlStatements(SQLParser.SqlStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#sqlStatements}.
	 * @param ctx the parse tree
	 */
	void exitSqlStatements(SQLParser.SqlStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(SQLParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(SQLParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#queryExpression}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpression(SQLParser.QueryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#queryExpression}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpression(SQLParser.QueryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecification(SQLParser.QuerySpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecification(SQLParser.QuerySpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#topClause}.
	 * @param ctx the parse tree
	 */
	void enterTopClause(SQLParser.TopClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#topClause}.
	 * @param ctx the parse tree
	 */
	void exitTopClause(SQLParser.TopClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#distinctClause}.
	 * @param ctx the parse tree
	 */
	void enterDistinctClause(SQLParser.DistinctClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#distinctClause}.
	 * @param ctx the parse tree
	 */
	void exitDistinctClause(SQLParser.DistinctClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#selectList}.
	 * @param ctx the parse tree
	 */
	void enterSelectList(SQLParser.SelectListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#selectList}.
	 * @param ctx the parse tree
	 */
	void exitSelectList(SQLParser.SelectListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#selectListElement}.
	 * @param ctx the parse tree
	 */
	void enterSelectListElement(SQLParser.SelectListElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#selectListElement}.
	 * @param ctx the parse tree
	 */
	void exitSelectListElement(SQLParser.SelectListElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(SQLParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(SQLParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableSource}.
	 * @param ctx the parse tree
	 */
	void enterTableSource(SQLParser.TableSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableSource}.
	 * @param ctx the parse tree
	 */
	void exitTableSource(SQLParser.TableSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void enterTableSourceItem(SQLParser.TableSourceItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void exitTableSourceItem(SQLParser.TableSourceItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void enterJoinPart(SQLParser.JoinPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void exitJoinPart(SQLParser.JoinPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#joinType}.
	 * @param ctx the parse tree
	 */
	void enterJoinType(SQLParser.JoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#joinType}.
	 * @param ctx the parse tree
	 */
	void exitJoinType(SQLParser.JoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#joinCondition}.
	 * @param ctx the parse tree
	 */
	void enterJoinCondition(SQLParser.JoinConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#joinCondition}.
	 * @param ctx the parse tree
	 */
	void exitJoinCondition(SQLParser.JoinConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(SQLParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(SQLParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#searchCondition}.
	 * @param ctx the parse tree
	 */
	void enterSearchCondition(SQLParser.SearchConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#searchCondition}.
	 * @param ctx the parse tree
	 */
	void exitSearchCondition(SQLParser.SearchConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(SQLParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(SQLParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(SQLParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(SQLParser.GroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#groupByItem}.
	 * @param ctx the parse tree
	 */
	void enterGroupByItem(SQLParser.GroupByItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#groupByItem}.
	 * @param ctx the parse tree
	 */
	void exitGroupByItem(SQLParser.GroupByItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(SQLParser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(SQLParser.HavingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(SQLParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(SQLParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#orderByExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrderByExpression(SQLParser.OrderByExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#orderByExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrderByExpression(SQLParser.OrderByExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#offsetFetchClause}.
	 * @param ctx the parse tree
	 */
	void enterOffsetFetchClause(SQLParser.OffsetFetchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#offsetFetchClause}.
	 * @param ctx the parse tree
	 */
	void exitOffsetFetchClause(SQLParser.OffsetFetchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SQLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SQLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(SQLParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(SQLParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(SQLParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(SQLParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#caseExpression}.
	 * @param ctx the parse tree
	 */
	void enterCaseExpression(SQLParser.CaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#caseExpression}.
	 * @param ctx the parse tree
	 */
	void exitCaseExpression(SQLParser.CaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#whenClause}.
	 * @param ctx the parse tree
	 */
	void enterWhenClause(SQLParser.WhenClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#whenClause}.
	 * @param ctx the parse tree
	 */
	void exitWhenClause(SQLParser.WhenClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(SQLParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(SQLParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#windowFunction}.
	 * @param ctx the parse tree
	 */
	void enterWindowFunction(SQLParser.WindowFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#windowFunction}.
	 * @param ctx the parse tree
	 */
	void exitWindowFunction(SQLParser.WindowFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#windowSpecification}.
	 * @param ctx the parse tree
	 */
	void enterWindowSpecification(SQLParser.WindowSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#windowSpecification}.
	 * @param ctx the parse tree
	 */
	void exitWindowSpecification(SQLParser.WindowSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#windowFrame}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrame(SQLParser.WindowFrameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#windowFrame}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrame(SQLParser.WindowFrameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#windowFrameBound}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameBound(SQLParser.WindowFrameBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#windowFrameBound}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameBound(SQLParser.WindowFrameBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#rankingFunction}.
	 * @param ctx the parse tree
	 */
	void enterRankingFunction(SQLParser.RankingFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#rankingFunction}.
	 * @param ctx the parse tree
	 */
	void exitRankingFunction(SQLParser.RankingFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#analyticFunction}.
	 * @param ctx the parse tree
	 */
	void enterAnalyticFunction(SQLParser.AnalyticFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#analyticFunction}.
	 * @param ctx the parse tree
	 */
	void exitAnalyticFunction(SQLParser.AnalyticFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SQLParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SQLParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void enterAggregateFunction(SQLParser.AggregateFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void exitAggregateFunction(SQLParser.AggregateFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#scalarFunction}.
	 * @param ctx the parse tree
	 */
	void enterScalarFunction(SQLParser.ScalarFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#scalarFunction}.
	 * @param ctx the parse tree
	 */
	void exitScalarFunction(SQLParser.ScalarFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#stringFunction}.
	 * @param ctx the parse tree
	 */
	void enterStringFunction(SQLParser.StringFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#stringFunction}.
	 * @param ctx the parse tree
	 */
	void exitStringFunction(SQLParser.StringFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#dateFunction}.
	 * @param ctx the parse tree
	 */
	void enterDateFunction(SQLParser.DateFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#dateFunction}.
	 * @param ctx the parse tree
	 */
	void exitDateFunction(SQLParser.DateFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#conversionFunction}.
	 * @param ctx the parse tree
	 */
	void enterConversionFunction(SQLParser.ConversionFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#conversionFunction}.
	 * @param ctx the parse tree
	 */
	void exitConversionFunction(SQLParser.ConversionFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#columnReference}.
	 * @param ctx the parse tree
	 */
	void enterColumnReference(SQLParser.ColumnReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#columnReference}.
	 * @param ctx the parse tree
	 */
	void exitColumnReference(SQLParser.ColumnReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(SQLParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(SQLParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(SQLParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(SQLParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#columnAlias}.
	 * @param ctx the parse tree
	 */
	void enterColumnAlias(SQLParser.ColumnAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#columnAlias}.
	 * @param ctx the parse tree
	 */
	void exitColumnAlias(SQLParser.ColumnAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void enterTableAlias(SQLParser.TableAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void exitTableAlias(SQLParser.TableAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#schemaName}.
	 * @param ctx the parse tree
	 */
	void enterSchemaName(SQLParser.SchemaNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#schemaName}.
	 * @param ctx the parse tree
	 */
	void exitSchemaName(SQLParser.SchemaNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(SQLParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(SQLParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(SQLParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(SQLParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#nonReservedKeyword}.
	 * @param ctx the parse tree
	 */
	void enterNonReservedKeyword(SQLParser.NonReservedKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#nonReservedKeyword}.
	 * @param ctx the parse tree
	 */
	void exitNonReservedKeyword(SQLParser.NonReservedKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(SQLParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(SQLParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SQLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SQLParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(SQLParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(SQLParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(SQLParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(SQLParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#setOperator}.
	 * @param ctx the parse tree
	 */
	void enterSetOperator(SQLParser.SetOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#setOperator}.
	 * @param ctx the parse tree
	 */
	void exitSetOperator(SQLParser.SetOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void enterInsertStatement(SQLParser.InsertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void exitInsertStatement(SQLParser.InsertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStatement(SQLParser.UpdateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStatement(SQLParser.UpdateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeleteStatement(SQLParser.DeleteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeleteStatement(SQLParser.DeleteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#createStatement}.
	 * @param ctx the parse tree
	 */
	void enterCreateStatement(SQLParser.CreateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#createStatement}.
	 * @param ctx the parse tree
	 */
	void exitCreateStatement(SQLParser.CreateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(SQLParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(SQLParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#declareStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStatement(SQLParser.DeclareStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#declareStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStatement(SQLParser.DeclareStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void enterSetStatement(SQLParser.SetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void exitSetStatement(SQLParser.SetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SQLParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SQLParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(SQLParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(SQLParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SQLParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SQLParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void enterColumnDefinition(SQLParser.ColumnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void exitColumnDefinition(SQLParser.ColumnDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#columnConstraint}.
	 * @param ctx the parse tree
	 */
	void enterColumnConstraint(SQLParser.ColumnConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#columnConstraint}.
	 * @param ctx the parse tree
	 */
	void exitColumnConstraint(SQLParser.ColumnConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(SQLParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(SQLParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(SQLParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(SQLParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#alterStatement}.
	 * @param ctx the parse tree
	 */
	void enterAlterStatement(SQLParser.AlterStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#alterStatement}.
	 * @param ctx the parse tree
	 */
	void exitAlterStatement(SQLParser.AlterStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#dropStatement}.
	 * @param ctx the parse tree
	 */
	void enterDropStatement(SQLParser.DropStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#dropStatement}.
	 * @param ctx the parse tree
	 */
	void exitDropStatement(SQLParser.DropStatementContext ctx);
}