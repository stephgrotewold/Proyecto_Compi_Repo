package compiler.ast;
import java.util.ArrayList;

public class BreakStatementNode extends StatementNode {
    public BreakStatementNode(int line, int column) {
        super(line, column);
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        return new ArrayList<>();
    }
}