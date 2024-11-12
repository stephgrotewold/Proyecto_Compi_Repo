package compiler.ast;

public class IntLiteralNode extends LiteralNode {
    private int value;

    public IntLiteralNode(int value) {
        super(String.valueOf(value), "int");
        this.value = value;
    }
}