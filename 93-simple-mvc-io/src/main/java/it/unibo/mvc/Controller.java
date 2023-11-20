package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */

public class Controller {
    private final String FILENAME = "output.txt";
    
    private final File current;
    
    public Controller(File current) {
        this.current = current;
    }

    public File getCurrent() {
        return this.current;
    }

    public String getPath() {
        final String PATH = System.getProperty("user.home")
            + File.separator
            + FILENAME;
        return PATH;
    }

    public void writeStringOnFile(String stringToWrite){
        try (PrintStream ps = new PrintStream(this.getPath(), StandardCharsets.UTF_8)) {
            ps.print(stringToWrite);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
