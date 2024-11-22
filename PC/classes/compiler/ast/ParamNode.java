package compiler.ast;

import java.util.ArrayList;

public class ParamNode extends ASTNode {
    public TypeNode type;
    public String name;

    public ParamNode(TypeNode type, String name, int line, int column) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.add(type);
        return children;
    }
}