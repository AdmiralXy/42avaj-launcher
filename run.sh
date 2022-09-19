find * -name "*.java" > sources.txt
javac @sources.txt
java -classpath src/main/java/ com.admiralxy.avaj.Simulation scenario.txt