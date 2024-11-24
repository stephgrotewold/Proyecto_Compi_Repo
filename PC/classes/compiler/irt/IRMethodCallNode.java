package compiler.irt;

import java.util.ArrayList;

public class IRMethodCallNode extends IRNode {
    private String methodName;
    private ArrayList<IRNode> arguments;

    public IRMethodCallNode(String methodName, ArrayList<IRNode> arguments) {
        this.methodName = methodName;
        this.arguments = arguments;
    }

    @Override
    public String toIR() {
        StringBuilder sb = new StringBuilder();
        sb.append("CALL ").append(methodName).append("(");
        for (int i = 0; i < arguments.size(); i++) {
            sb.append(arguments.get(i).toIR());
            if (i < arguments.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}