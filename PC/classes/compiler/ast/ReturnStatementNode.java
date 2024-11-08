package compiler.ast;

public class ReturnStatementNode extends StatementNode {
    public ExprNode expression;

    public ReturnStatementNode(ExprNode expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Return";
    }
}