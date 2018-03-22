package day;

import day.impl.DayPrinterImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;

@RunWith(MockitoJUnitRunner.class)
public class DayPrinterTest {

    @Mock
    private DayServiceI mockDayService;

    @InjectMocks
    private DayPrinterI dayPrinter = new DayPrinterImpl();
    private ByteArrayOutputStream output;

    @Before
    public void setUp() {
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