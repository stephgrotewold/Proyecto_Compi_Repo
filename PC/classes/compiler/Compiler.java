package compiler;
import compiler.lexer.Lexer;
import compiler.parser.sym;
import compiler.parser.Parser;
import compiler.semantic.*;
import compiler.semantic.Symbol;
import compiler.ast.*;
import compiler.irt.IRGenerator;
import compiler.irt.IRNode;
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
            } else if (targetStage.equals("parse") || targetStage.equals("ast") || targetStage.equals("semantic") || targetStage.equals("irt")) {
                ProgramNode ast = performParsing(fileReader, inputFile);
                
                if (targetStage.equals("ast")) {
                    generateAndVisualizeAST(ast);
                }

                if (targetStage.equals("semantic")) {
                    checkSemantics(ast);
                }

                if (targetStage.equals("irt")) {
                    generateIntermediateRepresentation(ast);
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
        if (node == null) return;
        
        System.out.println("Checking node: " + node.getClass().getSimpleName());
        
        if (node instanceof MethodDeclNode) {
            MethodDeclNode methodNode = (MethodDeclNode) node;
            currentMethod = methodNode.name;
            scope = "global." + methodNode.name;
        }
    
        // Verificar el tipo de nodo y realizar las comprobaciones correspondientes
        if (node instanceof AssignNode) {
            checkAssignment((AssignNode) node, symbolTable, scope, errorCollector);
        }
        else if (node instanceof IfNode) {
            IfNode ifNode = (IfNode) node;
            checkIfCondition(ifNode, symbolTable, scope, errorCollector);
            checkTypes(ifNode.thenBlock, symbolTable, scope, errorCollector);
            if (ifNode.elseBlock != null) {
                checkTypes(ifNode.elseBlock, symbolTable, scope, errorCollector);
            }
        }
        else if (node instanceof ReturnNode) {
            checkReturnStatement((ReturnNode) node, symbolTable, currentMethod, errorCollector);
        }
        else if (node instanceof MethodCallStatementNode) {
            checkMethodCall(((MethodCallStatementNode) node).methodCall, symbolTable, scope, errorCollector);
        }
    
        // Recorrer los hijos del nodo
        for (ASTNode child : node.getChildren()) {
            checkTypes(child, symbolTable, scope, errorCollector);
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
        System.out.println("\nDEBUG: Checking assignment to " + assign.location.name);
        
        Symbol leftSymbol = symbolTable.lookup(assign.location.name, scope);
        if (leftSymbol == null) {
            System.out.println("DEBUG: Left symbol not found in scope: " + scope);
            leftSymbol = symbolTable.lookup(assign.location.name, "global");
        }
        
        if (leftSymbol == null) {
            System.out.println("DEBUG: Left symbol not found in any scope");
            return;
        }
        
        System.out.println("DEBUG: Left symbol type: " + leftSymbol.type);
        
        String rightType = getExpressionType(assign.expression, symbolTable, scope);
        System.out.println("DEBUG: Right expression type: " + rightType);
    
        if (!rightType.equals(leftSymbol.type)) {
            errorCollector.addError(
                "Type mismatch in assignment to '" + assign.location.name + 
                "': cannot assign " + rightType + " to " + leftSymbol.type,
                assign.getLine(),
                assign.getColumn());
        }
    }
    
    private static void checkIfCondition(IfNode ifNode, SymbolTable symbolTable, String scope, SemanticErrorCollector errorCollector) {
        String conditionType = getExpressionType(ifNode.condition, symbolTable, scope);
        if (!conditionType.equals("boolean")) {
            errorCollector.addError(
                "If condition must be of type boolean, found: " + conditionType,
                ifNode.getLine(),
                ifNode.getColumn());
        }
    }
    
    private static void checkReturnStatement(ReturnNode returnNode, SymbolTable symbolTable, String methodName, SemanticErrorCollector errorCollector) {
        Symbol methodSymbol = symbolTable.lookup(methodName, "global");
        
        if (methodSymbol == null) {
            errorCollector.addError(
                "Method '" + methodName + "' not found",
                returnNode.getLine(),
                returnNode.getColumn());
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
                "': expected " + expectedType + ", found " + actualType,
                returnNode.getLine(),
                returnNode.getColumn());
        }
    }
    
    private static void checkFieldDeclaration(FieldDeclNode fieldDecl, SymbolTable symbolTable, String scope, SemanticErrorCollector errorCollector) {
        if (fieldDecl.type.typeName.equals("void")) {
            errorCollector.addError(
                "Cannot declare variable of type void",
                fieldDecl.getLine(),
                fieldDecl.getColumn()
            );
        }
    }

    private static void checkMethodCall(MethodCallNode call, SymbolTable symbolTable, String scope, SemanticErrorCollector errorCollector) {
        Symbol method = symbolTable.lookup(call.name, scope);
        if (method == null || !method.isMethod) {
            errorCollector.addError(
                "Method '" + call.name + "' not found",
                call.getLine(),
                call.getColumn());
            return;
        }
    
        // Verificar número de argumentos
        if (method.paramTypes.size() != call.arguments.size()) {  // Cambiado
            errorCollector.addError(
                "Wrong number of arguments for method '" + call.name + "'",
                call.getLine(),
                call.getColumn());
            return;
        }
    
        // Verificar tipos de argumentos
        for (int i = 0; i < call.arguments.size(); i++) {
            String expectedType = method.paramTypes.get(i);  // Cambiado
            String actualType = getExpressionType(call.arguments.get(i), symbolTable, scope);
            if (!symbolTable.isCompatibleType(expectedType, actualType)) {
                errorCollector.addError(
                    "Type mismatch in argument " + (i+1) + " of method '" + call.name + 
                    "': expected " + expectedType + ", found " + actualType,
                    call.getLine(),
                    call.getColumn());
            }
        }
    }
    
    private static String getExpressionType(ExprNode expr, SymbolTable symbolTable, String scope) {
        if (expr == null) {
            System.out.println("DEBUG: Expression is null");
            return "undefined";
        }
    
        System.out.println("DEBUG: Expression class: " + expr.getClass().getName());
    
        if (expr instanceof LiteralNode) {
            LiteralNode lit = (LiteralNode) expr;
            String type = lit.getType();
            System.out.println("DEBUG: LiteralNode type: " + type);
            return type;
        }
    
        if (expr instanceof LocationNode) {
            LocationNode loc = (LocationNode) expr;
            Symbol symbol = symbolTable.lookup(loc.name, scope);
            if (symbol == null) {
                symbol = symbolTable.lookup(loc.name, "global");
            }
            String type = symbol != null ? symbol.type : "undefined";
            System.out.println("DEBUG: LocationNode " + loc.name + " type: " + type);
            return type;
        }
    
        if (expr instanceof BinaryOpNode) {
            BinaryOpNode binOp = (BinaryOpNode) expr;
            String leftType = getExpressionType(binOp.left, symbolTable, scope);
            String rightType = getExpressionType(binOp.right, symbolTable, scope);
            System.out.println("DEBUG: BinaryOp " + binOp.operator + " types: " + leftType + " and " + rightType);
            
            switch (binOp.operator) {
                case "+": case "-": case "*": case "/": case "%":
                    return (leftType.equals("int") && rightType.equals("int")) ? "int" : "undefined";
                case "<": case ">": case "<=": case ">=": case "==": case "!=":
                    return (leftType.equals(rightType)) ? "boolean" : "undefined";
                case "&&": case "||":
                    return (leftType.equals("boolean") && rightType.equals("boolean")) ? "boolean" : "undefined";
                default:
                    return "undefined";
            }
        }
    
        if (expr instanceof UnaryOpNode) {
            UnaryOpNode unaryOp = (UnaryOpNode) expr;
            String operandType = getExpressionType(unaryOp.expression, symbolTable, scope);
            System.out.println("DEBUG: UnaryOp " + unaryOp.operator + " type: " + operandType);
            
            if (unaryOp.operator.equals("-")) {
                return operandType.equals("int") ? "int" : "undefined";
            }
            if (unaryOp.operator.equals("!")) {
                return operandType.equals("boolean") ? "boolean" : "undefined";
            }
        }
    
        System.out.println("DEBUG: Unknown expression type: " + expr.getClass().getName());
        return "undefined";
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

    private static void checkVoidVariable(TypeNode type, SemanticErrorCollector errorCollector) {
        if (type.typeName.equals("void")) {
            errorCollector.addError(
                "Cannot declare variable of type void",
                type.getLine(),
                type.getColumn()
            );
        }
    }

    // private static void debugPrintExpression(ExprNode expr) {
    //     if (expr == null) {
    //         System.out.println("Debug - Expression is null");
    //         return;
    //     }
        
    //     System.out.println("Debug - Expression type: " + expr.getClass().getName());
        
    //     if (expr instanceof BooleanLiteralNode) {
    //         BooleanLiteralNode boolNode = (BooleanLiteralNode) expr;
    //         System.out.println("Boolean value: " + boolNode.getValue());
    //     } else if (expr instanceof IntLiteralNode) {
    //         IntLiteralNode intNode = (IntLiteralNode) expr;
    //         System.out.println("Int value: " + intNode.getValue());
    //     }
    // }

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
    
    private static void generateIntermediateRepresentation(ProgramNode ast) {
        System.out.println("Generating Intermediate Representation Tree (IRT)...");
        IRNode irt = IRGenerator.generateIR(ast); // Genera el IRT usando el generador
        System.out.println("IRT:");
        System.out.println(irt.toIR()); // Imprime la representación intermedia
        System.out.println("IRT generation completed.");
    }
}