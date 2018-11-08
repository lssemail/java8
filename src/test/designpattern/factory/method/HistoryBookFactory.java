package test.designpattern.factory.method;

import test.designpattern.factory.Book;
import test.designpattern.factory.HistoryBook;

/**
 * Created by Administrator on 2018-9-10.
 */
public class HistoryBookFactory implements BookFactory {

    @Override
    public Book get() {
        return new HistoryBook();
    }
}
