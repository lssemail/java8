package part02.chapt05;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by lssemail on 2017/9/25.
 */
public class StreamTest07 {

    public static void main(String[] args) {
        test02();
    }

    public static void test01(){
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100)
                        .boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                        .mapToObj(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)})
                        );


        pythagoreanTriples.forEach(item -> System.out.println(item[0] + ":" + item[1] + ":" + item[2]));
    }

    public static void test02(){
        Stream<Stream<int[]>> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .map(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        );

        pythagoreanTriples.forEach(sb -> sb.forEach(item -> System.out.println(item[0] + ":" + item[1] + ":" + item[2])));
    }

    public static void test03(){
        Stream<double[]> pythagoreanTriples2 =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .mapToObj(
                                                b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                                        .filter(t -> t[2] % 1 == 0));
    }




}
