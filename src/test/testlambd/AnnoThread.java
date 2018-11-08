package test.testlambd;

/**
 * Created by Administrator on 2018-9-10.
 */
public class AnnoThread {

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("Runnable");
        }).start();

    }
}
