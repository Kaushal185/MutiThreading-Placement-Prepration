package Multithreading;

import java.util.ArrayList;

//String is slow - on every change it will create new object (immutable).
//StringBuffer is threadsafe but StringBuilder is not. But both are mutable.
//StringBuiler is faster
class BufferVsBuilder extends Thread{
    static StringBuffer sb = new StringBuffer("");
    static int counter = 1;
    @Override
    public void run(){
        sb.append("a");
        synchronized (BufferVsBuilder.class){
            counter++;// making counter synchronized because it is a shared resource.
        }
        System.out.println(Thread.currentThread().getName());
    }
}

class StringBufferIsThreadSafe {

    public static void main(String args[]) throws InterruptedException{
        final ArrayList<BufferVsBuilder> threads = new ArrayList<>(100);
        BufferVsBuilder thread = new BufferVsBuilder();
        for(int i=0;i<1000;i++){
            thread = new BufferVsBuilder();
            thread.start();
            threads.add(thread);
        }
        for (BufferVsBuilder t : threads) {
            t.join();
        }
        System.out.println("length of sb: "+ BufferVsBuilder.sb.length());
        System.out.println("value of counter: "+ BufferVsBuilder.counter);

    }
}

