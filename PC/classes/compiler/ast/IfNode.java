package compiler.ast;

import java.util.ArrayList;

public class IfNode extends StatementNode {
    public ExprNode condition;
    public BlockNode thenBlock;
    public BlockNode elseBlock;  // puede ser null

    public IfNode(ExprNode condition, BlockNode thenBlock, BlockNode elseBlock, int line, int column) {
        super(line, column);
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.add(condition);
        children.add(thenBlock);
        if (elseBlock != null) {
            children.add(elseBlock);
        }
        return children;
    }
}