package part01.chapt03.service;

/**
 * Created by lssemail on 2017/9/11.
 */
public class LamdUseService {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        useLamdO1();
    }

    public static void useLamdO1(){
        Runnable runnable = () -> System.out.println("hello java8");
        runnable.run();
    }
}
