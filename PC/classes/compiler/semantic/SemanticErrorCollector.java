package compiler.semantic;

import java.util.ArrayList;
import java.util.List;

public class SemanticErrorCollector {
    private List<String> errors;

    public SemanticErrorCollector() {
        this.errors = new ArrayList<>();
    }

    public void addError(String error) {
        errors.add(error);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void reportErrors() {
        if (hasErrors()) {
            System.err.println("Semantic errors found:");
            for (String error : errors) {
                System.err.println("- " + error);
            }
            throw new SemanticException("Multiple semantic errors found");
        }
    }
}