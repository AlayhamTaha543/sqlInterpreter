package com.sqlcompiler.parser.ast;

import com.sqlcompiler.parser.ast.clauses.CTENode;
import com.sqlcompiler.parser.ast.clauses.DeleteTargetItemNode;
import com.sqlcompiler.parser.ast.clauses.DeleteTargetNode;
import com.sqlcompiler.parser.ast.clauses.FromClauseNode;
import com.sqlcompiler.parser.ast.clauses.GroupByClauseNode;
import com.sqlcompiler.parser.ast.clauses.HavingClauseNode;
import com.sqlcompiler.parser.ast.clauses.JoinClauseNode;
import com.sqlcompiler.parser.ast.clauses.MergeWhenClauseNode;
import com.sqlcompiler.parser.ast.clauses.OrderByClauseNode;
import com.sqlcompiler.parser.ast.clauses.SelectClauseNode;
import com.sqlcompiler.parser.ast.clauses.WhenClauseNode;
import com.sqlcompiler.parser.ast.clauses.WhereClauseNode;
import com.sqlcompiler.parser.ast.clauses.WithClauseNode;
import com.sqlcompiler.parser.ast.expressions.AggregateFunctionNode;
import com.sqlcompiler.parser.ast.expressions.BinaryExpressionNode;
import com.sqlcompiler.parser.ast.expressions.CaseexpressionNode;
import com.sqlcompiler.parser.ast.expressions.ColumnNode;
import com.sqlcompiler.parser.ast.expressions.FunctionCallNode;
import com.sqlcompiler.parser.ast.expressions.LiteralNode;
import com.sqlcompiler.parser.ast.expressions.SubqueryNode;
import com.sqlcompiler.parser.ast.expressions.NotExpressionNode;
import com.sqlcompiler.parser.ast.expressions.TableNode;
import com.sqlcompiler.parser.ast.other.ColumnDefinitionNode;
import com.sqlcompiler.parser.ast.other.DataTypeNode;
import com.sqlcompiler.parser.ast.other.DropDatabaseNode;
import com.sqlcompiler.parser.ast.other.DropTableNode;
import com.sqlcompiler.parser.ast.statements.AlterStatementNode;
import com.sqlcompiler.parser.ast.statements.CloseCursorNode;
import com.sqlcompiler.parser.ast.statements.CreateStatementNode;
import com.sqlcompiler.parser.ast.statements.DeallocateCursorNode;
import com.sqlcompiler.parser.ast.statements.DeclareCursorNode;
import com.sqlcompiler.parser.ast.statements.DeleteStatementNode;
import com.sqlcompiler.parser.ast.statements.DropStatementNode;
import com.sqlcompiler.parser.ast.statements.FetchCursorNode;
import com.sqlcompiler.parser.ast.statements.MergeStatementNode;
import com.sqlcompiler.parser.ast.statements.IfStatementNode;
import com.sqlcompiler.parser.ast.statements.OpenCursorNode;
import com.sqlcompiler.parser.ast.statements.ProgramNode;
import com.sqlcompiler.parser.ast.statements.RenameItemNode;
import com.sqlcompiler.parser.ast.statements.RenameStatementNode;
import com.sqlcompiler.parser.ast.statements.SelectStatementNode;
import com.sqlcompiler.parser.ast.statements.StatementBlockNode;
import com.sqlcompiler.parser.ast.statements.TruncateStatementNode;
import com.sqlcompiler.parser.ast.statements.InsertStatementNode;
import com.sqlcompiler.parser.ast.statements.UpdateStatementNode;
import com.sqlcompiler.parser.ast.statements.ValuesClauseNode;
import com.sqlcompiler.parser.ast.statements.ValuesRowNode;


public interface ASTVisitor<T> {
    T visit(ProgramNode node);
    // Statements
    T visit(SelectStatementNode node);
    T visit(InsertStatementNode node);
    T visit(UpdateStatementNode node);
    T visit(AlterStatementNode node);

    T visit(DeclareCursorNode node);
    T visit(OpenCursorNode node);
    T visit(CloseCursorNode node);
    T visit(FetchCursorNode node);
    T visit(DeallocateCursorNode node);
    //omar
    T visit(DeleteStatementNode node);
    T visit (DropStatementNode node); 
    T visit(DeleteTargetNode node);
    T visit(DeleteTargetItemNode node);
    T visit(DropDatabaseNode node);
    T visit (DropTableNode node);
    // Clauses
    T visit(SelectClauseNode node);
    T visit(FromClauseNode node);
    T visit(WhereClauseNode node);
    T visit(JoinClauseNode node);
    T visit(GroupByClauseNode node);
    T visit(HavingClauseNode node);
    T visit(OrderByClauseNode node);
    T visit(WithClauseNode node);
    T visit(CTENode node);
    
    // Expressions
    T visit(ColumnNode node);
    T visit(TableNode node);
    T visit(LiteralNode node);
    T visit(BinaryExpressionNode node);
    T visit(FunctionCallNode node);
    T visit(AggregateFunctionNode node);
    T visit(CaseexpressionNode node);
    T visit(SubqueryNode node);
    T visit(NotExpressionNode node);
    T visit(WhenClauseNode  node);
    T visit(RenameStatementNode node);
    T visit(RenameItemNode node);
    T visit(MergeStatementNode node);
    T visit(MergeWhenClauseNode node);
    T visit(TruncateStatementNode node);

    T visit(CreateStatementNode node);

T visit(StatementBlockNode node);
T visit(ValuesClauseNode node);

    T visit(ValuesRowNode node);

T visit(IfStatementNode node);
// Other
    T visit(ColumnDefinitionNode node);

    T visit(DataTypeNode node);
}