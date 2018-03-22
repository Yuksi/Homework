package day;

import day.impl.DayServiceImpl;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.ParseException;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class DayServiceTest {

    @Mock
    private DayInfoI mockDayInfo;

    @InjectMocks
    private DayServiceI dayService = new DayServiceImpl();

    @Before
    public void setUp() {
        dayService = new DayServiceImpl();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getDayOfWeekStringIsNull() throws ParseException {
        thrown.expect(IllegalArgumentException.class);
        dayService.getDayOfWeek(null);
    }

    @Test
    public void getDayOfWeekStringIsEmpty() throws ParseException {
        thrown.expect(IllegalArgumentException.class);
        dayService.getDayOfWeek("");
    }

    @Test
    public void getDayOfWeekStringNotDate() throws ParseException {
        thrown.expect(ParseException.class);
        dayService.getDayOfWeek("something");
    }

    @Test
    public void getDayOfWeekInvalidStringFormat() throws ParseException {
        thrown.expect(ParseException.class);
        dayService.getDayOfWeek("18-03-2018");
    }

    @Test
    public void getDayOfWeekNotCallsMockObjectMethodStringNull() throws Exception {
        try {
            dayService.getDayOfWeek(null);
        } catch (IllegalArgumentException e) {}
        Mockito.verify(this.mockDayInfo, Mockito.never()).getDayOfWeek(null);
    }

    @Test
    public void getDayOfWeekReturnSunday() throws ParseException {
        Mockito.when(mockDayInfo.getDayOfWeek(new Date())).thenReturn("Sunday");
        Assert.assertEquals("Sunday", dayService.getDayOfWeek("18/03/2018"));
    }
}