
import java.util.*;

abstract class ParkedVehicle {
    protected String type;
    protected int hours;
    ParkedVehicle(String type, int hours) {
        this.type = type;
        this.hours = hours;
    }
    abstract double charge();
    String getType() { return type; }
}

class BikeParking extends ParkedVehicle {
    BikeParking(int h) { super("BIKE", h); }
    double charge() { return 10.0 * hours; }
}

class CarParking extends ParkedVehicle {
    CarParking(int h) { super("CAR", h); }
    double charge() { return 30.0 + 20.0 * (hours - 1); }
}

class TruckParking extends ParkedVehicle {
    TruckParking(int h) { super("TRUCK", h); }
    double charge() { return Math.max(50.0 * hours, 100.0); }
}

class ParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<ParkedVehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            if (type.equals("BIKE")) vehicles.add(new BikeParking(hours));
            else if (type.equals("CAR")) vehicles.add(new CarParking(hours));
            else vehicles.add(new TruckParking(hours));
        }
        double total = 0;
        for (ParkedVehicle v : vehicles) {
            double c = v.charge();
            total += c;
            System.out.println(v.getType() + ": " + String.format("%.2f", c));
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}