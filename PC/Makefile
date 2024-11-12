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
GRAPHVIZ_JAR = $(LIB_DIR)/graphviz-java-0.18.1.jar

# Java compiler
JAVAC = javac
JAVA = java

# Classpath definitions
BASIC_CLASSPATH = $(CUP_RUNTIME_JAR):$(GRAPHVIZ_JAR):$(SRC_DIR)
FULL_CLASSPATH = $(shell find $(LIB_DIR) -name "*.jar" | tr '\n' ':')$(SRC_DIR)

get-slf4j:
	curl -L -o $(LIB_DIR)/slf4j-simple-1.7.30.jar https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/1.7.30/slf4j-simple-1.7.30.jar

# Targets
all: get-slf4j lexer parser compile

lexer: | $(LEXER_DIR)
	$(JAVA) -cp $(JFLEX_JAR):$(CUP_RUNTIME_JAR) jflex.Main -d $(LEXER_DIR) $(LEXER_DIR)/Lexer.flex

parser: | $(PARSER_DIR)
	$(JAVA) -jar $(CUP_JAR) -parser Parser -symbols sym -destdir $(PARSER_DIR) $(PARSER_DIR)/Parser.cup

$(PARSER_DIR):
	mkdir -p $(PARSER_DIR)

$(LEXER_DIR):
	mkdir -p $(LEXER_DIR)

$(BUILD_DIR) $(BUILD_PARSER_DIR) $(BUILD_LEXER_DIR):
	mkdir -p $@

compile: lexer parser | $(BUILD_DIR) $(BUILD_PARSER_DIR) $(BUILD_LEXER_DIR)
	$(JAVAC) -cp "$(FULL_CLASSPATH)" -d $(BUILD_DIR) \
		$(SRC_DIR)/compiler/*.java \
		$(PARSER_DIR)/*.java \
		$(LEXER_DIR)/*.java

scan: compile
	$(JAVA) -cp "$(FULL_CLASSPATH):$(BUILD_DIR)" compiler.Compiler -target scan simple.decaf

parse: compile
	$(JAVA) -cp "$(FULL_CLASSPATH):$(BUILD_DIR)" compiler.Compiler -target parse simple.decaf

ast: compile
	$(JAVA) -Dorg.slf4j.simpleLogger.defaultLogLevel=INFO -cp "$(FULL_CLASSPATH):$(BUILD_DIR)" compiler.Compiler -target ast simple.decaf

semantic: compile
	$(JAVA) -cp "$(FULL_CLASSPATH):$(BUILD_DIR)" compiler.Compiler -target semantic simple.decaf

clean:
	rm -f $(LEXER_DIR)/Lexer.java $(PARSER_DIR)/sym.java $(PARSER_DIR)/Parser.java
	rm -rf $(BUILD_DIR)
	rm -f ast_output.png

.PHONY: all lexer parser compile scan parse ast semanticclean get-slf4j