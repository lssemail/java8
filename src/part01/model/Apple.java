package part01.model;

/**
 * Created by lssemail on 2017/8/11.
 */
public class Apple {

    private int wight;

    private String color;

    private String name;

    private Integer price;

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "wight=" + wight +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
