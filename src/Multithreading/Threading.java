package Multithreading;

public class Threading {
    public static void main(String[] args) throws InterruptedException {
        /*
        Runnable withRunnable = ()->{
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };

         */

        Thread t1 = new Thread(
            ()->{
                try{
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        );
        System.out.println(t1.getName()+" "+t1.getState());
        t1.start();

        System.out.println(t1.getName()+" "+t1.getState());

        try {
            t1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());

        System.out.println(t1.getName()+" "+t1.getState());

        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
    }
}
