package Multithreading;

class Counter{
    private int count = 0;
    /*
    public synchronized void increment(){
        count++;// we made method synchronized
        //if multiple threads working on critical section and the
        //final result is affected this is called race condition.
    }
     */
    public void increment(){
        synchronized(this) {
            count++;//this is critical section (common resource accessed by multiple processes)
            //mutual exclution -> only 1 thread access critical<> section at a time.
        }
    }
    public int getCount() {
        return this.count;
    }
}
class TempThread extends Thread{
    private Counter counter;
    public TempThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for(int i=0;i<10000;i++){
            counter.increment();
        }
    }
}
public class Synchronization {
    public static void main(String[] args){
        Counter counter = new Counter();
        TempThread t1 = new TempThread(counter);
        TempThread t2 = new TempThread(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();// written join to finish both t1 and t2 then print count value;
        }catch (InterruptedException e){

        }
        System.out.println(counter.getCount());
    }

}
