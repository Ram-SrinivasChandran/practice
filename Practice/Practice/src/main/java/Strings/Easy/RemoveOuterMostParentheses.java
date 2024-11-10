package Strings.Easy;

import java.util.Scanner;

public class RemoveOuterMostParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(removeOuterParentheses(s));
    }

    private static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) {
                    result.append(c);
                }

                balance++;
            } else {
                balance--;
                if (balance > 0) {
                    result.append(c);
                }

            }

        }

        return String.valueOf(result);
    }
}

/*
Input: s = "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: s = "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 */