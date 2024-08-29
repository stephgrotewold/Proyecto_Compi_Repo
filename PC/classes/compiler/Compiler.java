package compiler;
import compiler.scanner.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Compiler {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No input file provided.");
            return;
        }

        String targetStage = "codegen"; // Default stage
        String inputFile = null;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-target":
                    if (i + 1 < args.length) {
                        targetStage = args[++i];
                    } else {
                        System.out.println("Error: -target requires an argument.");
                        return;
                    }
                    break;
                default:
                    inputFile = args[i];
                    break;
            }
        }

        if (inputFile == null) {
            System.out.println("No input file provided.");
            return;
        }

        try (FileReader fileReader = new FileReader(inputFile)) {
            // Aquí es donde realizarías las operaciones del compilador
            System.out.println("Compiling " + inputFile + " to stage: " + targetStage);

            // Dependiendo de la etapa solicitada, llama a las clases necesarias
            if (targetStage.equals("scan")) {
                Scanner scanner = new Scanner(fileReader);
                // Ejecuta la fase de escaneo
            } else if (targetStage.equals("parse")) {
                // Ejecuta la fase de parsing
            } else if (targetStage.equals("ast")) {
                // Ejecuta la fase de AST
            }
            // Continúa con las otras fases según sea necesario
        } catch (IOException e) {
            System.out.println("File not found: " + inputFile);
        }
    }
}