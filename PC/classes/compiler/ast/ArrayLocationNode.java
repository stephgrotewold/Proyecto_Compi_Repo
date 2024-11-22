package compiler.ast;

public class ArrayLocationNode extends LocationNode {
    public ExprNode index;

    public ArrayLocationNode(String name, ExprNode index, int line, int column) {
        super(name, line, column);
        this.index = index;
    }
}