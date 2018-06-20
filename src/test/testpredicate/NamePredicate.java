package test.testpredicate;

import part01.model.Apple;

/**
 * Created by Administrator on 2018/6/20.
 */
public class NamePredicate implements PrintPredicate<Apple> {

    @Override
    public String accept(Apple entity) {

        return entity.getName();
    }
}
