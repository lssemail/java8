package part02.chapt05;

import part02.Part2Util;

import java.util.Optional;

/**
 * Created by lssemail on 2017/9/25.
 */
public class StreamTest04 {

    public static void main(String[] args) {

//        test01();
//        test02();
        test04();
    }


    public static void test01(){

        int sum = Part2Util.getNums().stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    public static void test02(){

        Optional<Integer> sum = Part2Util.getNums().stream().reduce(Integer::sum);
        System.out.println(sum.get());
    }

    public static void test03(){
        Optional<Integer> max = Part2Util.getNums().stream().reduce(Integer::max);
        Optional<Integer> min = Part2Util.getNums().stream().reduce(Integer::min);
        System.out.println(max.get());
        System.out.println(min.get());
    }

    public static void test04(){

        int count = Part2Util.getDishList().stream().map(d -> 1).reduce(0, Integer::sum);
        System.out.println(count);
        System.out.println(Part2Util.getDishList().stream().count());
    }
}
