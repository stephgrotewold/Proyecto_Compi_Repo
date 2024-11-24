package compiler.irt;

import java.util.ArrayList;

public class IRWhileNode extends IRNode {
    private IRNode condition;
    private IRNode body;

    public IRWhileNode(IRNode condition, IRNode body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public String toIR() {
        return "WHILE " + condition.toIR() + " DO " + body.toIR();
    }
}