package mythread.ticket;

/**
 * Created by lssemail on 2018/4/12.
 */
public class Ticket implements Runnable{

    private Integer count = 23;
    private Object lock = new Object();

    private void sellTicket(){
        synchronized (lock){

            if (count > 0){
                count--;
                System.out.println(Thread.currentThread().getName() + "购买了一张票，当前票数:" + count);
            }else {
                System.out.println(Thread.currentThread().getName() + "想买票，但是票卖完了:");
            }
        }

    }

    @Override
    public void run() {

        while (count > 0){
            sellTicket();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
