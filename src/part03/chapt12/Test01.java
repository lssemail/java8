package part03.chapt12;

import jodd.util.ClassLoaderUtil;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * Created by lssemail on 2017/9/28.
 */
public class Test01 {

    public static void main(String[] args) {
        testLocalDate();
    }

    public static void testLocalDate(){
        LocalDate date = LocalDate.of(2017, 3, 13);
        System.out.println(date.getYear());
        System.out.println(date.getDayOfMonth());
        System.out.println(LocalDate.now());

        System.out.println(date.get(ChronoField.YEAR));

        System.out.println(1.4f != 1.4f);
    }
}
