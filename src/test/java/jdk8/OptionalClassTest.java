package jdk8;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionalClassTest {

    @Test
    void isPresent_WrapNullObject_ReturnFalse(){
        Optional<Object> optional = Optional.empty();
        //noinspection ConstantConditions
        Assertions.assertFalse(optional.isPresent());
    }

    @Test
    void isPresent_WrapNonNullObject_ReturnTrue(){
        Optional<Object> optional = Optional.of(new Object());
        //noinspection ConstantConditions
        Assertions.assertTrue(optional.isPresent());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    void of_GiveNullObjectInOf_ThrowNullPointerException(){
        //noinspection ConstantConditions
        Assertions.assertThrows(NullPointerException.class, () -> Optional.of(null));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    void get_GiveNullObjectInOf_ThrowNullPointerException(){
        //noinspection ConstantConditions
        Assertions.assertThrows(NullPointerException.class, () -> Optional.of(null).get());
    }

    @Test
    void get_GiveNullObjectInOfNullable_ReturnNoSuchElementException(){
        //noinspection ConstantConditions
        Assertions.assertThrows(NoSuchElementException.class, () -> Optional.ofNullable(null).get());
    }

    @Test
    void get_GiveIntegerObjectInOf_ReturnIntegerObject(){
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
