package SystemDesign.lldPractice.parkingLot;

import java.util.ArrayList;
import java.util.List;

enum VehicleType {
    BIKE, CAR, TRUCK
}
class Vehicle {
    private String number;
    private VehicleType type;

    public Vehicle(String number, VehicleType type) {
        this.number = number;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}
class ParkingSpot {
    private int id;//fix - decided at the time of spot creation
    private VehicleType type;//fix
    private boolean occupied;// variables
    private Vehicle vehicle;//variables

    public ParkingSpot(int id, VehicleType type) {
        this.id = id;
        this.type = type;
        this.occupied = false;
    }

    public boolean canFitVehicle(Vehicle v) {
        return !occupied && v.getType() == this.type;
        // return occupied == false && v.getType() == this.type();
    }

    public void park(Vehicle v) {
        this.vehicle = v;
        this.occupied = true;
    }

    public void unpark() {
        this.vehicle = null;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getId() {
        return id;
    }
}

class ParkingLot {
    private List<ParkingSpot> spots;

    public ParkingLot(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public ParkingSpot parkVehicle(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (spot.canFitVehicle(v)) {
                spot.park(v);
                System.out.println("Vehicle parked at spot: " + spot.getId());
                return spot;
            }
        }
        System.out.println("No available spot for vehicle");
        return null;
    }

    public void unparkVehicle(int spotId) {
        for (ParkingSpot spot : spots) {
            if (spot.getId() == spotId && spot.isOccupied()) {
                spot.unpark();
                System.out.println("Vehicle removed from spot: " + spotId);
                return;
            }
        }
        System.out.println("Invalid spot or already empty");
    }
}

public class Main {
    public static void main(String[] args) {

        List<ParkingSpot> spots = new ArrayList<>();
        spots.add(new ParkingSpot(1, VehicleType.CAR));
        spots.add(new ParkingSpot(2, VehicleType.BIKE));
        spots.add(new ParkingSpot(3, VehicleType.TRUCK));

        ParkingLot parkingLot = new ParkingLot(spots);

        Vehicle car1 = new Vehicle("MH12AB1234", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("MH12XY5678", VehicleType.BIKE);
        Vehicle truck1 = new Vehicle("MH12XY5612", VehicleType.TRUCK);
        Vehicle truck2 = new Vehicle("MH12XY5613", VehicleType.TRUCK);


        ParkingSpot s1 = parkingLot.parkVehicle(car1);
        ParkingSpot s2 = parkingLot.parkVehicle(bike1);
        ParkingSpot s3 = parkingLot.parkVehicle(truck1);
        ParkingSpot s4 = parkingLot.parkVehicle(truck2);


        parkingLot.unparkVehicle(s3.getId());

        ParkingSpot s5 = parkingLot.parkVehicle(truck2);

    }
}