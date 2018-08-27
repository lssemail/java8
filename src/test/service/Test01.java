package test.service;

import test.DataUtil;
import test.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by lssemail on 2017/9/28.
 */
public class Test01 {

    public static void main(String[] args) {

//        test01(Book::isJishuBook);
//        Book.BookEnum lishi = Book.BookEnum.Lishi;
//        test01((Book b) -> b.getType().equals(lishi));
//        test02();
        test3();
    }

    public static void test01(Predicate<Book> predicate){

        List<Book> result = new ArrayList<>();
        for(Book book : DataUtil.bookList()){
            if(predicate.test(book)){
                result.add(book);
            }
        }
        System.out.println(result.size());
    }

    public static void test02(){
        List<Book> list = DataUtil.bookList();
        Map<Book.BookEnum, List<Book>> map =
                list.stream().collect(Collectors.groupingBy(Book::getType));
        System.out.println(map);
    }

    public static void test3(){
        List<Book> list = DataUtil.bookList();
        List<String> nameList = list.stream().map(book -> book.getName()).collect(Collectors.toList());
        System.out.println(nameList);
    }
}
