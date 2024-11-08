package compiler.ast;

public class IfStatementNode extends StatementNode {
    public ExprNode condition;
    public BlockNode thenBlock;
    public BlockNode elseBlock;

    public IfStatementNode(ExprNode condition, BlockNode thenBlock, BlockNode elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }
    @Override
    public String toString() {
        return "If";
    }
}