package mythread.test;


import static mythread.test.PrintNum.number;

/**
 * Created by Administrator on 2018-12-14.
 */
public class PrintNum {

    static Object obj = new Object();
    static volatile int number = 0;
    public static void main(String[] args) {

        new Thread(new PrintThread(1, obj)).start();
        new Thread(new PrintThread(2, obj)).start();
        new Thread(new PrintThread(3, obj)).start();
    }
}

class PrintThread implements Runnable{

    int threadId;
    Object object;

    PrintThread(int threadId, Object object){
        this.threadId = threadId;
        this.object = object;
    }

    @Override
    public void run() {
        while (number < 75){
            synchronized (object){
                if(number/5%3 + 1 == threadId){
                    for (int i = 0; i< 5; i++){
                        System.out.println("threadId=" + threadId + "number=" + (++number));
                    }
                    object.notifyAll();
                }else {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}
