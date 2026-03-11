// File name: UseCase12PalindromeCheckerApp.java
import java.util.*;

interface UC12PalindromeStrategy {
    boolean isPalindrome(String input);
}

class UC12StackStrategy implements UC12PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String s = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);
        for (char c : s.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }
}

class UC12DequeStrategy implements UC12PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String s = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }
}

class UC12PalindromeContext {
    private UC12PalindromeStrategy strategy;
    public UC12PalindromeContext(UC12PalindromeStrategy strategy) { this.strategy = strategy; }
    public boolean checkPalindrome(String input) { return strategy.isPalindrome(input); }
}

class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string:");
        String input = sc.nextLine();
        System.out.println("Choose strategy: 1-Stack, 2-Deque");
        int choice = sc.nextInt(); sc.nextLine();
        UC12PalindromeStrategy strat = (choice==1)? new UC12StackStrategy() : new UC12DequeStrategy();
        UC12PalindromeContext ctx = new UC12PalindromeContext(strat);
        System.out.println(ctx.checkPalindrome(input)? "\"" + input + "\" is a palindrome!" : "\"" + input + "\" is NOT a palindrome!");
        sc.close();
    }
}