package review;

/**
 * Created by lssemail on 2017/10/9.
 */
public interface IPrint {

    default void print(String string){
        System.out.println(string);
    }

    default void read(){
        System.out.println("read");
    }
}
