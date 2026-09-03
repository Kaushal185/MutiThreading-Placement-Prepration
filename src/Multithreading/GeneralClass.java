package Multithreading;

import java.util.ArrayList;

class MyThread1 extends Thread{
    @Override
    public void run(){

    }
}
/*
class MyThread2 implements Runnable{
    @Override
    public void run(){

    }
}
 */
public class GeneralClass {
    static void main() throws InterruptedException{
        ArrayList<Integer> list = new ArrayList<>(10);
        Thread t2 = new Thread(
                ()-> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(100);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println("Thread working");
                    }
                }
        );
        t2.start();
        t2.join();
        System.out.println("Main ends");

    }
}
