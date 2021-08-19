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
}
