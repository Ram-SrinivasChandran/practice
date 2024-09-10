package Array.Medium;

import java.util.Scanner;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(maxSubArraySum(array, arrayLength));

        System.out.println(maxSubArraySum(array));
    }

    private static int maxSubArraySum(int[] array, int arrayLength) {
        int i = 0;
        int max = Integer.MIN_VALUE;
        while (i < arrayLength) {
            int sum = array[i];
            if (array[i] > max) {
                max = array[i];
            }

            for (int j = i + 1; j < arrayLength; j++) {
                if (max < sum) {
                    max = sum;
                }

                sum += array[j];
            }

            if (max < sum) {
                max = sum;
            }

            i++;
        }

        return Math.max(max, 0);
    }

    private static int maxSubArraySum(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int j : array) {
            sum += j;
            maxSum = Math.max(maxSum, sum);

            if (sum < 0) {
                sum = 0;
            }

        }

        return maxSum;
    }
}

/*
Example 1:
Input:
 arr = [-2,1,-3,4,-1,2,1,-5,4]

Output:
 6

Explanation:
 [4,-1,2,1] has the largest sum = 6.

Examples 2:
Input:
 arr = [1]

Output:
 1

Explanation:
 Array has only one element and which is giving positive sum of 1.
 */