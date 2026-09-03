package Multithreading.Defogtech;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
If it is genuinely CPU-intensive, a cached thread pool is generally not a good choice.


A cached pool can potentially create a large number of threads
because it doesn't have a fixed maximum pool size in the same way as newFixedThreadPool.
 */
public class CatchedThreadPool {
    static void main() {
        //for lot of short lived tasks
        ExecutorService service = Executors.newCachedThreadPool();

        //submit the task for execution
        for(int i=0;i<100;i++){
            //service.submit(new CpuIntensiveTask());
            // cached threadpool used for short lived tasks
            // inewCachedThreadPool() is designed for many short-lived asynchronous tasks, particularly when tasks frequently finish and threads can be reused.
            service.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }

        //Don't accept any new tasks, but finish the tasks that have already been submitted.
        service.shutdown();
    }
}
