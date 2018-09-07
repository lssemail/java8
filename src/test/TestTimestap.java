package test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-8-11.
 */
public class TestTimestap {

    public static void main(String[] args) {

        String str = "0x6491af3ab52e60c73042939f1e72844c5643e8835f94f3b6f6e0720d21b1e3d9";
        List<String> list = new ArrayList<>();
        list.add(str.substring(0, 24));
        list.add(str.substring(24, 48));
        list.add(str.substring(48, str.length()));
        for(String s: list){
            System.out.println(s);
        }

    }

    private static String oathFormatter(String oath){

        if(oath.length()<= 6){
            return oath;
        }
        int length = oath.length();
        String result = oath.substring(0, 3) + "****" + oath.substring(length - 3, length);
        return result;
    }
}
