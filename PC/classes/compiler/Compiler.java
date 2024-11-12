package compiler;
import compiler.lexer.Lexer;
import compiler.parser.sym;
import compiler.parser.Parser;
import compiler.semantic.*;
import compiler.semantic.Symbol;
import compiler.ast.*;
import java.io.FileReader;
import java.io.IOException;

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
            } else if (targetStage.equals("parse") || targetStage.equals("ast") || targetStage.equals("semantic")) {
                ProgramNode ast = performParsing(fileReader, inputFile);
                
                if (targetStage.equals("ast")) {
                    generateAndVisualizeAST(ast);
                }

                if (targetStage.equals("semantic")) {
                    checkSemantics(ast);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + inputFile);
        } catch (SemanticException e) {
            System.err.println("Semantic error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error during compilation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void checkSemantics(ASTNode root) {
        SymbolTable symbolTable = new SymbolTable();
        SemanticErrorCollector errorCollector = new SemanticErrorCollector();
        
        // Primera pasada: recolectar declaraciones
        collectDeclarations(root, symbolTable, "global");
        
        // Segunda pasada: verificar tipos y usos
        checkTypes(root, symbolTable, "global", errorCollector);
        
        // Reportar errores si los hay
        errorCollector.reportErrors();
    }

    private static void collectDeclarations(ASTNode node, SymbolTable symbolTable, String scope) {
        if (node instanceof FieldDeclNode) {
            // Manejar declaraciones de campos (variables globales)
            FieldDeclNode fieldDecl = (FieldDeclNode) node;
            String type = fieldDecl.type.typeName;
            for (FieldNode field : fieldDecl.fields) {
                symbolTable.addSymbol(field.name, type, "global");
            }
        } else if (node instanceof MethodDeclNode) {
            MethodDeclNode methodDecl = (MethodDeclNode) node;
            String methodScope = scope + "." + methodDecl.name;
            
            // Añadir el método al symbol table
            symbolTable.addSymbol(methodDecl.name, methodDecl.returnType.typeName, "global", true);
            
            // Añadir parámetros al scope del método
            for (ParamNode param : methodDecl.params) {
                symbolTable.addSymbol(param.name, param.type.typeName, methodScope);
                symbolTable.addMethodParam(methodDecl.name, "global", param.type.typeName);
            }
    
            // Continuar con el cuerpo del método
            collectDeclarations(methodDecl.body, symbolTable, methodScope);
        } else if (node instanceof VarDeclNode) {
            VarDeclNode varDecl = (VarDeclNode) node;
            String type = varDecl.type.typeName;
            for (String var : varDecl.variables) {
                symbolTable.addSymbol(var, type, scope);
            }
        }
        
        // Recorrer hijos
        for (ASTNode child : node.getChildren()) {
            if (child != null) {
                collectDeclarations(child, symbolTable, scope);
            }
        }
    }

    private static String currentMethod = "";

    private static void checkTypes(ASTNode node, SymbolTable symbolTable, String scope, SemanticErrorCollector errorCollector) {
        System.out.println("Checking node: " + node.getClass().getSimpleName());
        
        if (node instanceof MethodDeclNode) {
            MethodDeclNode methodNode = (MethodDeclNode) node;
            currentMethod = methodNode.name;
        }
        
        if (node instanceof AssignNode) {
            checkAssignment((AssignNode)node, symbolTable, scope, errorCollector);
        } else if (node instanceof IfNode) {
            checkIfStatement((IfNode)node, symbolTable, scope, errorCollector);
        } else if (node instanceof ReturnNode) {
            checkReturnStatement((ReturnNode)node, symbolTable, currentMethod, errorCollector);
        }

        // Recorrer hijos
        for (ASTNode child : node.getChildren()) {
            if (child != null) {
                checkTypes(child, symbolTable, scope, errorCollector);
            }
        }
}

    private static String getCurrentMethodFromScope(String scope) {
        // Si el scope es "global.methodName", retorna "methodName"
        int lastDot = scope.lastIndexOf('.');
        if (lastDot != -1) {
            String methodName = scope.substring(lastDot + 1);
            System.out.println("Current method from scope: " + methodName);
            return methodName;
        }
        return scope;
    }

    
    private static void checkAssignment(AssignNode assign, SymbolTable symbolTable, String scope, SemanticErrorCollector errorCollector) {
        System.out.println("Checking assignment: " + assign.location.name);
        
        compiler.semantic.Symbol leftSymbol = symbolTable.lookup(assign.location.name, scope);
        String exprType = getExpressionType(assign.expression, symbolTable, scope);
        
        System.out.println("Assignment types - Left: " + leftSymbol.type + ", Right: " + exprType);
        
        if (!symbolTable.isCompatibleType(leftSymbol.type, exprType)) {
            errorCollector.addError(
                "Type mismatch in assignment to '" + assign.location.name + 
                "': cannot assign " + exprType + " to " + leftSymbol.type);
        }
    }
    
    private static void checkIfStatement(IfNode ifNode, SymbolTable symbolTable, String scope, SemanticErrorCollector errorCollector) {
        String conditionType = getExpressionType(ifNode.condition, symbolTable, scope);
        if (!conditionType.equals("boolean")) {
            errorCollector.addError("If condition must be of type boolean, found: " + conditionType);
        }
    }
    
    
    private static void checkReturnStatement(ReturnNode returnNode, SymbolTable symbolTable, String methodName, SemanticErrorCollector errorCollector) {
        Symbol methodSymbol = symbolTable.lookup(methodName, "global");
        
        if (methodSymbol == null) {
            errorCollector.addError("Method '" + methodName + "' not found");
            return;
        }
    
        String expectedType = methodSymbol.type;
        String actualType = returnNode.expression != null ? 
            getExpressionType(returnNode.expression, symbolTable, "global." + methodName) : "void";
    
        System.out.println("Checking return in method '" + methodName + 
                          "' - Expected: " + expectedType + 
                          ", Actual: " + actualType);
    
        if (!symbolTable.isCompatibleType(expectedType, actualType)) {
            errorCollector.addError(
                "Return type mismatch in method '" + methodName + 
                "': expected " + expectedType + ", found " + actualType);
        }
    }
    
    private static void checkFieldDeclaration(FieldDeclNode fieldDecl, SymbolTable symbolTable, String scope, SemanticErrorCollector errorCollector) {
        if (fieldDecl.type.typeName.equals("void")) {
            errorCollector.addError("Cannot declare variable of type void");
        }
    }

    private static void checkMethodCall(MethodCallNode call, SymbolTable symbolTable, String scope, SemanticErrorCollector errorCollector) {
        Symbol method = symbolTable.lookup(call.name, scope);
        
        if (!method.isMethod) {
            errorCollector.addError("'" + call.name + "' is not a method");
            return;
        }
    
        // Verificar número de argumentos
        if (call.arguments.size() != method.paramTypes.size()) {
            errorCollector.addError(
                "Method '" + call.name + "' called with wrong number of arguments. " +
                "Expected " + method.paramTypes.size() + ", got " + call.arguments.size());
            return;
        }
    
        // Verificar tipos de argumentos
        for (int i = 0; i < call.arguments.size(); i++) {
            String expectedType = method.paramTypes.get(i);
            String actualType = getExpressionType(call.arguments.get(i), symbolTable, scope);
            
            if (!symbolTable.isCompatibleType(expectedType, actualType)) {
                errorCollector.addError(
                    "Type mismatch in argument " + (i + 1) + " of call to '" + call.name +
                    "': expected " + expectedType + ", got " + actualType);
            }
        }
    }
    
    // Añadir este método auxiliar
    private static String getExpressionType(ExprNode expr, SymbolTable symbolTable, String scope) {
        System.out.println("Getting type for expression: " + expr.getClass().getSimpleName());
        
        if (expr instanceof LocationNode) {
            Symbol symbol = symbolTable.lookup(((LocationNode)expr).name, scope);
            System.out.println("Location type: " + symbol.type);
            return symbol.type;
        } else if (expr instanceof LiteralNode) {
            String type = ((LiteralNode)expr).getType();
            System.out.println("Literal type: " + type);
            return type;
        } else if (expr instanceof BooleanLiteralNode) {
            System.out.println("Boolean literal type: boolean");
            return "boolean";
        } else if (expr instanceof IntLiteralNode) {
            System.out.println("Int literal type: int");
            return "int";
        }
        
        System.out.println("Unknown expression type");
        return "unknown";
    }

    private static void performLexicalAnalysis(FileReader fileReader) throws Exception {
        Lexer lexer = new Lexer(fileReader);
        java_cup.runtime.Symbol token;

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
        
        java_cup.runtime.Symbol parseResult = parser.parse(inputFile);
        
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