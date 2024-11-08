package compiler.ast;

public class CalloutArgNode extends ASTNode {
    public Object value; // Can be ExprNode or String

    public CalloutArgNode(Object value) {
        this.value = value;
    }
}