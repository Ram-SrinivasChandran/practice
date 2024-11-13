package Strings.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsomorphicString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.next();
        String string2 = scanner.next();

        System.out.println(isIsomorphic(string1, string2));
    }

    private static boolean isIsomorphic(String string1, String string2) {
        if (string1.length() != string2.length())
            return false;
        Map<Character, Character> result = new HashMap<>();

        for (int i = 0; i < string1.length(); i++) {
            if (result.containsKey(string1.charAt(i)) || result.containsValue(string2.charAt(i))) {

                if (result.containsValue(string2.charAt(i))) {
                    Character keyByValue = getKeyByValue(result, string2.charAt(i));

                    if (keyByValue != null && keyByValue != string1.charAt(i))
                        return false;
                }

                if (result.get(string1.charAt(i)) != string2.charAt(i)) {
                    return false;
                }

            } else {
                result.put(string1.charAt(i), string2.charAt(i));
            }

        }

        return true;
    }

    public static Character getKeyByValue(Map<Character, Character> map, Character value) {
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }

        }

        return null;
    }
}

/*
Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true
 */