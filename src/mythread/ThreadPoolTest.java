package mythread;

import jodd.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018-11-16.
 */
public class ThreadPoolTest {

    static int count = 0;
    static AtomicInteger num = new AtomicInteger(0);
    static Object key = new Object();

    static Runnable myRunnable = new Runnable() {
        @Override public void run() {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " run");
            } catch (InterruptedException e) {
                e.printStackTrace(); }
        }
    };
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("test - %d").get();
        ThreadPoolExecutor service = new ThreadPoolExecutor(10, 20, 4000, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), factory);

        for (int i=0;i< 50000; i++){
            service.execute(() ->{
                num.getAndIncrement();
                count++;
                System.out.println(Thread.currentThread().getName());
            });
        }
        service.shutdown();
    }



    public static void testSingle(){
        long start = System.currentTimeMillis();
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i=0;i< 100000; i++){
            service.execute(() ->{
                num.getAndIncrement();
                count++;
                System.out.println(Thread.currentThread().getName());
            });
        }
        service.shutdown();
        while (true){
            if(service.isTerminated()){
                System.out.println(count);
                System.out.println(num.get());
                break;
            }
        }
        System.out.println(Thread.currentThread().getName());
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void testFixed(){
        long start = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i=0;i< 10000; i++){
            service.execute(() ->{
                num.getAndIncrement();
                count++;
                System.out.println(Thread.currentThread().getName());
            });
        }
        service.shutdown();
        while (true){
            if(service.isTerminated()){
                System.out.println(count);
                System.out.println(num.get());
                break;
            }
        }
        System.out.println(Thread.currentThread().getName());
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    public static void testCached(){
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i< 10000; i++){
            service.execute(() ->{
                num.getAndIncrement();
                count++;
                System.out.println(Thread.currentThread().getName() + "count=" + count);
            });
        }


        System.out.println("a:" + count);
        System.out.println("a:" + num.get());
        service.shutdown();
        while (true){
            if(service.isTerminated()){
                System.out.println(count);
                System.out.println(num.get());
                break;
            }
        }
    }

}
