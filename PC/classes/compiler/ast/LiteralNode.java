package compiler.ast;

import java.util.ArrayList;

public class LiteralNode extends ExprNode {
    private String value;
    private String type;

    public LiteralNode(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Literal: " + value;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        return new ArrayList<>();
    }
}