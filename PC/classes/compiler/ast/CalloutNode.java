package compiler.ast;

import java.util.ArrayList;

public class CalloutNode extends MethodCallNode {
    public ArrayList<CalloutArgNode> calloutArgs;

    public CalloutNode(String function, ArrayList<CalloutArgNode> arguments) {
        super(function, new ArrayList<>()); // Llamada al constructor de MethodCallNode
        this.calloutArgs = arguments;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.addAll(calloutArgs);
        return children;
    }
}