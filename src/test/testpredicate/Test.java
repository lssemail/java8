package test.testpredicate;

import part01.model.Apple;
import utils.DataUtil;

import java.util.List;

/**
 * Created by Administrator on 2018/6/20.
 */
public class Test {

    public static void main(String[] args) {

        List<Apple> appleList = DataUtil.getAppleList();

        appleList.stream().filter(item -> item.getColor().equals("red") && item.getWight() < 112 )
                .forEach(item -> System.out.println(item.getName()));


        DataUtil.pintAppleProperty(new NameAndColorPredicate());
    }
}
