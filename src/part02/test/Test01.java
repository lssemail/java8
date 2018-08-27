package part02.test;

import part02.Dish;
import part02.Part2Util;
import part02.Transaction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Created by lssemail on 2018/3/26.
 */
public class Test01 {

    public static void main(String[] args) {
        test09();
    }

    public static void test10(){

        IntSummaryStatistics statistics = Part2Util.getDishList().stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getAverage());
    }

    /**
     * sum
     * 优先推荐第三种，避免装箱操作，性能最优
     */
    public static void test09(){

        Optional<Integer> sum1 = Part2Util.getDishList().stream().map(Dish::getCalories).reduce(Integer::sum);
        System.out.println(sum1.get());

        int sum2 = Part2Util.getDishList().stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(sum2);

        int sum3 = Part2Util.getDishList().stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum3);


    }
    /**
     * 计算最大值，最小值的几种方法
     */
    public static void test08(){

        Optional<Integer> maxValue = Part2Util.getTransactionList().stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(maxValue.get());

        Optional<Transaction> transaction = Part2Util.getTransactionList().stream().collect(Collectors.maxBy(Comparator.comparingInt(Transaction::getValue)));
        System.out.println(transaction.get().getValue());
    }

    public static void test01(){

        List<Dish> dishList = Part2Util.getDishList();
        Map<Dish.Type, List<Dish>> map = dishList.stream()
                .filter(item -> item.getCalories() < 500)
                .collect(groupingBy(item -> item.getType()));

        System.out.println(map);

    }

    public static void test02(){

        List<String> list= Arrays.asList("Hello", "world");
        List<String> strings = list.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        strings.stream().forEach(System.out::print);
    }

    public static void test03(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream()
                .map(x -> x * x)
                .forEach(System.out::println);

    }


    public static void test05(){

        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(3, 4);

        List<int[]> pairs = num1.stream()
                .flatMap(i -> num2.stream().map(j -> new int[]{i, j}))
                .collect(toList());

        pairs.stream().forEach(item -> {
            System.out.println(item[0] +"," + item[1]);
        });
    }

    public static void pythagoreanTriples(){

        Stream<int[]> stream = IntStream.range(1, 100).boxed()
                .flatMap(a ->
                    IntStream.range(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
            );
        stream.forEach(item -> {
            System.out.println(item[0] + "," + item[1] + ","+ item[2]);
        });
    }

    public static void test06(){

        Stream.iterate(new int[]{0,1}, n ->new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .map(item -> item[0])
                .forEach(System.out::println);

    }

    public static void test07(){

        long count = Part2Util.getDishList().stream().collect(Collectors.counting());
        long count1 = Part2Util.getDishList().stream().count();

        System.out.println(count);
        System.out.println(count1);
    }
}
