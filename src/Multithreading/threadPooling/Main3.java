package Multithreading.threadPooling;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future =  executorService.submit(()->1+2);
        //Integer i = future.get();// this printed by main thread
        //System.out.println("sum is:"+i);
        //executorService.shutdown();
        //Thread.sleep(1000);
        System.out.println(executorService.isShutdown());

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
        //List<Future<Integer>> futures = executorService.invokeAll(list);//invokeAll -> execute collection of tasks
        List<Future<Integer>> futures = executorService.invokeAll(list,1,TimeUnit.SECONDS);// only live for 1 sec and terminate


        //invokeAll block main thread till completion of all the threads
        for(Future<Integer> f: futures){
            try {
                System.out.println(f.get());
            }catch (InterruptedException e){

            }catch (ExecutionException e){

            }catch (CancellationException e){

            }
        }
        executorService.shutdown();
    }
}
