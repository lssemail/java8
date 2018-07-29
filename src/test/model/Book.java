package test.model;

/**
 * Created by lssemail on 2017/9/28.
 */
public class Book {

    private String name;

    private Double price;

    private BookEnum type;

    private Integer pages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BookEnum getType() {
        return type;
    }

    public void setType(BookEnum type) {
        this.type = type;
    }

    public enum BookEnum {
        Lishi, Jishu
    }

    public Book(String name, Double price, BookEnum type, Integer pages) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.pages = pages;
    }

    public Book() {}

    public static boolean isJishuBook(Book book){

        return BookEnum.Jishu.equals(book.getType());
    }
}
