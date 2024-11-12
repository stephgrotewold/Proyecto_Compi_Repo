package compiler.ast;

public class BooleanLiteralNode extends LiteralNode {
    private boolean value;

    public BooleanLiteralNode(boolean value) {
        super(String.valueOf(value), "boolean");
        this.value = value;
    }
}