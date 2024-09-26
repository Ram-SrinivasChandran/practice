package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class NumberOFOccurance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int target = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(count(array, arrayLength, target));

    }

    private static int count(int[] array, int arrayLength, int target) {
        int firstOccurance = binarySearchForFirstOccurance(array, target, 0, arrayLength - 1);
        int lastOccurance = binarySearchForLastOccurance(array, target, 0, arrayLength - 1);

        if (array[firstOccurance] != target && array[lastOccurance] != target) {
            return 0;
        }

        return lastOccurance - firstOccurance + 1;
    }

    private static int binarySearchForFirstOccurance(int[] array, int target, int start, int end) {
        if (start > end)
            return end;

        int mid = start + (end - start) / 2;

        if (array[mid] == target) {
            if (mid > 0 && array[mid - 1] == target) {
                return binarySearchForFirstOccurance(array, target, start, mid - 1);
            }

            return mid;
        } else if (array[mid] < target) {
            return binarySearchForFirstOccurance(array, target, mid + 1, end);
        } else {
            return binarySearchForFirstOccurance(array, target, start, mid - 1);
        }

    }

    private static int binarySearchForLastOccurance(int[] array, int target, int start, int end) {
        if (start > end)
            return end;

        int mid = start + (end - start) / 2;

        if (array[mid] == target) {
            if (mid < array.length - 1 && array[mid + 1] == target) {
                return binarySearchForLastOccurance(array, target, mid + 1, end);
            }

            return mid;
        } else if (array[mid] < target) {
            return binarySearchForLastOccurance(array, target, mid + 1, end);
        } else {
            return binarySearchForLastOccurance(array, target, start, mid - 1);
        }

    }
}

/*
This code is designed to count the number of occurrences of a target value in a sorted array using binary search. It consists of two main parts:

count method:

This method uses two helper methods, binarySearchForFirstOccurance and binarySearchForLastOccurance, to find the first and last occurrence of the target in the sorted array.
Once both the first and last occurrence indices are found, the count of occurrences is calculated as:
java
Copy code
lastOccurance - firstOccurance + 1
If the target is not found (i.e., both firstOccurance and lastOccurance do not point to the target), the method returns 0.
binarySearchForFirstOccurance method:

This method performs a binary search to find the first occurrence of the target.
It searches the array by dividing it in half (binary search), checking if the middle element is equal to the target:
If the middle element is equal to the target and the element before it is also equal to the target, it continues searching the left half (i.e., recursive call mid - 1).
If the middle element is the target but there is no target to the left of it (i.e., it is the first occurrence), it returns the index.
If the middle element is smaller than the target, it continues searching the right half.
If the middle element is larger than the target, it continues searching the left half.
binarySearchForLastOccurance method:

This method performs a binary search to find the last occurrence of the target.
It operates similarly to binarySearchForFirstOccurance, but it ensures that the target is the last occurrence:
If the middle element is equal to the target and the element after it is also equal to the target, it continues searching the right half (i.e., recursive call mid + 1).
If the middle element is the target but there is no target to the right of it (i.e., it is the last occurrence), it returns the index.
If the middle element is smaller than the target, it continues searching the right half.
If the middle element is larger than the target, it continues searching the left half.
Step-by-Step Execution
Assume we have an array: [1, 2, 2, 2, 3, 4, 5] and we want to count occurrences of 2.

First Occurrence (binarySearchForFirstOccurance):

Midpoint = 3 (value = 2). Since array[2] == 2, continue to the left.
Midpoint = 1 (value = 2). The value before this (index 0) is not 2, so return index 1 as the first occurrence.
Last Occurrence (binarySearchForLastOccurance):

Midpoint = 3 (value = 2). Since array[4] != 2, return index 3 as the last occurrence.
Final Count:

First occurrence = 1, Last occurrence = 3. Count = 3 - 1 + 1 = 3.
Summary:
count: Uses binary search to find the first and last occurrences of a target and computes the number of occurrences.
binarySearchForFirstOccurance: Finds the first occurrence of the target.
binarySearchForLastOccurance: Finds the last occurrence of the target.
 */
