package part03.chapt10.model;

import java.util.Optional;

/**
 * Created by lssemail on 2017/9/28.
 */
public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
