package Strings.Easy;

import java.util.Scanner;

public class ReverseWordInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        StringBuilder word = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((i == 0 && s.charAt(i) == ' ') || (i == s.length() - 1 && s.charAt(i) == ' '))
                continue;
            if (s.charAt(i) == ' ' && (i - 1 >= 0) && s.charAt(i - 1) != ' ' && !word.isEmpty()) {
                StringBuilder newWord = new StringBuilder();
                for (int j = word.length() - 1; j >= 0; j--) {
                    newWord.append(word.charAt(j));
                }

                newWord.append(' ');
                result.append(newWord);
                word = new StringBuilder();
            } else {
                if (s.charAt(i) != ' ')
                    word.append(s.charAt(i));
            }

        }

        StringBuilder newWord = new StringBuilder();
        for (int j = word.length() - 1; j >= 0; j--) {
            newWord.append(word.charAt(j));
        }

        result.append(newWord);

        return String.valueOf(result);
    }
}

/*
Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */