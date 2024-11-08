package compiler.ast;

public class BinOpNode extends ExprNode {
    public String operator;
    public ExprNode left;
    public ExprNode right;

    public BinOpNode(String operator, ExprNode left, ExprNode right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Op: " + operator;
    }
}