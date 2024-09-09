package Array.Medium;

import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int target = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        int[] result = twoSum(array, target);

        for (int j : result) {
            System.out.println(j);
        }

    }

    private static int[] twoSum(int[] array, int target) {
        int number1 = -1;
        int number2 = -1;
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            while (j < array.length) {
                if (array[i] + array[j] == target) {
                    number1 = i;
                    number2 = j;
                    break;
                }

                j++;
            }

        }

        return new int[] { number1, number2 };
    }
}

/*
Example 1:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
Result: YES (for 1st variant)
       [1, 3] (for 2nd variant)
Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for the first variant and [1, 3] for 2nd variant.

Example 2:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 15
Result: NO (for 1st variant)
	[-1, -1] (for 2nd variant)
Explanation: There exist no such two numbers whose sum is equal to the target.
 */