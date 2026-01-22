package com.sqlcompiler.compiler;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.*;
import com.sqlcompiler.parser.SQLLexer;
import com.sqlcompiler.parser.SQLParser;
import com.sqlcompiler.parser.ast.ASTBuilder;
import com.sqlcompiler.parser.ast.ASTNode;
import com.sqlcompiler.parser.ast.printAst.TreePrinter;
import com.sqlcompiler.parser.ast.statements.ProgramNode;

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
        
        // 4️⃣ Parse all statements
System.out.println("\n" + "=".repeat(60));
System.out.println("Parsing SQL Statements...");
System.out.println("=".repeat(60));

SQLParser.SqlStatementsContext statementsTree = parser.sqlStatements();

if (parser.getNumberOfSyntaxErrors() > 0) {
    System.err.println("\n❌ Parsing failed with " + parser.getNumberOfSyntaxErrors() + " error(s).");
    return;
}

// 5️⃣ Build AST
ASTBuilder builder = new ASTBuilder();
ASTNode ast = null;

try {
    ast = builder.visit(statementsTree);
    
    if (ast instanceof ProgramNode) {
        ProgramNode program = (ProgramNode) ast;
        System.out.println("\n✅ Built program with " + program.getStatementCount() + " statement(s) successfully!");
    }
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
