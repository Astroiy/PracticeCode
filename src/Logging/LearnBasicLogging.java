package Logging;

import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LearnBasicLogging {
    private static final Logger myLogger = Logger.getLogger("com.mycompany.myapp");
    public static void main(String[] args) {
        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("File->Open menu item selected");
        //Logger.getGlobal().setLevel(Level.OFF);
    }
}
