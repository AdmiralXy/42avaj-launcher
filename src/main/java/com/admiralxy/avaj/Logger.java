package com.admiralxy.avaj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static final Logger instance;
    private static final FileWriter writer;

    static {
        instance = new Logger();
        try {
            File file = new File("simulation.txt");
            if (file.exists())
                file.delete();
            file.createNewFile();
            writer = new FileWriter(file);
        } catch (IOException e) {
            throw new LoggerException("Failed to open file for writing");
        }
    }

    private Logger() {
    }

    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) {
        try {
            writer.write(String.format("%s\n", message));
        } catch (IOException e) {
            throw new LoggerException("Failed to write to file");
        }

    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            throw new LoggerException("Failed to close file");
        }
    }
}
