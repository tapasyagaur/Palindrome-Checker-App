// UseCase8PalindromeCheckerApp.java
import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListPalindromeChecker {
    Node head;

    // Convert string to linked list
    public void createLinkedList(String str) {
        head = null;
        Node tail = null;
        for (char c : str.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
    }

    // Check if the linked list is a palindrome
    public boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        // Find middle using fast and slow pointers
        Node slow = head;
        Node fast = head;
        Node prevSlow = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

        // Split the list and reverse second half
        Node secondHalf = slow;
        prevSlow.next = null; // end first half
        secondHalf = reverseList(secondHalf);

        // Compare both halves
        Node firstHalf = head;
        Node tempSecond = secondHalf;
        boolean palindrome = true;
        while (firstHalf != null && tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        // Optional: Restore original list (reverse second half back)
        secondHalf = reverseList(secondHalf);
        if (prevSlow != null) prevSlow.next = secondHalf;

        return palindrome;
    }

    private Node reverseList(Node node) {
        Node prev = null;
        Node current = node;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

public class UseCase8PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListPalindromeChecker checker = new LinkedListPalindromeChecker();

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        // Remove spaces and convert to lower case for case-insensitive comparison
        input = input.replaceAll("\\s+", "").toLowerCase();

        checker.createLinkedList(input);

        if (checker.isPalindrome()) {
            System.out.println("The string is a palindrome!");
        } else {
            System.out.println("The string is NOT a palindrome!");
        }
    }
}