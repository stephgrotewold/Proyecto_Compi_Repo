package compiler.semantic;

import java.util.ArrayList;
import java.util.List;

public class Symbol {
    public String name;
    public String type;
    public String scope;
    public boolean isMethod;
    public List<String> paramTypes; 
    
    public Symbol(String name, String type, String scope, boolean isMethod) {
        this.name = name;
        this.type = type;
        this.scope = scope;
        this.isMethod = isMethod;
        this.paramTypes = new ArrayList<>();
    }

    public void addParamType(String paramType) {
        paramTypes.add(paramType);
    }

    @Override
    public String toString() {
        return String.format("%s %s (scope: %s)", type, name, scope);
    }
}