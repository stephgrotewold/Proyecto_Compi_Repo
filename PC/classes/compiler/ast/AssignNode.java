package compiler.ast;

import java.util.ArrayList;

public class AssignNode extends StatementNode {
    public LocationNode location;
    public String operator;
    public ExprNode expression;

    public AssignNode(LocationNode location, String operator, ExprNode expression, int line, int column) {
        super(line, column);
        this.location = location;
        this.operator = operator;
        this.expression = expression;
    }
    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.add(location);
        children.add(expression);
        return children;
    }
    @Override
    public String toString() {
        return "Assign";
    }
}