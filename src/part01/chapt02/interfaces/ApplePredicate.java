package part01.chapt02.interfaces;

import part01.model.Apple;

/**
 * Created by lssemail on 2017/8/11.
 */
@FunctionalInterface
public interface ApplePredicate {

    boolean test(Apple apple);
}
