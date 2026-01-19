import java.sql.Time;

class PrioThread extends Thread{
    public PrioThread(String name){
        super(name);//set name of thread
    }
    public void run(){
        try {
            for(int i=0;i<5;i++){
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
                Thread.yield();
            }
        }catch (InterruptedException e){
            System.out.println("in catch block");
            e.printStackTrace();
        }
    }
}

class ThreadCreate extends Thread{
    public ThreadCreate(String name){
        super(name);
    }
    public void run(){
        while(true){

        }
    }
}
public class ThreadPriority {
    public static void main(String[] args) throws InterruptedException {
        PrioThread t1 = new PrioThread("low");
        PrioThread t2 = new PrioThread("medium");
        PrioThread t3 = new PrioThread("high");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        //t1.start();
        //t2.start();
        //t3.start();
        Thread.sleep(10000);

        PrioThread p1 = new PrioThread("p1Thread");
        //p1.start();
        //p1.interrupt();// woke up sleeping threads and throw exception
        //p1.join();
        /*
        Thread methods:
            run()
            start()
            join()
            interrupt()
            yield()
            getName()
            getState()

            Types of Thread
            User Thread -> we create that thread that's only
            Daemon Thread ->

             A daemon thread is a low-priority background thread that provides support services for user (non-daemon) threads,
             like garbage collection or logging, and doesn't prevent the application from exiting;
             the Java Virtual Machine (JVM) automatically terminates daemon threads once all user threads have finished.
             These threads are essential for housekeeping tasks but aren't critical to the application's main function,
             acting as background assistants that don't block program termination.

             if all threads terminated then daemon also get terminate,
             but if user thread is alive then daemon thread wait for his termination
             and then end.
         */
          ThreadCreate mythread = new ThreadCreate("daemon1");
          mythread.setDaemon(true);// it is background thread
          ThreadCreate p2 = new ThreadCreate("prio");
          //p2.start();
          mythread.start();
          System.out.println("main done");

    }
}
