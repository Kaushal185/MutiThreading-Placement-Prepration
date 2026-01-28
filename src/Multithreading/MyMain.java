package Multithreading;

class WithExtends extends Thread{
    public void run(){
        //run method extended from Thread class can not throws InterruptedExcpetion
        //we have to handle it via try and catch in the which in which it is extended
        try {
            Thread.sleep(5000);
        }catch (InterruptedException exception){
            exception.printStackTrace();;
        }
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
        }

    }
}

class WithRunnable implements Runnable{
    public void run(){
        try {
            for(int i=0;i<5;i++){
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

public class MyMain {
    public static void main(String[] args)throws InterruptedException {
        //Created Thread with extending Thread class
        WithExtends t1 = new WithExtends();//NEW
        t1.start();//RUNNABLE,RUNNING
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
        }

        WithRunnable withRunnable = new WithRunnable();
        Thread t2 = new Thread(withRunnable);
        t2.start();

    }
}