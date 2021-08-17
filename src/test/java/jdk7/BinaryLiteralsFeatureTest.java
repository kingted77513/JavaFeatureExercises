package jdk7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryLiteralsFeatureTest {
    @Test
    void equalByteBinaryLiterals() {
        byte excepted = Byte.MAX_VALUE;
        byte actual = (byte) 0b01111111;
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void equalShortBinaryLiterals() {
        short excepted = Short.MAX_VALUE;
        short actual = (short) 0b0111111111111111;
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void equalIntegerBinaryLiterals() {
        int excepted = Integer.MAX_VALUE;
        int actual = 0b01111111111111111111111111111111;
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void equalUpperOrLowerCase() {
        int excepted = 0b101;
        int actual = 0B101;
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void equalLongBinaryLiterals() {
        long excepted = Long.MAX_VALUE;
        long actual = 0b0111111111111111111111111111111111111111111111111111111111111111L;
        Assertions.assertEquals(excepted, actual);
    }
}
