package Strings.Easy;

import java.util.Scanner;

public class RotateStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String goal = scanner.next();

        System.out.println(rotateString(string, goal));
    }

    private static boolean rotateString(String string, String goal) {
        if (string.length() != goal.length())
            return false;
        string += string;
        return string.contains(goal);
    }

}

/*
Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 */
