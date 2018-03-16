package main.java;

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
    private static final String LANGUAGE = "en-US";

    private static final Logger LOGGER = LoggerFactory.getLogger(DayInfo.class);

    public String getDayOfWeek(Date date) {
        SimpleDateFormat dayFormat = new SimpleDateFormat(DAY_PATTERN, new Locale(LANGUAGE));
        String dayOfWeek = dayFormat.format(date);
        LOGGER.info("got day of week: " + dayOfWeek);
        return dayOfWeek;
    }

}
