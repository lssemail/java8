package test;

import java.util.stream.Stream;

/**
 * Created by Administrator on 2018-12-27.
 */
public class TestLacalDate {

    public static void main(String[] args) {

        String path = "D:\\hik_temp_pic\\20181227-2c9f018a67e9dc1f0167eb3e7c34000d-SHUXUE-08_45_00-09_25_00\\105_1-2c9f018a67e9dc1f0167eb3e7c34000d-129-3.jpg";

        String last = path.substring(path.lastIndexOf("\\"));
        String[] infos = last.substring(1, last.length() - 4).split("-");

        Stream.of(infos).forEach(System.out::println);

    }
}
