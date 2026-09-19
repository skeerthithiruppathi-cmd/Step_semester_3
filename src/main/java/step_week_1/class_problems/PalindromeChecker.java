package step_week_1.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false; // mismatch found
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }
    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return Arrays.equals(original, reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String input = sc.nextLine();
        String text = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        System.out.println("\nInput: \"" + input + "\"");
        System.out.println("Iterative: " + (iterative ? "Palindrome" : "Not Palindrome")
                + " | Recursive: " + (recursive ? "Palindrome" : "Not Palindrome")
                + " | Array Reversal: " + (arrayReversal ? "Palindrome" : "Not Palindrome"));
        if (iterative == recursive && recursive == arrayReversal) {
            System.out.println("All three approaches agree.");
        } else {
            System.out.println("Mismatch found - check the logic!");
        }

        sc.close();
    }
}