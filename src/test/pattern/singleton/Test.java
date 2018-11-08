package test.pattern.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018-9-17.
 */
public class Test {
    static int count = 100;
    public static void main(String[] args) {


        CountDownLatch latch = new CountDownLatch(count);
        for (int i=0; i < count; i++){
            new Thread(()->{
               Singleton01.getInstance().print();
            }).start();
            latch.countDown();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
