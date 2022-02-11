package jdk7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecimalClassTest {

    @Test
    void divideBigDecimal() {
        final BigDecimal lendMoney = new BigDecimal(3780);
        final BigDecimal deviceMoney = new BigDecimal(6000);

        final BigDecimal excepted = new BigDecimal("0.37");
        final BigDecimal actual = BigDecimal.ONE.subtract(lendMoney.divide(deviceMoney, 2, RoundingMode.HALF_UP));

        Assertions.assertEquals(excepted, actual);
        Assertions.assertEquals(2, excepted.scale());
        Assertions.assertEquals(2, actual.scale());
    }

    @Test
    void toString_DecimalToString_ReturnDigitString() {
        final BigDecimal integer = BigDecimal.valueOf(10);

        final String excepted = "10";
        final String actual = integer.toString();
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void compareTo_TwoBigDecimal_ReturnNumberOfOver() {
        final int excepted = 1;

        final BigDecimal num1 = new BigDecimal(10);
        final BigDecimal num2 = new BigDecimal(5);

        final int actual = num1.compareTo(num2);
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void compareTo_TwoBigDecimal_ReturnNumberOfEqual() {
        final int excepted = 0;

        final BigDecimal num1 = new BigDecimal(10);
        final BigDecimal num2 = new BigDecimal(10);

        final int actual = num1.compareTo(num2);
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void compareTo_TwoBigDecimal_ReturnNumberOfLess() {
        final int excepted = -1;

        final BigDecimal num1 = new BigDecimal(5);
        final BigDecimal num2 = new BigDecimal(10);

        final int actual = num1.compareTo(num2);
        Assertions.assertEquals(excepted, actual);
    }
}
