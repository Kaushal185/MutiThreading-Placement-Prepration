package Oops;
enum OrderStatuses{
    Initiated,
    Pending,
    Processing,
    Confirmed
}
enum UserRoles{
    Admin,
    Customer,
    Owner
}
enum Fuel{
    Disel,
    Petrol,
    Electricity,
    Water
}
abstract class Vehicles{
    private String model;
    private Fuel fuel;
    Vehicles(String model,Fuel fuel){
        this.model = model;
        this.fuel = fuel;
    }
    public String getModel() {
        return model;
    }

    public Fuel getFuel() {
        return fuel;
    }
}
class Cars extends Vehicles{
    Cars(String model,Fuel fuel){
        super(model,fuel);
    }
}
public class Enums {
    public static void main(String[] args) {
        Vehicles myCar = new Cars("Suzuki",Fuel.Petrol);
        System.out.println(myCar.getModel()+" "+myCar.getFuel());
    }
}
