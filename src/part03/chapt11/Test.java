package part03.chapt11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-12-10.
 */
public class Test {

    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        list.add(3L);
        list.add(6L);
        list.add(2L);

        double avg = list.stream().mapToLong(Long::valueOf).average().getAsDouble();
        System.out.println(avg);
        System.out.println(avg < 5D);


    }
}
