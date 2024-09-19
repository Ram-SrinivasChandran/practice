package Array.Hard;

import java.util.Scanner;

public class SubArrayWithXORSumK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(subArrayWithXORSumK(array, k));
    }

    private static int subArrayWithXORSumK(int[] array, int k) {
        int totalSubArray = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                totalSubArray++;
            }

            int sum = array[i];
            int j = i + 1;
            while (j < array.length) {
                if ((sum ^ array[j]) == k) {
                    totalSubArray++;
                }

                sum ^= array[j];
                j++;
            }

        }

        return totalSubArray;
    }

}

/*
Example 1:
Input Format:
 A = [4, 2, 2, 6, 4] , k = 6
Result:
 4
Explanation:
 The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

Example 2:
Input Format:
 A = [5, 6, 7, 8, 9], k = 5
Result:
 2
Explanation:
 The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]
 */