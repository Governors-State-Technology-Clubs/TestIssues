import java.util.Scanner;

/*
I needed to enter the number in as a string.  I tested my version of reading the number in as an integer and
there were certain cases the program did not do what was intnded.
For instance 0000, returns 1 because Java thinks 0000 as int is 0.
I used a string function instead that reads the number in as a string.
 */


public class NumberOfZeros {

    // Method to count the number of zeros in a string (including leading zeros)
    public static int zeros(String s) {
        // Base case
        // If the string is empty, return 0
        if (s.isEmpty()) {
            return 0;
        }
        // Recursive case
        // check if the first character is '0'
        // We start at index 0 and add one if we enconter a zero and if not do not
        // Substring(1) of the string will keep taking off the first digit of the
        // String until the end.
        if (s.charAt(0) == '0') {
            return 1 + zeros(s.substring(1));
        } else {
            return zeros(s.substring(1));
        }
    }

    public static void main(String[] args) {
        // Create a Scanner object
        Scanner in = new Scanner(System.in);
        // Prompt user for input
        System.out.println("This program returns the number of 0's in an integer.");
        System.out.println("Enter an integer: ");
        // Store the input as a string
        String input = in.next();
        // Output display
        System.out.println(zeros(input));
    }
}