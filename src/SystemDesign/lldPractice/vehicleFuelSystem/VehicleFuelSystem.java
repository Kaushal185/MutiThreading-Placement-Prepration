package SystemDesign.lldPractice.vehicleFuelSystem;
enum FuelType{
    DISEL,
    PETROL,
    EV
}
abstract class Vehicle{
    String model;
    FuelType fuelType;
    Vehicle(FuelType fuelType,String model){
        this.fuelType = fuelType;
        this.model = model;
    }
    abstract FuelType getFuelType();
    abstract String getModel();
}
class Car extends Vehicle {
    Car(FuelType fuelType,String model){
        super(fuelType,model);
    }
    FuelType getFuelType(){
        return fuelType;
    }
    String getModel(){
        return model;
    }
}
public class VehicleFuelSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Car(FuelType.DISEL,"Maruti Suzuki");
        System.out.println(v1.getFuelType()+" "+v1.getModel());
    }
}
