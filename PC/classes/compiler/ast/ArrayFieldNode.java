package compiler.ast;

public class ArrayFieldNode extends FieldNode {
    public int size;

    public ArrayFieldNode(String name, int size) {
        super(name);
        this.size = size;
    }
}