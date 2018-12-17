package part03.chapt11;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018-12-10.
 */
public class Shop {

    private String name;

    static Random random = new Random();

    public double getPrice(String product) {

        return 0D;
    }

    public Future<Double> getPriceAsync(String product){

        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                future.complete(price);
            } catch (Exception ex) {
                ex.printStackTrace();
                future.completeExceptionally(ex);
            }
        }).start();

        return future;
    }

    public Future<Double> getPriceAsync1(String product){

        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private static double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay(){
        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    List<Shop> shops = new ArrayList<>();


    private final Executor executor = Executors.newFixedThreadPool(Math.min(10, 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {

            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    public static void main(String[] args) {
        Shop shop = new Shop();
        long start = System.nanoTime();
        Future<Double> future = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        try {
            double price = future.get(2, TimeUnit.SECONDS);
            System.out.printf("Price is %.2f%n", price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }catch (TimeoutException e){
            e.printStackTrace();
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
