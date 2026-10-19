import java.util.*;

interface SaverCapable {
    double SAVER_FACTOR = 0.75;
}

abstract class Appliance {
    private static final double RATE_PER_UNIT = 8;
    protected String name;
    protected double hours;
    Appliance(String name, double hours) {
        this.name = name;
        this.hours = hours;
    }
    abstract double powerWatts();
    double units(boolean saver) {
        double u = powerWatts() * hours / 1000;
        if (saver && this instanceof SaverCapable) u = u * SaverCapable.SAVER_FACTOR;
        return u;
    }
    double cost(double units) { return units * RATE_PER_UNIT; }
    String getName() { return name; }
}

class Fridge extends Appliance {
    Fridge(double h) { super("FRIDGE", h); }
    double powerWatts() { return 150; }
}

class AirConditioner extends Appliance implements SaverCapable {
    AirConditioner(double h) { super("AC", h); }
    double powerWatts() { return 1500; }
}

class Television extends Appliance {
    Television(double h) { super("TV", h); }
    double powerWatts() { return 100; }
}

class WashingMachine extends Appliance implements SaverCapable {
    WashingMachine(double h) { super("WASHER", h); }
    double powerWatts() { return 500; }
}

class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");
            Appliance a;
            if (parts[0].equals("FRIDGE")) a = new Fridge(hours);
            else if (parts[0].equals("AC")) a = new AirConditioner(hours);
            else if (parts[0].equals("TV")) a = new Television(hours);
            else a = new WashingMachine(hours);
            if (saver && !(a instanceof SaverCapable)) {
                System.out.println(a.getName() + ": saver mode not supported");
                continue;
            }
            double u = a.units(saver);
            double c = a.cost(u);
            total += c;
            System.out.println(a.getName() + ": Units=" + String.format("%.2f", u)
                    + " Cost=" + String.format("%.2f", c));
        }
        System.out.println("Total Cost: " + String.format("%.2f", total));
    }
}