package Array.Hard;

import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoSortedArrayWithoutExtraSpace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength1 = scanner.nextInt();
        long[] array1 = new long[arrayLength1];
        int arrayLength2 = scanner.nextInt();
        long[] array2 = new long[arrayLength2];

        for (int i = 0; i < arrayLength1; i++) {
            array1[i] = scanner.nextLong();
        }

        for (int i = 0; i < arrayLength2; i++) {
            array2[i] = scanner.nextLong();
        }

        mergeTwoSortedArraysWithoutExtraSpace(array1, array2);

        for (int i = 0; i < arrayLength1; i++) {
            System.out.print(array1[i] + " ");
        }

        for (int i = 0; i < arrayLength2; i++) {
            System.out.print(array2[i] + " ");
        }

    }

    private static void mergeTwoSortedArraysWithoutExtraSpace(long[] array1, long[] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] > array2[j]) {
                    long temp = array1[i];
                    array1[i] = array2[j];
                    array2[j] = temp;
                }

            }

        }

        Arrays.sort(array2);
    }
}

/*
Example 1:
Input:

n = 4, arr1[] = [1 4 8 10]
m = 5, arr2[] = [2 3 9]

Output:

arr1[] = [1 2 3 4]
arr2[] = [8 9 10]

Explanation:

After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.

Example2:
Input:

n = 4, arr1[] = [1 3 5 7]
m = 5, arr2[] = [0 2 6 8 9]

Output:

arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]

Explanation:

After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
 */
