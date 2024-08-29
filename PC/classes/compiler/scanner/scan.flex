package compiler.scanner;

import java_cup.runtime.*;

%%

%class Scanner
%cup
%line
%column

%{
  // Código de usuario que se insertará en la clase Scanner
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }
%}

// Definiciones de macros
ID = [a-zA-Z][a-zA-Z0-9_]*
INTLITERAL = [0-9]+
STRINGLITERAL = \"([^\"]*)\"

%%

// Palabras clave
"class"      { return symbol(sym.CLASS, yytext()); }
"if"         { return symbol(sym.IF, yytext()); }
"else"       { return symbol(sym.ELSE, yytext()); }
"while"      { return symbol(sym.WHILE, yytext()); }
"return"     { return symbol(sym.RETURN, yytext()); }
"true"       { return symbol(sym.TRUE, yytext()); }
"false"      { return symbol(sym.FALSE, yytext()); }
"new"        { return symbol(sym.NEW, yytext()); }
"int"        { return symbol(sym.INT, yytext()); }
"bool"       { return symbol(sym.BOOL, yytext()); }
"string"     { return symbol(sym.STRING, yytext()); }
"void"       { return symbol(sym.VOID, yytext()); }
"this"       { return symbol(sym.THIS, yytext()); }

// Identificadores y literales
{ID}         { return symbol(sym.ID, yytext()); }
{INTLITERAL} { return symbol(sym.INTLITERAL, Integer.parseInt(yytext())); }
{STRINGLITERAL} { return symbol(sym.STRINGLITERAL, yytext()); }

// Operadores y símbolos
"{"          { return symbol(sym.LBRACE, yytext()); }
"}"          { return symbol(sym.RBRACE, yytext()); }
"="          { return symbol(sym.ASSIGN, yytext()); }
";"          { return symbol(sym.SEMICOLON, yytext()); }
"("          { return symbol(sym.LPAREN, yytext()); }
")"          { return symbol(sym.RPAREN, yytext()); }
"<"          { return symbol(sym.LT, yytext()); }
">"          { return symbol(sym.GT, yytext()); }
"+"          { return symbol(sym.PLUS, yytext()); }
"-"          { return symbol(sym.MINUS, yytext()); }
"*"          { return symbol(sym.TIMES, yytext()); }
"/"          { return symbol(sym.DIVIDE, yytext()); }
"&&"         { return symbol(sym.AND, yytext()); }
"||"         { return symbol(sym.OR, yytext()); }

// Ignorar espacios en blanco y comentarios
[ \t\r\n\f]  { /* Ignorar espacios en blanco */ }
"//".*       { /* Ignorar comentarios de una línea */ }
"/*"[^*]*"*/"  { /* Ignorar comentarios de múltiples líneas */ }

// Manejar caracteres ilegales
.            { throw new RuntimeException("Caracter ilegal: " + yytext()); }
