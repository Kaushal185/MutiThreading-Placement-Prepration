package Oops.inheritance;

class Animal{
    int a = 10;
    int b = 20;
    void sound(){
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal{
    int a = 25;
    int b = 35;
    void sound(){
        System.out.println("Dog barks");
    }
}
class Cat extends Animal{
    void sound(){
        System.out.println("Cat meow");
    }
}
/*
Key Concept to Remember

Variables → Compile-time (reference type decides)
Methods → Runtime (object type decides)

Variables are hidden, not overridden.
 */
public class Inheritance {
    public static void main(String[] args) {
        Animal a = new Dog();
        Animal b = new Cat();
        Animal x = new Animal();
        System.out.println(a.a);
        System.out.println(b.b);
        Dog doggy = new Dog();
        System.out.println(doggy.a+" "+doggy.b);
        a.sound();
        b.sound();
        x.sound();
    }
}
