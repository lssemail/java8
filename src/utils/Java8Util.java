package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Java8Util<T> {

    public static <T> List<T> filter(List<T> list, Predicate<T> p){

        List<T> result = new ArrayList<T>();
        for(T e : list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T i: list){
            c.accept(i);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f){

        List<R> result = new ArrayList<R>();
        for(T s : list){
            result.add(f.apply(s));
        }
        return result;
    }
}
