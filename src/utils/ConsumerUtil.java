package utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by lssemail on 2017/9/11.
 */
public class ConsumerUtil {

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T i: list){
            c.accept(i);
        }
    }
}
