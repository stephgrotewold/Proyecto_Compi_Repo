package compiler.irt;

import java.util.ArrayList;

public class IRCompositeNode extends IRNode {
    private String name;
    private ArrayList<IRNode> children;

    public IRCompositeNode(String name, ArrayList<IRNode> children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public String toIR() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" {\n");
        for (IRNode child : children) {
            sb.append("  ").append(child.toIR()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}