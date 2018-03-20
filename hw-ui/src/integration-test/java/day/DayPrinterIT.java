package day;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class DayPrinterIT {

    private DayPrinter dayPrinter;
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
    public void printTodaySunday() {
        dayPrinter.printToday("18/03/2018");
        Assert.assertEquals("Sunday",output.toString().replaceAll(System.lineSeparator(),""));
    }

    @Test
    public void printTodayNothingStringEmpty() {
        dayPrinter.printToday("");
        Assert.assertEquals("",output.toString().replaceAll(System.lineSeparator(),""));
    }

    @Test
    public void printTodayNothingStringNull() {
        dayPrinter.printToday("");
        Assert.assertEquals("",output.toString().replaceAll(System.lineSeparator(),""));
    }

    @Test
    public void printTodayNothingStringInvalidFormat() {
        dayPrinter.printToday("something");
        Assert.assertEquals("",output.toString().replaceAll(System.lineSeparator(),""));
    }
}