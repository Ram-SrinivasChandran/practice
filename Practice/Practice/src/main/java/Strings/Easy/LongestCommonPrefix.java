package Strings.Easy;

import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();

        String[] strings = new String[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            strings[i] = scanner.next();
        }

        System.out.println(longestCommonPrefix(strings));

    }

    private static String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0)
            return "";
        String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }

            }

        }

        return prefix;
    }
}

/*
Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */