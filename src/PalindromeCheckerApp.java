import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            queue.add(input.charAt(i));
            stack.push(input.charAt(i));
        }

        System.out.print("Queue (FIFO): ");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll());
        }
        System.out.println();

        System.out.print("Stack (LIFO): ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();

        sc.close();
    }
}