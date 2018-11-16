package part02.chapt06;

import part02.Dish;
import part02.Part2Util;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

/**
 * Created by lssemail on 2017/9/25.
 */
public class StreamCollect01 {

    public static void main(String[] args) {
        test07();
    }

    public static void test01(){
        List<Dish> dishList = Part2Util.getDishList();
        long dishes = dishList.stream().collect(counting());
        System.out.println(dishes);
    }

    public static void test02(){
        List<Dish> dishList = Part2Util.getDishList();
        String names = dishList.stream().map(Dish::getName)
            .collect(joining());
        System.out.println(names);
    }

    public static void test03(){
        List<Dish> dishList = Part2Util.getDishList();
        Map<Dish.Type, List<Dish>> dishesByType =
                dishList.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);
    }

    public static void test04(){
        List<Dish> dishList = Part2Util.getDishList();
        Map<CaloricLevel, List<Dish>> dishesByType =
            dishList.stream().collect(groupingBy(dish ->{
                if(dish.getCalories() <= 400){
                    return CaloricLevel.DEAF;
                }else if(dish.getCalories() <= 700){
                    return CaloricLevel.NORMAL;
                }else {
                    return CaloricLevel.FAT;
                }
            }));
        System.out.println(dishesByType);
    }

    public static void test05(){
        List<Dish> dishList = Part2Util.getDishList();
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByType =
            dishList.stream().collect(groupingBy(Dish::getType, groupingBy(dish ->{
                if(dish.getCalories() <= 400){
                    return CaloricLevel.DEAF;
                }else if(dish.getCalories() <= 700){
                    return CaloricLevel.NORMAL;
                }else {
                    return CaloricLevel.FAT;
                }
        })));
        System.out.println(dishesByType);
    }

    public static void test06(){
        List<Dish> dishList = Part2Util.getDishList();
        Map<Dish.Type, Long> typesCount = dishList.stream()
                .collect(groupingBy(Dish::getType, counting()));
        System.out.println(typesCount);
    }

    public static void test07(){
        List<Dish> dishList = Part2Util.getDishList();
        Map<Dish.Type, Optional<Dish>> typesCount = dishList.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(typesCount);
    }


    public enum CaloricLevel{DEAF, NORMAL, FAT}
}
