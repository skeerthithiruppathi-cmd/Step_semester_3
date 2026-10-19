
import java.util.*;

abstract class Employee {
    protected String name;
    protected double salary;
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    abstract double bonus();
    String getName() { return name; }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.10; }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.05; }
}

class InternEmployee extends Employee {
    InternEmployee(String n, double s) { super(n, s); }
    double bonus() { return 2000; }
}

class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            if (type.equals("FULLTIME")) employees.add(new FullTimeEmployee(name, salary));
            else if (type.equals("PARTTIME")) employees.add(new PartTimeEmployee(name, salary));
            else employees.add(new InternEmployee(name, salary));
        }
        double total = 0;
        for (Employee e : employees) {
            double b = e.bonus();
            total += b;
            System.out.println(e.getName() + ": " + String.format("%.2f", b));
        }
        System.out.println("Total Bonus: " + String.format("%.2f", total));
    }
}