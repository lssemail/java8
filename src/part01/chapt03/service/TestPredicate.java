package part01.chapt03.service;

import java.util.function.Predicate;

/**
 * Created by lssemail on 2017/9/11.
 */
public class TestPredicate {

    public static void main(String[] args) {
        Predicate<String> notEmpty = (String s) -> !s.isEmpty();
    }
}
