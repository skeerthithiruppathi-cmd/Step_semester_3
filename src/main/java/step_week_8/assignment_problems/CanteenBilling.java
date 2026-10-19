import java.util.*;

abstract class Customer {
    protected String type;
    protected double bill;
    Customer(String type, double bill) {
        this.type = type;
        this.bill = bill;
    }
    abstract double finalAmount();
    String getType() { return type; }
}

class StudentCustomer extends Customer {
    StudentCustomer(double bill) { super("STUDENT", bill); }
    double finalAmount() { return bill * 0.90; }
}

class StaffCustomer extends Customer {
    StaffCustomer(double bill) { super("STAFF", bill); }
    double finalAmount() { return bill * 0.95; }
}

class GuestCustomer extends Customer {
    GuestCustomer(double bill) { super("GUEST", bill); }
    double finalAmount() { return bill + 10; }
}

class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            if (type.equals("STUDENT")) customers.add(new StudentCustomer(amount));
            else if (type.equals("STAFF")) customers.add(new StaffCustomer(amount));
            else customers.add(new GuestCustomer(amount));
        }
        double total = 0;
        for (Customer c : customers) {
            double a = c.finalAmount();
            total += a;
            System.out.println(c.getType() + ": " + String.format("%.2f", a));
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}