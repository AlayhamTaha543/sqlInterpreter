package com.sqlcompiler.compiler;

import com.sqlcompiler.parser.ast.ASTNode;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility to visualize custom AST using Graphviz DOT format.
 * Uses reflection to work with any ASTNode structure.
 */
public class ASTVisualizer {
    private StringBuilder dotContent;
    private int nodeCount;

    public ASTVisualizer() {
        this.dotContent = new StringBuilder();
        this.nodeCount = 0;
    }

    /**
     * Generates a DOT file from the given AST.
     */
    public void generateDotFile(ASTNode ast, String filePath) throws IOException {
        dotContent.setLength(0);
        nodeCount = 0;
        
        dotContent.append("digraph AST {\n");
        dotContent.append("  node [shape=box, fontname=\"Arial\"];\n");
        
        walk(ast, -1);
        
        dotContent.append("}\n");
        
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(dotContent.toString());
        }
    }

    /**
     * Recursively walks the AST and builds the DOT content.
     */
    private int walk(ASTNode node, int parentId) {
        if (node == null) return -1;
        
        int currentId = nodeCount++;
        
        // Get node label
        String label = getNodeLabel(node);
        
        // Determine color based on class name
        String fillColor = getColorForNodeType(node.getClass().getSimpleName());
        dotContent.append(String.format(
            "  node%d [label=\"%s\", style=filled, fillcolor=%s];\n", 
            currentId, label, fillColor
        ));
        
        // Connect to parent
        if (parentId != -1) {
            dotContent.append(String.format("  node%d -> node%d;\n", parentId, currentId));
        }
        
        // Process children using reflection
        List<ASTNode> children = getChildren(node);
        for (ASTNode child : children) {
            walk(child, currentId);
        }
        
        return currentId;
    }

    /**
     * Gets the label for a node (class name and any relevant data).
     */
    private String getNodeLabel(ASTNode node) {
        String className = node.getClass().getSimpleName();
        String nodeStr = node.toString();
        
        // If toString() provides useful info, use it
        if (nodeStr != null && !nodeStr.startsWith(node.getClass().getName() + "@")) {
            nodeStr = nodeStr.replace("\"", "\\\"").replace("\n", "\\n");
            if (nodeStr.length() > 60) {
                nodeStr = nodeStr.substring(0, 57) + "...";
            }
            return nodeStr;
        }
        
        return className;
    }

    /**
     * Uses reflection to find and return child nodes.
     */
    private List<ASTNode> getChildren(ASTNode node) {
        List<ASTNode> children = new ArrayList<>();
        
        try {
            // Try common method names first
            Method[] methods = {
                findMethod(node, "getChildren"),
                findMethod(node, "children"),
                findMethod(node, "getChildNodes")
            };
            
            for (Method method : methods) {
                if (method != null) {
                    Object result = method.invoke(node);
                    if (result instanceof List) {
                        @SuppressWarnings("unchecked")
                        List<ASTNode> list = (List<ASTNode>) result;
                        children.addAll(list);
                        return children;
                    }
                }
            }
            
            // If no method found, try fields
            Field[] fields = node.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(node);
                
                if (value instanceof List) {
                    @SuppressWarnings("unchecked")
                    List<?> list = (List<?>) value;
                    for (Object item : list) {
                        if (item instanceof ASTNode) {
                            children.add((ASTNode) item);
                        }
                    }
                } else if (value instanceof ASTNode) {
                    children.add((ASTNode) value);
                }
            }
            
        } catch (Exception e) {
            // Silently continue if reflection fails
        }
        
        return children;
    }

    /**
     * Helper method to find a method by name.
     */
    private Method findMethod(Object obj, String methodName) {
        try {
            return obj.getClass().getMethod(methodName);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /**
     * Assigns colors to different node types for better visualization.
     */
    private String getColorForNodeType(String nodeClassName) {
        String type = nodeClassName.toUpperCase();
        
        if (type.contains("SELECT")) {
            return "lightgreen";
        } else if (type.contains("FROM")) {
            return "lightblue";
        } else if (type.contains("WHERE")) {
            return "lightyellow";
        } else if (type.contains("JOIN")) {
            return "lightcoral";
        } else if (type.contains("COLUMN")) {
            return "lightcyan";
        } else if (type.contains("TABLE")) {
            return "lavender";
        } else if (type.contains("CONDITION") || type.contains("EXPRESSION")) {
            return "wheat";
        } else if (type.contains("LITERAL") || type.contains("VALUE")) {
            return "lightpink";
        } else if (type.contains("ORDER")) {
            return "lightgoldenrodyellow";
        } else if (type.contains("GROUP")) {
            return "palegreen";
        } else {
            return "white";
        }
    }

    /**
     * Generates PNG from DOT file using Graphviz.
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