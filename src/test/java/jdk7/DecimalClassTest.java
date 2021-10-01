package jdk7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecimalClassTest {

    @Test
    void divideBigDecimal() {
        BigDecimal lendMoney = new BigDecimal(3780);
        BigDecimal deviceMoney = new BigDecimal(6000);

        BigDecimal excepted = new BigDecimal("0.37");
        BigDecimal actual = BigDecimal.ONE.subtract(lendMoney.divide(deviceMoney, 2, RoundingMode.HALF_UP));

        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void toString_DecimalToString_ReturnDigitString() {
        BigDecimal integer = BigDecimal.valueOf(10);

        String excepted = "10";
        String actual = integer.toString();
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void compareTo_TwoBigDecimal_ReturnNumberOfOver() {
        int excepted = 1;

        BigDecimal num1 = new BigDecimal(10);
        BigDecimal num2 = new BigDecimal(5);

        int actual = num1.compareTo(num2);
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void compareTo_TwoBigDecimal_ReturnNumberOfEqual() {
        int excepted = 0;

        BigDecimal num1 = new BigDecimal(10);
        BigDecimal num2 = new BigDecimal(10);

        int actual = num1.compareTo(num2);
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void compareTo_TwoBigDecimal_ReturnNumberOfLess() {
        int excepted = -1;

        BigDecimal num1 = new BigDecimal(5);
        BigDecimal num2 = new BigDecimal(10);

        int actual = num1.compareTo(num2);
        Assertions.assertEquals(excepted, actual);
    }
}
