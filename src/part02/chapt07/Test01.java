package part02.chapt07;

import java.util.stream.LongStream;

/**
 * Created by lssemail on 2018/4/23.
 */
public class Test01 {

    public static void main(String[] args) {

        long num = 10000000L;
        sequentialSum(num);
        iterativeSum(num);

        System.out.println(Runtime.getRuntime().availableProcessors());

    }

    public static long sequentialSum(long n){

        long before = System.currentTimeMillis();
        long sum = LongStream.range(1, n).parallel().reduce(0L, Long::sum);
        long offset = System.currentTimeMillis() - before;
        System.out.println("sequentialSum:" + offset);
        return sum;
    }

    public static long iterativeSum(long n){

        long before = System.currentTimeMillis();
        long sum = 0;
        for (long i=1L; i <=n; i++){
            sum +=i;
        }
        long offset = System.currentTimeMillis() - before;
        System.out.println("iterativeSum:" + offset);
        return sum;
    }
}
