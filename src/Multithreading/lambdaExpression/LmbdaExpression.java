package Multithreading.lambdaExpression;
//FunctionalInterface -> Interfaces with single abstract method is present is called
//ex. Runnable is functional interface

/*
    Lambda Expression - anonymous function
    Anonymous: It does not have a name.
    Functionality as Data: It lets you treat a block of code (functionality) as an object that can be passed around and executed on demand.
    Functional Interface Implementation: A lambda expression provides the implementation for the single abstract method defined in a functional interface
    (an interface with exactly one abstract method).
    Concise Syntax: It provides a compact, readable syntax compared to traditional anonymous inner classes.
 */

import java.util.HashMap;

/*
How join works?
🔍 What Actually Happens
    Step-by-step:
    t1.start() → Thread t1 starts
    t2.start() → Thread t2 starts
    t1.join() → main thread waits ONLY for t1
    t2 → runs independently (no one is waiting for it)
 */
class R1 implements Runnable{

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("kaushal "+Thread.currentThread().getName()+" "+Thread.currentThread().getState());
                Thread.sleep(100);
            }
        }catch (InterruptedException e){

        }
    }
}
public class LmbdaExpression {


    public static void main(String[] args) throws InterruptedException {
        Runnable task = new Runnable(){
            @Override
            public void run() {

            }
        };
        Runnable task2 = ()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };

        Runnable task3 = ()-> System.out.println("Hello");// executing single statement so {} removed
        Thread t1 = new Thread(task); // instead of passing task we can direct pass lambda
        Thread t2 = new Thread(()->{
           try {
               Thread.sleep(1000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        });


        Thread g1 = new Thread(new R1());
        g1.start();

        Thread tt = new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println("hello");
            }
        });
        tt.start();
        tt.join();
        System.out.println("state of tt is "+tt.getState());
    }


}

