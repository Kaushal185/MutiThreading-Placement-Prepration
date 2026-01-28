package Multithreading;

class MyThreading extends Thread{
    public void run(){
        try {
            System.out.println("RUNNING");
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class AllStates {
    public static void main(String[] args)throws InterruptedException {
        MyThreading t1 = new MyThreading();
        System.out.println(t1.getState());//NEW
        t1.start();//NEW -> RUNNABLE
        System.out.println(t1.getState());//t1 is in RUNNABLE
        Thread.sleep(100);// main thread RUNNABLE -> TIMED WAITING for 100ms
        System.out.println(t1.getState());//100ms lapsed main is RUNNABLE, 2000ms-100ms time remaining for t1,so t1 still in TIMED WAITING state.
        t1.join();// main will wait for execution of t1
        System.out.println(t1.getState());//t1 terminated and main starts execution.
    }
}
