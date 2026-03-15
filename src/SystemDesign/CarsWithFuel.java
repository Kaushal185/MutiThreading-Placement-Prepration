package SystemDesign;

enum FuelType{
    DISEL,PETROL,ELECTRIC
}

interface Vehicle{
    FuelType getFuleType();
    String getModel();
}
class Car implements Vehicle{
    FuelType fuelType;
    String Model;
    Car(FuelType fuelType,String Model){
        this.fuelType = fuelType;
        this.Model = Model;
    }

    @Override
    public FuelType getFuleType() {
        return this.fuelType;
    }

    @Override
    public String getModel() {
        return this.Model;
    }
}
class DiselCar extends Car{
    DiselCar(String Model){
        super(FuelType.DISEL,Model);
    }
}
public class CarsWithFuel {
    public static void main(String[] args) {
        Vehicle v1 = new DiselCar("Hyundai i20");
        System.out.println(v1.getModel()+" "+v1.getFuleType());
    }
}
