package compiler.ast;

public class BooleanLiteralNode extends LiteralNode {
    public boolean value;

    public BooleanLiteralNode(boolean value) {
        this.value = value;
    }
}