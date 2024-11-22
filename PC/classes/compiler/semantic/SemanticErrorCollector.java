package compiler.semantic;

import java.util.ArrayList;
import java.util.List;

public class SemanticErrorCollector {
    private List<SemanticError> errors;

    public SemanticErrorCollector() {
        this.errors = new ArrayList<>();
    }

    public void addError(String message, int line, int column) {
        errors.add(new SemanticError(message, line, column));
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void reportErrors() {
        if (hasErrors()) {
            System.err.println("Semantic errors found:");
            for (SemanticError error : errors) {
                System.err.printf("- Line %d, Column %d: %s%n", 
                    error.line, error.column, error.message);
            }
            throw new SemanticException("Multiple semantic errors found");
        }
    }

    private static class SemanticError {
        String message;
        int line;
        int column;

        SemanticError(String message, int line, int column) {
            this.message = message;
            this.line = line;
            this.column = column;
        }
    }
}