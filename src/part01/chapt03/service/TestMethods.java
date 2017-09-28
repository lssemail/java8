package part01.chapt03.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Created by lssemail on 2017/9/13.
 */
public class TestMethods {

    public static void main(String[] args) {
//        test02();
        test03();
    }

    public static void test01(){
        List<String> str = Arrays.asList("a", "b", "A", "B");
        //LAMD 表达式写法
        //str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        //引用方法写法
        str.sort(String :: compareToIgnoreCase);
        System.out.println(str);
    }

    public static void test02(){
        //LAMD 表达式写法
        //Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        //引用方法写法
        Function<String, Integer> stringToInteger = Integer::parseInt;
        Integer num = stringToInteger.apply("123");
        System.out.println(num);

    }

    public static void test03(){
        List<String> str = Arrays.asList("a", "b", "A", "B");
        //BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contains = List::contains;
        boolean result = contains.test(str, "A");
        System.out.println(result);
    }
}

