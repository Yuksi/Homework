package day;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class DayInfoTest {

    private DayInfo dayInfo;

    @Before
    public void setDayInfo() {
        dayInfo = new DayInfo();
    }

    @Test(expected = NullPointerException.class)
    public void getDayOfWeekDateIsNullThrowNullPointerException() {
        dayInfo.getDayOfWeek(null);
    }

    @Test
    public void getDayOfWeekReturnSunday() {
        Date date = new Date(1521400000000L);
        Assert.assertEquals("Sunday", dayInfo.getDayOfWeek(date));
    }
}

