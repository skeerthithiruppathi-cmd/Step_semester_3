package step_week_1.assignment_problems;
import java.util.Scanner;

public class Problem3 {

    static void findLongestStreak(String signalLog) {
        char bestColor = signalLog.charAt(0);
        int bestLength = 1;
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestColor = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + bestColor + "' repeated " + bestLength + " times");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String signalLog = sc.nextLine();

        if (signalLog.length() == 0) {
            System.out.println("Signal log is empty");
        } else {
            findLongestStreak(signalLog);
        }
    }
}