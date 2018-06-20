package test.testpredicate;

import part01.model.Apple;

/**
 * Created by Administrator on 2018/6/20.
 */
public class RedPredicate implements CommonPredicate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor());
    }
}
