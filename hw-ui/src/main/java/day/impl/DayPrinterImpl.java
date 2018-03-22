package day.impl;

import day.DayPrinterI;
import day.DayServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;

/**
 * Created by Yuksi on 15.03.2018.
 */
public class DayPrinterImpl implements DayPrinterI {

    private DayServiceI dayService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DayPrinterImpl.class);

    public DayPrinterImpl() {
        dayService = new DayServiceImpl();
    }

    @Override
    public void printToday(String date) {
        LOGGER.info("arg string date is: {}", date);
        try {
            String dayOfWeek = dayService.getDayOfWeek(date);
            LOGGER.info("day of week is: {}", dayOfWeek);
            System.out.println(dayOfWeek);
        } catch (ParseException e) {
            LOGGER.error("invalid argument format", e);
        } catch (IllegalArgumentException e) {
            LOGGER.error("string is null or empty", e);
        }
    }
}
