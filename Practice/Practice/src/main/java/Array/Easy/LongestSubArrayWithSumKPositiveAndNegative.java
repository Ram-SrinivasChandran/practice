package Array.Easy;

import java.util.Scanner;

public class LongestSubArrayWithSumKPositiveAndNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(getLongestSubArray(array, k));
    }

    public static int getLongestSubArray(int[] array, int k) {
        int longestSubArray = 0;
        for (int i = 0; i < array.length; i++) {
            int count = 1;
            if (array[i] == k && count > longestSubArray) {
                longestSubArray = count;
            }

            int sum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (sum + array[j] == k) {
                    count++;
                    if (count > longestSubArray) {
                        longestSubArray = count;
                    }

                } else {
                    count++;
                }

                sum += array[j];
            }

        }

        return longestSubArray;
    }
}

/*
Example 1:
Input Format:
 N = 3, k = 5, array[] = {2,3,5}
Result:
 2
Explanation:
 The longest subarray with sum 5 is {2, 3}. And its length is 2.

Example 2:
Input Format
: N = 3, k = 1, array[] = {-1, 1, 1}
Result:
 3
Explanation:
 The longest subarray with sum 1 is {-1, 1, 1}. And its length is 3.
 */
