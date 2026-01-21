package com.sqlcompiler.compiler;

import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.clauses.*;
import com.sqlcompiler.parser.ast.expressions.*;
import com.sqlcompiler.parser.ast.statements.SelectStatementNode;

/**
 * Diagnostic utility to inspect AST structure and identify issues
 */
public class ASTDiagnostic {
    
    public static void diagnose(ASTNode ast) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("AST DIAGNOSTIC REPORT");
        System.out.println("=".repeat(60));
        
        if (ast == null) {
            System.out.println("❌ AST is NULL!");
            return;
        }
        
        System.out.println("✅ AST Root: " + ast.getClass().getSimpleName());
        
        if (ast instanceof SelectStatementNode) {
            diagnoseSelectStatement((SelectStatementNode) ast);
        }
        
        System.out.println("=".repeat(60));
    }
    
    private static void diagnoseSelectStatement(SelectStatementNode node) {
        System.out.println("\n📊 SELECT STATEMENT DETAILS:");
        
        // SELECT Clause
        System.out.println("\n1️⃣ SELECT CLAUSE:");
        if (node.selectClause == null) {
            System.out.println("   ❌ SelectClause is NULL!");
        } else {
            System.out.println("   ✅ SelectClause exists");
            System.out.println("   - Distinct: " + node.selectClause.distinct);
            System.out.println("   - Items count: " + node.selectClause.selectItems.size());
            
            for (int i = 0; i < node.selectClause.selectItems.size(); i++) {
                SelectClauseNode.SelectItem item = node.selectClause.selectItems.get(i);
                System.out.println("\n   Item[" + i + "]:");
                System.out.println("     - Alias: " + (item.alias != null ? item.alias : "none"));
                
                if (item.expression == null) {
                    System.out.println("     ❌ Expression is NULL!");
                } else {
                    System.out.println("     - Expression type: " + item.expression.getClass().getSimpleName());
                    
                    if (item.expression instanceof ColumnNode) {
                        ColumnNode col = (ColumnNode) item.expression;
                        System.out.println("     - Column: " + col.columnName);
                        System.out.println("     - Table: " + (col.tableName != null ? col.tableName : "none"));
                    } else if (item.expression instanceof LiteralNode) {
                        LiteralNode lit = (LiteralNode) item.expression;
                        System.out.println("     - Value: " + lit.value);
                        System.out.println("     - Type: " + lit.type);
                    } else if (item.expression instanceof BinaryExpressionNode) {
                        BinaryExpressionNode bin = (BinaryExpressionNode) item.expression;
                        System.out.println("     - Operator: " + bin.operator);
                        System.out.println("     - Left: " + (bin.left != null ? bin.left.getClass().getSimpleName() : "null"));
                        System.out.println("     - Right: " + (bin.right != null ? bin.right.getClass().getSimpleName() : "null"));
                    }
                }
            }
        }
        
        // FROM Clause
        System.out.println("\n2️⃣ FROM CLAUSE:");
        if (node.fromClause == null) {
            System.out.println("   ❌ FromClause is NULL!");
        } else {
            System.out.println("   ✅ FromClause exists");
            System.out.println("   - Table sources count: " + node.fromClause.tableSources.size());
            
            for (int i = 0; i < node.fromClause.tableSources.size(); i++) {
                FromClauseNode.TableSource ts = node.fromClause.tableSources.get(i);
                System.out.println("\n   TableSource[" + i + "]:");
                System.out.println("     - Alias: " + (ts.alias != null ? ts.alias : "none"));
                
                if (ts.source == null) {
                    System.out.println("     ❌ Source is NULL!");
                } else {
                    System.out.println("     - Source type: " + ts.source.getClass().getSimpleName());
                    
                    if (ts.source instanceof TableNode) {
                        TableNode table = (TableNode) ts.source;
                        System.out.println("     - Table name: " + table.tableName);
                    } else if (ts.source instanceof SubqueryNode) {
                        SubqueryNode sub = (SubqueryNode) ts.source;
                        System.out.println("     - Subquery alias: " + sub.getAlias());
                    }
                }
                
                // Check joins
                if (ts.joins == null) {
                    System.out.println("     ⚠️  Joins list is NULL!");
                } else if (ts.joins.isEmpty()) {
                    System.out.println("     - Joins: none");
                } else {
                    System.out.println("     - Joins count: " + ts.joins.size());
                    
                    for (int j = 0; j < ts.joins.size(); j++) {
                        JoinClauseNode join = ts.joins.get(j);
                        System.out.println("\n     Join[" + j + "]:");
                        System.out.println("       - Type: " + join.joinType);
                        System.out.println("       - Alias: " + (join.alias != null ? join.alias : "none"));
                        
                        if (join.table == null) {
                            System.out.println("       ❌ Join table is NULL!");
                        } else {
                            System.out.println("       - Table type: " + join.table.getClass().getSimpleName());
                            if (join.table instanceof TableNode) {
                                System.out.println("       - Table name: " + ((TableNode) join.table).tableName);
                            }
                        }
                        
                        if (join.condition == null) {
                            System.out.println("       ⚠️  Condition is NULL (CROSS JOIN?)");
                        } else {
                            System.out.println("       - Condition type: " + join.condition.getClass().getSimpleName());
                        }
                    }
                }
            }
        }
        
        // WHERE Clause
        System.out.println("\n3️⃣ WHERE CLAUSE:");
        if (node.whereClause == null) {
            System.out.println("   - No WHERE clause");
        } else {
            System.out.println("   ✅ WhereClause exists");
            if (node.whereClause.condition == null) {
                System.out.println("   ❌ Condition is NULL!");
            } else {
                System.out.println("   - Condition type: " + node.whereClause.condition.getClass().getSimpleName());
                diagnoseExpression(node.whereClause.condition, "   ");
            }
        }
        
        // GROUP BY Clause
        System.out.println("\n4️⃣ GROUP BY CLAUSE:");
        if (node.groupByClause == null) {
            System.out.println("   - No GROUP BY clause");
        } else {
            System.out.println("   ✅ GroupByClause exists");
            System.out.println("   - Elements count: " + node.groupByClause.groupingElements.size());
        }
        
        // HAVING Clause
        System.out.println("\n5️⃣ HAVING CLAUSE:");
        if (node.havingClause == null) {
            System.out.println("   - No HAVING clause");
        } else {
            System.out.println("   ✅ HavingClause exists");
        }
        
        // ORDER BY Clause
        System.out.println("\n6️⃣ ORDER BY CLAUSE:");
        if (node.orderByClause == null) {
            System.out.println("   - No ORDER BY clause");
        } else {
            System.out.println("   ✅ OrderByClause exists");
            System.out.println("   - Sort items count: " + node.orderByClause.sortItems.size());
        }
    }
    
    private static void diagnoseExpression(ExpressionNode expr, String indent) {
        if (expr instanceof BinaryExpressionNode) {
            BinaryExpressionNode bin = (BinaryExpressionNode) expr;
            System.out.println(indent + "- Binary expression: " + bin.operator);
            if (bin.left != null) {
                System.out.println(indent + "  Left: " + bin.left.getClass().getSimpleName());
                if (bin.left instanceof ColumnNode) {
                    ColumnNode col = (ColumnNode) bin.left;
                    System.out.println(indent + "    -> " + (col.tableName != null ? col.tableName + "." : "") + col.columnName);
                }
            }
            if (bin.right != null) {
                System.out.println(indent + "  Right: " + bin.right.getClass().getSimpleName());
                if (bin.right instanceof LiteralNode) {
                    LiteralNode lit = (LiteralNode) bin.right;
                    System.out.println(indent + "    -> " + lit.value + " [" + lit.type + "]");
                }
            }
        } else if (expr instanceof NotExpressionNode) {
            NotExpressionNode not = (NotExpressionNode) expr;
            System.out.println(indent + "- NOT expression");
            if (not.getExpression() != null) {
                diagnoseExpression(not.getExpression(), indent + "  ");
            }
        }
    }
}