How to run the project

"./run.sh" in the root folder
or

java -classpath /usr/share/jflex-1.4.3/lib/JFlex.jar JFlex.Main .flex

java -classpath /usr/share/java//java-cup-11a.jar java\_cup.Main -parser mjavac -interface .cup

javac -classpath .:/usr/share/java/java-cup-11a-runtime.jar Scanner.java sym.java mjavac.java JavaSymbol?.java ./backend/symboltable/.java ./backend/symboltable/objects/.java

java -classpath .:/usr/share/java/java-cup-11a.jar mjavac $1

llvm-as -f $2

llc --x86-asm-syntax=intel -f .bc

lli .bc

rm .class | rm mjavac.java | rm Scanner.java| rm sym.java | rm .ll | rm .s| rm .bc | rm ~