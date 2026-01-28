package Multithreading.threadPooling;

import java.util.concurrent.*;

/**
 * TOPIC: ScheduledExecutorService (The Modern Replacement for java.util.Timer)
 * * WHY USE IT?
 * 1. Handles multiple threads (Timer is single-threaded).
 * 2. Exception Safety: One task failing doesn't kill the whole scheduler.
 * 3. Precision: Uses nanosecond precision internally via System.nanoTime().
 */
public class ScheduleExecutorServiceLearn {
    public static void main(String[] args) {
        // Pool size should typically be based on number of concurrent scheduled tasks
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // 1. ONE-SHOT EXECUTION
        // Use Case: Triggering an event after a specific delay (e.g., a "session timeout" alert)
        scheduler.schedule(
                () -> System.out.println("LOG: One-time task executed!"),
                5, TimeUnit.SECONDS
        );

        // 2. FIXED RATE (Start-to-Start)
        // Interval is constant regardless of task duration.
        // Period = 5s, Task takes 2s -> Next task starts 5s after the FIRST started.

        scheduler.scheduleAtFixedRate(
                () -> {
                    System.out.println("LOG: Fixed Rate Tick at: " + System.currentTimeMillis());
                    // NOTE: If this task blocks, subsequent executions are delayed but not concurrent.
                },
                0, 5, TimeUnit.SECONDS
        );

        // 3. FIXED DELAY (End-to-Start)
        // Interval is calculated AFTER the task completes.
        // Delay = 5s, Task takes 2s -> Next task starts 7s after the FIRST started.

        ScheduledFuture<?> delayHandle = scheduler.scheduleWithFixedDelay(
                () -> {
                    try {
                        System.out.println("LOG: Fixed Delay Task processing...");
                        Thread.sleep(2000); // Simulate work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                },
                5, 5, TimeUnit.SECONDS
        );

        // 4. GRACEFUL SHUTDOWN
        // Important: Scheduled tasks keep the JVM alive. Always shut down!
        scheduler.schedule(() -> {
            System.out.println("CRITICAL: Shutting down scheduler...");
            scheduler.shutdown();
        }, 30, TimeUnit.SECONDS);
    }
}