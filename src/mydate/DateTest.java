package mydate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by lssemail on 2018/4/12.
 */
public class DateTest {

    public static void main(String[]  args) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
        try {
            Date date = dateFormat.parse("2018-07-09");
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date newDate = calendar.getTime();
        } catch (ParseException e) {

        }
    }

}
