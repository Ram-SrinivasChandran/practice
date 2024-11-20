package Strings.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckIfTwoStringsAreAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.next();
        String word2 = scanner.next();

        System.out.println(isAnagram(word1, word2));
    }

    private static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : word1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : word2.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0)
                return false;
            charCount.put(c, charCount.get(c) - 1);
        }

        return true;
    }
}

/*
Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false
 */
