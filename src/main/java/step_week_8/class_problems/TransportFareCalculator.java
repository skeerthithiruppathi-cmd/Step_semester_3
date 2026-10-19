import java.util.*;

abstract class Journey {
    protected String name;
    protected double distance;
    Journey(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }
    abstract double fare();
    String getName() { return name; }
}

class BusJourney extends Journey {
    BusJourney(double d) { super("BUS", d); }
    double fare() { return Math.min(2 + 0.10 * distance, 10); }
}

class TrainJourney extends Journey {
    TrainJourney(double d) { super("TRAIN", d); }
    double fare() { return 3 + 0.15 * distance; }
}

class MetroJourney extends Journey {
    private double peakHourFactor;
    MetroJourney(double d, double f) {
        super("METRO", d);
        peakHourFactor = f;
    }
    double fare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
}

class TransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double d = sc.nextDouble();
            if (type.equals("BUS")) journeys.add(new BusJourney(d));
            else if (type.equals("TRAIN")) journeys.add(new TrainJourney(d));
            else journeys.add(new MetroJourney(d, sc.nextDouble()));
        }
        double total = 0;
        for (Journey j : journeys) {
            double f = j.fare();
            total += f;
            System.out.println(j.getName() + ": " + String.format("%.2f", f));
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}