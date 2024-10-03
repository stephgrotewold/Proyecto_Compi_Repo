package compiler;

import compiler.parser.Lexer; // Cambiado a Lexer
import compiler.parser.sym;
import compiler.parser.Parser;
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

            if (targetStage.equals("scan")) {
                Lexer lexer = new Lexer(fileReader); // Usar el lexer en lugar del scanner
                Symbol token;

                System.out.println("Starting lexical analysis (scanning)...");

                // Recorre los tokens generados por el lexer
                while ((token = lexer.next_token()) != null) {
                    System.out.println("(línea: " + (token.left + 1) + ", columna: " + (token.right + 1) + ", token: " + sym.terminalNames[token.sym] + ")");
                    
                    if (token.sym == sym.EOF) {
                        System.out.println("End of file reached.");
                        break;
                    }
                }

                System.out.println("Lexical analysis (scanning) completed.");

            } else if (targetStage.equals("parse")) {
                Lexer lexer = new Lexer(fileReader); // Usa tu lexer
                Parser parser = new Parser(lexer);  // Instancia el parser con el lexer
                System.out.println("Starting parsing...");

                // Agregar un print para el archivo que se está analizando
                System.out.println("Parsing input from: " + inputFile);
                
                Symbol parseResult = parser.parse(inputFile); // Llama al método parse()

                // Imprime el resultado del parseo
                System.out.println("Resultado del parseo: " + parseResult);
                
                // Aquí puedes agregar más prints según el resultado del parseo.
                System.out.println("Parsing completed successfully.");

            } else if (targetStage.equals("ast")) {
                // Implementar la fase AST si es necesario
            }
        } catch (IOException e) {
            System.out.println("File not found: " + inputFile);
        } catch (Exception e) {
            System.out.println("Error during parsing: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
