package compiler.ast;

public class CharLiteralNode extends LiteralNode {
    private char value;

    public CharLiteralNode(char value, int line, int column) {
        super(String.valueOf(value), "char", line, column);
        this.value = value;
    }

    @Override
    public String getType() {
        return "char";
    }

    public Character getValue() {
        return (Character)value;
    }
}