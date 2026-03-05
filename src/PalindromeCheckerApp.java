import java.util.Scanner;
import java.util.Stack;

class PalindromeChecker {

    private String data;

    public PalindromeChecker(String data) {
        this.data = data;
    }

    public boolean checkPalindrome() {
        Stack<Character> stack = new Stack<>();
        String normalized = data.replaceAll("\\s+", "").toLowerCase();

        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) return false;
        }

        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeChecker checker = new PalindromeChecker(input);

        if (checker.checkPalindrome()) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is Not a Palindrome");
        }

        sc.close();
    }
}