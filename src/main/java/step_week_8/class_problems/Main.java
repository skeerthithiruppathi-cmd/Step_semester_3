import java.util.*;

abstract class PaymentMethod {
    protected String name;
    protected double amount;
    PaymentMethod(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
    abstract double finalAmount();
    String getName() { return name; }
}

class CardPayment extends PaymentMethod {
    CardPayment(double amount) { super("CARD", amount); }
    double finalAmount() { return amount * 1.02; }
}

class WalletPayment extends PaymentMethod {
    WalletPayment(double amount) { super("WALLET", amount); }
    double finalAmount() { return amount * 1.01; }
}

class BankTransferPayment extends PaymentMethod {
    BankTransferPayment(double amount) { super("BANKTRANSFER", amount); }
    double finalAmount() { return amount; }
}

public class Main {
    static PaymentMethod create(String type, double amount) {
        switch (type) {
            case "CARD": return new CardPayment(amount);
            case "WALLET": return new WalletPayment(amount);
            default: return new BankTransferPayment(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<PaymentMethod> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            payments.add(create(type, amount));
        }
        double total = 0;
        for (PaymentMethod p : payments) {
            double a = p.finalAmount();
            total += a;
            System.out.println(p.getName() + ": " + String.format("%.2f", a));
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}