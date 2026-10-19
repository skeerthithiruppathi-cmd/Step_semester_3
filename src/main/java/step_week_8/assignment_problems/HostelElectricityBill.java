
import java.util.*;

abstract class HostelRoom {
    protected String type;
    protected int units;
    protected int occupants;
    HostelRoom(String type, int units, int occupants) {
        this.type = type;
        this.units = units;
        this.occupants = occupants;
    }
    abstract double bill();
    String getType() { return type; }
}

class SingleRoom extends HostelRoom {
    SingleRoom(int units) { super("SINGLE", units, 1); }
    double bill() { return 8.0 * units; }
}

class SharedRoom extends HostelRoom {
    SharedRoom(int units, int occupants) { super("SHARED", units, occupants); }
    double bill() { return 6.0 * units / occupants; }
}

class AcRoom extends HostelRoom {
    AcRoom(int units) { super("AC", units, 1); }
    double bill() { return 10.0 * units + 200; }
}

class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<HostelRoom> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            if (type.equals("SINGLE")) rooms.add(new SingleRoom(units));
            else if (type.equals("SHARED")) rooms.add(new SharedRoom(units, sc.nextInt()));
            else rooms.add(new AcRoom(units));
        }
        double total = 0;
        for (HostelRoom r : rooms) {
            double b = r.bill();
            total += b;
            System.out.println(r.getType() + ": " + String.format("%.2f", b));
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}