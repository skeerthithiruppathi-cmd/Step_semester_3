import java.util.*;

abstract class Connection {
    protected String type;
    protected int units;
    Connection(String type, int units) {
        this.type = type;
        this.units = units;
    }
    abstract double bill();
    String getType() { return type; }
}

class HomeConnection extends Connection {
    HomeConnection(int u) { super("HOME", u); }
    double bill() {
        if (units <= 100) return 5.0 * units;
        return 500.0 + 7.0 * (units - 100);
    }
}

class ShopConnection extends Connection {
    ShopConnection(int u) { super("SHOP", u); }
    double bill() { return 8.0 * units + 100; }
}

class FactoryConnection extends Connection {
    FactoryConnection(int u) { super("FACTORY", u); }
    double bill() { return Math.max(6.0 * units, 1000.0); }
}

class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            if (type.equals("HOME")) connections.add(new HomeConnection(units));
            else if (type.equals("SHOP")) connections.add(new ShopConnection(units));
            else connections.add(new FactoryConnection(units));
        }
        double total = 0;
        for (Connection c : connections) {
            double b = c.bill();
            total += b;
            System.out.println(c.getType() + ": " + String.format("%.2f", b));
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}