package compiler.ast;

import java.util.ArrayList;

public class MethodCallNode extends ExprNode {
    public String name;
    public ArrayList<ExprNode> arguments;

    public MethodCallNode(String name, ArrayList<ExprNode> arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.addAll(arguments);
        return children;
    }
}