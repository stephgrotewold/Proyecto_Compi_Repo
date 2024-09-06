package analizadorlexico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Scanner {
    private static final int ARITH_OP = 1;
    private static final int DIGIT = 2;
    private static final int ALPHA = 3;
    private static final int ID = 4;
    private static final int UNKNOWN = 5;

    private LinkedList<Token> tokens;
    private int line;
    private int column;

    public Scanner() {
        tokens = new LinkedList<>();
        line = 1;
        column = 0;
    }

    public LinkedList<Token> scanFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scanLine(line);
                this.line++;
                this.column = 0;
            }
        }
        return tokens;
    }

    private void scanLine(String line) {
        StringBuilder buffer = new StringBuilder();
        for (char c : line.toCharArray()) {
            column++;
            if (isArithOp(c)) {
                addToken(buffer);
                tokens.add(new Token(ARITH_OP, String.valueOf(c), this.line, column));
            } else if (Character.isDigit(c)) {
                buffer.append(c);
            } else if (Character.isLetter(c)) {
                buffer.append(c);
            } else if (Character.isWhitespace(c)) {
                addToken(buffer);
            } else {
                addToken(buffer);
                tokens.add(new Token(UNKNOWN, String.valueOf(c), this.line, column));
            }
        }
        addToken(buffer);
    }

    private void addToken(StringBuilder buffer) {
        if (buffer.length() > 0) {
            String value = buffer.toString();
            int type = determineType(value);
            tokens.add(new Token(type, value, line, column - value.length() + 1));
            buffer.setLength(0);
        }
    }

    private int determineType(String value) {
        if (value.matches("\\d+")) return DIGIT;
        if (value.matches("[a-zA-Z][a-zA-Z0-9]*")) return ID;
        if (value.matches("[a-zA-Z]")) return ALPHA;
        return UNKNOWN;
    }

    private boolean isArithOp(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }
}
