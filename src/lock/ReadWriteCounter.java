package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment(){
        writeLock.lock();
        try {
            count++;
            Thread.sleep(50);
        }catch (InterruptedException e){

        } finally {
            writeLock.unlock();
        }
    }
    public int getCount(){
        readLock.lock();// multiple threads can acquire this readlock
        //readlock and writelock are related
        //readlock only acquired only if writelock is not acquired by anyone.
        try {
            return count;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {

        ReadWriteCounter counter = new ReadWriteCounter();
        Runnable readTask = new Runnable(){
            @Override
            public void run(){
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+" read: "+counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable(){
            @Override
            public void run(){
                for(int i=0;i<10;i++){
                    counter.increment();
                    System.out.println(Thread.currentThread().getName()+" incremented");
                }
            }
        };

        Thread writerThread = new Thread(writeTask);
        Thread readerThread1 = new Thread(readTask);
        Thread readerThread2 = new Thread(readTask);

        writerThread.start();
        readerThread1.start();
        readerThread2.start();

        System.out.println("Final count: "+counter.getCount());

    }

}
