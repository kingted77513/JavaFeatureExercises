package jdk8.time;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZonedDateTimeClassTest {
    @Test
    void getFistDayOfThisWeek_Today_ReturnDayOfThisWeek() {
        int excepted = 1;

        ZoneId utc = ZoneId.of("UTC");
        final ZonedDateTime now = ZonedDateTime.now(utc);
        final ZonedDateTime firstDay =
            ZonedDateTime.of(now.minusDays(now.getDayOfWeek().getValue() - 1).toLocalDate(),
                LocalTime.MIN, utc);
        int actual = firstDay.getDayOfWeek().getValue();
        Assertions.assertEquals(excepted, actual);
    }
}
