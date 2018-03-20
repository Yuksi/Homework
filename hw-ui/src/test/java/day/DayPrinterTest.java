package day;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.Date;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ DayPrinter.class })
public class DayPrinterTest {

    @Mock
    private DayService mockDayService;

    private DayPrinter dayPrinter = new DayPrinter();
    private ByteArrayOutputStream output;

    @Before
    public void setUp() {
        dayPrinter = new DayPrinter();
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @After
    public void tearDown() {
        PrintStream old=System.out;
        System.setOut(old);
    }

    @Test
    public void printTodaySunday() throws ParseException {
        Mockito.when(mockDayService.getDayOfWeek("18/03/2018")).thenReturn("Sunday");
        dayPrinter.printToday("18/03/2018");
        Assert.assertEquals("Sunday",output.toString().replaceAll(System.lineSeparator(),""));
    }

    @Test
    public void printTodaySundayCallsMockObjectOnce() throws Exception {
        String date = "18/03/2018";
        PowerMockito.whenNew(DayService.class).withNoArguments().thenReturn(this.mockDayService);
        Mockito.when(mockDayService.getDayOfWeek(date)).thenReturn("Sunday");
        dayPrinter.printToday(date);
        Mockito.verify(this.mockDayService, Mockito.times(1)).getDayOfWeek(date);
    }

    @Test
    public void printTodayNothingStringEmpty() throws ParseException {
        Mockito.when(mockDayService.getDayOfWeek("")).thenThrow(IllegalArgumentException.class);
        dayPrinter.printToday("");
        Assert.assertEquals("",output.toString().replaceAll(System.lineSeparator(),""));
    }

    @Test
    public void printTodayNothingStringNull() throws ParseException {
        Mockito.when(mockDayService.getDayOfWeek(null)).thenThrow(IllegalArgumentException.class);
        dayPrinter.printToday(null);
        Assert.assertEquals("",output.toString().replaceAll(System.lineSeparator(),""));
    }

    @Test
    public void printTodayNothingStringInvalidFormat() throws ParseException {
        Mockito.when(mockDayService.getDayOfWeek("something")).thenThrow(IllegalArgumentException.class);
        dayPrinter.printToday("something");
        Assert.assertEquals("",output.toString().replaceAll(System.lineSeparator(),""));
    }
}