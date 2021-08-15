package jdk7;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenericInstanceCreationFeatureTest {
    @Test
    void genericInstanceCreation(){
        final Map<String, Integer> beforeJdk = new HashMap<String,Integer>();
        final Map<String, Integer> jdk8 = new HashMap<>();

        beforeJdk.put("id", 100);
        jdk8.put("id", 100);

        final int excepted = beforeJdk.get("id");
        final int actual = jdk8.get("id");

        Assertions.assertEquals(excepted, actual);
    }
}
