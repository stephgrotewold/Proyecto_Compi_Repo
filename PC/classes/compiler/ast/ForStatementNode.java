package compiler.ast;

import java.util.ArrayList;

public class ForStatementNode extends StatementNode {
    public String variable;
    public ExprNode initExpr;
    public ExprNode condition;
    public ExprNode updateExpr; // Opcional
    public BlockNode body;

    // Constructor sin updateExpr
    public ForStatementNode(String variable, ExprNode initExpr, ExprNode condition, BlockNode body, int line, int column) {
        super(line, column);
        this.variable = variable;
        this.initExpr = initExpr;
        this.condition = condition;
        this.updateExpr = null; // Asignar null por defecto
        this.body = body;
    }

    // Constructor con updateExpr
    public ForStatementNode(String variable, ExprNode initExpr, ExprNode condition, ExprNode updateExpr, BlockNode body, int line, int column) {
        super(line, column);
        this.variable = variable;
        this.initExpr = initExpr;
        this.condition = condition;
        this.updateExpr = updateExpr;
        this.body = body;
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        children.add(initExpr);
        children.add(condition);
        if (updateExpr != null) {
            children.add(updateExpr);
        }
        children.add(body);
        return children;
    }

    @Override
    public String toString() {
        return "ForStatement(variable=" + variable + ")";
    }
}