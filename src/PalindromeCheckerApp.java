import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is Not a Palindrome");
        }

        sc.close();
    }
}