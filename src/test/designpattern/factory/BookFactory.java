package test.designpattern.factory;

/**
 * Created by Administrator on 2018-9-10.
 */
public class BookFactory {

    public static Book getBook(Class<? extends Book> clazz){

        Book book = null;
        try {
            if(ItBook.class.equals(clazz)){
                book = ItBook.class.newInstance();
            }else if(HistoryBook.class.equals(clazz)){
                book = HistoryBook.class.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return book;

    }
}
