package compiler.ast;

public class LocationNode extends ExprNode {
    public String name;

    public LocationNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location: " + name;
    }
}