package mythread.countnum;

/**
 * Created by lssemail on 2018/4/12.
 */
public class SubThread extends Thread{

    private MyCount myCount;

    public SubThread(MyCount count){

        myCount = count;
    }

    @Override
    public void run() {
        while (true) {
            myCount.sub();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
