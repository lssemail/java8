package mythread.countnum;

/**
 * Created by lssemail on 2018/4/12.
 */
public class MyCount {

    public static volatile int count = 1;

    public synchronized void add(){
        count++;
        System.out.println(Thread.currentThread().getName() + "执行加法, count=" + count);

    }

    public synchronized void sub(){
        count--;
        System.out.println(Thread.currentThread().getName() + "执行减法, count=" + count);

    }

}
