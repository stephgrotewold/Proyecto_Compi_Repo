# Ruta a los directorios y archivos
FLEX_SRC=class/compiler/scanner/scan.flex
SCANNER_OUT=class/compiler/scanner/Scanner.java

# Generar Scanner.java a partir de scan.flex usando JFlex
$(SCANNER_OUT): $(FLEX_SRC)
	java -jar lib/jflex-1.9.1.jar $(FLEX_SRC)

# Compilar todos los archivos .java
compile:
	javac -d build/classes $(SCANNER_OUT) class/compiler/parser/*.java class/compiler/ast/*.java class/compiler/semantic/*.java class/compiler/irt/*.java class/compiler/opt/*.java class/compiler/codegen/*.java

# Limpiar los archivos .class
clean:
	rm -rf build/classes/*.class