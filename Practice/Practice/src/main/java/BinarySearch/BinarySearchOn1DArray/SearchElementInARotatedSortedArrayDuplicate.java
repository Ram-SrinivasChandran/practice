package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class SearchElementInARotatedSortedArrayDuplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int target = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(search(array, arrayLength, target));
    }

    private static boolean search(int[] array, int arrayLength, int target) {
        int result = binarySearchForRotatedSortedArray(array, target, 0, arrayLength - 1);
        return result >= 0 && result < arrayLength && array[result] == target;
    }

    private static int binarySearchForRotatedSortedArray(int[] array, int target, int start, int end) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] >= array[start]) {
            if (array[mid] == array[start] && array[mid] == array[end]) {
                return binarySearchForRotatedSortedArray(array, target, start + 1, end - 1);
            } else if (array[mid] == array[start]) {
                return binarySearchForRotatedSortedArray(array, target, start + 1, end);
            } else if (array[mid] == array[end]) {
                return binarySearchForRotatedSortedArray(array, target, start, end - 1);
            }

            if (array[mid] >= target && array[start] <= target) {
                return binarySearchForRotatedSortedArray(array, target, start, mid - 1);
            } else {
                return binarySearchForRotatedSortedArray(array, target, mid + 1, end);
            }

        } else {
            if (array[mid] == array[start] && array[mid] == array[end]) {
                return binarySearchForRotatedSortedArray(array, target, start + 1, end - 1);
            } else if (array[mid] == array[start]) {
                return binarySearchForRotatedSortedArray(array, target, start + 1, end);
            } else if (array[mid] == array[end]) {
                return binarySearchForRotatedSortedArray(array, target, start, end - 1);
            }

            if (array[mid] <= target && array[end] >= target) {
                return binarySearchForRotatedSortedArray(array, target, mid + 1, end);
            } else {
                return binarySearchForRotatedSortedArray(array, target, start, mid - 1);
            }

        }

    }
}

/*
Sample Input 1:
7 4
3 4 5 0 0 1 2


Sample Output 1:
True


Explanation Of Sample Input 1:
Input: a = [3, 4, 5, 0, 0, 1, 2], key = 4

Output: True

Explanation: The array 'a' contains the 'key' = 3, so we return True.


Sample Input 2:
6 47
31 44 56 0 10 13


Sample Output 2:
False


Expected Time Complexity:
Try to solve this with average time complexity O(log(n)).
Constraints:
1 <= 'n' <= 10^5
0 <= 'a[i]', 'key' <= 10^9
Time Limit: 1 sec
 */
