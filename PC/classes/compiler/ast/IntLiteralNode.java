package compiler.ast;

public class IntLiteralNode extends LiteralNode {
    public int value;

    public IntLiteralNode(int value) {
        this.value = value;
    }
}