# Makefile for Compiler Project

# Directories
LIB_DIR = lib
SRC_DIR = classes
BUILD_DIR = $(SRC_DIR)/build
PARSER_DIR = $(SRC_DIR)/compiler/parser
LEXER_DIR = $(SRC_DIR)/compiler/lexer
BUILD_PARSER_DIR = $(BUILD_DIR)/compiler/parser
BUILD_LEXER_DIR = $(BUILD_DIR)/compiler/lexer

# JAR files
JFLEX_JAR = $(LIB_DIR)/jflex-1.9.1.jar
CUP_JAR = $(LIB_DIR)/java-cup-11b.jar
CUP_RUNTIME_JAR = $(LIB_DIR)/java-cup-11b-runtime.jar

# Java compiler
JAVAC = javac
JAVA = java

# Classpath
CLASSPATH = $(CUP_RUNTIME_JAR):$(SRC_DIR)

# Targets
all: lexer parser compile

lexer: | $(LEXER_DIR)
	$(JAVA) -cp "$(JFLEX_JAR):$(CUP_RUNTIME_JAR)" jflex.Main -d $(LEXER_DIR) $(LEXER_DIR)/Lexer.flex

parser: | $(PARSER_DIR)
	$(JAVA) -jar $(CUP_JAR) -parser Parser -symbols sym -destdir $(PARSER_DIR) $(PARSER_DIR)/Parser.cup

$(PARSER_DIR):
	mkdir -p $(PARSER_DIR)

$(LEXER_DIR):
	mkdir -p $(LEXER_DIR)

$(BUILD_DIR) $(BUILD_PARSER_DIR) $(BUILD_LEXER_DIR):
	mkdir -p $@

compile: lexer parser | $(BUILD_DIR) $(BUILD_PARSER_DIR) $(BUILD_LEXER_DIR)
	$(JAVAC) -cp "$(CLASSPATH)" -d $(BUILD_DIR) \
		$(SRC_DIR)/compiler/*.java \
		$(PARSER_DIR)/*.java \
		$(LEXER_DIR)/*.java

scan: compile
	$(JAVA) -cp $(CLASSPATH):$(BUILD_DIR) compiler.Compiler -target scan simple.decaf

parse: compile
	$(JAVA) -cp $(CLASSPATH):$(BUILD_DIR) compiler.Compiler -target parse simple.decaf

clean:
	rm -f $(LEXER_DIR)/Lexer.java $(PARSER_DIR)/sym.java $(PARSER_DIR)/Parser.java
	rm -rf $(BUILD_DIR)

.PHONY: all lexer parser compile scan parse clean
