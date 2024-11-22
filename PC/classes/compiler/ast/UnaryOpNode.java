package compiler.ast;

import java.util.ArrayList;

public class UnaryOpNode extends ExprNode {
    public String operator;
    public ExprNode expression;

    public UnaryOpNode(String operator, ExprNode expression, int line, int column) {
        super(line, column);
        this.operator = operator;
        this.expression = expression;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.add(expression);
        return children;
    }
}
