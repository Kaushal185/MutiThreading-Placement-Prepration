package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {

    // Creating a Lock object using ReentrantLock
    // By default ReentrantLock is "UNFAIR" (not FIFO)
    // Meaning: Any thread can acquire the lock next, not necessarily the one waiting longest
    private final Lock unfailerLock = new ReentrantLock();

    // This method represents a shared resource which multiple threads will access
    public void accessResource() {

        // Thread tries to acquire the lock
        // If another thread already holds it, this thread will wait (block) until lock is free
        unfailerLock.lock();

        try {
            // Once lock is acquired, thread enters the critical section
            System.out.println(Thread.currentThread().getName() + " acquired the lock");

            // Simulating some work inside the critical section
            // Thread will hold the lock for 1 second
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            // If thread is interrupted while sleeping, restore the interrupt status
            Thread.currentThread().interrupt();

        } finally {
            // This block ALWAYS runs, whether exception occurs or not

            // Printing before releasing the lock
            System.out.println(Thread.currentThread().getName() + " release the lock");

            // Unlocking the lock so that other waiting threads can acquire it
            // NOTE: First print happens, then unlock happens
            unfailerLock.unlock();
        }
    }

    public static void main(String[] args) {

        UnfairLockExample example = new UnfairLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        // Starting all threads almost at the same time
        // They will compete for the same lock
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
