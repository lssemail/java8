package test.testmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterTest {


    public static void main(String[] args) {
        test3();
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

    public static void test2(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.stream().map(n -> n * n).forEach(System.out::println);

    }

    public static void test3(){

        Integer[] a1 = {1, 2, 3}, b1 = {4, 5};
        List<Integer> l1 = Arrays.asList(a1);
        List<Integer> l2 = Arrays.asList(b1);

        List<int[]> list = l1.stream().flatMap(a -> l2.stream().map(b -> new int[]{a, b})).collect(Collectors.toList());
        list.stream().forEach(item -> {
            System.out.println(item[0] + "," + item[1]);
        });

    }
}
