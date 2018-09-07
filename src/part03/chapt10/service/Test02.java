package part03.chapt10.service;

import part03.chapt10.model.Insurance;

import java.util.Optional;

/**
 * Created by Administrator on 2018-7-28.
 */
public class Test02 {

    public static void main(String[] args) {

        Insurance insurance = new Insurance();
//        insurance.setName("pingan");

        Optional<Insurance> optional = Optional.of(insurance);
        Optional<String> name = optional.map(Insurance::getName);
        System.out.println(name);
    }
}
