package main.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yuksi on 15.03.2018.
 */
public class DayService {

    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final Logger LOGGER = LoggerFactory.getLogger(DayService.class);

    public boolean isNullOrEmpty(String stringDate) {
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

    public String getDayOfWeek(String stringDate) {
        if (isNullOrEmpty(stringDate)) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        Date date= null;
        try {
            date = dateFormat.parse(stringDate);
        } catch (ParseException e) {
            LOGGER.error("invalid argument format",e);
            return "invalid argument format";
        }

        LOGGER.info("created date", date);
        DayInfo dayInfo = new DayInfo();
        return dayInfo.getDayOfWeek(date);
    }

}
