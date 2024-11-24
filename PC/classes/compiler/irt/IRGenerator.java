package compiler.irt;

import compiler.ast.*;
import java.util.ArrayList;

public class IRGenerator {

    // Método principal para convertir AST a IR
    public static IRNode generateIR(ASTNode node) {
        if (node instanceof BinaryOpNode) {
            return handleBinaryOp((BinaryOpNode) node);
        } else if (node instanceof UnaryOpNode) {
            return handleUnaryOp((UnaryOpNode) node);
        } else if (node instanceof MethodCallNode) {
            return handleMethodCall((MethodCallNode) node);
        } else if (node instanceof LiteralNode) {
            return handleLiteral((LiteralNode) node);
        } else if (node instanceof IfNode) {
            return handleIf((IfNode) node);
        } else if (node instanceof WhileNode) {
            return handleWhile((WhileNode) node);
        } else if (node instanceof ForStatementNode) {
            return handleFor((ForStatementNode) node);
        } else if (node instanceof ReturnNode) {
            return handleReturn((ReturnNode) node);
        } else if (node instanceof FieldDeclNode) {
            return handleFieldDecl((FieldDeclNode) node);
        } else if (node instanceof MethodDeclNode) {
            return handleMethodDecl((MethodDeclNode) node);
        } else if (node instanceof ProgramNode) {
            return handleProgramNode((ProgramNode) node);
        } else if (node instanceof BlockNode) {
            return handleBlock((BlockNode) node);
        } else if (node instanceof AssignNode) {
            return handleAssign((AssignNode) node);
        } else if (node instanceof LocationNode) {
            return handleLocation((LocationNode) node);
        } else if (node instanceof MethodCallStatementNode) {
            return handleMethodCallStatement((MethodCallStatementNode) node);
        }
        return new IRLiteralNode("Unsupported AST Node: " + node.getClass().getSimpleName());
    }

    // Manejo de nodos binarios (BinaryOpNode)
    private static IRNode handleBinaryOp(BinaryOpNode node) {
        return new IRBinaryOpNode(node.operator, generateIR(node.left), generateIR(node.right));
    }

    // Manejo de nodos unarios (UnaryOpNode)
    private static IRNode handleUnaryOp(UnaryOpNode node) {
        return new IRUnaryOpNode(node.operator, generateIR(node.expression));
    }

    // Manejo de bloques (BlockNode)
    private static IRNode handleBlock(BlockNode node) {
        ArrayList<IRNode> irStatements = new ArrayList<>();
        for (StatementNode stmt : node.statements) {
            irStatements.add(generateIR(stmt));
        }
        return new IRCompositeNode("Block", irStatements);
    }

    // Manejo de llamadas a métodos (MethodCallNode)
    private static IRNode handleMethodCall(MethodCallNode node) {
        ArrayList<IRNode> irArguments = new ArrayList<>();
        for (ExprNode argument : node.arguments) {
            irArguments.add(generateIR(argument));
        }
        return new IRMethodCallNode(node.name, irArguments);
    }

    // Manejo de literales (LiteralNode)
    private static IRNode handleLiteral(LiteralNode node) {
        return new IRLiteralNode(String.valueOf(node.getValue()));
    }

    // Manejo de declaraciones IF (IfNode)
    private static IRNode handleIf(IfNode node) {
        IRNode condition = generateIR(node.condition);
        IRNode thenBlock = generateIR(node.thenBlock);
        IRNode elseBlock = node.elseBlock != null ? generateIR(node.elseBlock) : null;
        return new IRIfNode(condition, thenBlock, elseBlock);
    }

    // Manejo de ciclos WHILE (WhileNode)
    private static IRNode handleWhile(WhileNode node) {
        IRNode condition = generateIR(node.condition);
        IRNode body = generateIR(node.body);
        return new IRWhileNode(condition, body);
    }

    // Manejo de ciclos FOR (ForStatementNode)
    private static IRNode handleFor(ForStatementNode node) {
        IRNode init = node.initExpr != null ? generateIR(node.initExpr) : null;
        IRNode condition = generateIR(node.condition);
        IRNode update = node.updateExpr != null ? generateIR(node.updateExpr) : null;
        IRNode body = generateIR(node.body);
        return new IRForNode(init, condition, update, body);
    }

    // Manejo de declaraciones RETURN (ReturnNode)
    private static IRNode handleReturn(ReturnNode node) {
        return new IRReturnNode(node.expression != null ? generateIR(node.expression) : null);
    }

    // Manejo de declaraciones de campos (FieldDeclNode)
    private static IRNode handleFieldDecl(FieldDeclNode node) {
        ArrayList<IRNode> irFields = new ArrayList<>();
        for (FieldNode field : node.fields) {
            irFields.add(new IRLiteralNode("Field: " + node.type.typeName + " " + field.name));
        }
        return new IRCompositeNode("Fields", irFields); 
    }

    // Manejo de declaraciones de métodos (MethodDeclNode)
    private static IRNode handleMethodDecl(MethodDeclNode node) {
        ArrayList<IRNode> irParams = new ArrayList<>();
        for (ParamNode param : node.params) {
            irParams.add(new IRLiteralNode("Param: " + param.name + " (" + param.type.typeName + ")"));
        }
        IRNode body = generateIR(node.body);
        return new IRMethodNode(node.name, node.returnType.typeName, irParams, body);
    }

    // Manejo de asignaciones (AssignNode)
    private static IRNode handleAssign(AssignNode node) {
        IRNode location = generateIR(node.location);
        IRNode value = generateIR(node.expression);
        return new IRAssignNode(location, value);
    }

    // Manejo de ubicaciones (LocationNode)
    private static IRNode handleLocation(LocationNode node) {
        return new IRLiteralNode("Location: " + node.name);
    }

    // Manejo de llamadas a métodos como declaración (MethodCallStatementNode)
    private static IRNode handleMethodCallStatement(MethodCallStatementNode node) {
        return generateIR(node.methodCall);
    }

    // Manejo del nodo raíz del programa (ProgramNode)
    private static IRNode handleProgramNode(ProgramNode node) {
        ArrayList<IRNode> irFields = new ArrayList<>();
        ArrayList<IRNode> irMethods = new ArrayList<>();

        // Convertir campos (fields) a IR
        for (FieldDeclNode field : node.fields) {
            irFields.add(generateIR(field));
        }

        // Convertir métodos (methods) a IR
        for (MethodDeclNode method : node.methods) {
            irMethods.add(generateIR(method));
        }

        return new IRProgramNode(node.name, irFields, irMethods);
    }
}