package simulator;

import java.io.*;

public class SimulationLogger {
    private static PrintWriter writer;

    static {
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter("simulation.txt", false)));
        } catch (IOException e) {
            System.err.println("Could not open simulation.txt for writing.");
            System.exit(1);
        }
    }

    public static void log(String message) {
        writer.println(message);
        writer.flush();
    }

    public static void close() {
        writer.close();
    }
}