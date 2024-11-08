package compiler.ast;

public class CharLiteralNode extends LiteralNode {
    public char value;

    public CharLiteralNode(char value) {
        this.value = value;
    }
}