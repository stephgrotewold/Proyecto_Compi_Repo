package compiler.irt;

public class IRIfNode extends IRNode {
    private IRNode condition;
    private IRNode thenBlock;
    private IRNode elseBlock;

    public IRIfNode(IRNode condition, IRNode thenBlock, IRNode elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public String toIR() {
        String result = "IF " + condition.toIR() + " THEN " + thenBlock.toIR();
        if (elseBlock != null) {
            result += " ELSE " + elseBlock.toIR();
        }
        return result;
    }
}