package Oops.allAboutMaps;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample{


    private static final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        map.put("counter",0);// multiple threads putting counter in map
        Runnable task = ()->{
            for(int i=0;i<1000;i++){
                System.out.println(Thread.currentThread().getName());
                map.compute("counter",(k,v)->v+1);
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("Final Counter Value: " + map.get("counter"));

    }
}