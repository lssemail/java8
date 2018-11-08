package test.testpredicate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018-9-18.
 */
public class DateUtil {

    public static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(()->{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat;
    });

    public static void main(String[] args) throws Exception{
        Date result = DateUtil.df.get().parse("2018-09-18");
        System.out.println(result);
    }
}
