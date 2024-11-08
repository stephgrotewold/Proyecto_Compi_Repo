package compiler.ast;

public class TypeNode extends ASTNode {
    public String typeName;

    public TypeNode(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }
}