package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by lssemail on 2017/9/11.
 */
public class FunctionUtil {

    public static <T, R> List<R> map(List<T> list, Function<T, R> f){

        List<R> result = new ArrayList<R>();
        for(T s : list){
            result.add(f.apply(s));
        }
        return result;
    }
}
