package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class ImplementLowerBound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        int numberToFind = scanner.nextInt();

        System.out.println(lowerBound(array, arrayLength, numberToFind));
    }

    private static int lowerBound(int[] array, int arrayLength, int numberToFind) {
        return binarySearchForLowerBound(array, numberToFind, 0, arrayLength - 1);
    }

    private static int binarySearchForLowerBound(int[] array, int numberToFind, int start, int end) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        if (array[mid] >= numberToFind) {
            return binarySearchForLowerBound(array, numberToFind, start, mid - 1);
        } else {
            return binarySearchForLowerBound(array, numberToFind, mid + 1, end);
        }

    }
}

/*
A lower bound search is typically used in sorted arrays. It finds the smallest index where a given number can be inserted into the array without violating the array's sorted order. Specifically:

If the number exists in the array, the lower bound returns the index of the first occurrence of the number.
If the number doesn't exist, it returns the index where the number can be inserted to keep the array sorted.
Code Walkthrough
lowerBound Method
java
Copy code
private static int lowerBound(int[] array, int arrayLength, int numberToFind) {
    return binarySearchForLowerBound(array, numberToFind, 0, arrayLength - 1);
}
This is the main entry point to start the lower bound search. It calls binarySearchForLowerBound with the entire array (start = 0 and end = arrayLength - 1).
binarySearchForLowerBound Method
java
Copy code
private static int binarySearchForLowerBound(int[] array, int numberToFind, int start, int end) {
    if (start > end) {
        return start;  // This is the insertion point when the search is complete
    }
Base case: If the start index exceeds the end index (start > end), it means we've finished the search, and the start index is the correct lower bound.
This occurs when the search narrows down to a point where the number is either not found or an appropriate index is identified.
java
Copy code
    int mid = start + (end - start) / 2;
Finding the middle: The midpoint of the current search range is calculated. This avoids overflow (which can happen with (start + end) / 2 when start and end are large).
java
Copy code
    if (array[mid] >= numberToFind) {
        return binarySearchForLowerBound(array, numberToFind, start, mid - 1);
    } else {
        return binarySearchForLowerBound(array, numberToFind, mid + 1, end);
    }
}
Key conditional check:
If array[mid] >= numberToFind: This means that the number might be present in the left half (or at mid itself), so the search continues in the left half (mid - 1).
Otherwise, if array[mid] < numberToFind: This means that the number must be located in the right half, so the search continues from mid + 1 to end.
Why start is returned in the base case?
Once the search range becomes invalid (start > end), start represents the index where the number can be inserted without disrupting the array's order. This is how lower bounds work: they return the index of the first element greater than or equal to numberToFind.
Example Walkthrough
Let's take an example where array = [2, 4, 6, 8, 10] and numberToFind = 5.

Initial call: start = 0, end = 4 (array = [2, 4, 6, 8, 10])

mid = 2 → array[mid] = 6
Since 6 >= 5, search left: binarySearchForLowerBound(array, 5, 0, 1)
Second call: start = 0, end = 1 (array = [2, 4])

mid = 0 → array[mid] = 2
Since 2 < 5, search right: binarySearchForLowerBound(array, 5, 1, 1)
Third call: start = 1, end = 1 (array = [4])

mid = 1 → array[mid] = 4
Since 4 < 5, search right: binarySearchForLowerBound(array, 5, 2, 1)
Final call: start = 2, end = 1

start > end, so return start = 2, which is the correct insertion point.
Thus, 5 can be inserted at index 2 to maintain the sorted order: [2, 4, 5, 6, 8, 10].

Key Takeaways:
The binary search efficiently narrows down the search range.
When start > end, the correct insertion point is found.
The logic ensures that if the number is present, the first occurrence is returned (because of the array[mid] >= numberToFind condition).
 */
