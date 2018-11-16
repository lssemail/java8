package test;

import java.net.SocketTimeoutException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018-10-16.
 */
public class DateTest {

    public static void main(String[] args) {

        List<Double> list = Arrays.asList(0.4, 0.45, 0.56, 0.32, 0.1);
        Optional<Double> min = list.stream().collect(Collectors.minBy(Comparator.comparingDouble(Double::doubleValue)));
        double avg = list.stream().filter(item -> item > min.get()).collect(Collectors.averagingDouble(Double::doubleValue));
        System.out.println(avg);

    }





    public static int getGradeByJoinYear(int joinYear){

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int off = year - joinYear;
        //若是8月份之后,应该多一级;
        if(month > 7){
            off +=1;
        }
        return off;
    }

    public static int getJoinYear(String grade){

        int igrade = Integer.parseInt(grade);
        igrade = igrade % 7;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 3);
        int month = calendar.get(Calendar.MONTH);
        igrade = igrade - 1;
        if(month <= 7){
            igrade = 0 - igrade;
        }
        calendar.add(Calendar.YEAR, igrade);
        int year = calendar.get(Calendar.YEAR);

        return year;
    }

    public static Date getStartDateTime(String time){

        List<Integer> times = Arrays.asList(time.split(":")).stream().map(Integer::parseInt).collect(Collectors.toList());
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, times.get(0));
        calendar.set(Calendar.MINUTE, times.get(1));
        calendar.set(Calendar.SECOND, times.get(2));
        return calendar.getTime();

    }

    public static int getTodayOfWeek(){

        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_WEEK);
        return today - 1;
    }

    public static List<Map<String, Date>> getDaysOfLastWeek(int n){

        List<Map<String, Date>> list = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, (7 * n));

        for(int i = Calendar.MONDAY; i <= Calendar.FRIDAY; i++){
            Map<String, Date> date = new HashMap<>(2);
            calendar.set(Calendar.DAY_OF_WEEK, i);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            Date startDate = calendar.getTime();
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            Date endDate = calendar.getTime();

            date.put("start", startDate);
            date.put("end", endDate);

            list.add(date);
        }

        return list;

    }



    public static Date[] getLastWeekDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        Date startDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        Date endDate = calendar.getTime();

        return new Date[]{startDate, endDate};
    }



    public static Date[] getLastHalfMonth() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        Date endDate = calendar.getTime();

        calendar.add(Calendar.DATE, -15);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        Date startDate = calendar.getTime();




        return new Date[]{startDate, endDate};
    }
}