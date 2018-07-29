package part02.chapt07;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Created by lssemail on 2018/4/23.
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long>{

    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 10_100;

    public ForkJoinSumCalculator(long[] numbers){

        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end){

        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        int length = end - start;
        if(length <= THRESHOLD){
            return computeSequentially();
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length/2);
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length/2, end);
        rightTask.fork();
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();

        return leftResult + rightResult;
    }

    private long computeSequentially(){

        long sum = 0;
        for (int i = start; i < end; i++){
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n){

        long[] numbers = LongStream.range(1, n).toArray();
        ForkJoinSumCalculator task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);

    }


    public static void main(String[] args) {
        long n = 1000000L;
        System.out.println(forkJoinSum(n));
    }

}
