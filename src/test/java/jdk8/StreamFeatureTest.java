package jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StreamFeatureTest {

    @Test
    void sum_GiveIntegerList_ReturnSumOfAllIntegerInList() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        int sum1 = getSumUsingBeforeJDK(numbers);
        int sum2 = getSumUsingJava8(numbers);

        Assertions.assertEquals(sum1, sum2);
    }

    private int getSumUsingBeforeJDK(List<Integer> numbers) {
        int sun = 0;
        for (Integer number : numbers) {
            sun += number;
        }
        return sun;
    }

    private int getSumUsingJava8(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    @Test
    void count_GiveStringList_ReturnStringLengthIs3TotalNumber() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

        long count1 = getCountLength3UsingBeforeJDK(strings);
        long count2 = getCountLength3UsingJDK8(strings);

        Assertions.assertEquals(count1, count2);

    }

    private long getCountLength3UsingBeforeJDK(List<String> strings) {
        long count = 0;

        for (String string : strings) {

            if (string.length() == 3) {
                count++;
            }
        }
        return count;
    }

    private long getCountLength3UsingJDK8(List<String> strings) {
        return strings.stream().filter(string -> string.length() == 3).count();
    }

    @Test
    void map_GiveIntegerList_ReturnPowerIntegerList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> powerNumbers1 = getPowerIntegerListUsingBeforeJDK(numbers);
        List<Integer> powerNumbers2 = getPowerIntegerListUsingJDK8(numbers);

        Assertions.assertEquals(powerNumbers1.toString(), powerNumbers2.toString());
    }

    private List<Integer> getPowerIntegerListUsingBeforeJDK(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();

        for (Integer number : numbers) {
            list.add((int) Math.pow(number, 2));
        }

        return list;
    }

    private List<Integer> getPowerIntegerListUsingJDK8(List<Integer> numbers) {
        return numbers.stream().map(number -> Double.valueOf(Math.pow(number, 2)).intValue()).collect(Collectors.toList());
    }

    @Test
    void joinEntry_MergeParams_ReturnMergeString() {
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        params.put("Amount", "100");
        params.put("IsTest", Boolean.FALSE.toString());
        params.put("CurrencyId", "1");

        String excepted = "Amount=100&CurrencyId=1&IsTest=false";
        String actual = params.entrySet().stream().sorted(Map.Entry.comparingByKey())
            .map(entry -> entry.getKey() + "=" + entry.getValue())
            .collect(Collectors.joining("&"));
        Assertions.assertEquals(excepted, actual);
    }
}
