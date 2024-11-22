package compiler.ast;

import java.util.ArrayList;

public class BlockNode extends StatementNode {
    public ArrayList<VarDeclNode> varDeclarations;
    public ArrayList<StatementNode> statements;

    public BlockNode(ArrayList<VarDeclNode> varDeclarations, ArrayList<StatementNode> statements, int line, int column) {
        super(line, column);
        this.varDeclarations = varDeclarations;
        this.statements = statements;
    }
    @Override
    public String toString() {
        return "Block";
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.addAll(statements);
        return children;
    }
}