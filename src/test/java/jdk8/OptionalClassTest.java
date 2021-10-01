package jdk8;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionalClassTest {

    @Test
    void maxOfBigDecimal() {
        BigDecimal limitAmount = BigDecimal.valueOf(0.5);
        BigDecimal deviceMoney = BigDecimal.valueOf(0.8);

        BigDecimal excepted = BigDecimal.valueOf(0.8);
        BigDecimal actual = Optional.ofNullable(limitAmount).map(deviceMoney::max).orElse(BigDecimal.valueOf(0.0));
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void isPresent_WrapNullObject_ReturnFalse() {
        Optional<Object> optional = Optional.empty();
        Assertions.assertFalse(optional.isPresent());
    }

    @Test
    void isPresent_WrapNonNullObject_ReturnTrue() {
        Optional<Object> optional = Optional.of(new Object());
        Assertions.assertTrue(optional.isPresent());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    void of_GiveNullObjectInOf_ThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> Optional.of(null));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    void get_GiveNullObjectInOf_ThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> Optional.of(null).get());
    }

    @Test
    void get_GiveNullObjectInOfNullable_ReturnNoSuchElementException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> Optional.ofNullable(null).get());
    }

    @Test
    void get_GiveIntegerObjectInOf_ReturnIntegerObject() {
        Integer excepted = 10;
        Integer actual = Optional.of(excepted).get();

        Assertions.assertEquals(excepted, actual);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void ofElse_GiveNullIntegerAndNonNullInteger_ReturnNonNullInteger() {
        Integer nullInteger = null;
        Integer excepted = 10;

        Integer actual = Optional.ofNullable(nullInteger).orElse(excepted);

        Assertions.assertEquals(excepted, actual);
    }
}
