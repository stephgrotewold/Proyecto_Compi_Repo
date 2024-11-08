package compiler.ast;

import java.util.ArrayList;

public class ProgramNode extends ASTNode {
    public String name;
    public ArrayList<FieldDeclNode> fields;
    public ArrayList<MethodDeclNode> methods;

    public ProgramNode(String name, ArrayList<FieldDeclNode> fields, ArrayList<MethodDeclNode> methods) {
        this.name = name;
        this.fields = fields;
        this.methods = methods;
    }

    @Override
    public String toString() {
        return "Program: " + name;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        if (fields != null) children.addAll(fields);
        if (methods != null) children.addAll(methods);
        return children;
    }
}