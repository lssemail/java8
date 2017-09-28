package part01.chapt03.service;

import utils.ConsumerUtil;

import java.util.Arrays;

/**
 * Created by lssemail on 2017/9/11.
 */
public class TestConsumer {

    public static void main(String[] args) {
        ConsumerUtil.forEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i));
    }
}
