package mythread.sumnum;

/**
 * Created by lssemail on 2018/4/12.
 */
public class Counter {

    private static int count = 0;

    public synchronized static int totalCount(int preCount){

        System.out.println(Thread.currentThread().getName() + "\tpreCount=" + preCount);
        count+=preCount;
        return count;
    }

    public int getTotal(){

        return count;
    }
}
