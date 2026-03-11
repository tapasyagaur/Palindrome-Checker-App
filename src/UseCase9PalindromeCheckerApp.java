// File: UseCase9PalindromeCheckerApp.java
import java.util.Scanner;

public class UseCase9PalindromeCheckerApp {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        // Base condition: if start >= end, string is a palindrome
        if (start >= end) {
            return true;
        }
        // If characters at start and end do not match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        // Recursive call for next characters
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        // Remove spaces and convert to lowercase for uniform checking
        String formattedInput = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(formattedInput, 0, formattedInput.length() - 1);

        if (result) {
            System.out.println("\"" + input + "\" is a palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome!");
        }

        scanner.close();
    }
}