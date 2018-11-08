package part02.chapt05;

import part02.Dish;
import part02.Part2Util;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by lssemail on 2017/9/25.
 */
public class StreamTest06 {

    public static void main(String[] args) {

        test01();
    }

    public static void test01(){
        IntStream intStream = Part2Util.getDishList().stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

    }

    public static void test02(){
        IntStream evenNums = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0);
        evenNums.forEach(i ->{
            System.out.println(i);
        });
    }

    public static void test03(){
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
    }

    public static void test04(){

        Stream.iterate(new int[]{0, 1}, n -> {
            return new int[]{n[1], n[0] + n[1]};
        }).limit(10)
          .forEach(t -> {
              System.out.println(t[0] + "," + t[1]);
          });
    }


}
