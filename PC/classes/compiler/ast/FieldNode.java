package compiler.ast;

import java.util.ArrayList;

public class FieldNode extends ASTNode {
    public String name;

    public FieldNode(String name, int line, int column) {
        super(line, column);
        this.name = name;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        return new ArrayList<>();
    }
}