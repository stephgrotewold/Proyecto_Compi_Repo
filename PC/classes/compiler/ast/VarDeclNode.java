package compiler.ast;

import java.util.ArrayList;

public class VarDeclNode extends ASTNode {
    public TypeNode type;
    public ArrayList<String> variables;

    public VarDeclNode(TypeNode type, ArrayList<String> variables) {
        this.type = type;
        this.variables = variables;
    }

    @Override
    public String toString() {
        return "Var: " + variables + " : " + type;  // Usar variables en lugar de name
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.add(type);
        return children;
    }
}