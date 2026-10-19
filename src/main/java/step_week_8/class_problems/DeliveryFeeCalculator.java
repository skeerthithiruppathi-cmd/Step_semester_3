import java.util.*;

abstract class Delivery {
    protected String name;
    protected double weight;
    protected double distance;
    Delivery(String name, double weight, double distance) {
        this.name = name;
        this.weight = weight;
        this.distance = distance;
    }
    abstract double fee();
    String getName() { return name; }
}

class StandardDelivery extends Delivery {
    StandardDelivery(double w, double d) { super("STANDARD", w, d); }
    double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double w, double d) { super("EXPRESS", w, d); }
    double fee() { return 15 + 1.00 * weight + 0.20 * distance; }
}

class InternationalDelivery extends Delivery {
    private double customsFee;
    InternationalDelivery(double w, double d, double c) {
        super("INTERNATIONAL", w, d);
        customsFee = c;
    }
    double fee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
}

class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double d = sc.nextDouble();
            if (type.equals("STANDARD")) deliveries.add(new StandardDelivery(w, d));
            else if (type.equals("EXPRESS")) deliveries.add(new ExpressDelivery(w, d));
            else deliveries.add(new InternationalDelivery(w, d, sc.nextDouble()));
        }
        double total = 0;
        for (Delivery d : deliveries) {
            double f = d.fee();
            total += f;
            System.out.println(d.getName() + ": " + String.format("%.2f", f));
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}