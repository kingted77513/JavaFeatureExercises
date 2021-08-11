package jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FunctionalInterfacesAndLambdaFeatureTest {

    @Test
    void sort_StringList_ReturnSortedStringList() {
        List<String> names1 = new ArrayList<>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<>(names1);

        sortUsingBeforeJDK(names1);
        sortUsingJava8Lambda(names2);

        Assertions.assertEquals(names1, names2);
    }

    private void sortUsingBeforeJDK(List<String> names) {
        Collections.sort(names, new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    private void sortUsingJava8Lambda(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}
