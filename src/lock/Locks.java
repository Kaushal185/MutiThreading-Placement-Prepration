package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    intrincic-> automatic lock, when we use synchronized keyword
    explicit
 */
/*
class BankAccount{
    private int balance = 100;

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+"attempting withdraw");

        if(balance > amount){
            System.out.println(Thread.currentThread().getName()+"proceeding with withdrawal");
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){

            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName()+" "+"insufficient balance");

        }{
            System.out.println(Thread.currentThread().getName()+" "+"completed withdrawal remaining balance amount = "+balance);
        }
    }
}

 */
class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();// this is key
    // below methods is washroom
    // who is going washroom lock the room
    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" attempting withdraw");
        try{
            if(lock.tryLock(4000, TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    try {
                        System.out.println(Thread.currentThread().getName()+" proceeding with withdrawal");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()+" completed withdrawal. Remaining balance "+balance);
                    }catch (Exception e){
                        Thread.currentThread().interrupt();
                    }
                    finally {
                        lock.unlock();//removing the acquired lock
                    }
                }else{
                    System.out.println(Thread.currentThread().getName()+" insuffienciet balance");
                }
            }else{
                System.out.println(Thread.currentThread().getName()+" ould not acquire the lock, will try later");
            }
        }catch(Exception e){
            Thread.currentThread().interrupt();
        }
    }
}
public class Locks {
    public static void main(String[] args) {
        /*
        BankAccount bankAccount = new BankAccount();
        Runnable task = new Runnable(){
            @Override
            public void run(){
                bankAccount.withdraw(50);
            }

        };
        Thread t1 = new Thread("Thread1");
        Thread t2 = new Thread("Thread2");

         */

    BankAccount sbi = new BankAccount();
    Runnable task = new Runnable(){
        @Override
        public void run(){
            sbi.withdraw(50);
        }
    };
    Thread t1 = new Thread(task,"Thread 1");
    Thread t2 = new Thread(task,"Thread 2");
    t1.start();
    t2.start();
    }
}
