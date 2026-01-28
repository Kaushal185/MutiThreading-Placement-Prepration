package Multithreading.threadPooling;

import java.util.concurrent.*;

public class ExecuterServiceReturnsFuture {

    private static long factorial(int n){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Future<?> future = executorService.submit(()->{factorial(finalI);});
            System.out.println(future.get());
        }
        //executorService.shutdown();

        //Runnable runnable = ()->{"Hello world"};// will throw error, method inside Runnable interface has return type void
        // but when we call executorService.submit(()->{factorial(finalI);}); it use Callable interface not Runnable
        //Callable vs Runnable
        Callable callable = ()->{
            int val = 20;
            return val;
        };

    }
}
