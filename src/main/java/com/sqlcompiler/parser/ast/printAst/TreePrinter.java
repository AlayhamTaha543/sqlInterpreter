package com.sqlcompiler.parser.ast.printAst;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.ASTVisitor;
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
import com.sqlcompiler.parser.ast.statements.SelectStatementNode;


public class TreePrinter implements ASTVisitor<Void> {
    private int level = 0;
    private final StringBuilder output = new StringBuilder();
    
    public static String print(ASTNode node) {
        TreePrinter printer = new TreePrinter();
        if (node != null) {
            node.accept(printer);
        }
        return printer.output.toString();
    }
    
    private String getIndent() {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("│   ");
        }
        return indent.toString();
    }
    
    private void addLine(String text) {
        output.append(getIndent()).append("├── ").append(text).append("\n");
    }
    
    // ========== Statements ==========
    @Override
    public Void visit(SelectStatementNode node) {
        addLine("SelectStatement");
        level++;
        
        // SELECT clause
        if (node.selectClause != null) {
            node.selectClause.accept(this);
        }
        
        // FROM clause
        if (node.fromClause != null) {
            node.fromClause.accept(this);
        }
        
        // WHERE clause
        if (node.whereClause != null) {
            node.whereClause.accept(this);
        }
        
        // GROUP BY clause
        if (node.groupByClause != null) {
            node.groupByClause.accept(this);
        }
        
        // HAVING clause
        if (node.havingClause != null) {
            node.havingClause.accept(this);
        }
        
        // ORDER BY clause
        if (node.orderByClause != null) {
            node.orderByClause.accept(this);
        }
        
        // LIMIT (تأكد أن لديك هذه الخاصية في SelectStatementNode)
        if (node.limit != null) {
            addLine("LIMIT: " + node.limit);
        }
        
        // OFFSET (تأكد أن لديك هذه الخاصية في SelectStatementNode)
        if (node.offset != null) {
            addLine("OFFSET: " + node.offset);
        }
        
        level--;
        return null;
    }
    
    // @Override
    // public Void visit(InsertStatementNode node) {
    //     addLine("InsertStatement");
    //     return null;
    // }
    
    // @Override
    // public Void visit(UpdateStatementNode node) {
    //     addLine("UpdateStatement");
    //     return null;
    // }
    
    // @Override
    // public Void visit(DeleteStatementNode node) {
    //     addLine("DeleteStatement");
    //     return null;
    // }
    
    // ========== Clauses ==========
    @Override
    public Void visit(SelectClauseNode node) {
        addLine("SELECT" + (node.distinct ? " DISTINCT" : ""));
        level++;
        
        for (SelectClauseNode.SelectItem item : node.selectItems) {
            String aliasText = (item.alias != null && !item.alias.isEmpty()) ? 
                             " AS " + item.alias : "";
            
            if (item.allColumns) {
                addLine("Wildcard (*)");
            } else {
                addLine("SelectItem" + aliasText);
                
                if (item.expression != null) {
                    level++;
                    item.expression.accept(this);
                    level--;
                }
            }
        }
        
        level--;
        return null;
    }
    
    @Override
    public Void visit(FromClauseNode node) {
        addLine("FROM");
        level++;
        
        for (FromClauseNode.TableSource table : node.tableSources) {
            String aliasText = (table.alias != null && !table.alias.isEmpty()) ? 
                             " AS " + table.alias : "";
            addLine("TableSource" + aliasText);
            
            if (table.source != null) {
                level++;
                table.source.accept(this);
                level--;
            }
        }
        
        level--;
        return null;
    }
    
    @Override
    public Void visit(WhereClauseNode node) {
        if (node != null && node.condition != null) {
            addLine("WHERE");
            level++;
            node.condition.accept(this);
            level--;
        }
        return null;
    }
    
    @Override
    public Void visit(JoinClauseNode node) {
        if (node != null) {
            addLine("JOIN: " + node.joinType);
        }
        return null;
    }
    
    @Override
    public Void visit(GroupByClauseNode node) {
        if (node != null && !node.groupingElements.isEmpty()) {
            addLine("GROUP BY");
            level++;
            for (GroupByClauseNode.GroupingElement elem : node.groupingElements) {
                if (elem.expression != null) {
                    elem.expression.accept(this);
                }
            }
            level--;
        }
        return null;
    }
    
    @Override
    public Void visit(HavingClauseNode node) {
        if (node != null && node.condition != null) {
            addLine("HAVING");
            level++;
            node.condition.accept(this);
            level--;
        }
        return null;
    }
    
    @Override
    public Void visit(OrderByClauseNode node) {
        if (node != null && !node.sortItems.isEmpty()) {
            addLine("ORDER BY");
            level++;
            for (OrderByClauseNode.SortItem item : node.sortItems) {
                if (item.expression != null) {
                    item.expression.accept(this);
                }
            }
            level--;
        }
        return null;
    }
    
    // ========== Expressions ==========
    @Override
    public Void visit(ColumnNode node) {
        if (node != null) {
            String text = node.tableName != null ? 
                         node.tableName + "." + node.columnName : 
                         node.columnName;
            addLine("Column: " + text);
        }
        return null;
    }
    
    @Override
    public Void visit(TableNode node) {
        if (node != null) {
            String aliasText = (node.alias != null && !node.alias.isEmpty()) ? 
                             " AS " + node.alias : "";
            addLine("Table: " + node.tableName + aliasText);
        }
        return null;
    }
    
    @Override
    public Void visit(LiteralNode node) {
        if (node != null) {
            addLine("Literal[" + node.type + "]: " + node.value);
        }
        return null;
    }
    
    @Override
    public Void visit(BinaryExpressionNode node) {
        if (node != null) {
            addLine("BinaryExpr: " + node.operator);
            level++;
            if (node.left != null) node.left.accept(this);
            if (node.right != null) node.right.accept(this);
            level--;
        }
        return null;
    }
    
    @Override
    public Void visit(FunctionCallNode node) {
        if (node != null) {
            addLine("Function: " + node.functionName);
        }
        return null;
    }
    
    @Override
    public Void visit(AggregateFunctionNode node) {
        if (node != null) {
            addLine("Aggregate: " + node.type);
        }
        return null;
    }
    
    @Override
    public Void visit(CaseexpressionNode node) {
        addLine("CaseExpression");
        return null;
    }
    
   @Override
public Void visit(SubqueryNode node) {
    if (node != null) {
        String aliasText = (node.alias != null && !node.alias.isEmpty()) ? 
                         " AS " + node.alias : "";
        addLine("Subquery" + aliasText);
        
        if (node.query != null) {
            level++;
            
            // الطريقة 1: استخدام accept() إذا كان الـ query يدعمها
            if (node.query instanceof SelectStatementNode) {
                // نحتاج إلى معرفة نوع الـ query وزيارته
                addLine("Query Type: " + node.query.getClass().getSimpleName());
                node.query.accept(this);
            } else {
                addLine("Query: " + node.query.getClass().getSimpleName());
            }
            
            level--;
        }
    }
    return null;
}
}