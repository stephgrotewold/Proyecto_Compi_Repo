package compiler.ast;
import java.util.ArrayList;

public class WhileNode extends StatementNode {
    public ExprNode condition;
    public BlockNode body;

    public WhileNode(ExprNode condition, BlockNode body, int line, int column) {
        super(line, column);
        this.condition = condition;
        this.body = body;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.add(condition);
        children.add(body);
        return children;
    }

    @Override
    public String toString() {
        return "WhileNode";
    }
}