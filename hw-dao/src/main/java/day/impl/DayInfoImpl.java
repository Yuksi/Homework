package day.impl;

import day.DayInfoI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Yuksi on 15.03.2018.
 */
public class DayInfoImpl implements DayInfoI {

    private static final String DAY_PATTERN = "EEEE";
    private static final Locale LOCALE = Locale.ENGLISH;

    private static final Logger LOGGER = LoggerFactory.getLogger(DayInfoImpl.class);

    @Override
    public String getDayOfWeek(Date date) {
        LOGGER.info("argument is date: {}", date);
        SimpleDateFormat dayFormat = new SimpleDateFormat(DAY_PATTERN, LOCALE);
        String dayOfWeek = dayFormat.format(date);
        LOGGER.info("return day of week: {}", dayOfWeek);
        return dayOfWeek;
    }

}
