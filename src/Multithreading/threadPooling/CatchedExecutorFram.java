package Multithreading.threadPooling;

import java.util.concurrent.*;

class DependentService implements Callable {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" service started.");
        Thread.sleep(2000);
        return "ok";
    }
}
public class CatchedExecutorFram {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //ExecutorService executorService = Executors.newCachedThreadPool();// dynamically adjust thread pool size
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future1 = executorService.submit(new DependentService());
        Future<String> future2 = executorService.submit(new DependentService());
        Future<String> future3 = executorService.submit(new DependentService());
        future1.get();
        future2.get();
        future3.get();

        System.out.println("All dependent services finished. Starting main service...");
        executorService.shutdown();
    }
}
