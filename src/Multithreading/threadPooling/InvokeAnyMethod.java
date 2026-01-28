package Multithreading.threadPooling;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAnyMethod {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> callable1 = ()->{
            System.out.println("Task1");
            Thread.sleep(1000);
            return 1;
        };
        Callable<Integer> callable2 = ()->{
            System.out.println("Task2");
            Thread.sleep(1000);
            return 2;
        };
        Callable<Integer> callable3 = ()->{
            System.out.println("Task3");
            Thread.sleep(1000);
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1,callable2,callable3);
        try {
            Integer i = executorService.invokeAny(list);// execute all tasks and return result of 1st task executed.
            System.out.println("output of invokeAny: "+i);
        }catch (InterruptedException | CancellationException | ExecutionException e){

        }
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
