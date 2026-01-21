package deadlock;
/*
    Deadlock is a situation in multithreading where two or more threads
    are blocked forever, waiting for each other to release a resource.
    This typically occurs when two or more threads have circular dependencies
    on set of locks.


    1. Mutual Exclution:
    2. Hold and wait:
    3. No preemption
    4. Circular wait:
 */


/*
  expalining example:
  pen and paper are resources
  task1  have pen but not paper
  task2 have paper but not pen

  both are doing writing task
  task1 wants paper and task2 wants pen
  so deadlock happened both are waiting for each other to release resource
  and not progressing.


  synchronized keyword we always use on the on method in which
  critical section is present.
  ex. class Pen and Paper

  we not use this on class which extending Thread or implementing Runnable interface.
 */
class Pen{
    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName()+" us using pen "+this+ " and trying to write");
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finished using pen "+this);
    }
}

class Paper{
    public synchronized void writeWithPenAndPaper(Pen pen){
        System.out.println(Thread.currentThread().getName()+" is using paper "+this+" and trying to write");
        pen.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finished using paper "+this);
    }
}
class Task1 implements Runnable{
    private Pen pen;
    private Paper paper;
    public Task1(Pen pen,Paper paper){
        this.pen = pen;
        this.paper = paper;
    }
    @Override
    public void run(){
        pen.writeWithPenAndPaper(paper);
    }
}

class Task2 implements Runnable{
    private Pen pen;
    private Paper paper;
    public Task2(Pen pen,Paper paper){
        this.pen = pen;
        this.paper = paper;
    }
    @Override
    public void run(){
        paper.writeWithPenAndPaper(pen);
    }
}

public class DeadkLock {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread t1 = new Thread(new Task1(pen,paper),"Thread1");
        Thread t2 = new Thread(new Task2(pen,paper),"Thread2");
        t1.start();
        t2.start();
    }
}
