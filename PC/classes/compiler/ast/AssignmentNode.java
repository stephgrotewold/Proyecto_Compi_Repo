package compiler.ast;

public class AssignmentNode extends StatementNode {
    public LocationNode location;
    public String operator;
    public ExprNode expression;

    public AssignmentNode(LocationNode location, String operator, ExprNode expression) {
        this.location = location;
        this.operator = operator;
        this.expression = expression;
    }
    @Override
    public String toString() {
        return "Assign";
    }
}