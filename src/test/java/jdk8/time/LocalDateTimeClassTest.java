package jdk8.time;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocalDateTimeClassTest {

    @Test
    void getMonthValue_CallMethod_ReturnMonthValue() {
        int expected = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int actual = LocalDateTime.now().getMonthValue();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDayOfYear_CallMethod_ReturnDayOfYear() {
        int expected = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        int actual = LocalDateTime.now().getDayOfYear();
        Assertions.assertEquals(expected, actual);
    }
}
