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
        
        System.out.println("=".repeat(60));
        System.out.println("SQL Input:");
        System.out.println("=".repeat(60));
        System.out.println(sql);
        
        // 2️⃣ Lexer
        CharStream input = CharStreams.fromString(sql);
        SQLLexer lexer = new SQLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // 3️⃣ Parser
        SQLParser parser = new SQLParser(tokens);
        
        // Add error listener to show parsing errors
        parser.removeErrorListeners(); // Remove default error listener
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                  int line, int charPositionInLine, String msg,
                                  RecognitionException e) {
                System.err.println("❌ Syntax Error at line " + line + ":" + charPositionInLine + " - " + msg);
            }
        });
        
        // 4️⃣ Parse Tree
        SQLParser.SelectStatementContext tree = parser.selectStatement();
        
        // Check for parsing errors
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("\n❌ Parsing failed with " + parser.getNumberOfSyntaxErrors() + " error(s).");
            return;
        }
        
        // 5️⃣ AST Builder
        ASTBuilder builder = new ASTBuilder();
        ASTNode ast = null;
        
        try {
            ast = builder.visit(tree);
            System.out.println("\n✅ AST built successfully!");
        } catch (Exception e) {
            System.err.println("\n❌ Error building AST: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        
        // 6️⃣ Run Diagnostic
        try {
            ASTDiagnostic.diagnose(ast);
        } catch (Exception e) {
            System.err.println("❌ Error in diagnostic: " + e.getMessage());
            e.printStackTrace();
        }
        
        // 7️⃣ Print AST (text format)
        System.out.println("\n" + "=".repeat(60));
        System.out.println("AST Text Representation:");
        System.out.println("=".repeat(60));
        
        try {
            String treeOutput = TreePrinter.print(ast);
            System.out.println(treeOutput);
        } catch (Exception e) {
            System.err.println("❌ Error printing AST tree: " + e.getMessage());
            e.printStackTrace();
        }
        
        // 8️⃣ Generate AST Visual Image
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Generating AST Visualization...");
        System.out.println("=".repeat(60));
        
        try {
            ASTVisualizer visualizer = new ASTVisualizer();
            String dotFile = "ast_tree.dot";
            String pngFile = "ast_tree.png";
            
            visualizer.generateDotFile(ast, dotFile);
            System.out.println("✅ DOT file created: " + dotFile);
            
            boolean success = ASTVisualizer.generatePng(dotFile, pngFile);
            
            if (success) {
                System.out.println("✅ AST image generated successfully: " + pngFile);
            } else {
                System.out.println("⚠️  Could not generate PNG. Ensure Graphviz is installed.");
                System.out.println("   To install Graphviz:");
                System.out.println("   - Ubuntu/Debian: sudo apt-get install graphviz");
                System.out.println("   - macOS: brew install graphviz");
                System.out.println("   - Windows: Download from https://graphviz.org/download/");
                System.out.println("\n   You can manually generate PNG with:");
                System.out.println("   dot -Tpng " + dotFile + " -o " + pngFile);
            }
        } catch (Exception e) {
            System.err.println("❌ Error generating visualization: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Processing completed!");
        System.out.println("=".repeat(60));
    }
}
