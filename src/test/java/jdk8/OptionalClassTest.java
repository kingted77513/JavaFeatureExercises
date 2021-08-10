package jdk8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalClassTest {

    @Test
    void isPresent_WrapNullObject_ReturnFalse(){
        Optional<Object> optional = Optional.ofNullable(null);
        Assertions.assertFalse(optional.isPresent());
    }

    @Test
    void isPresent_WrapNonNullObject_ReturnTrue(){
        Optional<Object> optional = Optional.ofNullable(new Object());
        Assertions.assertTrue(optional.isPresent());
    }
}
