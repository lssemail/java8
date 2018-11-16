package part01.chapt01;

import part01.model.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;

import static java.util.stream.Collectors.summingInt;

/**
 * Created by lssemail on 2017/9/28.
 */
public class Index {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Apple ap1 = new Apple();
        Apple ap2 = new Apple();
        Apple ap3 = new Apple();
        ap1.setPrice(40);
        ap2.setPrice(20);
        ap3.setPrice(30);
        List<Apple> appleList = Arrays.asList(ap1, ap2, ap3);
        int total = appleList.stream().collect(summingInt(Apple::getPrice));
        System.out.println(total);
        IntSummaryStatistics intSummaryStatistics = appleList.stream().mapToInt(p -> p.getPrice()).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getSum());
        appleList.sort(Comparator.comparing(Apple::getPrice));
        System.out.println(appleList);
    }
}
