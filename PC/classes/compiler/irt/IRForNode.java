package compiler.irt;

public class IRForNode extends IRNode {
    private IRNode init;
    private IRNode condition;
    private IRNode update;
    private IRNode body;

    public IRForNode(IRNode init, IRNode condition, IRNode update, IRNode body) {
        this.init = init;
        this.condition = condition;
        this.update = update;
        this.body = body;
    }

    @Override
    public String toIR() {
        return "FOR (" + (init != null ? init.toIR() : "") + "; " + 
               condition.toIR() + "; " + 
               (update != null ? update.toIR() : "") + ") DO " + body.toIR();
    }
}