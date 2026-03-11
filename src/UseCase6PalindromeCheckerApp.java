import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {

        // Hardcoded string to check
        String word = "deed";

        // Create a queue (FIFO) and a stack (LIFO)
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Add characters to both queue and stack
        for (char ch : word.toCharArray()) {
            queue.add(ch);   // enqueue
            stack.push(ch);  // push
        }

        // Compare dequeue vs pop
        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}