package compiler.ast;

import java.util.ArrayList;

public abstract class ASTNode {
    protected int line;
    protected int column;

    public ASTNode(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public abstract ArrayList<ASTNode> getChildren();
}