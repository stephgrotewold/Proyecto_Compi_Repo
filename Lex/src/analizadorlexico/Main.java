package analizadorlexico;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String inputFile = "test/test.txt";
        Scanner scanner = new Scanner();

        try {
            String absolutePath = Paths.get(inputFile).toAbsolutePath().toString();
            LinkedList<Token> tokens = scanner.scanFile(absolutePath);
            for (Token token : tokens) {
                System.out.println(token);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
