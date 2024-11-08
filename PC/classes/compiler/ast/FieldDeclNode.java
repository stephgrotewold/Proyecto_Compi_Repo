package compiler.ast;

import java.util.ArrayList;

public class FieldDeclNode extends ASTNode {
    public TypeNode type;
    public ArrayList<FieldNode> fields;

    public FieldDeclNode(TypeNode type, ArrayList<FieldNode> fields) {
        this.type = type;
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Field Declaration: " + type;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.add(type);
        if (fields != null) {
            children.addAll(fields);
        }
        return children;
    }
}