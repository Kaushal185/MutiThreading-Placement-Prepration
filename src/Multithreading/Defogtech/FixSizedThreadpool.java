package Multithreading.Defogtech;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CpuIntensiveTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class One {

      static void main(String[] args) {

        // Create thread pool
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Current core count: " + coreCount);

        ExecutorService executorService =
                Executors.newFixedThreadPool(coreCount);

        long startTime = System.currentTimeMillis();

        // Submit 100 tasks
        for (int i = 0; i < 100; i++) {
            executorService.submit(new CpuIntensiveTask());
        }

        // Stop accepting new tasks
        executorService.shutdown();

        // Wait for all tasks to complete
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis() - startTime;

        System.out.println("Total time taken: " + endTime + " ms");
    }
}