package compiler.ast;

import java.util.ArrayList;

public class MethodCallStatementNode extends StatementNode {
    public MethodCallNode methodCall;

    public MethodCallStatementNode(MethodCallNode methodCall, int line, int column) {
        super(line, column);
        this.methodCall = methodCall;
    }
    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.add(methodCall);
        return children;
    }
}