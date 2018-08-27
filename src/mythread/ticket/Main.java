package mythread.ticket;

/**
 * Created by lssemail on 2018/4/12.
 */
public class Main {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket, "顾客1");
        Thread thread2 = new Thread(ticket, "顾客2");
        Thread thread3 = new Thread(ticket, "顾客3");
        Thread thread4 = new Thread(ticket, "顾客4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


    }
}
