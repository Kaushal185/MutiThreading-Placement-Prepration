package practiceClasses;

class Mythread implements Runnable{
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
public class Practice2 {
    public static void main(String[] args) throws InterruptedException {

        Mythread mythread = new Mythread();
        Thread t1 = new Thread(mythread,"Kaushal");
        t1.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("namaste world");
            }
        };
        Thread t2 = new Thread(runnable);
        t2.start();

        Thread t3 = new Thread(
                ()->{
                    System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
                },"IronMan"
        );
        t3.start();
        t3.join();
    }
}
