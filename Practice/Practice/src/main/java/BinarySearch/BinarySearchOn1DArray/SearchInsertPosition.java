package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int target = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(searchInsert(array, target));

    }

    private static int searchInsert(int[] array, int target) {
        return binarySearchForInsertionPosition(array, target, 0, array.length - 1);
    }

    private static int binarySearchForInsertionPosition(int[] array, int target, int start, int end) {

        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return binarySearchForInsertionPosition(array, target, mid + 1, end);
        } else {
            if (start == mid) {
                return start;
            }

            return binarySearchForInsertionPosition(array, target, start, mid);
        }

    }
}

/*
Example 1:
Input Format: arr[] = {1,2,4,7}, x = 6
Result: 3
Explanation: 6 is not present in the array. So, if we will insert 6 in the 3rd index(0-based indexing), the array will still be sorted. {1,2,4,6,7}.

Example 2:
Input Format: arr[] = {1,2,4,7}, x = 2
Result: 1
Explanation: 2 is present in the array and so we will return its index i.e. 1.
 */