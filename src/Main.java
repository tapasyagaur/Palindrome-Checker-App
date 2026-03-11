import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class PalindromeChecker{
    boolean isPalindrome(String str){
        Queue<Character> q = new LinkedList<>();
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            q.offer(str.charAt(i));
            s.push(str.charAt(i));
        }

        for(int i=0;i<str.length();i++){
            if(q.poll() != s.pop()){
                return false;
            }
        }

        return true;
    }
}

class Main{
    public static void main(String[] args){
        PalindromeChecker c = new PalindromeChecker();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter String: ");
        String str = input.nextLine();

        System.out.println("Is it a palindrome string?");
        System.out.println(c.isPalindrome(str) ? "Yes" : "No");
    }
}
