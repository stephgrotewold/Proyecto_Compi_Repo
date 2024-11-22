package compiler.ast;

public abstract class ExprNode extends ASTNode {
    public ExprNode(int line, int column) {
        super(line, column);
    }
}