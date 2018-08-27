package mythread.countnum;

/**
 * Created by lssemail on 2018/4/12.
 */
public class CountMain {

    public static void main(String[] args) {

        MyCount myCount = new MyCount();

        AddThread addThread1 = new AddThread(myCount);
        AddThread addThread2 = new AddThread(myCount);
        AddThread addThread3 = new AddThread(myCount);
        SubThread subThread1 = new SubThread(myCount);
        SubThread subThread2 = new SubThread(myCount);

        addThread1.setName("加法1");
        addThread2.setName("加法2");

        subThread1.setName("减法1");
        subThread2.setName("减法2");

        addThread1.start();
        addThread2.start();

        subThread1.start();
        subThread2.start();
    }
}
