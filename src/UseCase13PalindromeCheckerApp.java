// File: UseCase13PalindromeCheckerApp.java
import java.util.*;

interface UC13PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based strategy
class UC13StackStrategy implements UC13PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String s = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);
        for (char c : s.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }
}

// Deque-based strategy
class UC13DequeStrategy implements UC13PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String s = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }
}

// Recursive strategy
class UC13RecursiveStrategy implements UC13PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String s = input.replaceAll("\\s+", "").toLowerCase();
        return check(s, 0, s.length() - 1);
    }
    private boolean check(String s, int left, int right) {
        if (left >= right) return true;
        return s.charAt(left) == s.charAt(right) && check(s, left + 1, right - 1);
    }
}

// Performance tester (non-public)
class UC13PerformanceTester {
    private String input;
    private List<UC13PalindromeStrategy> strategies = new ArrayList<>();
    private List<String> strategyNames = new ArrayList<>();

    public UC13PerformanceTester(String input) {
        this.input = input;
    }

    public void addStrategy(String name, UC13PalindromeStrategy strat) {
        strategies.add(strat);
        strategyNames.add(name);
    }

    public void runTests() {
        System.out.println("Performance comparison for input: \"" + input + "\"");
        for (int i = 0; i < strategies.size(); i++) {
            long start = System.nanoTime();
            boolean result = strategies.get(i).isPalindrome(input);
            long end = System.nanoTime();
            System.out.printf("%-15s: %s | Time: %d ns%n", strategyNames.get(i),
                    result ? "Palindrome" : "Not Palindrome", (end - start));
        }
    }
}

// Main class (no public keyword)
class UseCase13PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string for palindrome performance test:");
        String input = sc.nextLine();

        UC13PerformanceTester tester = new UC13PerformanceTester(input);
        tester.addStrategy("Stack", new UC13StackStrategy());
        tester.addStrategy("Deque", new UC13DequeStrategy());
        tester.addStrategy("Recursive", new UC13RecursiveStrategy());

        tester.runTests();
        sc.close();
    }
}