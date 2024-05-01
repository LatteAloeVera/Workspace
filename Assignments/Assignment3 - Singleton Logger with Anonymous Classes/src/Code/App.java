package Code;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getInstance();

        // Log with INFO level formatting
        logger.log("This is an INFO message", new MessageFormatter(){
            @Override
            public String format(String message) {
                return "INFO: " + message;
            }
        });

        logger.log("This is an ERROR message", new MessageFormatter() {
            @Override
            public String format(String message) {
                return "ERROR: " + message;
            }
        });

        logger.log("This is a Timestamp formatted message", new MessageFormatter() {
            @Override
            public String format(String message) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                Date date = new Date();

                return formatter.format(date) + ": " + message;
            }
        });

        



    }
}
