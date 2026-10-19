import java.util.*;

interface NightService {
    double NIGHT_SURCHARGE = 0.20;
}

abstract class Cab {
    private static final double MINIMUM_FARE = 100;
    protected String type;
    Cab(String type) { this.type = type; }
    abstract double ratePerKm();
    double dayFare(double km) { return Math.max(km * ratePerKm(), MINIMUM_FARE); }
    String getType() { return type; }
}

class MiniCab extends Cab {
    MiniCab() { super("MINI"); }
    double ratePerKm() { return 10; }
}

class SedanCab extends Cab implements NightService {
    SedanCab() { super("SEDAN"); }
    double ratePerKm() { return 14; }
}

class SuvCab extends Cab implements NightService {
    SuvCab() { super("SUV"); }
    double ratePerKm() { return 18; }
}

class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab;
            if (type.equals("MINI")) cab = new MiniCab();
            else if (type.equals("SEDAN")) cab = new SedanCab();
            else cab = new SuvCab();
            double fare = cab.dayFare(km);
            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    fare = fare * (1 + NightService.NIGHT_SURCHARGE);
                } else {
                    System.out.println(cab.getType() + ": night service not available");
                    continue;
                }
            }
            total += fare;
            System.out.println(cab.getType() + ": " + String.format("%.2f", fare));
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}