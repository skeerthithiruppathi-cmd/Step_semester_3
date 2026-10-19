
import java.time.LocalDate;
import java.util.*;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;
    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
    abstract int validityDays();
    LocalDate renewalDate() { return startDate.plusDays(validityDays()); }
    String getName() { return name; }
}

class BasicPlan extends SubscriptionPlan {
    BasicPlan(String n, LocalDate d) { super(n, d); }
    int validityDays() { return 30; }
}

class StandardPlan extends SubscriptionPlan {
    StandardPlan(String n, LocalDate d) { super(n, d); }
    int validityDays() { return 90; }
}

class PremiumPlan extends SubscriptionPlan {
    PremiumPlan(String n, LocalDate d) { super(n, d); }
    int validityDays() { return 365; }
}

class StreamingRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<SubscriptionPlan> plans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            if (type.equals("BASIC")) plans.add(new BasicPlan(name, date));
            else if (type.equals("STANDARD")) plans.add(new StandardPlan(name, date));
            else plans.add(new PremiumPlan(name, date));
        }
        for (SubscriptionPlan p : plans) {
            System.out.println(p.getName() + ": " + p.renewalDate());
        }
    }
}