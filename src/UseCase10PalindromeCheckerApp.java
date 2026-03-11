// File: UseCase10PalindromeCheckerApp.java
import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) { // Base condition
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1); // Recursive call
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome (case-insensitive, spaces ignored):");
        String input = scanner.nextLine();

        // Normalize the string: remove spaces and convert to lowercase
        String normalizedInput = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(normalizedInput, 0, normalizedInput.length() - 1);

        if (result) {
            System.out.println("\"" + input + "\" is a palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome!");
        }

        scanner.close();
    }
}