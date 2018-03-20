package day;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ DayService.class })
public class DayServiceTest {

    @Mock
    private DayInfo mockDayInfo;

    private DayService dayService;

    @Before
    public void setUp() {
        dayService = new DayService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDayOfWeekStringIsNull() throws ParseException {
        dayService.getDayOfWeek(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDayOfWeekStringIsEmpty() throws ParseException {
        dayService.getDayOfWeek("");
    }

    @Test(expected = ParseException.class)
    public void getDayOfWeekStringNotDate() throws ParseException {
        dayService.getDayOfWeek("something");
    }

    @Test
    public void getDayOfWeekNotCallsMockObjectMethodStringEmpty() throws Exception {
        Date someDate = new GregorianCalendar(2018, 02, 18).getTime();
        PowerMockito.whenNew(DayInfo.class).withNoArguments().thenReturn(this.mockDayInfo);
        try {
            dayService.getDayOfWeek("");
        } catch (IllegalArgumentException e) {}
        Mockito.verify(this.mockDayInfo, Mockito.never()).getDayOfWeek(someDate);
    }

    @Test
    public void getDayOfWeekNotCallsMockObjectMethodStringNull() throws Exception {
        Date someDate = new GregorianCalendar(2018, 02, 18).getTime();
        PowerMockito.whenNew(DayInfo.class).withNoArguments().thenReturn(this.mockDayInfo);
        try {
            dayService.getDayOfWeek(null);
        } catch (IllegalArgumentException e) {}
        Mockito.verify(this.mockDayInfo, Mockito.never()).getDayOfWeek(someDate);
    }

    @Test
    public void getDayOfWeekNotCallsMockObjectMethodStringInvalidFormat() throws Exception {
        Date someDate = new GregorianCalendar(2018, 02, 18).getTime();
        PowerMockito.whenNew(DayInfo.class).withNoArguments().thenReturn(this.mockDayInfo);
        try {
            dayService.getDayOfWeek("something");
        } catch (ParseException e) {}
        Mockito.verify(this.mockDayInfo, Mockito.never()).getDayOfWeek(someDate);
    }

    @Test
    public void getDayOfWeekCallsMockObjectMethod() throws Exception {
        Date someDate = new GregorianCalendar(2018, 02, 18).getTime();
        PowerMockito.whenNew(DayInfo.class).withNoArguments().thenReturn(this.mockDayInfo);
        Mockito.when(mockDayInfo.getDayOfWeek(someDate)).thenReturn("Sunday");
        dayService.getDayOfWeek("18/03/2018");
        Mockito.verify(this.mockDayInfo, Mockito.times(1)).getDayOfWeek(someDate);
    }

    @Test
    public void getDayOfWeekReturnSunday() throws ParseException {
        Mockito.when(mockDayInfo.getDayOfWeek(new Date())).thenReturn("Sunday");
        Assert.assertEquals("Sunday", dayService.getDayOfWeek("18/03/2018"));
    }

    @Test (expected = ParseException.class)
    public void getDayOfWeekInvalidStringFormat() throws ParseException {
        Assert.assertEquals("Sunday", dayService.getDayOfWeek("18-03-2018"));
    }
}