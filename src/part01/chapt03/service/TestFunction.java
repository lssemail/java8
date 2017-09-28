package part01.chapt03.service;

import utils.FunctionUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lssemail on 2017/9/11.
 */
public class TestFunction {

    public static void main(String[] args) {
        List<Integer> l = FunctionUtil.map(
                Arrays.asList("lambdas","in","action"),(String s) -> s.length()
        );
        System.out.println(l.size());
    }
}
