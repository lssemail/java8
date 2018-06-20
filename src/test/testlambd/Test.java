package test.testlambd;

import utils.DataUtil;
import utils.Java8Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/6/20.
 */
public class Test {

    public static void main(String[] args) {

//        Runnable r1 = () -> System.out.println("hello world 1!");
//
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello world 2!");
//            }
//        };
//
//        r1.run();
//        r2.run();

        file();

        Java8Util.forEach(Arrays.asList(1, 2, 3, 4, 5, 7), (item) -> System.out.println(item));

        List<String> nameList = Java8Util.map(DataUtil.getAppleList(), item -> item.getName());

        Java8Util.forEach(nameList, (item) -> System.out.println(item));
    }

    public static void file(){

        System.out.println(processFile((BufferedReader br) -> br.readLine()));
    }

    public static String processFile(BufferedReaderProcessor p){

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/test/testlambd/data.txt"));
            return p.process(br);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
