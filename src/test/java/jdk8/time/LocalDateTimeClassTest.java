package jdk8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
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

    @Test
    void getTime() {
        final LocalDate today = LocalDate.now();
        final long startTime = Date.from(LocalDateTime.of(today, LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant()).getTime();
        final long endTime = Date.from(LocalDateTime.of(today, LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant()).getTime();
        Assertions.assertEquals(startTime, endTime, 100000000);
    }
}
