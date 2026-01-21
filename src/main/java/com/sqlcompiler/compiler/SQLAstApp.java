package com.sqlcompiler.compiler;

import java.nio.file.Files;
import java.nio.file.Path;
import org.antlr.v4.runtime.*;
import com.sqlcompiler.parser.SQLLexer;
import com.sqlcompiler.parser.SQLParser;
import com.sqlcompiler.parser.ast.ASTBuilder;
import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.printAst.TreePrinter;

public class SQLAstApp {
    public static void main(String[] args) throws Exception {
        // 1️⃣ Read SQL from test.sql
        String sql = Files.readString(Path.of("test.sql"));
        
        // 2️⃣ Lexer
        CharStream input = CharStreams.fromString(sql);
        SQLLexer lexer = new SQLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // 3️⃣ Parser
        SQLParser parser = new SQLParser(tokens);
        
        // 4️⃣ Parse Tree
        SQLParser.SelectStatementContext tree = parser.selectStatement();
        
        // 5️⃣ AST Builder
        ASTBuilder builder = new ASTBuilder();
        ASTNode ast = builder.visit(tree);
        
        // 6️⃣ Print AST (text format)
        System.out.println("\n" + "=".repeat(60));
        System.out.println("AST Text Representation:");
        System.out.println("=".repeat(60));
        TreePrinter.print(ast);
        
        // 7️⃣ Generate AST Visual Image
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Generating AST Visualization...");
        System.out.println("=".repeat(60));
        
        try {
            ASTVisualizer visualizer = new ASTVisualizer();
            String dotFile = "ast_tree.dot";
            String pngFile = "ast_tree.png";
            
            visualizer.generateDotFile(ast, dotFile);
            boolean success = ASTVisualizer.generatePng(dotFile, pngFile);
            
            if (success) {
                System.out.println("✅ AST image generated successfully: " + pngFile);
            } else {
                System.out.println("⚠️ Could not generate PNG. Ensure Graphviz is installed.");
                System.out.println("   DOT file created: " + dotFile);
            }
        } catch (Exception e) {
            System.err.println("❌ Error generating visualization: " + e.getMessage());
        }
    }
}