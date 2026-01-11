package com.sqlcompiler.compiler;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utility to visualize ANTLR ParseTree using Graphviz DOT format.
 */
public class TreeVisualizer {

    private StringBuilder dotContent;
    private int nodeCount;

    public TreeVisualizer() {
        this.dotContent = new StringBuilder();
        this.nodeCount = 0;
    }

    /**
     * Generates a DOT file from the given parse tree.
     *
     * @param tree     The parse tree to visualize
     * @param parser   The parser used to create the tree (for rule names)
     * @param filePath The path where the .dot file will be saved
     * @throws IOException If file writing fails
     */
    public void generateDotFile(ParseTree tree, Parser parser, String filePath) throws IOException {
        dotContent.setLength(0);
        nodeCount = 0;

        dotContent.append("digraph ParseTree {\n");
        dotContent.append("  node [shape=box, fontname=\"Arial\"];\n");
        
        walk(tree, parser, -1);

        dotContent.append("}\n");

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(dotContent.toString());
        }
    }

    /**
     * Recursively walks the tree and builds the DOT content.
     */
    private int walk(ParseTree tree, Parser parser, int parentId) {
        int currentId = nodeCount++;
        String label;

        if (tree instanceof TerminalNode) {
            Token token = ((TerminalNode) tree).getSymbol();
            String text = token.getText().replace("\"", "\\\"");
            if (token.getType() == Token.EOF) {
                label = "EOF";
            } else {
                label = "Token: " + text;
            }
            dotContent.append(String.format("  node%d [label=\"%s\", style=filled, fillcolor=lightblue];\n", currentId, label));
        } else {
            RuleContext ctx = (RuleContext) tree;
            label = parser.getRuleNames()[ctx.getRuleIndex()];
            dotContent.append(String.format("  node%d [label=\"%s\"];\n", currentId, label));
        }

        if (parentId != -1) {
            dotContent.append(String.format("  node%d -> node%d;\n", parentId, currentId));
        }

        for (int i = 0; i < tree.getChildCount(); i++) {
            walk(tree.getChild(i), parser, currentId);
        }

        return currentId;
    }

    /**
     * Attempts to convert a DOT file to a PNG image using the 'dot' command.
     *
     * @param dotFilePath The path to the source .dot file
     * @param pngFilePath The path where the .png image will be saved
     * @return true if successful, false otherwise
     */
    public static boolean generatePng(String dotFilePath, String pngFilePath) {
        try {
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", dotFilePath, "-o", pngFilePath);
            Process process = pb.start();
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (IOException | InterruptedException e) {
            System.err.println("Error generating PNG: " + e.getMessage());
            return false;
        }
    }
}