package lesson_6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
//    private static final Logger logger = Logger.getLogger("");

    private static final Logger logger= LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        /*logger.log(Level.INFO, "Info Message");
        logger.setLevel(Level.WARNING);*/

        /*logger.getHandlers()[0].setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
            }
        });

        logger.log(Level.INFO, "Info Message");
        logger.setLevel(Level.ALL);

        Handler handler = new FileHandler("mylog.log", true);

        logger.addHandler(handler);
        logger.log(Level.WARNING, "Info Message");
        logger.log(Level.CONFIG, "Info Message");
        logger.log(Level.FINER, "Info Message");
        logger.info("Info");

        logger.error("Error");
        logger.warn("Warning");

        if(logger.isDebugEnabled()){
            logger.debug("Debug");
        }

        logger.info("INFO MESSAGE {}", "text");*/
    }
}
