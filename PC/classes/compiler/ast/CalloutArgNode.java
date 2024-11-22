package compiler.ast;

import java.util.ArrayList;

public class CalloutArgNode extends ASTNode {
    public Object value; // Can be ExprNode or String

    public CalloutArgNode(Object value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        if (value instanceof ASTNode) {
            children.add((ASTNode) value);
        }
        return children;
    }
}