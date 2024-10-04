# Makefile for Compiler Project

# Directories
LIB_DIR = lib
CLASSES_DIR = classes
PARSER_DIR = $(CLASSES_DIR)/compiler/parser

# JAR files
JFLEX_JAR = $(LIB_DIR)/jflex-1.9.1.jar
CUP_JAR = $(LIB_DIR)/java-cup-11b.jar
CUP_RUNTIME_JAR = $(LIB_DIR)/java-cup-11b-runtime.jar

# Java compiler
JAVAC = javac
JAVA = java

# Classpath
CLASSPATH = $(CUP_RUNTIME_JAR):$(CLASSES_DIR)

# Targets
all: lexer parser compile

lexer:
	$(JAVA) -cp "$(JFLEX_JAR):$(CUP_RUNTIME_JAR)" jflex.Main $(PARSER_DIR)/Lexer.flex

parser: | $(PARSER_DIR)
	$(JAVA) -jar $(CUP_JAR) -parser Parser -symbols sym -destdir $(PARSER_DIR) $(PARSER_DIR)/Parser.cup

$(PARSER_DIR):
	mkdir -p $(PARSER_DIR)

compile:
	$(JAVAC) -cp "$(CUP_RUNTIME_JAR):." -d $(CLASSES_DIR) $(CLASSES_DIR)/compiler/*.java $(PARSER_DIR)/*.java

scan: compile
	$(JAVA) -cp $(CLASSPATH) compiler.Compiler -target scan simple.decaf

parse: compile
	$(JAVA) -cp $(CLASSPATH) compiler.Compiler -target parse simple.decaf

clean:
	rm -f $(PARSER_DIR)/Lexer.java $(PARSER_DIR)/sym.java $(PARSER_DIR)/Parser.java
	find $(CLASSES_DIR) -name "*.class" -type f -delete

.PHONY: all lexer parser compile scan parse clean
