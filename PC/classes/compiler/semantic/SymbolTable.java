package compiler.semantic;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Symbol> symbols;
    private String currentScope;
    
    public SymbolTable() {
        symbols = new HashMap<>();
        currentScope = "global";
    }
    
    public void enterScope(String scope) {
        currentScope = scope;
    }
    
    public void exitScope() {
        currentScope = "global";
    }
    
    public void addSymbol(String name, String type, String scope, boolean isMethod) {
        Symbol symbol = new Symbol(name, type, scope, isMethod);
        symbols.put(scope + "." + name, symbol);
    }
    
    // Sobrecarga para variables normales
    public void addSymbol(String name, String type, String scope) {
        addSymbol(name, type, scope, false);
    }
    
    // Método adicional para métodos
    public void addMethod(String name, String type, String scope) {
        String key = scope + "." + name;
        if (symbols.containsKey(key)) {
            throw new SemanticException("Method '" + name + "' already declared in scope '" + scope + "'");
        }
        symbols.put(key, new Symbol(name, type, scope, true));
    }

    public void addMethodParam(String methodName, String scope, String paramType) {
        Symbol method = lookup(methodName, scope);
        if (method != null && method.isMethod) {
            method.addParamType(paramType);
        }
    }
    public Symbol lookup(String name, String scope) {
        // Primero buscar en el scope actual
        Symbol symbol = symbols.get(scope + "." + name);
        
        if (symbol != null) {
            return symbol;
        }
        
        // Si no se encuentra y no estamos en el scope global,
        // buscar en el scope global
        if (!scope.equals("global")) {
            symbol = symbols.get("global." + name);
            if (symbol != null) {
                return symbol;
            }
        }
        
        // Si aún no se encuentra, buscar solo por nombre
        return symbols.get(name);
    }

    public boolean isCompatibleType(String expected, String actual) {
        if (expected == null || actual == null) {
            return false;
        }
        
        // Si los tipos son iguales, son compatibles
        if (expected.equals(actual)) {
            return true;
        }
        
        // Manejo especial para void
        if (expected.equals("void")) {
            return actual.equals("void");
        }
        
        return false;
    }
}