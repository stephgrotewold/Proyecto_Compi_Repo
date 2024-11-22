package compiler.ast;

import java.util.ArrayList;
import java.util.List;

public class MethodCallNode extends ExprNode {
    public String name;
    public List<ExprNode> arguments;

    public MethodCallNode(String name, List<ExprNode> arguments, int line, int column) {
        super(line, column);
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