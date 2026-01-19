
class Counter{
    private int count = 0;
    /*
    public synchronized void increment(){
        count++;// we made method synchronized
    }

     */
    public void increment(){
        synchronized(this) {
            count++;
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
