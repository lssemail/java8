package part02.chapt05;

import part02.Dish;
import part02.Part2Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by lssemail on 2017/9/25.
 */
public class StreamTest02 {

    public static void main(String[] args) {
//        test01();
//        test04();
        test05();
//          test06();
//        test07();
    }

    public static void test01(){

        List<Dish> threeHightCaloricDishNames = Part2Util.getDishList()
                .stream().filter(Dish :: isVegetarian)
                .limit(3)
                .collect(toList());
        System.out.println(threeHightCaloricDishNames);
    }

    public static void test02(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 6);
        numbers.stream().filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    public static void test03(){

        List<Dish> threeHightCaloricDishNames = Part2Util.getDishList()
                .stream().filter(dish -> dish.getType().equals(Dish.Type.MEAT))
                .limit(2)
                .collect(toList());
        System.out.println(threeHightCaloricDishNames);
    }

    public static void test04(){

        List<Integer> threeHightCaloricDishNames = Part2Util.getDishList()
                .stream().map(Dish::getName).map(String::length)
                .collect(toList());
        System.out.println(threeHightCaloricDishNames);
    }


    public static void test05(){
        String[] words = {"Hello world!", "Java 8"};
        Stream<String> streamOfwords = Arrays.stream(words);
        List<String> list = streamOfwords.map(w -> w.split(""))
        .flatMap(Arrays::stream)
        .distinct().collect(Collectors.toList());
        System.out.println(list);
    }

    public static void test06(){
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = nums.stream().map(n -> n * n)
                .collect(toList());
        System.out.println(squares);
    }

    public static void test07(){
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                number1.stream().flatMap(i -> number2.stream().map(j -> new int[]{i, j}))
                .collect(toList());

    }

}
