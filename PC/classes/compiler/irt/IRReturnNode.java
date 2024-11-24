package compiler.irt;

public class IRReturnNode extends IRNode {
    private IRNode expression;

    public IRReturnNode(IRNode expression) {
        this.expression = expression;
    }

    @Override
    public String toIR() {
        return "RETURN " + (expression != null ? expression.toIR() : "void");
    }
}