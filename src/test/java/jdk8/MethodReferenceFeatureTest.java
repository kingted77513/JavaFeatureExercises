package jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MethodReferenceFeatureTest {

    @Test
    void sort_StringList_ReturnSortedStringList() {
        List<String> names1 = new ArrayList<>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<>(names1);

        sortUsingJava8Lambda(names1);
        sortUsingJava8LambdaAndMethodReference(names2);

        Assertions.assertEquals(names1, names2);
    }

    private void sortUsingJava8Lambda(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }

    private void sortUsingJava8LambdaAndMethodReference(List<String> names) {
        Collections.sort(names, String::compareTo);
    }
}
