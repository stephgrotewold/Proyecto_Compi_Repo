package compiler.ast;

import java.util.ArrayList;

public abstract class LiteralNode extends ExprNode {
    protected Object value;
    protected String type;

    public LiteralNode(Object value, String type, int line, int column) {
        super(line, column);
        this.value = value;
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public String getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Literal: " + value + " (" + type + ")";
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        return new ArrayList<>();
    }
}