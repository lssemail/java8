package part03.chapt11;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2018-12-10.
 */
public class TestFuture {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                System.out.println("begin");
                Thread.sleep(5000L);
                System.out.println("end");
                return 1.0D;
            }
        });

        try {
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println(0);
        }
    }
}
