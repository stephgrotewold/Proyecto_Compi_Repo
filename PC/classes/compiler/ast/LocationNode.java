package compiler.ast;

import java.util.ArrayList;

public class LocationNode extends ExprNode {
    public String name;

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        return children;
    }

    public LocationNode(String name, int line, int column) {
        super(line, column);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location: " + name;
    }
}