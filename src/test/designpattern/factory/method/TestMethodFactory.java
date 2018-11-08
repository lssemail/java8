package test.designpattern.factory.method;

import test.designpattern.factory.Book;
import test.designpattern.factory.HistoryBook;

/**
 * Created by Administrator on 2018-9-10.
 */
public class TestMethodFactory {

    public static void main(String[] args) {
        BookFactory factory = HistoryBook::new;
        Book book = factory.get();
        System.out.println(book.getName());
    }
}
