// File: UseCase11PalindromeCheckerApp.java
import java.util.Scanner;

// Helper class with a unique name
class PalindromeService {
    private String input;

    public PalindromeService(String input) {
        this.input = input;
    }

    public boolean checkPalindrome() {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursive(normalized, 0, normalized.length() - 1);
    }

    private boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}

// Main class – must match file name
public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome (Object-Oriented):");
        String input = scanner.nextLine();

        // Use the uniquely named helper class
        PalindromeService checker = new PalindromeService(input);
        boolean result = checker.checkPalindrome();

        if (result) {
            System.out.println("\"" + input + "\" is a palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome!");
        }

        scanner.close();
    }
}