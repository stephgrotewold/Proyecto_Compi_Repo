package compiler.ast;

public class CharLiteralNode extends LiteralNode {
    private char value;

    public CharLiteralNode(char value) {
        super(String.valueOf(value), "char");
        this.value = value;
    }
}