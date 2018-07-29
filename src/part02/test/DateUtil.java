package part02.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by lssemail on 2018/3/31.
 */
public class DateUtil {


    public static void main(String[] args) {

        test04();
    }


    public static void test01(){

        LocalDate date = LocalDate.of(2018, 3, 31);
        System.out.println(date.getYear());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getMonthValue());

    }

    public static void test02(){

        LocalTime localTime = LocalTime.parse("09:45:56");
//        DateTimeFormatter dtf = new DateTimeFormatter();
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());

    }

    public static void test03(){

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate localDate3 = localDate2.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(localDate2.getDayOfMonth());
        System.out.println(localDate2.getDayOfWeek());
        System.out.println(localDate2.getDayOfYear());

        System.out.println(localDate3.getDayOfYear());

    }

    public static void test04(){

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(localDate.format(formatter));


    }
}
