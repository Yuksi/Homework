package day.impl;

import day.DayInfoI;
import day.DayServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yuksi on 15.03.2018.
 */
public class DayServiceImpl implements DayServiceI {

    private DayInfoI dayInfo;

    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final Logger LOGGER = LoggerFactory.getLogger(DayServiceImpl.class);

    public DayServiceImpl() {
        dayInfo = new DayInfoImpl();
    }

    private boolean isNullOrEmpty(String stringDate) {
        if (stringDate == null) {
            LOGGER.error("argument is null");
            return true;
        }
        if (stringDate.isEmpty()) {
            LOGGER.error("argument is empty string");
            return true;
        }
        return false;
    }

    @Override
    public String getDayOfWeek(String stringDate) throws ParseException {
        LOGGER.info("argument string date: {}", stringDate);
        if (isNullOrEmpty(stringDate)) {
            throw new IllegalArgumentException();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        Date date = dateFormat.parse(stringDate);
        String dayOfWeek = dayInfo.getDayOfWeek(date);
        LOGGER.info("return day of week: {}", dayOfWeek);
        return dayOfWeek;
    }

}
