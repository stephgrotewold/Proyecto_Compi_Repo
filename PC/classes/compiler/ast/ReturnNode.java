package compiler.ast;

import java.util.ArrayList;

public class ReturnNode extends StatementNode {
    public ExprNode expression;  // puede ser null para return;

    public ReturnNode(ExprNode expression) {
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