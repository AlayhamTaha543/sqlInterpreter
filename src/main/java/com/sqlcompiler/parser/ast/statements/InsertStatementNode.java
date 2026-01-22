package com.sqlcompiler.parser.ast.statements;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.expressions.ExpressionNode;
import java.util.List;

public class InsertStatementNode extends ASTNode {
    public final String target; // target table or specification text
    public final List<String> columns; // optional column list
    public final List<List<ExpressionNode>> valueRows; // VALUES (...) rows
    public final ExpressionNode querySource; // SELECT ... source
    public final boolean defaultValues;

    public InsertStatementNode(String target,
                               List<String> columns,
                               List<List<ExpressionNode>> valueRows,
                               ExpressionNode querySource,
                               boolean defaultValues) {
        this.target = target;
        this.columns = columns;
        this.valueRows = valueRows;
        this.querySource = querySource;
        this.defaultValues = defaultValues;
    }

    @Override
    public <T> T accept(com.sqlcompiler.parser.ast.ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
