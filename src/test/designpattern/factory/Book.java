package test.designpattern.factory;

/**
 * Created by Administrator on 2018-9-10.
 */
public abstract class Book {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }
}
