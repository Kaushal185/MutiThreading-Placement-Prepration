package Oops.inheritance;
//Runtime Polymorphism (Dynamic Method Dispatch)
/*
Variables are hidden and resolved at compile time using the reference type,
whereas overridden methods are resolved at runtime using the actual object type through dynamic method dispatch.
 */
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
        Dog g = new Dog();
        Animal b = new Cat();
        Animal x = new Animal();

        System.out.println("variable is of Animal "+a.a+" "+a.b);
        System.out.println("variable is of Dog "+g.a+" "+g.b);

        System.out.println(b.b);
        Dog doggy = new Dog();
        System.out.println(doggy.a+" "+doggy.b);
        a.sound();
        b.sound();
        x.sound();
    }
}
