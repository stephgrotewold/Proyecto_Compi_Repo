package compiler.ast;

import java.util.ArrayList;

public class BinaryOpNode extends ExprNode {
    public ExprNode left;
    public String operator;
    public ExprNode right;

    public BinaryOpNode(ExprNode left, String operator, ExprNode right, int line, int column) {
        super(line, column);
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.add(left);
        children.add(right);
        return children;
    }

    @Override
    public String toString() {
        return "BinaryOp: " + operator;
    }
}