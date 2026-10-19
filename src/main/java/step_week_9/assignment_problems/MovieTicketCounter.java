import java.util.*;

abstract class MovieTicket {
    private static final double CONVENIENCE_FEE = 20;
    protected String seat;
    protected int count;
    MovieTicket(String seat, int count) {
        this.seat = seat;
        this.count = count;
    }
    abstract double price();
    final double amount() { return count * (price() + CONVENIENCE_FEE); }
    String getSeat() { return seat; }
}

class RegularTicket extends MovieTicket {
    RegularTicket(int c) { super("REGULAR", c); }
    double price() { return 150; }
}

class PremiumTicket extends MovieTicket {
    PremiumTicket(int c) { super("PREMIUM", c); }
    double price() { return 250; }
}

class ReclinerTicket extends MovieTicket {
    ReclinerTicket(int c) { super("RECLINER", c); }
    double price() { return 400; }
}

class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<MovieTicket> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            if (seat.equals("REGULAR")) bookings.add(new RegularTicket(count));
            else if (seat.equals("PREMIUM")) bookings.add(new PremiumTicket(count));
            else bookings.add(new ReclinerTicket(count));
        }
        double total = 0;
        for (MovieTicket t : bookings) {
            double a = t.amount();
            total += a;
            System.out.println(t.getSeat() + ": " + String.format("%.2f", a));
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}