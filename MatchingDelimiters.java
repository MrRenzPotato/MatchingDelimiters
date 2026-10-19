
/*
Description: Checks matching delimiters and displays stack operations.

Programmed by: Renz Edward Torcuator, BSIT, DATA STRUCTURES AND ALGORITHMS
Last Modified: October 19, 2026
Version: 1.4

Acknowledgements: OpenAI ChatGPT assisted with code drafting.
The student should review and verify the program.
*/

import java.util.Scanner;
import java.util.Stack;

public class MatchingDelimiters {

    public static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter a sequence: ");
        String sequence = input.nextLine();

        boolean valid = true;
        String reason = "";

        for (int i = 0; i < sequence.length(); i++) {
            char ch = sequence.charAt(i);

            System.out.println("\nRead: " + ch);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                System.out.println("Operation: PUSH " + ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}') {

                if (stack.isEmpty()) {
                    valid = false;
                    reason = "Closing delimiter has no matching opening delimiter.";
                    System.out.println("Operation: INVALID");
                    System.out.println("Reason: " + reason);
                    System.out.println("Stack: " + stack);
                    break;
                }

                char top = stack.peek();
                System.out.println("Operation: PEEK " + top);

                if (isMatching(top, ch)) {
                    stack.pop();
                    System.out.println("Operation: POP " + top);
                } else {
                    valid = false;
                    reason = "Mismatched delimiters.";
                    System.out.println("Operation: INVALID");
                    System.out.println("Reason: " + reason);
                    System.out.println("Stack: " + stack);
                    break;
                }
            }
            else {
                System.out.println("Operation: IGNORE (not a delimiter)");
            }

            System.out.println("Stack: " + stack);
        }

        if (valid && !stack.isEmpty()) {
            valid = false;
            reason = "Unmatched opening delimiter remains.";
            System.out.println("\nReason: " + reason);
        }

        if (valid) {
            System.out.println("\nResult: Valid");
        } else {
            System.out.println("\nResult: Invalid");
        }

        input.close();
    }
}