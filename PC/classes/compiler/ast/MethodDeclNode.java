package compiler.ast;

import java.util.ArrayList;

public class MethodDeclNode extends ASTNode {
    public TypeNode returnType;
    public String name;
    public ArrayList<ParamNode> params;
    public BlockNode body;

    public MethodDeclNode(TypeNode returnType, String name, ArrayList<ParamNode> params, BlockNode body, int line, int column) {
        super(line, column);
        this.returnType = returnType;
        this.name = name;
        this.params = params;
        this.body = body;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.add(returnType);
        children.addAll(params);
        children.add(body);
        return children;
    }

    @Override
    public String toString() {
        return "Method: " + name + " : " + returnType;
    }
}