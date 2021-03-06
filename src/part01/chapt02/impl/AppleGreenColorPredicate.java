package part01.chapt02.impl;

import part01.chapt02.interfaces.ApplePredicate;
import part01.model.Apple;

/**
 * Created by lssemail on 2017/8/11.
 */
public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
