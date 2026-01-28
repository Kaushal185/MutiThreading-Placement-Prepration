package Multithreading;
//FunctionalInterface -> Interfaces with single abstract method is present is called
//ex. Runnable is functional interface

/*
    Lambda Expression - anonymous function
    Anonymous: It does not have a name.
    Functionality as Data: It lets you treat a block of code (functionality) as an object that can be passed around and executed on demand.
    Functional Interface Implementation: A lambda expression provides the implementation for the single abstract method defined in a functional interface
    (an interface with exactly one abstract method).
    Concise Syntax: It provides a compact, readable syntax compared to traditional anonymous inner classes.
 */
public class LmbdaExpression {


    public static void main(String[] args) {
        Runnable task = new Runnable(){
            @Override
            public void run() {

            }
        };
        Runnable task2 = ()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };

        Runnable task3 = ()-> System.out.println("Hello");// executing single statement so {} removed
    }

}
