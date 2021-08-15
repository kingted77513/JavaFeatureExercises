package jdk7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwitchStatementFeatureTest {
    @Test
    void getCaseByString() {
        final String fruit = "apple";

        final String excepted = getCaseByStringUsingBeforeJDK(fruit);
        final String actual = getCaseByStringUsingJDK7(fruit);

        Assertions.assertEquals(excepted, actual);

    }

    private String getCaseByStringUsingBeforeJDK(final String fruit) {
        if (fruit.equals("apple")) {
            return "This is an apple";
        } else if (fruit.equals("banana")) {
            return "This is a banana";
        } else {
            return null;
        }
    }

    private String getCaseByStringUsingJDK7(final String fruit) {
        switch (fruit) {
            case "apple":
                return "This is an apple";
            case "banana":
                return "This is a banana";
            default:
                return null;
        }
    }
}
