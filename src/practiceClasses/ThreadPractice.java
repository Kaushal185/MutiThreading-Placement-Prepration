package practiceClasses;

class YourThread extends Thread{
    @Override
    public void run(){
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" RUNNING"+" "+i);
            }
        }catch (InterruptedException e){

        }
    }
}
public class ThreadPractice {
    public static void main(String[] args) throws InterruptedException {
        YourThread t1 = new YourThread();
        System.out.println("Before calling start state of t1: "+t1.getState());//NEW
        t1.start();
        Thread.sleep(10);
        System.out.println("after calling start state of t1: "+t1.getState());//timed-waiting or Runnable
        /*
                main thread is faster so when we call t1.start() t1 thread goes into run method but
                it not got cpu yet but in meantime main thread got cpu and it would be thinking that
                t1 called run method so it is in Runnable state.


                but if we write Thread.sleep(10) after calling t1.start(), here in span of 10ms in which main thread
                is waiting t1 got cpu and it get also called method Thread.sleep() so main will print timed-waiting state
                here.
         */
        Thread.sleep(990);
        System.out.println("after 990ms : "+t1.getState());//timed-waiting or Runnable
        t1.join();
        Thread.sleep(5000);
        System.out.println("wait in 5 seconds in main and check state: "+t1.getState());//terminated
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
        System.out.println("state of t1 at last: "+t1.getState());// terminated
    }
}
