package compiler.ast;

public class BooleanLiteralNode extends LiteralNode {
    private boolean value;

    public BooleanLiteralNode(boolean value, int line, int column) {
        super(Boolean.valueOf(value), "boolean", line, column);
        this.value = value;
    }

    @Override
    public String getType() {
        return "boolean";
    }

    public Boolean getValue() {
        return (Boolean)value;
    }
}