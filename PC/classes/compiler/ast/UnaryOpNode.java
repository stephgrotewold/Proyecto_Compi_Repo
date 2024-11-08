package compiler.ast;

public class UnaryOpNode extends ExprNode {
    public String operator;
    public ExprNode expression;

    public UnaryOpNode(String operator, ExprNode expression) {
        this.operator = operator;
        this.expression = expression;
    }
}
