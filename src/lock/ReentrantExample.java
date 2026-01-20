package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock = new ReentrantLock();
    public void outerMethod(){
        lock.lock();
        try{
            System.out.println("Outer method");
            innerMethod();
        }finally {
            lock.unlock();
        }
    }

    public void innerMethod(){
        lock.lock();// so lock ir Reentranant to thread can re enter again and increase hold count.
        //prevent deadlock live situation.
        //lock.lockInterruptibility();// thread2 waiting indefinite time for thread 1 to finish,
        //but this lock interrupt thread1 and acquire that lock
        /*
           ReentrantLock in Java is a flexible, explicit lock from java.util.concurrent.locks that allows the same thread to acquire a lock multiple times (reentrancy),
           unlike basic synchronized blocks, preventing self-deadlock and offering advanced features like tryLock() (timed/interruptible attempts),
           fairness policies, and multiple conditions for finer-grained thread synchronization. It requires manual lock() and unlock() calls,
           typically within a try-finally block to guarantee release.

            Reentrancy: A thread holding the lock can re-acquire it without blocking, incrementing a "hold count".
            Explicit Control: Requires manual lock() and unlock() calls, offering more control than synchronized.
            Advanced Features:
            tryLock(): Attempt to acquire the lock without waiting indefinitely.
            Interruptible Locks: Threads waiting for the lock can be interrupted.
            Fairness: Can be configured to grant access in a first-come, first-served order.
         */
        try{
            System.out.println("Inner method");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();
    }

}
