package Multithreading.Defogtech;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ScheduledTask implements Runnable {

    private final String taskName;

    ScheduledTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(
                taskName + " | Thread: " +
                        Thread.currentThread().getName() +
                        " | Time: " +
                        System.currentTimeMillis()
        );

        try {
            // Simulate task execution
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ScheduledThreadPool {

     static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(2);

        // 1. Execute ONCE after 5 seconds
        scheduler.schedule(
                new ScheduledTask("One-Time Task"),
                5,
                TimeUnit.SECONDS
        );

        // 2. Execute repeatedly at a FIXED RATE
        scheduler.scheduleAtFixedRate(
                new ScheduledTask("Fixed-Rate Task"),
                2,              // initial delay
                5,              // period
                TimeUnit.SECONDS
        );

        // 3. Execute repeatedly with FIXED DELAY
        scheduler.scheduleWithFixedDelay(
                new ScheduledTask("Fixed-Delay Task"),
                2,              // initial delay
                5,              // delay AFTER previous task completes
                TimeUnit.SECONDS
        );

        // In a real application, don't immediately shutdown
        // because we want scheduled tasks to continue running.
    }
}
