package part01.chapt02.service;

import part01.chapt02.impl.AppleHeavyWeightPredicate;
import part01.chapt02.interfaces.AppleFormatter;
import part01.chapt02.interfaces.ApplePredicate;
import part01.model.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lssemail on 2017/8/11.
 * 对 filterApples 的行为参数化
 */
public class AppleService {

    private static List<Apple> inventory = null;
    static {
        inventory = new ArrayList<>();
        Apple apple = new Apple();
        apple.setName("apple");
        apple.setColor("red");
        apple.setWight(157);
        inventory.add(apple);
    }

    //查询苹果的入口，封装方法
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static void printName(List<Apple> inventory, AppleFormatter f){
        for(Apple apple : inventory){
            System.out.println(f.accept(apple));
        }
    }

    public static void main(String[] args) {
        List<Apple> appleList = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> appleList1 = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(appleList.size());
        System.out.println(appleList1.size());
    }
}
