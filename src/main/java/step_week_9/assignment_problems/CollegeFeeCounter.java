import java.util.*;

interface BusUser {
    double TRANSPORT_FEE = 12000;
}

abstract class Student {
    protected String name;
    Student(String name) { this.name = name; }
    abstract double tuition();
    double totalFee() {
        double fee = tuition();
        if (this instanceof BusUser) fee += BusUser.TRANSPORT_FEE;
        return fee;
    }
    String getName() { return name; }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) { super(name); }
    double tuition() { return 40000; }
}

class Hosteller extends Student {
    Hosteller(String name) { super(name); }
    double tuition() { return 40000 + 60000; }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) { super(name); }
    double tuition() { return 20000; }
}

class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            if (type.equals("DAY_SCHOLAR")) students.add(new DayScholar(name));
            else if (type.equals("HOSTELLER")) students.add(new Hosteller(name));
            else students.add(new ScholarshipStudent(name));
        }
        double total = 0;
        for (Student s : students) {
            double f = s.totalFee();
            total += f;
            System.out.println(s.getName() + ": " + String.format("%.2f", f));
        }
        System.out.println("Total Collected: " + String.format("%.2f", total));
    }
}