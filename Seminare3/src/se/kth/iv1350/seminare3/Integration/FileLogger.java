package se.kth.iv1350.seminare3.Integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger {
    private PrintWriter logStream;

    /**
     * Creates a new instance and also creates a new log file. An existing log file will be deleted.
     */
    public FileLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
        } catch (IOException ioe) {
            System.out.println("CAN NOT LOG.");
            ioe.printStackTrace();
        }
    }

    public void log(String message) {
        logStream.println(message);
    }
}
