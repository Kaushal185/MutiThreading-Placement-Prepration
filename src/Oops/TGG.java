package Oops;

abstract class Vehicle{
    String fuel;
    String model;
    Vehicle(){

    }
    Vehicle(String fuel,String model){
        this.fuel = fuel;
        this.model = model;
    }
    abstract String getFuel();
    abstract String getModel();


}
//when we use abstract keyword variables are also accessible by child class
class SUV extends Vehicle{
    SUV(String fuel,String model){
        super(fuel,model);
    }
    String getFuel(){
      return this.fuel;
    }

    String getModel(){
        return this.model;
    }
}

class Sedan extends Vehicle{
    Sedan(){

    }
    Sedan(String fuel,String model){
        super(fuel,model);
    }
    String getFuel(){
        return this.fuel;
    }
    String getModel(){
        return this.model;
    }
}
public class TGG {
    public static void main(String[] args) {
        Vehicle xuv = new SUV("DISEL","TATA");
        Vehicle i20 = new Sedan("PETROL","Suzuki");
        System.out.println(xuv.getFuel()+" "+xuv.getModel());
        System.out.println(i20.getFuel()+" "+i20.getModel());
    }
}
