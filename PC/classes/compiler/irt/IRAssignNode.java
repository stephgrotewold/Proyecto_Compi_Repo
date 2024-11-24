package compiler.irt;

public class IRAssignNode extends IRNode {
    private IRNode location;
    private IRNode value;

    public IRAssignNode(IRNode location, IRNode value) {
        this.location = location;
        this.value = value;
    }

    @Override
    public String toIR() {
        return location.toIR() + " = " + value.toIR();
    }
}