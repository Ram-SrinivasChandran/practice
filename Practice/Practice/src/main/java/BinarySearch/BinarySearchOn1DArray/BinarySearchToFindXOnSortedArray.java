package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class BinarySearchToFindXOnSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();

        System.out.println(search(array, target));
    }

    private static int search(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int target, int start, int end) {
        int result = 0;
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        if (array[mid] > target) {
            result = binarySearch(array, target, start, mid);
        } else if (array[mid] < target) {
            result = binarySearch(array, target, mid + 1, end);
        } else {
            return mid;
        }

        return result;
    }
}

/*
Binary search is an efficient algorithm for finding an item from a sorted array. It works by repeatedly dividing the search interval in half. If the value of the search key is less than the item in the middle of the interval, the search continues in the lower half, or if it's greater, it continues in the upper half. This continues until the value is found or the interval is empty.

Code Explanation
java
Copy code
private static int search(int[] array, int target) {
    return binarySearch(array, target, 0, array.length - 1);
}
search Method:
This method serves as a wrapper for the binarySearch method.
It takes an array and a target value as input.
It initializes the binary search by calling binarySearch with the full range of the array (from index 0 to array.length - 1).
java
Copy code
private static int binarySearch(int[] array, int target, int start, int end) {
    int result = 0;
    if (start > end)
        return -1; // Base case: target not found

    int mid = start + (end - start) / 2; // Calculate mid index

    if (array[mid] > target) {
        result = binarySearch(array, target, start, mid); // Search in the left half
    } else if (array[mid] < target) {
        result = binarySearch(array, target, mid + 1, end); // Search in the right half
    } else {
        return mid; // Target found
    }

    return result; // Return the result
}
binarySearch Method:
This method performs the actual binary search.

Parameters:

array: The sorted array to search within.
target: The value to search for.
start: The starting index of the current search interval.
end: The ending index of the current search interval.
Base Case:

if (start > end) return -1;: This checks if the search interval is invalid (meaning the target is not found in the array). If start exceeds end, the function returns -1, indicating that the target is not present.
Calculate Midpoint:

int mid = start + (end - start) / 2;: This computes the middle index of the current search interval. The formula helps to prevent overflow that could happen if you used (start + end) / 2 directly.
Recursive Search:

Left Half:
if (array[mid] > target): If the element at the midpoint is greater than the target, it recursively searches the left half of the array with binarySearch(array, target, start, mid);. (Note: This is incorrect; it should be mid - 1 instead of mid to avoid infinite recursion.)
Right Half:
else if (array[mid] < target): If the element at the midpoint is less than the target, it recursively searches the right half of the array with binarySearch(array, target, mid + 1, end);.
Target Found:
If the element at the midpoint equals the target, it returns mid, indicating that the target has been found at that index.
Return Statement:

Finally, the method returns result. However, if the target is not found, result will still be 0, which may lead to confusion. It's generally better to return -1 if not found.
 */
