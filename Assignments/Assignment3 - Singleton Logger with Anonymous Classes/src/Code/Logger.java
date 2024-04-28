package Code;

//A singleton class
public class Logger {
    private static Logger instance = null;

    private Logger() {

    }
    
    public static Logger getInstance() {
        if (Logger.instance == null) {
            instance = new Logger();
        }

        return instance;
    }
    
    public void log(String message, MessageFormatter formatter) {
        
        
    }

}
