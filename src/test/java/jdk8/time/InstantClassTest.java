package jdk8.time;

import java.time.Instant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InstantClassTest {

    @Test
    void getCurrentSecond() {
        long excepted = System.currentTimeMillis() / 1000;
        long actual = Instant.now().getEpochSecond();

        Assertions.assertEquals(excepted, actual);
    }

}
