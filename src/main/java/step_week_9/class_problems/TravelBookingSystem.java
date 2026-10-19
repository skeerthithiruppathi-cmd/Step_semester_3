import java.util.*;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50;
    protected String mode;
    protected double distance;
    TravelBooking(String mode, double distance) {
        this.mode = mode;
        this.distance = distance;
    }
    abstract double baseFare();
    final double totalFare() { return baseFare() + BOOKING_FEE; }
    String getMode() { return mode; }
}

class BusBooking extends TravelBooking {
    BusBooking(double d) { super("BUS", d); }
    double baseFare() { return 2.0 * distance; }
}

class TrainBooking extends TravelBooking {
    TrainBooking(double d) { super("TRAIN", d); }
    double baseFare() { return 1.5 * distance; }
}

class FlightBooking extends TravelBooking {
    FlightBooking(double d) { super("FLIGHT", d); }
    double baseFare() { return 2500 + 4.0 * distance; }
}

class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double d = sc.nextDouble();
            if (mode.equals("BUS")) bookings.add(new BusBooking(d));
            else if (mode.equals("TRAIN")) bookings.add(new TrainBooking(d));
            else bookings.add(new FlightBooking(d));
        }
        for (TravelBooking b : bookings) {
            System.out.println(b.getMode() + ": " + String.format("%.2f", b.totalFare()));
        }
    }
}