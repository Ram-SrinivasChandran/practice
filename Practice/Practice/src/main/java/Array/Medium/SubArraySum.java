package Array.Medium;

import java.util.Scanner;

public class SubArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(subArraySum(array, k));
    }

    private static int subArraySum(int[] array, int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }

            int sum = array[i];
            int j = i + 1;
            while (j < array.length) {
                if (sum + array[j] == k) {
                    count++;
                }

                sum += array[j];
                j++;
            }

        }

        return count;
    }
}

/*
Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 */
