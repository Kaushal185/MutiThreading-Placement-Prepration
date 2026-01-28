package Multithreading.threadPooling;

/*
    1. Resource management - creating and destroy is expensive of threads,
    2. Response time
    3. Control over Tread count

     problems with manual threads
     1. manual Thread management
     2. Resource Management
     3. scalability
     4. Thread reuse
     5. error Handling

     *Executor Framework in Java.
     The Java Executor Framework (introduced in Java 5 in java.util.concurrent) is a high-level API for managing concurrent threads,
     separating task submission from execution. It uses thread pools to efficiently reuse threads, reducing overhead compared to
     creating new threads for every task. Key components include Executor, ExecutorService, and ThreadPoolExecutor


     Executor Framework interfaces:
     1) Executor
     2) ExecutorService
     3) ScheduledExecutorService

 */
public class ThreadPooling {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread[] thread = new Thread[9];
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            thread[i-1] = new Thread(
                    ()->{
                        long result = factorial(finalI);
                        System.out.println(result);
                    }
            );
            thread[i-1].start();
        }
        for (int i = 1; i < 10; i++) {
            thread[i-1].join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: "+(endTime-startTime));
/*
        for (int i = 0; i < 10; i++) {
            System.out.println(factorial(i));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: "+(endTime-startTime));

 */
    }
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

}
