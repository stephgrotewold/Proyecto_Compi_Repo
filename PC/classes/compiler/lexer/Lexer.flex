package compiler.lexer;

import java_cup.runtime.*;
import compiler.parser.sym;

%%

%public
%class Lexer
%cup
%unicode
%line
%column

%{
  private Symbol symbol(int type) {
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline + 1, yycolumn + 1, value);
  }

  public void printToken(Symbol token) {
    System.out.printf("(línea: %d, columna: %d, token: %s, valor: %s)\n",
        token.left, token.right, sym.terminalNames[token.sym], token.value);
  }
%}

%%

// Palabras clave
"class"      { return symbol(sym.CLASS, yytext()); }
"int"        { return symbol(sym.INT, yytext()); }
"void"       { return symbol(sym.VOID, yytext()); }
"boolean"    { return symbol(sym.BOOLEAN, yytext()); }
"true"       { return symbol(sym.TRUE, yytext()); }
"false"      { return symbol(sym.FALSE, yytext()); }
"if"         { return symbol(sym.IF, yytext()); }
"else"       { return symbol(sym.ELSE, yytext()); }
"for"        { return symbol(sym.FOR, yytext()); }
"return"     { return symbol(sym.RETURN, yytext()); }
"break"      { return symbol(sym.BREAK, yytext()); }
"continue"   { return symbol(sym.CONTINUE, yytext()); }
"callout"    { return symbol(sym.CALLOUT, yytext()); }

// Operadores y símbolos
"="          { return symbol(sym.ASSIGN, yytext()); }
"=="         { return symbol(sym.EQ, yytext()); }
"!="         { return symbol(sym.NEQ, yytext()); }
"<"          { return symbol(sym.LT, yytext()); }
">"          { return symbol(sym.GT, yytext()); }
"<="         { return symbol(sym.LTE, yytext()); }
">="         { return symbol(sym.GTE, yytext()); }
"&&"         { return symbol(sym.AND, yytext()); }
"||"         { return symbol(sym.OR, yytext()); }
"!"          { return symbol(sym.NOT, yytext()); }
"+"          { return symbol(sym.PLUS, yytext()); }
"-"          { return symbol(sym.MINUS, yytext()); }
"*"          { return symbol(sym.TIMES, yytext()); }
"/"          { return symbol(sym.DIVIDE, yytext()); }
"%"          { return symbol(sym.MOD, yytext()); }
"+="         { return symbol(sym.PLUS_ASSIGN, yytext()); }
"-="         { return symbol(sym.MINUS_ASSIGN, yytext()); }
";"          { return symbol(sym.SEMI, yytext()); }
","          { return symbol(sym.COMMA, yytext()); }

// Agrupaciones
"{"          { return symbol(sym.LCURLY, yytext()); }
"}"          { return symbol(sym.RCURLY, yytext()); }
"("          { return symbol(sym.LPAREN, yytext()); }
")"          { return symbol(sym.RPAREN, yytext()); }
"["          { return symbol(sym.LBRACKET, yytext()); }
"]"          { return symbol(sym.RBRACKET, yytext()); }

// Literales numéricos
[0-9]+       { return symbol(sym.INT_LITERAL, Integer.parseInt(yytext())); }
0x[0-9A-Fa-f]+ { return symbol(sym.INT_LITERAL, Integer.parseInt(yytext().substring(2), 16)); }

// Literales de caracteres
'[^'\n]'     { return symbol(sym.CHAR_LITERAL, yytext().charAt(1)); }
'\\[ntr\\\']' { return symbol(sym.CHAR_LITERAL, yytext().charAt(1) == 'n' ? '\n' : 
                                                   yytext().charAt(1) == 't' ? '\t' : 
                                                   yytext().charAt(1) == 'r' ? '\r' : 
                                                   yytext().charAt(1)); }

// Literales de cadenas
\"[^\"]*\"   { return symbol(sym.STRING_LITERAL, yytext().substring(1, yytext().length() - 1)); }

// Identificadores
"Program"    { return symbol(sym.PROGRAM_ID, yytext()); }
[a-zA-Z][a-zA-Z0-9_]* { return symbol(sym.ID, yytext()); }

// Saltos de línea y espacios en blanco
[ \t\r\n]+   { /* ignore whitespace */ }

// Comentarios
"//".*       { /* Ignorar comentarios de una línea */ }
"/*"([^*]|\*+[^*/])*\*+"/" { /* Ignorar comentarios multilínea */ }

// Manejo de errores
.            { 
    throw new RuntimeException("Caracter ilegal: '" + yytext() + "' en la línea " + (yyline + 1) + ", columna " + (yycolumn + 1));
}

<<EOF>>      { return symbol(sym.EOF); }
