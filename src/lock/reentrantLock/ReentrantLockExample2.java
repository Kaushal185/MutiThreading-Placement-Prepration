package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
Code between lock() and unlock() method is called critical section and which always written in
try block.
So unlock method will be called in finally block.
 */

/*
This is equivalent code for          Thread t1 = new Thread(()->r1.f1());

Runnable task = new Runnable() {
    @Override
    public void run() {
        r1.f1();
    }
};

Thread t1 = new Thread(task);
 */
class Resource{
    Lock lock;
    Resource(){
        lock = new ReentrantLock();
    }
    void f1(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" Entered");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" Exited");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class ReentrantLockExample2 {
    static void main() {
        Resource r1 = new Resource();
        Thread t1 = new Thread(()->r1.f1());
        Thread t2 = new Thread(()->r1.f1());
        Thread t3 = new Thread(()->r1.f1());
        t1.start();
        t2.start();
        t3.start();
    }

}
