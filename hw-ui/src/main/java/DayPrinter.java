package main.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yuksi on 15.03.2018.
 */
public class DayPrinter  {

    private static final Logger LOGGER = LoggerFactory.getLogger(DayPrinter.class);

    public void printToday(String date) {
        LOGGER.info("arg string date is: " + date);
        DayService dayService = new DayService();
        System.out.println(dayService.getDayOfWeek(date));
    }
}
