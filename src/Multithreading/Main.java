package Multithreading;

class MyThread extends Thread{
    public void run(){
        try {
            for(int i=0;i<5;i++){
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class World implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread());
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException{
        /*
        Thread States:
        New
        Runnable
        Running
        Timed Waiting
        Waiting/Blocked
        Terminated
         */
        MyThread t1 = new MyThread();
        System.out.println(t1.getName()+" "+t1.getState());
        t1.start();
        System.out.println(t1.getName()+" "+t1.getState());
        //t1.join();
        /*
         The Thread.join() method is used for thread synchronization.
         It pauses the execution of the current thread until,
         the thread on which the join() method is called completes its execution (dies)
         */
        //Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
        Thread.sleep(100);
        /*
        main calls t1.start(). t1 is now NEW -> RUNNABLE.
        main hits Thread.sleep(100) and goes to sleep.
        t1 gains control of the CPU, enters run(), and hits Thread.sleep(1000).
        t1 is now in TIMED_WAITING because it is waiting exactly 1000ms to wake up.
        main wakes up after its 100ms nap. It checks t1.getState().
        Since t1 is still in its 1000ms sleep, main prints: Thread-0 TIMED_WAITING.
         */
        System.out.println(t1.getName()+" "+t1.getState());
        t1.join();// main method waiting for t1 to terminate
        System.out.println(t1.getName()+" "+t1.getState());;

        /*
            exteds Thread vs implements Runnable
            java does not support multiple inheritance
            ex. class A extends B, Implements Runnable{}
         */

    }
}