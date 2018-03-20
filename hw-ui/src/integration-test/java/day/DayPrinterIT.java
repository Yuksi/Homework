package day;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class DayPrinterIT {

    private DayPrinter dayPrinter;
    PrintStream old;
    private ByteArrayOutputStream output;

    @Before
    public void setUp() {
        dayPrinter = new DayPrinter();
        old=System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @After
    public void tearDown() {
        System.setOut(old);
    }

    @Test
    public void printTodaySunday() {
        String validDate = "18/03/2018";
        dayPrinter.printToday(validDate);
        System.setOut(old);
        dayPrinter.printToday(validDate);
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