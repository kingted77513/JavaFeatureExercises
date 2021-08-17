package jdk7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnderscoresInNumericLiteralsFeatureTest {

    @Test
    void equalInteger() {
        int excepted = 1000000;
        int actual = 1_000_000;
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void equalLong() {
        long excepted = 1234567890123456L;
        long actual = 1234_5678_9012_3456L;
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void equalFloat() {
        float excepted = 3.14159F;
        float actual = 3.14_159F;
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void equalHex() {
        long excepted = 0xFFECDE5E;
        long actual = 0xFF_EC_DE_5E;
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void equalByte() {
        byte excepted = 0b00100101;
        byte actual = 0b0010_0101;
        Assertions.assertEquals(excepted, actual);
    }
}
