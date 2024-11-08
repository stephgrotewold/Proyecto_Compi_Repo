package compiler.ast;

public class MethodCallStatementNode extends StatementNode {
    public MethodCallNode methodCall;

    public MethodCallStatementNode(MethodCallNode methodCall) {
        this.methodCall = methodCall;
    }
}