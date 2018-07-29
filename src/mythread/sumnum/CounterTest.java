package mythread.sumnum;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lssemail on 2018/4/12.
 */
public class CounterTest {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(10, new TotalTask(new Counter()));
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i< 10; i++){
            int start = i*10 + 1;
            int end = start + 9;
            CountThread countThread = new CountThread(i, start, end, barrier);
            executorService.execute(countThread);
        }
        executorService.shutdown();

    }
}
