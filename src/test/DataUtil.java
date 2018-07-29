package test;

import test.model.Book;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lssemail on 2017/9/28.
 */
public class DataUtil {

    public static List<Book> bookList(){
        Book book1 = new Book("Java 修炼手册", 124D, Book.BookEnum.Jishu, 123);
        Book book2 = new Book("JS基础教程", 84D, Book.BookEnum.Jishu, 333);
        Book book3 = new Book("中国上下五千年", 54D, Book.BookEnum.Lishi, 432);
        Book book4 = new Book("史记", 444D, Book.BookEnum.Lishi, 276);
        Book book5 = new Book("Linux ", 104D, Book.BookEnum.Jishu, 12);

        return Arrays.asList(book1, book2, book3, book4, book5);
    }
}
