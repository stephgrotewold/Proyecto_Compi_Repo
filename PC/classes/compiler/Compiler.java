package compiler;

import compiler.lexer.Lexer;
import compiler.parser.sym;
import compiler.parser.Parser;
import compiler.ast.*;
import java.io.FileReader;
import java.io.IOException;
import java_cup.runtime.Symbol;

// Importaciones para la visualización del AST
import guru.nidi.graphviz.attribute.Label;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;
import static guru.nidi.graphviz.model.Factory.*;

import java.io.File;

public class Compiler {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No input file provided.");
            return;
        }

        String targetStage = "codegen"; // Default stage
        String inputFile = null;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-target":
                    if (i + 1 < args.length) {
                        targetStage = args[++i];
                    } else {
                        System.out.println("Error: -target requires an argument.");
                        return;
                    }
                    break;
                default:
                    inputFile = args[i];
                    break;
            }
        }

        if (inputFile == null) {
            System.out.println("No input file provided.");
            return;
        }

        try (FileReader fileReader = new FileReader(inputFile)) {
            System.out.println("Compiling " + inputFile + " to stage: " + targetStage);

            if (targetStage.equals("scan")) {
                performLexicalAnalysis(fileReader);
            } else if (targetStage.equals("parse") || targetStage.equals("ast")) {
                ProgramNode ast = performParsing(fileReader, inputFile);
                
                if (targetStage.equals("ast")) {
                    generateAndVisualizeAST(ast);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + inputFile);
        } catch (Exception e) {
            System.out.println("Error during compilation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void performLexicalAnalysis(FileReader fileReader) throws Exception {
        Lexer lexer = new Lexer(fileReader);
        Symbol token;

        System.out.println("Starting lexical analysis (scanning)...");

        while ((token = lexer.next_token()) != null) {
            String tokenValue = token.value != null ? ", value: " + token.value : "";
            System.out.printf("(línea: %d, columna: %d, token: %s%s)\n", 
                token.left, token.right, 
                sym.terminalNames[token.sym], tokenValue);
            
            if (token.sym == sym.EOF) {
                System.out.println("End of file reached.");
                break;
            }
        }

        System.out.println("Lexical analysis (scanning) completed.");
    }

    private static ProgramNode performParsing(FileReader fileReader, String inputFile) throws Exception {
        Lexer lexer = new Lexer(fileReader);
        Parser parser = new Parser(lexer);
        System.out.println("Starting parsing...");
        System.out.println("Parsing input from: " + inputFile);
        
        Symbol parseResult = parser.parse(inputFile);
        
        if (parseResult.value instanceof ProgramNode) {
            System.out.println("Parsing completed successfully.");
            return (ProgramNode) parseResult.value;
        } else {
            throw new Exception("Parsing failed: AST root is not a ProgramNode");
        }
    }

    private static void generateAndVisualizeAST(ProgramNode ast) {
        System.out.println("Generating AST...");
        visualizeAST(ast, "ast_output.png");
        System.out.println("AST visualization saved as ast_output.png");
    }

    private static void visualizeAST(ASTNode root, String outputPath) {
        MutableGraph graph = mutGraph("AST").setDirected(true);
        visualizeNode(graph, root, null);
        try {
            Graphviz.fromGraph(graph).width(1000).render(Format.PNG).toFile(new File(outputPath));
        } catch (IOException e) {
            System.err.println("Error generating AST visualization: " + e.getMessage());
        }
    }

    private static MutableNode visualizeNode(MutableGraph graph, ASTNode node, MutableNode parent) {
        String nodeId = node.getClass().getSimpleName() + System.identityHashCode(node);
        MutableNode graphNode = mutNode(nodeId);
        
        // Crear una etiqueta más descriptiva
        String label = node.getClass().getSimpleName();
        if (node.toString() != null && !node.toString().isEmpty()) {
            label += "\n" + node.toString();
        }
        
        graphNode.add(Label.of(label));
        graph.add(graphNode);
    
        if (parent != null) {
            parent.addLink(graphNode);
        }
    
        for (ASTNode child : node.getChildren()) {
            visualizeNode(graph, child, graphNode);
        }
    
        return graphNode;
    }
}