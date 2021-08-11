package jdk8;

import jdk8.defaultmethod.DefaultMethodClass;
import jdk8.defaultmethod.DefaultMethodInterface2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DefaultMethodFeatureTest {

    DefaultMethodClass defaultMethodClass;

    @BeforeEach
    void init() {
        defaultMethodClass = new DefaultMethodClass();
    }

    @Test
    void method_CallMethod_ReturnMethodString() {
        String expected = "Method";
        String actual = defaultMethodClass.method();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void defaultMethod_CallMethod_ReturnMethodString() {
        String expected = "Default Method 1st";
        String actual = defaultMethodClass.defaultMethod();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void staticMethod_CallMethod_ReturnMethodString() {
        String expected = "Static Method 2nd";
        String actual = DefaultMethodInterface2.staticMethod();
        Assertions.assertEquals(expected, actual);
    }
}
