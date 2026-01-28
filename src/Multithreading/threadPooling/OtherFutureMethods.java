package Multithreading.threadPooling;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class OtherFutureMethods {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(()->{
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                System.out.println("Exception occurred "+e);
            }
            return 42;
        });

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Exception occured: "+e);
        }
        future.cancel(false);// we marking cancel
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());// ya to task complete hua ho ya fir exception aya ho -> true
        executorService.shutdown();// important to close thread pool else our program is still running
        /*
            Methods of future:
            get()
            isDone() // ya to task complete hua ho ya fir exception aya ho -> true
            isCancelled()
            cancel()
            get(1,TimeUnit.SECONDS)
         */
    }
}
