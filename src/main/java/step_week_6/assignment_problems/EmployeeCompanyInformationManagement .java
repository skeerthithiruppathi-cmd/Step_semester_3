package step_week_6.assignment_problems;
class Employee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyInformationManagement {

    public static void main(String[] args) {
        Employee first = new Employee("Divya", 65000);
        Employee second = new Employee("Arjun", 30000);
        Employee third = new Employee("Meera", 48000);
        Employee.printCompanyInfo();
    }
}