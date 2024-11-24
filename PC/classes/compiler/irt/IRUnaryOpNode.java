package compiler.irt;

public class IRUnaryOpNode extends IRNode {
    private String operator;
    private IRNode operand;

    public IRUnaryOpNode(String operator, IRNode operand) {
        this.operator = operator;
        this.operand = operand;
    }

    @Override
    public String toIR() {
        return "(" + operator + " " + operand.toIR() + ")";
    }
}