package mythread.countnum;

/**
 * Created by lssemail on 2018/4/12.
 */
public class AddThread extends Thread{

    private MyCount myCount;

    public AddThread(MyCount count){

        myCount = count;
    }

    @Override
    public void run() {
        while (true){
            myCount.add();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
