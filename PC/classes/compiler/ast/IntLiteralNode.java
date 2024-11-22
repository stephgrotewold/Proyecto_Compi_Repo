package compiler.ast;

public class IntLiteralNode extends LiteralNode {
    private int value;

    public IntLiteralNode(String value, int line, int column) {
        super(Integer.parseInt(value), "int", line, column);
        this.value = Integer.parseInt(value);
    }

    @Override
    public String getType() {
        return "int";
    }

    public Integer getValue() {
        return (Integer)value;
    }
}