package Array.Easy;

import java.util.Scanner;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(findMaxConsecutiveOnes(array));
    }

    private static int findMaxConsecutiveOnes(int[] array) {
        int countOnes = 0;
        int temp = 0;

        for (int j : array) {
            if (j == 1) {
                countOnes++;
            } else if (j == 0) {
                if (temp < countOnes) {
                    temp = countOnes;
                }

                countOnes = 0;
            }

        }

        if (temp < countOnes) {
            temp = countOnes;
        }

        return temp;
    }
}

/*
Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 */