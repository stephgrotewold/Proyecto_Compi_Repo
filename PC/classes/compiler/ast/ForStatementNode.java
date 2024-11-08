package compiler.ast;

public class ForStatementNode extends StatementNode {
    public String variable;
    public ExprNode initExpr;
    public ExprNode condition;
    public BlockNode body;

    public ForStatementNode(String variable, ExprNode initExpr, ExprNode condition, BlockNode body) {
        this.variable = variable;
        this.initExpr = initExpr;
        this.condition = condition;
        this.body = body;
    }
}