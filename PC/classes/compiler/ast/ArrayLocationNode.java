package compiler.ast;

public class ArrayLocationNode extends LocationNode {
    public ExprNode index;

    public ArrayLocationNode(String name, ExprNode index) {
        super(name);
        this.index = index;
    }
}