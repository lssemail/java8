package test.designpattern.factory.method;

import test.designpattern.factory.Book;
import test.designpattern.factory.ItBook;

/**
 * Created by Administrator on 2018-9-10.
 */
public class ITBookFactory implements BookFactory{

    @Override
    public Book get() {
        return new ItBook();
    }
}
