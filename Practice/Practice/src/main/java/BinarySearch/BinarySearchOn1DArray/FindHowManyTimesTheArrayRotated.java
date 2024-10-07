package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class FindHowManyTimesTheArrayRotated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(findMin(array));
    }

    private static int findMin(int[] array) {
        return binarySearch(array, 0, array.length - 1, Integer.MAX_VALUE, 0);
    }

    private static int binarySearch(int[] array, int start, int end, int result, int ans) {
        if (start > end)
            return ans;

        int mid = start + (end - start) / 2;

        if (array[mid] >= array[start]) {
            if (array[start] < result) {
                result = array[start];
                ans = start;
            }

            return binarySearch(array, mid + 1, end, result, ans);
        } else {
            if (array[mid] < result) {
                result = array[mid];
                ans = mid;
            }

            return binarySearch(array, start, mid - 1, result, ans);
        }

    }
}

/*
Example 1:
Input Format:
 arr = [4,5,6,7,0,1,2,3]
Result:
 4
Explanation:
 The original array should be [0,1,2,3,4,5,6,7]. So, we can notice that the array has been rotated 4 times.

Example 2:
Input Format:
 arr = [3,4,5,1,2]
Result:
 3
Explanation:
 The original array should be [1,2,3,4,5]. So, we can notice that the array has been rotated 3 times.
 */
