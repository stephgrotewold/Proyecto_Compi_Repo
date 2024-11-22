package compiler.ast;

import java.util.ArrayList;

public class TypeNode extends ASTNode {
    public String typeName;

    public TypeNode(String typeName, int line, int column) {
        super(line, column);
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }
    @Override
    public ArrayList<ASTNode> getChildren() {
        return new ArrayList<>();
    }
}