package com.sqlcompiler.parser.ast;

import com.sqlcompiler.parser.ast.clauses.FromClauseNode;
import com.sqlcompiler.parser.ast.clauses.GroupByClauseNode;
import com.sqlcompiler.parser.ast.clauses.HavingClauseNode;
import com.sqlcompiler.parser.ast.clauses.JoinClauseNode;
import com.sqlcompiler.parser.ast.clauses.OrderByClauseNode;
import com.sqlcompiler.parser.ast.clauses.SelectClauseNode;
import com.sqlcompiler.parser.ast.clauses.WhereClauseNode;
import com.sqlcompiler.parser.ast.expressions.AggregateFunctionNode;
import com.sqlcompiler.parser.ast.expressions.BinaryExpressionNode;
import com.sqlcompiler.parser.ast.expressions.CaseexpressionNode;
import com.sqlcompiler.parser.ast.expressions.ColumnNode;
import com.sqlcompiler.parser.ast.expressions.FunctionCallNode;
import com.sqlcompiler.parser.ast.expressions.LiteralNode;
import com.sqlcompiler.parser.ast.expressions.SubqueryNode;
import com.sqlcompiler.parser.ast.expressions.TableNode;
import com.sqlcompiler.parser.ast.statements.AlterStatementNode;
import com.sqlcompiler.parser.ast.statements.ProgramNode;
import com.sqlcompiler.parser.ast.statements.SelectStatementNode;
import com.sqlcompiler.parser.ast.statements.UpdateStatementNode;


public interface ASTVisitor<T> {
    T visit(ProgramNode node);
    // Statements
    T visit(SelectStatementNode node);
    // T visit(InsertStatementNode node);
    T visit(UpdateStatementNode node);
    T visit(AlterStatementNode node);
    // T visit(DeleteStatementNode node);
    // Clauses
    T visit(SelectClauseNode node);
    T visit(FromClauseNode node);
    T visit(WhereClauseNode node);
    T visit(JoinClauseNode node);
    T visit(GroupByClauseNode node);
    T visit(HavingClauseNode node);
    T visit(OrderByClauseNode node);
    
    // Expressions
    T visit(ColumnNode node);
    T visit(TableNode node);
    T visit(LiteralNode node);
    T visit(BinaryExpressionNode node);
    T visit(FunctionCallNode node);
    T visit(AggregateFunctionNode node);
    T visit(CaseexpressionNode node);
    T visit(SubqueryNode node);
}