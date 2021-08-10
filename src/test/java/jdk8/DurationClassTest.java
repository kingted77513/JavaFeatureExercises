package jdk8;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DurationClassTest {

    @Test
    void toMinutes_360Seconds_Return6Minutes() {
        Duration seconds = Duration.ofSeconds(360);

        long expected = 6;
        long actual = seconds.toMinutes();

        Assertions.assertEquals(expected, actual);
    }
}
