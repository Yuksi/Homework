package day;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Yuksi on 15.03.2018.
 */
public class DayInfo {

    private static final String DAY_PATTERN = "EEEE";
    private static final Locale LOCALE = Locale.ENGLISH;

    private static final Logger LOGGER = LoggerFactory.getLogger(DayInfo.class);

    public String getDayOfWeek(Date date) {
        LOGGER.info("argument is date: " + date.toString());
        SimpleDateFormat dayFormat = new SimpleDateFormat(DAY_PATTERN, LOCALE);
        String dayOfWeek = dayFormat.format(date);
        LOGGER.info("return day of week: " + dayOfWeek);
        return dayOfWeek;
    }

}
