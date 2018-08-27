package review;

import test.DataUtil;
import test.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by lssemail on 2017/10/9.
 * 运用传递方法 构建工具类
 */
public class Test02 {

    public static void main(String[] args) {

        List<Book> bookList = listFilter(DataUtil.bookList(), Book::isJishuBook);
        System.out.println(bookList);
    }

    public static <T> List<T> listFilter(List<T> list, Predicate<T> predicate){

        List<T> list1 = new ArrayList<T>();
        for(T t : list){
            if(predicate.test(t)){
                list1.add(t);
            }
        }
        return list1;
    }
}
