// Generated from com/sqlcompiler/parser/SQLParser.g4 by ANTLR 4.13.2
package com.sqlcompiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SQLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SQLParser#sqlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlStatement(SQLParser.SqlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#sqlStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlStatements(SQLParser.SqlStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(SQLParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#queryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryExpression(SQLParser.QueryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#querySpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuerySpecification(SQLParser.QuerySpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#topClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopClause(SQLParser.TopClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#distinctClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistinctClause(SQLParser.DistinctClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#selectList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectList(SQLParser.SelectListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#selectListElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectListElement(SQLParser.SelectListElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(SQLParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#tableSource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSource(SQLParser.TableSourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#tableSourceItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSourceItem(SQLParser.TableSourceItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#joinPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinPart(SQLParser.JoinPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#joinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinType(SQLParser.JoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#joinCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinCondition(SQLParser.JoinConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(SQLParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#searchCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchCondition(SQLParser.SearchConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(SQLParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByClause(SQLParser.GroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#groupByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByItem(SQLParser.GroupByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#havingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingClause(SQLParser.HavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(SQLParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#orderByExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByExpression(SQLParser.OrderByExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#offsetFetchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOffsetFetchClause(SQLParser.OffsetFetchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SQLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(SQLParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#subquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubquery(SQLParser.SubqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#caseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpression(SQLParser.CaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#whenClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenClause(SQLParser.WhenClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(SQLParser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#windowFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunction(SQLParser.WindowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#windowSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowSpecification(SQLParser.WindowSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#windowFrame}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrame(SQLParser.WindowFrameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#windowFrameBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameBound(SQLParser.WindowFrameBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#rankingFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRankingFunction(SQLParser.RankingFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#analyticFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnalyticFunction(SQLParser.AnalyticFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SQLParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#aggregateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunction(SQLParser.AggregateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#scalarFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarFunction(SQLParser.ScalarFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#stringFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFunction(SQLParser.StringFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#dateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateFunction(SQLParser.DateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#conversionFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConversionFunction(SQLParser.ConversionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#columnReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnReference(SQLParser.ColumnReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(SQLParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(SQLParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#columnAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnAlias(SQLParser.ColumnAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#tableAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableAlias(SQLParser.TableAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#schemaName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaName(SQLParser.SchemaNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(SQLParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(SQLParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#nonReservedKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonReservedKeyword(SQLParser.NonReservedKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(SQLParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SQLParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(SQLParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(SQLParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#setOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetOperator(SQLParser.SetOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#insertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStatement(SQLParser.InsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#updateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatement(SQLParser.UpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#deleteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStatement(SQLParser.DeleteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#deleteTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteTarget(SQLParser.DeleteTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#tableSources}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSources(SQLParser.TableSourcesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#joinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinClause(SQLParser.JoinClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#createStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateStatement(SQLParser.CreateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(SQLParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#declareStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareStatement(SQLParser.DeclareStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetStatement(SQLParser.SetStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SQLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(SQLParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SQLParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(SQLParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnConstraint(SQLParser.ColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(SQLParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(SQLParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#alterStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterStatement(SQLParser.AlterStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#dropStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropStatement(SQLParser.DropStatementContext ctx);
}