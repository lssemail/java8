package part03.chapt10.service;

import part03.chapt10.model.Car;
import part03.chapt10.model.Insurance;
import part03.chapt10.model.Person;

import java.util.Optional;

/**
 * Created by lssemail on 2017/9/28.
 */
public class Test01 {

    public static void main(String[] args) {

    }

    public static void test01(){
        Optional<Car> optCar1 = Optional.empty();
        Car car = null;
        Optional<Car> optCar2 = Optional.of(car);

        Optional<Car> optCar3 = Optional.ofNullable(car);

    }

    public static void test02(){
        Optional<Insurance> insurance = Optional.ofNullable(new Insurance());
        Optional<String> name = insurance.map(Insurance::getName);
    }

    public static void test03(){

    }

    public String getCarInsuranceName(Optional<Person> person){

        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
