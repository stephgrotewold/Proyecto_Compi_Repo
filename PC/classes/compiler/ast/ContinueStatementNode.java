package compiler.ast;
import java.util.ArrayList;

public class ContinueStatementNode extends StatementNode {
    public ContinueStatementNode(int line, int column) {
        super(line, column);
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        return new ArrayList<>();
    }
}