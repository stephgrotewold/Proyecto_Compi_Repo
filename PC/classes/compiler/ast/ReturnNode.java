package compiler.ast;

import java.util.ArrayList;

public class ReturnNode extends StatementNode {
    public ExprNode expression;  // puede ser null para return;

    public ReturnNode(ExprNode expression, int line, int column) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        if (expression != null) {
            children.add(expression);
        }
        return children;
    }
}