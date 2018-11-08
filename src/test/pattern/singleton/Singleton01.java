package test.pattern.singleton;

/**
 * Created by Administrator on 2018-9-17.
 */
public class Singleton01 {

    private Singleton01(){}

    public static Singleton01 instance = null;

    public static Singleton01 getInstance(){

        if(instance == null){
            synchronized (Singleton01.class){
                if (instance == null){
                    instance = new Singleton01();
                    System.out.println("init");
                }
            }
        }

        return instance;
    }

    public void print(){
        System.out.println("hello world");
    }
}
