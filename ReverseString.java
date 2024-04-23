//Objective: Write a recursive method that display a string reversely on the console with the following header:
//public static void reverseDisplay(String value)
//Go to chatGPT, bard.google, bind.com, or any other AI tools to ask the AI to generate the program for you and copy it to your Eclipse IDE to test and find out if it works.
//Submit two screenshots , one is the output of the AI and another one is your Eclipse output.
//Created by:Sebastian Xayaphet
//Date: 7/26/2023
//Version:jdk-20
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        System.out.print("Reversed string: ");
        reverseDisplay(input);
    }

    public static void reverseDisplay(String value) {
        if (value == null || value.isEmpty()) {
            return; // Base case: do nothing for an empty or null string
        } else {
            // Display the last character
            System.out.print(value.charAt(value.length() - 1));

            // Call the method recursively with the substring excluding the last character
            reverseDisplay(value.substring(0, value.length() - 1));
        }
    }
}





