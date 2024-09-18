package Array.Hard;

import java.util.Scanner;

public class LongestSubArrayWithSumZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(longestSubArray(array));

    }

    private static int longestSubArray(int[] array) {
        int longestSubArray = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (longestSubArray == 0) {
                    longestSubArray = 1;
                }

            }

            int count = 1;
            int j = i + 1;
            int sum = array[i];
            while (j < array.length) {
                sum += array[j];
                count++;
                j++;
                if (sum == 0) {
                    if (longestSubArray < count) {
                        longestSubArray = count;
                    }

                }

            }

        }

        return longestSubArray;
    }
}
