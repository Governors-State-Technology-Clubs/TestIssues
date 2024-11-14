import java.util.Scanner;

public class IsPalindrome {
    public static boolean isPalindrome(String str) {
        // Base case.
        // If the string has 0 or 1 character, it's a palindrome
        if (str.length() <= 1) {
            return true;
        }

        // Recursive case: check if the first and last characters are the same
        // and check the substring in between
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        // Check the substring in between
        return isPalindrome(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();
        // Example 1 isPalindrome("madam") Should return true
        // Example 2 isPalindrome("apple") Should return false
        // Example 3 isPalindrome("redder") Should return true
        boolean result = isPalindrome(string);
        System.out.println(result);
    }
}