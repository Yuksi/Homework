package day;

import day.impl.DayInfoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

public class DayInfoTest {

    private DayInfoI dayInfo;

    @Before
    public void setDayInfo() {
        dayInfo = new DayInfoImpl();
    }

    @Test(expected = NullPointerException.class)
    public void getDayOfWeekDateIsNullThrowNullPointerException() {
        dayInfo.getDayOfWeek(null);
    }

    @Test
    public void getDayOfWeekReturnSunday() {
        Date someDate = new GregorianCalendar(2018, 02, 18).getTime();
        Assert.assertEquals("Sunday", dayInfo.getDayOfWeek(someDate));
    }

    @Test
    public void getDayOfWeekReturnMonday() {
        Date someDate = new GregorianCalendar(2018, 02, 19).getTime();
        Assert.assertEquals("Monday", dayInfo.getDayOfWeek(someDate));
    }

    @Test
    public void getDayOfWeekReturnTuesday() {
        Date someDate = new GregorianCalendar(2018, 02, 20).getTime();
        Assert.assertEquals("Tuesday", dayInfo.getDayOfWeek(someDate));
    }

    @Test
    public void getDayOfWeekReturnWednesday() {
        Date someDate = new GregorianCalendar(2018, 02, 21).getTime();
        Assert.assertEquals("Wednesday", dayInfo.getDayOfWeek(someDate));
    }

    @Test
    public void getDayOfWeekReturnThursday() {
        Date someDate = new GregorianCalendar(2018, 02, 22).getTime();
        Assert.assertEquals("Thursday", dayInfo.getDayOfWeek(someDate));
    }

    @Test
    public void getDayOfWeekReturnFriday() {
        Date someDate = new GregorianCalendar(2018, 02, 23).getTime();
        Assert.assertEquals("Friday", dayInfo.getDayOfWeek(someDate));
    }

    @Test
    public void getDayOfWeekReturnSaturday() {
        Date someDate = new GregorianCalendar(2018, 02, 24).getTime();
        Assert.assertEquals("Saturday", dayInfo.getDayOfWeek(someDate));
    }
}

