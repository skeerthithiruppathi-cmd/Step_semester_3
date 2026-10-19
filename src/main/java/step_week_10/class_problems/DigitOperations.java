
import java.util.Scanner;

public class DigitOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0, rev = 0;

        while (n > 0) {
            int d = n % 10;
            sum += d;
            rev = rev * 10 + d;
            n /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + rev);
    }
}
