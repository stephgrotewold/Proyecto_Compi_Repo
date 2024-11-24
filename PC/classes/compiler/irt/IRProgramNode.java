package compiler.irt;

import java.util.ArrayList;

public class IRProgramNode extends IRNode {
    private String name;
    private ArrayList<IRNode> fields;
    private ArrayList<IRNode> methods;

    public IRProgramNode(String name, ArrayList<IRNode> fields, ArrayList<IRNode> methods) {
        this.name = name;
        this.fields = fields;
        this.methods = methods;
    }

    @Override
    public String toIR() {
        StringBuilder sb = new StringBuilder();
        sb.append("PROGRAM ").append(name).append(" {\n");

        sb.append("  FIELDS:\n");
        for (IRNode field : fields) {
            sb.append("    ").append(field.toIR()).append("\n");
        }

        sb.append("  METHODS:\n");
        for (IRNode method : methods) {
            sb.append("    ").append(method.toIR()).append("\n");
        }

        sb.append("}");
        return sb.toString();
    }
}