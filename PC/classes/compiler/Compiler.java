package compiler;

import compiler.scanner.Scanner;
import compiler.parser.sym;
import java.io.FileReader;
import java.io.IOException;
import java_cup.runtime.Symbol;

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
            System.out.println("Compiling " + inputFile + " to stage: " + targetStage);

            // Dependiendo de la etapa solicitada, llama a las clases necesarias
            if (targetStage.equals("scan")) {
                Scanner scanner = new Scanner(fileReader);
                Symbol token;
                
                System.out.println("Starting lexical analysis (scanning)...");

                // Recorre los tokens generados por el scanner
                while ((token = scanner.next_token()) != null) {
                    // Imprime el token, su línea y columna
                    System.out.println("(línea: " + (token.left + 1) + ", columna: " + (token.right + 1) + ", token: " + sym.terminalNames[token.sym] + ")");
                    
                    // Para detener al final del archivo (EOF)
                    if (token.sym == sym.EOF) {
                        System.out.println("End of file reached.");
                        break;
                    }
                }

                System.out.println("Lexical analysis (scanning) completed.");

            } else if (targetStage.equals("parse")) {
                // Ejecuta la fase de parsing (a completar)
            } else if (targetStage.equals("ast")) {
                // Ejecuta la fase de AST (a completar)
            }
            // Continúa con las otras fases según sea necesario
        } catch (IOException e) {
            System.out.println("File not found: " + inputFile);
        }
    }
}