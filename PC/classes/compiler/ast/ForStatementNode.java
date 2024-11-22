package compiler.ast;

import java.util.ArrayList;

public class ForStatementNode extends StatementNode {
    public String variable;
    public ExprNode initExpr;
    public ExprNode condition;
    public BlockNode body;

    public ForStatementNode(String variable, ExprNode initExpr, ExprNode condition, BlockNode body, int line, int column) {
        super(line, column);
        this.variable = variable;
        this.initExpr = initExpr;
        this.condition = condition;
        this.body = body;
    }
    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.add(initExpr);
        children.add(condition);
        children.add(body);
        return children;
    }
}