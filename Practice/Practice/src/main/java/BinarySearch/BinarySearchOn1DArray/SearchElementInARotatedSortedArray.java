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
        int result = binarySearchForRotatedSortedArray(array, target, 0, arrayLength - 1);

        if (result >= 0 && result < arrayLength && array[result] == target) {
            return result;
        }

        return -1;
    }

    private static int binarySearchForRotatedSortedArray(int[] array, int target, int start, int end) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > array[start]) {
            if (array[mid] >= target && array[start] <= target) {
                return binarySearchForRotatedSortedArray(array, target, start, mid - 1);
            } else {
                return binarySearchForRotatedSortedArray(array, target, mid + 1, end);
            }

        } else {
            if (array[mid] <= target && array[end] >= target) {
                return binarySearchForRotatedSortedArray(array, target, mid + 1, end);
            } else {
                return binarySearchForRotatedSortedArray(array, target, start, mid - 1);
            }

        }

    }

}

/*
Example 1:
Input Format: arr = [4,5,6,7,0,1,2,3], k = 0
Result: 4
Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

Example 2:
Input Format: arr = [4,5,6,7,0,1,2], k = 3
Result: -1
Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.

This code is designed to find a target element in a rotated sorted array. A rotated sorted array is an array that was originally sorted in ascending order but was rotated at some pivot point (for example, [4, 5, 6, 7, 0, 1, 2, 3]). The code uses a modified binary search to locate the target.

There are two methods:

search: The main method that initiates the binary search.
binarySearchForRotatedSortedArray: The recursive method that performs binary search on the rotated sorted array.
Breakdown of the Code:
Method 1: search
java
Copy code
private static int search(int[] array, int arrayLength, int target) {
    int result = binarySearchForRotatedSortedArray(array, target, 0, arrayLength - 1);

    if (result >= 0 && result < arrayLength && array[result] == target) {
        return result;
    }

    return -1;
}
Explanation:
Call the binary search function:

The method binarySearchForRotatedSortedArray is called with the input array, the target, and the bounds (start = 0, end = arrayLength - 1). This function returns the index where the target could be.
If the target is found, the index is returned.
Validate the result:

After the binary search, it checks if the result is within valid bounds and if the value at that index matches the target.
java
Copy code
if (result >= 0 && result < arrayLength && array[result] == target)
If the target is found, it returns the index. If not, it returns -1 to indicate that the target was not found.
Method 2: binarySearchForRotatedSortedArray
java
Copy code
private static int binarySearchForRotatedSortedArray(int[] array, int target, int start, int end) {
    if (start > end)
        return start;

    int mid = start + (end - start) / 2;

    if (array[mid] == target) {
        return mid;
    } else if (array[mid] > array[start]) {
        if (array[mid] >= target && array[start] <= target) {
            return binarySearchForRotatedSortedArray(array, target, start, mid - 1);
        } else {
            return binarySearchForRotatedSortedArray(array, target, mid + 1, end);
        }

    } else {
        if (array[mid] <= target && array[end] >= target) {
            return binarySearchForRotatedSortedArray(array, target, mid + 1, end);
        } else {
            return binarySearchForRotatedSortedArray(array, target, start, mid - 1);
        }

    }
}
Explanation:
Base case:

The base case checks if start > end, which means the target is not present in the current search range:
java
Copy code
if (start > end)
    return start;
Calculate the middle index:

The mid index is calculated to divide the array:
java
Copy code
int mid = start + (end - start) / 2;
Check if the middle element is the target:

If array[mid] == target, the target is found, and the index mid is returned:
java
Copy code
if (array[mid] == target) {
    return mid;
}
Determine which side of the array is sorted:

The key observation in a rotated sorted array is that one half is always sorted. So, the next check is to see whether the left half (from start to mid) is sorted:
java
Copy code
else if (array[mid] > array[start]) {
If the left half is sorted, we check if the target lies within this sorted range. If so, we search in the left half:
java
Copy code
if (array[mid] >= target && array[start] <= target) {
    return binarySearchForRotatedSortedArray(array, target, start, mid - 1);
}
If not, we search in the right half:
java
Copy code
else {
    return binarySearchForRotatedSortedArray(array, target, mid + 1, end);
}
If the right half is sorted:

If the left half is not sorted, it means the right half (from mid to end) is sorted:
java
Copy code
else {
    if (array[mid] <= target && array[end] >= target) {
        return binarySearchForRotatedSortedArray(array, target, mid + 1, end);
    } else {
        return binarySearchForRotatedSortedArray(array, target, start, mid - 1);
    }
}
We again check if the target lies within this sorted right half, and search accordingly.
Key Points:
The array is divided into two halves at each recursive step.
The algorithm checks which half is sorted and then determines whether the target is in that half.
If the target is in the sorted half, the search continues in that half; otherwise, it continues in the other half.
Time Complexity:
Since the array is divided in half at each step, the time complexity of this algorithm is O(log n), where n is the size of the array.
 */
