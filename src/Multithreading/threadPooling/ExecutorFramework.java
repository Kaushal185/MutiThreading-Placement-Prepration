package Multithreading.threadPooling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFramework {
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

    public static void main(String[] args) {
        long startTime =System.currentTimeMillis();
        //Runnable runnable = () ->{};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            executorService.submit(
                    ()->{
                        long result = factorial(finalI);
                        System.out.println(result);
                    }
            );
        }
        executorService.shutdown();
        //executorService.awaitTermination(1,TimeUnit.SECONDS);// 100 sec wait for executor to finish nahi to aage badh jao
        try {
            while(!executorService.awaitTermination(100,TimeUnit.MILLISECONDS)){
                //this is for unlimited wait for main thread.
                System.out.println("Waiting...");
            }
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: "+(endTime-startTime));

        //Callable vs Runnalbe

    }
}
