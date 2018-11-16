package part03.chapt12;

import org.omg.PortableInterceptor.INACTIVE;
import part03.chapt10.model.Insurance;

import javax.smartcardio.TerminalFactory;
import java.security.acl.Owner;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Administrator on 2018-11-16.
 */
public class Test02 {

    public static void main(String[] args) {

        //testLocalData();
        testInstant();

    }

    static void testInstant(){

        Instant now = Instant.now();
        System.out.println(now.toString());
        System.out.println(now.getEpochSecond());
        System.out.println(now.getNano());
        now.plusMillis(3);
        System.out.println(now.plusMillis(3).getEpochSecond());
    }

    static void testLocalData(){

        LocalDate today = LocalDate.now();
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("firstDayOfThisMonth:" + firstDayOfThisMonth);

    }

    static void testLocalTime(){

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());
        System.out.println(localDateTime.toString());


    }
}
