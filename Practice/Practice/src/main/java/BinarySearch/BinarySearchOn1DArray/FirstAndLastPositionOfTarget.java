package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class FirstAndLastPositionOfTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int target = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        int[] firstAndLastOccurance = firstAndLastPositionOfTarget(array, target);

        for (int j : firstAndLastOccurance) {
            System.out.print(j + " ");
        }

    }

    private static int[] firstAndLastPositionOfTarget(int[] array, int target) {
        int firstOccurance = binarySearchForFirstOccurance(array, target, 0, array.length - 1);
        int lastOccurance = binarySearchForLastOccurance(array, target, 0, array.length - 1);

        int[] firstAndLastOccurance = new int[2];

        if (firstOccurance >= 0 && array[firstOccurance] != target) {
            firstAndLastOccurance[0] = -1;
        } else {
            firstAndLastOccurance[0] = firstOccurance;
        }

        if (lastOccurance >= 0 && array[lastOccurance] != target) {
            firstAndLastOccurance[1] = -1;
        } else {
            firstAndLastOccurance[1] = lastOccurance;
        }

        return firstAndLastOccurance;
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
1. firstAndLastPositionOfTarget(int[] array, int target)
This method returns an array of two elements, where the first element is the index of the first occurrence of the target, and the second element is the index of the last occurrence of the target.

Parameters:

array: A sorted array where we want to find the target.
target: The value whose first and last occurrences are to be found.
Logic:

First Occurrence: Calls binarySearchForFirstOccurance to get the index of the first occurrence of the target.
Last Occurrence: Calls binarySearchForLastOccurance to get the index of the last occurrence of the target.
Initializes an array firstAndLastOccurance to store the first and last positions.
If the firstOccurance index is valid but the value at that index does not match the target, it sets the first occurrence to -1 (indicating the target was not found). Otherwise, it stores the index of the first occurrence.
Similarly, for lastOccurance, if the index is valid but the value at that index is not the target, it sets the last occurrence to -1. Otherwise, it stores the index of the last occurrence.
Finally, it returns the array firstAndLastOccurance containing both the first and last positions.
2. binarySearchForFirstOccurance(int[] array, int target, int start, int end)
This method performs a binary search to find the first occurrence of the target.

Parameters:

array: The sorted array.
target: The value whose first occurrence is to be found.
start: The starting index for the search.
end: The ending index for the search.
Logic:

If start is greater than end, the search is complete, and the method returns end. This ensures that the previous position is returned if the target is not found.
It calculates the middle index, mid.
If the middle value (array[mid]) is equal to the target:
If mid > 0 and the element before it (array[mid - 1]) is also the target, it means the first occurrence is still earlier in the array, so it recurses to the left (start to mid - 1).
Otherwise, it returns mid, which is the first occurrence.
If the middle value is smaller than the target, it continues searching in the right half (mid + 1 to end).
If the middle value is larger than the target, it searches in the left half (start to mid - 1).
3. binarySearchForLastOccurance(int[] array, int target, int start, int end)
This method performs a binary search to find the last occurrence of the target.

Parameters:

Same as the binarySearchForFirstOccurance method.
Logic:

If start is greater than end, the search is complete, and the method returns end.
It calculates the middle index, mid.
If the middle value (array[mid]) is equal to the target:
If mid < array.length - 1 and the element after it (array[mid + 1]) is also the target, it means the last occurrence is still later in the array, so it recurses to the right (mid + 1 to end).
Otherwise, it returns mid, which is the last occurrence.
If the middle value is smaller than the target, it continues searching in the right half (mid + 1 to end).
If the middle value is larger than the target, it searches in the left half (start to mid - 1).
Example:
Consider the following array:

java
Copy code
int[] array = {2, 4, 4, 4, 8, 9, 10};
int target = 4;
Step-by-Step Process:

Finding the First Occurrence:

The first binary search (binarySearchForFirstOccurance) is called.
First, mid = 3 (value = 4), which matches the target.
Since array[2] is also 4, it moves left to search for an earlier occurrence.
Now, mid = 1 (value = 4), which is the first occurrence.
So, the first occurrence is at index 1.
Finding the Last Occurrence:

The second binary search (binarySearchForLastOccurance) is called.
First, mid = 3 (value = 4), which matches the target.
Since array[4] is not 4, the search returns mid = 3, which is the last occurrence.
So, the last occurrence is at index 3.
Final Result:

java
Copy code
firstAndLastOccurance = [1, 3];
Edge Cases:
Target not found in the array:

If the target is not in the array, both binarySearchForFirstOccurance and binarySearchForLastOccurance will return -1 since the target doesn't exist.
Target is smaller than the smallest element:

The binary search will immediately conclude and return -1 for both first and last positions.
Target is larger than the largest element:

Similarly, it will return -1 for both first and last positions.
Single Occurrence of the Target:

If the target appears only once in the array, both the first and last occurrences will be the same index.
Summary:
First Occurrence: Found by recursively moving left if there is another occurrence of the target before the current midpoint.
Last Occurrence: Found by recursively moving right if there is another occurrence of the target after the current midpoint.
Time Complexity: Both binary searches have a time complexity of
𝑂(log⁡𝑛)
O(logn). Since two binary searches are performed, the total time complexity is
O(logn).
 */