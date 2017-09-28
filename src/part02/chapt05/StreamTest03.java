package part02.chapt05;

import part02.Dish;
import part02.Part2Util;

import java.util.List;

/**
 * Created by lssemail on 2017/9/25.
 */
public class StreamTest03 {

    public static void main(String[] args) {
        //test01();
        test02();
    }

    public static void test01(){
        List<Dish> dishList = Part2Util.getDishList();
        if(dishList.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("anyMatch");
        }

        if(dishList.stream().allMatch(dish -> dish.getCalories() < 100)){
            System.out.println("< 1000");
        }else {
            System.out.println("not all");
        }
    }

    public static void test02(){
            Part2Util.getDishList().stream().filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish1 -> System.out.println(dish1.getName()));
    }
}
