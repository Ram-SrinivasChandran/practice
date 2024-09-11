package Array.Medium;

import java.util.Arrays;
import java.util.Scanner;

public class LongestSuccessiveElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(longestSuccessiveElements(array));
    }

    private static int longestSuccessiveElements(int[] array) {
        Arrays.sort(array);
        int longestSuccessiveElements = 1;
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1] + 1) {
                count++;
            } else if (array[i] == array[i - 1]) {
                continue;
            } else {
                if (longestSuccessiveElements <= count) {
                    longestSuccessiveElements = count;
                }

                count = 1;

            }

        }

        if (longestSuccessiveElements < count) {
            longestSuccessiveElements = count;
        }

        return longestSuccessiveElements;
    }

}

/*
Example 1:
Input:
 [100, 200, 1, 3, 2, 4]

Output:
 4

Explanation:
 The longest consecutive subsequence is 1, 2, 3, and 4.

Input:
 [3, 8, 5, 7, 6]

Output:
 4

Explanation:
 The longest consecutive subsequence is 5, 6, 7, and 8.
 */
