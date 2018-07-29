package test.testmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterTest {


    public static void main(String[] args) {
        test1();
    }

    public static void test1(){

        List<String> list = Arrays.asList("Hello", "world");

        List<String> strings = list.stream()
                .map(item -> item.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(strings);
    }
}
