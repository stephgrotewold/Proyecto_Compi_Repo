package compiler.irt;

public class IRLiteralNode extends IRNode {
    private String value;

    public IRLiteralNode(String value) {
        this.value = value;
    }

    @Override
    public String toIR() {
        return value;
    }
}