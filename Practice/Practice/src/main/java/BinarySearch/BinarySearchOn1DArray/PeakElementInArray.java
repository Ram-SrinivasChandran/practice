package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class PeakElementInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(findPeakElement(array));
    }

    private static int findPeakElement(int[] array) {
        return binarySearchForFindingPeakElement(array, 0, array.length - 1);
    }

    private static int binarySearchForFindingPeakElement(int[] array, int start, int end) {
        if (start == end)
            return start;

        int mid = start + (end - start) / 2;

        if (mid > 0 && mid < array.length && array[mid - 1] < array[mid] && array[mid] < array[mid + 1]) {
            return binarySearchForFindingPeakElement(array, mid + 1, end);
        } else if (mid > 0 && mid < array.length && array[mid - 1] > array[mid] && array[mid] > array[mid + 1]) {
            return binarySearchForFindingPeakElement(array, start, mid - 1);
        } else if (mid > 0 && mid < array.length && array[mid - 1] > array[mid] && array[mid] < array[mid + 1]) {
            return binarySearchForFindingPeakElement(array, start, mid - 1);
        } else {
            if (mid == 0 && array[mid + 1] > array[mid]) {
                mid += 1;
            } else if (mid == array.length - 1 && array[mid - 1] > array[mid]) {
                mid -= 1;
            }

            return mid;
        }

    }
}

/*
Example 1:
Input Format: arr[] = {1,2,3,4,5,6,7,8,5,1}
Result: 7
Explanation: In this example, there is only 1 peak that is at index 7.

Example 2:
Input Format: arr[] = {1,2,1,3,5,6,4}
Result: 1
Explanation: In this example, there are 2 peak numbers that are at indices 1 and 5. We can consider any of them.

Example 3:
Input Format: arr[] = {1, 2, 3, 4, 5}
Result: 4
Explanation: In this example, there is only 1 peak that is at the index 4.

Example 4:
Input Format: arr[] = {5, 4, 3, 2, 1}
Result: 0
Explanation: In this example, there is only 1 peak that is at the index 0.
 */
