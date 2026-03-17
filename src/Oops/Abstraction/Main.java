package Oops.Abstraction;

abstract class Animal{
    public abstract void sayHello();
    public void sleep(){
        System.out.println("zzz...");
    }
}
class Dog extends Animal{
    public void sayHello(){
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
