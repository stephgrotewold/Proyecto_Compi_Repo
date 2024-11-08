package compiler.ast;

import java.util.ArrayList;

public abstract class ASTNode {
    public ArrayList<ASTNode> getChildren() {
        return new ArrayList<>();
    }
}