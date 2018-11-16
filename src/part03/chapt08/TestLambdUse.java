package part03.chapt08;

import jodd.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-11-12.
 */
public class TestLambdUse {

    public static void main(String[] args) {


        List<String> names = new ArrayList<>();
        names.add("a1");
        names.add("a2");

        System.out.println(StringUtil.join(names.stream().map(item -> "'" + item + "'").toArray(), ","));

    }
}
