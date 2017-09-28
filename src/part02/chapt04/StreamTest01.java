package part02.chapt04;

import part02.Dish;
import part02.Part2Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by lssemail on 2017/9/25.
 */
public class StreamTest01 {

    public static void main(String[] args) {
//        test01();
//        test02();
          test03();
    }

    public static void test01(){

        List<String> threeHightCaloricDishNames = Part2Util.getDishList()
                .stream().filter(d -> d.getCalories() > 300).map(Dish::getName)
                .limit(3)
                .collect(toList());
        System.out.println(threeHightCaloricDishNames);
    }

    public static void test02(){
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }

    public static void test03(){

        List<String> threeHightCaloricDishNames = Part2Util.getDishList()
                .stream().filter(d -> {
                    System.out.println("filtering:" + d.getName());
                    return d.getCalories() > 300;
                }).map(d ->{
                    System.out.println("mapping:" + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(toList());
        System.out.println(threeHightCaloricDishNames);
    }
}
