package compiler;

import compiler.lexer.Lexer; // Cambiado a Lexer
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
                try {
                    Lexer lexer = new Lexer(fileReader);
                    Symbol token;
            
                    System.out.println("Starting lexical analysis (scanning)...");
            
                    while ((token = lexer.next_token()) != null) {
                        String tokenValue = token.value != null ? ", value: " + token.value : "";
                        System.out.printf("(línea: %d, columna: %d, token: %s%s)\n", 
                            token.left, token.right, 
                            sym.terminalNames[token.sym], tokenValue);
                        
                        if (token.sym == sym.EOF) {
                            System.out.println("End of file reached.");
                            break;
                        }
                    }
            
                    System.out.println("Lexical analysis (scanning) completed.");
                } catch (Exception e) {
                    System.err.println("Error during lexical analysis: " + e.getMessage());
                    e.printStackTrace();
                }
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
