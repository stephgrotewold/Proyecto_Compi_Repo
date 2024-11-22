package compiler.ast;

public class ArrayFieldNode extends FieldNode {
    public int size;

    public ArrayFieldNode(String name, int size, int line, int column) {
        super(name, line, column);
        this.size = size;
    }
}