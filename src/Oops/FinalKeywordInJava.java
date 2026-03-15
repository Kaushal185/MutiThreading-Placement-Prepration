package Oops;
// final keyworkd - method,variable,class

/*
1. final on variables - we can not reinitialize that variables again
2. final on methods - we can not override that methods into child classes
3. final on class - we can not extend that class
4. can we use final keyword? - we cannot override constructors (constructors are just methods)  -> no use for final -> not allowed error.
    final methods can not be overridden in child methods.
    final class cannot be extended into child class
 */
final class Car{
    private final double pi = 3.14;
    private final int speedLimit;
    private static final int jumpLimit;

    static {
        jumpLimit = 20;// that final variable, it must be static to initialize here
    }
    Car(){
        // final variable can be initialized in constructor,at the time of declaration,
        speedLimit = 100;
    }
    public int getSpeedLimit() {
        return speedLimit;
    }
    //setter can not be created for final variable

    public final void airBags(){
        System.out.println("4 air bags");
    }

}
/*
class EVCar extends Car{
    @Override
    public void airBags(){
        System.out.println("2 air bags");
    }
}
 */
public class FinalKeywordInJava {
    public static void main(String[] args) {

    }
}
