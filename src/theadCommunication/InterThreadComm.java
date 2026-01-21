package theadCommunication;

/*
    Inter-thread communication (ITC) is how concurrent threads within the same process exchange data and synchronize actions,
    preventing conflicts and coordinating tasks, often using methods like wait(), notify(), and notifyAll() (Java) or
    condition variables/events (Python) to signal when resources are ready or conditions are met, avoiding busy-waiting for better performance.

    Synchronization: Ensures threads access shared resources safely, one at a time, preventing race conditions (like incorrect counter values).
    Cooperation: Threads signal each other to coordinate flow (e.g., a producer thread sends data, then waits; a consumer thread receives data and signals the producer).
    Blocking/Waiting: A thread pauses execution (releases its lock) until another thread notifies it that a condition has changed.

    wait(): Called by a thread in a synchronized block to pause itself and release the lock, waiting for a signal.
    notify(): Wakes up one arbitrarily chosen thread waiting on the same object.
    notifyAll(): Wakes up all threads waiting on the same object.

    *wait and notify used only in synchronized method.
  */

class SharedResource{
    private int data;
    private boolean hasData;// producer produce data if hasData is false.
                            // consumer consumes data if hasData if true.
    public synchronized void produce(int value){
        while (hasData){
            try {
                wait();// data hai to wait kariye
            }catch (Exception e){
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced:"+value);
        notify();// notify other consumer
    }
    public synchronized int consume(){
        while(!hasData){
            try{
                wait();
            }catch (Exception e){
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: "+data);
        notify();// notify to producer
        return data;
    }
}
class Producer implements Runnable{
    private SharedResource resource;
    public Producer(SharedResource resource){
        this.resource = resource;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            resource.produce(i);
        }
    }
}
class Consumer implements Runnable{
    private SharedResource resource;
    public Consumer(SharedResource resource){
        this.resource = resource;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            int value = resource.consume();
        }
    }
}
public class InterThreadComm {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Producer producer = new Producer(resource);// producer implements Runnable interface
        Consumer consumer = new Consumer(resource);// consumer implements Runnable interface
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
/*
    Thread safety: when multiple thread accessing it and unexpected results will not come
    or race condition will not occur.
 */
