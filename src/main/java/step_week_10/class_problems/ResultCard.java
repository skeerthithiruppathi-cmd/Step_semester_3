
import java.util.Scanner;

class StudentRecord {
    String name;
    int[] marks;

    StudentRecord(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        return (marks[0] + marks[1] + marks[2]) / 3.0;
    }

    char grade() {
        double avg = average();

        if (avg >= 90)
            return 'A';
        else if (avg >= 75)
            return 'B';
        else if (avg >= 60)
            return 'C';
        else if (avg >= 40)
            return 'D';
        else
            return 'F';
    }
}

public class ResultCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String name = sc.next();
            int[] marks = new int[3];

            for (int i = 0; i < 3; i++)
                marks[i] = sc.nextInt();

            StudentRecord s = new StudentRecord(name, marks);

            System.out.printf("%s: Average %.1f, Grade %c%n",
                    s.name.toUpperCase(), s.average(), s.grade());
        }
    }
}
