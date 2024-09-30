package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class SearchElementInARotatedSortedArray {
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

    private static int search(int[] array, int arrayLength, int target) {
        int position;
        if (array[(arrayLength - 1) / 2] == target) {
            return (arrayLength - 1) / 2;
        }

        position = binarySearch(array, target, 0, (arrayLength - 1) / 2);
        if (position > 0 && array[position] == target) {
            return position;
        }

        position = binarySearch(array, target, (arrayLength - 1) / 2 + 1, arrayLength - 1);
        if (position < arrayLength && array[position] == target) {
            return position;
        }

        return -1;
    }

    private static int binarySearch(int[] array, int target, int start, int end) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearch(array, target, start, mid - 1);
        } else {
            return binarySearch(array, target, mid + 1, end);
        }

    }

}

/*
The goal of the code is to search for a target value in a sorted array using a combination of a midpoint check and a binary search on both halves of the array. The idea is to perform an efficient search, similar to binary search, with some custom logic around how the array is split and searched.

The code consists of two methods:

search – the main method that orchestrates the search logic.
binarySearch – a helper method that performs a recursive binary search on a specific range of the array.
Method 1: search
Code
java
Copy code
private static int search(int[] array, int arrayLength, int target) {
    int position;

    // Check if the target is exactly in the middle of the array
    if (array[(arrayLength - 1) / 2] == target) {
        return (arrayLength - 1) / 2;
    }

    // Perform binary search on the first half of the array (from index 0 to the middle)
    position = binarySearch(array, target, 0, (arrayLength - 1) / 2);
    // If the binary search returned a valid position and the target is found at that position
    if (position > 0 && array[position] == target) {
        return position;
    }

    // Perform binary search on the second half of the array (from middle+1 to the last element)
    position = binarySearch(array, target, (arrayLength - 1) / 2 + 1, arrayLength - 1);
    // If the binary search returned a valid position and the target is found at that position
    if (position < arrayLength && array[position] == target) {
        return position;
    }

    // If the target is not found in either half, return -1 (not found)
    return -1;
}
Explanation
Initial Middle Element Check:

The first thing the search function does is check if the target value is at the midpoint of the array:
java
Copy code
if (array[(arrayLength - 1) / 2] == target)
This check helps avoid further computation if the target happens to be in the middle.
First Half Search:

If the target is not at the midpoint, the function calls binarySearch on the first half of the array (from index 0 to the midpoint):
java
Copy code
position = binarySearch(array, target, 0, (arrayLength - 1) / 2);
This returns the position of the target if it exists in the first half, or an invalid position otherwise.
Check the First Half Result:

After searching the first half, it checks if the returned position is valid (i.e., position > 0) and the value at that position is the target:
java
Copy code
if (position > 0 && array[position] == target)
If found, it returns the position.
Second Half Search:

If the target is not found in the first half, the function calls binarySearch on the second half of the array (from midpoint + 1 to the end of the array):
java
Copy code
position = binarySearch(array, target, (arrayLength - 1) / 2 + 1, arrayLength - 1);
Check the Second Half Result:

It then checks the result of the second half search to see if the target is found:
java
Copy code
if (position < arrayLength && array[position] == target)
If found, it returns the position.
Return -1 if Not Found:

If the target is not found in either half, the function returns -1 to indicate that the target is not present in the array.
Method 2: binarySearch
Code
java
Copy code
private static int binarySearch(int[] array, int target, int start, int end) {
    if (start > end) {
        return start; // If the search range is invalid, return start (an incorrect result)
    }

    // Calculate the middle index
    int mid = start + (end - start) / 2;

    // If the target is found at the middle index
    if (array[mid] == target) {
        return mid;
    }
    // If the target is smaller than the middle element, search the left half
    else if (array[mid] > target) {
        return binarySearch(array, target, start, mid - 1);
    }
    // If the target is greater than the middle element, search the right half
    else {
        return binarySearch(array, target, mid + 1, end);
    }
}
Explanation
Base Case: Invalid Range:

If start > end, the search range is invalid (i.e., the target is not found), and the function returns start (which is incorrect behavior as it should return -1 in a proper binary search):
java
Copy code
if (start > end)
    return start;
Calculate Midpoint:

The midpoint is calculated using:
java
Copy code
int mid = start + (end - start) / 2;
This helps in dividing the array into two halves for the binary search.
Check Midpoint:

If the element at the midpoint equals the target, return the midpoint:
java
Copy code
if (array[mid] == target)
    return mid;
Search Left Half:

If the target is smaller than the midpoint value, it recursively searches the left half (from start to mid - 1):
java
Copy code
else if (array[mid] > target)
    return binarySearch(array, target, start, mid - 1);
Search Right Half:

If the target is greater than the midpoint value, it recursively searches the right half (from mid + 1 to end):
java
Copy code
else
    return binarySearch(array, target, mid + 1, end);
 */
