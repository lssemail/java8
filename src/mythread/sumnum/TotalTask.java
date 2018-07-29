package mythread.sumnum;

/**
 * Created by lssemail on 2018/4/12.
 */
public class TotalTask implements Runnable{


    private Counter counter;

    public TotalTask(Counter counter){

        this.counter = counter;
    }
    @Override
    public void run() {
        System.out.println("线程执行完成，汇总结果是:" + counter.getTotal());
    }
}
