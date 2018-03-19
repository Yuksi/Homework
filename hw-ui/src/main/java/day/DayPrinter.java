package day;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;

/**
 * Created by Yuksi on 15.03.2018.
 */
public class DayPrinter  {

    private static final Logger LOGGER = LoggerFactory.getLogger(DayPrinter.class);

    public void printToday(String date) {
        LOGGER.info("arg string date is: " + date);
        DayService dayService = new DayService();
        try {
            String dayOfWeek = dayService.getDayOfWeek(date);
            LOGGER.info("day of week is: " + date);
            System.out.println(dayOfWeek);
        } catch (ParseException e) {
            LOGGER.error("invalid argument format",e);
        } catch (IllegalArgumentException e) {
            LOGGER.error("string is null or empty", e);
        }
    }
}
