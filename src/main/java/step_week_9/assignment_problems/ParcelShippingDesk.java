import java.util.*;

interface Insurable {
    double insurance();
}

abstract class Parcel {
    protected String type;
    protected double weight;
    protected double declaredValue;
    Parcel(String type, double weight, double declaredValue) {
        this.type = type;
        this.weight = weight;
        this.declaredValue = declaredValue;
    }
    abstract double charge();
    String getType() { return type; }
}

class StandardParcel extends Parcel {
    StandardParcel(double w, double v) { super("STANDARD", w, v); }
    double charge() { return 40 + 10 * weight; }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double w, double v) { super("EXPRESS", w, v); }
    double charge() { return 80 + 15 * weight; }
    public double insurance() { return 0.02 * declaredValue; }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double w, double v) { super("FRAGILE", w, v); }
    double charge() { return 40 + 10 * weight + 50; }
    public double insurance() { return 0.02 * declaredValue; }
}

class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double v = sc.nextDouble();
            if (type.equals("STANDARD")) parcels.add(new StandardParcel(w, v));
            else if (type.equals("EXPRESS")) parcels.add(new ExpressParcel(w, v));
            else parcels.add(new FragileParcel(w, v));
        }
        double grand = 0;
        for (Parcel p : parcels) {
            double c = p.charge();
            double ins = 0;
            if (p instanceof Insurable) ins = ((Insurable) p).insurance();
            double t = c + ins;
            grand += t;
            System.out.println(p.getType() + ": Charge=" + String.format("%.2f", c)
                    + " Insurance=" + String.format("%.2f", ins)
                    + " Total=" + String.format("%.2f", t));
        }
        System.out.println("Grand Total: " + String.format("%.2f", grand));
    }
}