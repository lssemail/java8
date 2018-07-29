package mythread.sumnum;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by lssemail on 2018/4/12.
 */
public class CountThread extends Thread{

    private int start;

    private int end;

    private CyclicBarrier barrier;

    public CountThread(int id, int start, int end, CyclicBarrier barrier){

        this.start = start;
        this.end = end;
        this.barrier = barrier;
        setName("Thread-" + id);
    }

    @Override
    public void run() {

        int count = 0;
        for (int i=start; i<= end; i++){
            count+=i;
        }
        Counter.totalCount(count);
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


        super.run();
    }
}
