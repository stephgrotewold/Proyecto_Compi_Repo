package compiler.irt;

import java.util.ArrayList;

public class IRMethodNode extends IRNode {
    private String name;
    private String returnType;
    private ArrayList<IRNode> params;
    private IRNode body;

    public IRMethodNode(String name, String returnType, ArrayList<IRNode> params, IRNode body) {
        this.name = name;
        this.returnType = returnType;
        this.params = params;
        this.body = body;
    }

    @Override
    public String toIR() {
        StringBuilder sb = new StringBuilder();
        sb.append("METHOD ").append(name).append(" (").append(returnType).append(") {\n");
        sb.append("  PARAMETERS:\n");
        for (IRNode param : params) {
            sb.append("    ").append(param.toIR()).append("\n");
        }
        sb.append("  BODY:\n");
        sb.append("    ").append(body.toIR()).append("\n");
        sb.append("}");
        return sb.toString();
    }
}