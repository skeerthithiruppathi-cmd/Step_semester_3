
import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] a = {11, 22, 33, 44};
        int i = 0, j = a.length - 1;

        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        System.out.println(Arrays.toString(a));
    }
}
