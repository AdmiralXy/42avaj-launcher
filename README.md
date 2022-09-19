## Avaj Launcher

### About

Java program that simulates aircraft flying in the sky. The program reads a text file that contains the number of times the simulation should run and the different types of aircraft and their initial coordinates. The program then outputs the different steps and states of the aircraft during the simulation in a text file.

### Features

* Observer design pattern
* Factory design pattern
* Singleton design pattern
* Inheritance
* Polymorphism
* Exception handling
* File handling

### How to run (on Linux / macOS)

1. Clone the repository
2. Make sure you have JDK 8+ installed
3. Execute `bash run.sh` to compile and run the program with the default `scenario.txt` file
4. Execute `bash clean.sh` to remove the .class files and the output file

### How to run (on Windows)

1. Compile the program to create the .class files:

```bash
find * -name "*.java" > sources.txt
javac @sources.txt
```

2. Run the program with `java -classpath src/main/java/ com.admiralxy.avaj.Simulation scenario.txt` where scenario.txt is the text file containing the number of times the simulation should run and the different types of aircrafts and their initial coordinates.


3. The output will be in a text file called `simulation.txt`

### UML Diagram of the program

![This is an image](assets/package.png)