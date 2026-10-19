
import java.util.Scanner;

public class WordReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.next();
            String r = new StringBuilder(s).reverse().toString();

            if (s.equals(r))
                System.out.println(r + " - palindrome");
            else
                System.out.println(r + " - not a palindrome");
        }
    }
}
