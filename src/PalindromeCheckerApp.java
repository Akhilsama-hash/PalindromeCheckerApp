import java.util.Scanner;

class Node {
    char data;
    Node next;
    Node(char data) { this.data = data; this.next = null; }
}

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String str) {
        Node head = null, tail = null;
        for (int i = 0; i < str.length(); i++) {
            Node newNode = new Node(str.charAt(i));
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            Node nextSlow = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextSlow;
        }

        Node firstHalf = prev;
        Node secondHalf = (fast != null) ? slow.next : slow;

        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is Not a Palindrome");
        }

        sc.close();
    }
}