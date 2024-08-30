# Definir variables
JAVAC = javac
JAVA = java
JFLEX = java -cp lib/java-cup-11b.jar:lib/java-cup-11b-runtime.jar -jar lib/jflex-1.9.1.jar
JARSPATH = lib/java-cup-11b.jar:lib/java-cup-11b-runtime.jar
CLASSPATH = $(JARSPATH):classes

all: compiler

# Regla para generar Scanner.java desde scan.flex
classes/compiler/scanner/Scanner.java: classes/compiler/scanner/scan.flex
	$(JFLEX) -d classes/compiler/scanner/ classes/compiler/scanner/scan.flex

compiler: classes/compiler/scanner/Scanner.java
	$(JAVAC) -cp $(CLASSPATH) -d classes classes/compiler/ast/*.java classes/compiler/codegen/*.java classes/compiler/irt/*.java classes/compiler/opt/*.java classes/compiler/parser/*.java classes/compiler/scanner/*.java classes/compiler/semantic/*.java classes/compiler/Compiler.java

run-scan:
	$(JAVA) -cp $(CLASSPATH) compiler.Compiler -target scan classes/compiler/test.decaf

run-parse:
	$(JAVA) -cp $(CLASSPATH) compiler.Compiler -target parse classes/compiler/test.decaf

clean:
	rm -rf classes/compiler/**/*.class
	rm -f classes/compiler/scanner/Scanner.java