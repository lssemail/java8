package test.testlambd;

import utils.Java8Util;

import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "A", "B");
        list.sort(String::compareToIgnoreCase);

        Java8Util.forEach(list, System.out::print);
    }
}
