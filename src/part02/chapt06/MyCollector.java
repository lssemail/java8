package part02.chapt06;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by Administrator on 2018-11-8.
 */
public class MyCollector implements Collector<String, List<String>, List<String>> {

    @Override
    public Supplier<List<String>> supplier() {
        return null;
    }

    @Override
    public BiConsumer<List<String>, String> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<List<String>> combiner() {
        return null;
    }

    @Override
    public Function<List<String>, List<String>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }

    public static void main(String[] args) {


    }
}
