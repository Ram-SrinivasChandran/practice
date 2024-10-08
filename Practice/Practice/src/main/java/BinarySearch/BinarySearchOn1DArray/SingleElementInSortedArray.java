package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(singleNonDuplicate(array));

    }

    private static int singleNonDuplicate(int[] array) {
        return binarySearch(array, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int start, int end) {
        if (start > end)
            return array[start];

        int mid = start + (end - start) / 2;

        if (mid > 0 && array[mid] == array[mid - 1]) {
            if (mid % 2 != 0) {
                return binarySearch(array, mid + 1, end);
            } else {
                return binarySearch(array, start, mid - 1);
            }

        } else if (mid < array.length - 1 && array[mid] == array[mid + 1]) {
            if (mid % 2 == 0) {
                return binarySearch(array, mid + 1, end);
            } else {
                return binarySearch(array, start, mid - 1);
            }

        } else {
            return array[mid];
        }

    }
}
