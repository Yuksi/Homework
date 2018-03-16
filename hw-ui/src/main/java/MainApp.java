package main.java;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yuksi on 15.03.2018.
 */
public class MainApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        DayPrinter dayPrinter = new DayPrinter();
        if (args.length > 0) {
            dayPrinter.printToday(args[0]);
        }
        else LOGGER.error("no args");
    }
}
