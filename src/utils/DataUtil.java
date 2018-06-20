package utils;

import part01.model.Apple;
import test.testpredicate.CommonPredicate;
import test.testpredicate.PrintPredicate;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {


    public static List<Apple> getAppleList(){

        List<Apple> list = new ArrayList<>();
            list.add(new Apple(110, "red", "红苹果1号"));
            list.add(new Apple(112, "red", "红苹果2号"));
            list.add(new Apple(113, "red", "红苹果3号"));
            list.add(new Apple(114, "red", "红苹果4号"));

            list.add(new Apple(80, "green", "青苹果1号"));
            list.add(new Apple(82, "green", "青苹果2号"));
            list.add(new Apple(83, "green", "青苹果3号"));
            list.add(new Apple(84, "green", "青苹果4号"));

        return list;
    }

    public static List<Apple> filterAppleList(CommonPredicate<Apple> predicate){

        List<Apple> returnList = new ArrayList<>();

        for (Apple apple : getAppleList()){
            if(predicate.test(apple)){
                returnList.add(apple);
            }
        }

        return returnList;
    }

    public static void pintAppleProperty(PrintPredicate<Apple> predicate){

        for (Apple apple : getAppleList()){
            String output = predicate.accept(apple);
            System.out.println(output);
        }
    }
}
