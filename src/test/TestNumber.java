package test;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018-12-3.
 */
public class TestNumber {

    public static void main(String[] args) throws Exception {

//        List<Double> list = Arrays.asList(0.2, 0.4, 0.6, 0.1, 0.2);
//        System.out.println(list);
//        list.sort(Comparator.comparing(Double::doubleValue).reversed());
//        double avg = list.stream().skip(2).limit(3).collect(Collectors.averagingDouble(Double::doubleValue));
//        System.out.println(avg);
        testCountDownLatch();
    }

    public static void testCountDownLatch() throws Exception{

        int count = 100;
        CountDownLatch cdl = new CountDownLatch(count);
        for (int i = 0; i < count; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    cdl.countDown();
                }
            }).start();
        }
        cdl.await();

        System.out.println("end");
        System.out.println(Thread.currentThread().getName());
    }
}
