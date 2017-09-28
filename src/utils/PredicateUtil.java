package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by lssemail on 2017/8/11.
 */
public class PredicateUtil {

    public static <T> List<T> filter(List<T> list, Predicate<T> p){

        List<T> result = new ArrayList<T>();
        for(T e : list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }


}
