package compiler.irt;

public class IRBinaryOpNode extends IRNode {
    private String operator;
    private IRNode left;
    private IRNode right;

    public IRBinaryOpNode(String operator, IRNode left, IRNode right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toIR() {
        return "(" + left.toIR() + " " + operator + " " + right.toIR() + ")";
    }
}