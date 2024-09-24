package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class ImplementUpperBound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int numberToFind = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(upperBound(array, numberToFind, arrayLength));

    }

    private static int upperBound(int[] array, int numberToFind, int arrayLength) {
        return binarySearchForUpperBound(array, numberToFind, 0, arrayLength - 1);
    }

    private static int binarySearchForUpperBound(int[] array, int numberToFind, int start, int end) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        if (array[mid] > numberToFind) {
            return binarySearchForUpperBound(array, numberToFind, start, mid - 1);
        } else {
            return binarySearchForUpperBound(array, numberToFind, mid + 1, end);
        }

    }
}

/*
The upper bound in an array is the index of the first element that is strictly greater than the target number. If the number doesn’t exist in the array, the upper bound gives the position where this number could be inserted while maintaining the sorted order.

For example, in a sorted array [2, 4, 6, 8, 10]:

The upper bound of 5 is 2 (since 6 is the first number greater than 5).
The upper bound of 8 is 4 (since 10 is the first number greater than 8).
Code Breakdown
Main function call:
java
Copy code
private static int binarySearchForUpperBound(int[] array, int numberToFind, int start, int end) {
This function performs the actual binary search for the upper bound.
Parameters:
array: The sorted array in which the upper bound is to be found.
numberToFind: The target number whose upper bound is being searched.
start and end: These define the current range of the array that is being searched.
Base Case:
java
Copy code
if (start > end) {
    return start;
}
What it means: When the start index exceeds the end index (start > end), it means the search is complete, and we haven’t found an element greater than numberToFind in the current range.
Why return start: At this point, start represents the index of the first element greater than numberToFind. If no such element exists, it would be the position where numberToFind could be inserted to maintain the sorted order.
Middle Index Calculation:
java
Copy code
int mid = start + (end - start) / 2;
Why it's done this way: This calculates the middle index of the current search range without causing overflow. (start + end) / 2 could overflow if start and end are large, so this is a safer way to calculate the middle.
Example: If start = 0 and end = 4 in a 5-element array, the midpoint will be 2.
Main Logic (Binary Search):
java
Copy code
if (array[mid] > numberToFind) {
    return binarySearchForUpperBound(array, numberToFind, start, mid - 1);
} else {
    return binarySearchForUpperBound(array, numberToFind, mid + 1, end);
}
Case 1: array[mid] > numberToFind:

If the current middle element is greater than numberToFind, it means the upper bound could be this element or an element even earlier in the array. Therefore, we continue searching in the left half of the array by setting end = mid - 1 and making a recursive call.
Why mid - 1: Since array[mid] is greater than numberToFind, there's no need to include mid in the next search range because the upper bound might be earlier in the array.
Case 2: array[mid] <= numberToFind:

If the current middle element is less than or equal to numberToFind, it means the upper bound must lie to the right of the current middle. So, we continue searching in the right half of the array by setting start = mid + 1 and making a recursive call.
Why mid + 1: Since array[mid] is less than or equal to numberToFind, the upper bound must be beyond the current mid, so the next search should begin at mid + 1.
Example Walkthrough
Let’s go through an example step-by-step. Suppose we have an array:

java
Copy code
array = [2, 4, 6, 8, 10];
numberToFind = 5;
We want to find the upper bound of 5.

Initial call: start = 0, end = 4

mid = 2 → array[mid] = 6
Since 6 > 5, the upper bound could be 6 or earlier. So, we search the left half: binarySearchForUpperBound(array, 5, 0, 1).
Second call: start = 0, end = 1

mid = 0 → array[mid] = 2
Since 2 <= 5, the upper bound must be to the right. So, we search the right half: binarySearchForUpperBound(array, 5, 1, 1).
Third call: start = 1, end = 1

mid = 1 → array[mid] = 4
Since 4 <= 5, the upper bound must be to the right. So, we search the right half: binarySearchForUpperBound(array, 5, 2, 1).
Final call: start = 2, end = 1

Since start > end, the search is complete, and start = 2 is returned.
Thus, the upper bound of 5 in the array [2, 4, 6, 8, 10] is 2. This means 6 is the first element greater than 5, and if 5 were to be inserted into the array, it would be at index 2.

Summary of Key Points:
Binary search: The function performs a binary search by dividing the array into halves and deciding which half contains the upper bound.
Returning start: The function returns start as the upper bound, which represents the index of the first element strictly greater than numberToFind.
Efficient: This approach is efficient because it reduces the search space by half at each step, making the time complexity O(log n) for a sorted array.
This method ensures that you find the correct insertion point or the first element greater than the target in a sorted array.

 */
