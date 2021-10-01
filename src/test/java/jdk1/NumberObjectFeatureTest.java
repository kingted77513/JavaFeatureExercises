package jdk1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberObjectFeatureTest {

    @Test
    void equalBetweenIntegerAndShort() {
        Integer intValue = Integer.valueOf("10");
        Short shortValueFromInt = Short.valueOf(intValue.shortValue());

        Short shortValue = Short.valueOf("10");
        Assertions.assertTrue(shortValue.equals(shortValueFromInt));
    }

}
