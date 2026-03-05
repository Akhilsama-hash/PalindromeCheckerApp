import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

interface PalindromeStrategy {
    boolean check(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) stack.push(c);
        for (char c : normalized.toCharArray())
            if (c != stack.pop()) return false;
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : normalized.toCharArray()) deque.addLast(c);
        while (deque.size() > 1)
            if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }
}

// Context class
class PalindromeChecker {
    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.check(input);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose strategy: 1-Stack, 2-Deque");
        int choice = sc.nextInt();

        PalindromeStrategy strategy;
        if (choice == 1) strategy = new StackStrategy();
        else strategy = new DequeStrategy();

        PalindromeChecker checker = new PalindromeChecker(strategy);

        if (checker.check(input)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is Not a Palindrome");
        }

        sc.close();
    }
}