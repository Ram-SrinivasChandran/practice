package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class MinimumInRotatedSortedArray {
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
        return binarySearch(array, 0, array.length - 1, Integer.MAX_VALUE);
    }

    private static int binarySearch(int[] array, int start, int end, int result) {
        if (start > end)
            return result;

        int mid = start + (end - start) / 2;

        if (array[mid] >= array[start]) {
            if (array[start] < result) {
                result = array[start];
            }

            return binarySearch(array, mid + 1, end, result);
        } else {
            if (array[mid] < result) {
                result = array[mid];
            }

            return binarySearch(array, start, mid - 1, result);
        }

    }
}

/*
Sample Input 1 :
4
3 4 1 2


Sample Output 1 :
1


Explanation of Sample Input 1 :
The original array was [1, 2, 3, 4] and it was rotated 2 times.


Sample Input 2 :
6
25 30 5 10 15 20


Sample Output 2 :
5


Explanation of Sample Input 2 :
The original array was [5, 10, 15, 20, 25, 30] and it was rotated 2 times.


Expected Time Complexity:
Try to solve this with O(log(n)) time complexity.


Constraints :
1 <= n <= 10^5
1 <= arr[i] <= 10^9

Time Limit: 1 sec
 */
