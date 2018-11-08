package test.designpattern.factory;

/**
 * Created by Administrator on 2018-9-10.
 */
public class BookTest {

    public static void main(String[] args) {
        Book book = BookFactory.getBook(ItBook.class);
        book.setName("ITBook");
        System.out.println(book.getName());

    }
}
