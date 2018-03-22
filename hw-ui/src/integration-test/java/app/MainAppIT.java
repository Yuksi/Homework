package app;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * Created by Yuksi on 22.03.2018.
 */
@RunWith(Parameterized.class)
public class MainAppIT {
    private String arg;
    private String expected;

    public MainAppIT(String arg, String expected) {
        this.arg = arg;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:get{0}return{1}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {null, ""},
                {"", ""},
                {"something", ""},
                {"18-03-2018", ""},
                {"18/03/2018", "Sunday"},
        });
    }

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
    public void paramTest() {
        String[] args = {arg};
        MainApp.main(args);
        Assert.assertEquals(expected,output.toString().replaceAll(System.lineSeparator(),""));
    }
}