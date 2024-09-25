package BinarySearch.BinarySearchOn1DArray;

import java.util.Scanner;

public class CeilAndFloor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int target = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        int[] floorAndCeil = getFloorAndCeil(array, target, arrayLength);

        for (int j : floorAndCeil) {
            System.out.print(j + " ");
        }

    }

    private static int[] getFloorAndCeil(int[] array, int target, int arrayLength) {
        int floor = binarySearchForFloor(array, target, 0, arrayLength - 1);
        int ceil = binarySearchForCeil(array, target, 0, arrayLength - 1);
        int[] floorAndCeil = new int[2];

        if (floor == -1) {
            floorAndCeil[0] = -1;
        } else {
            floorAndCeil[0] = array[floor];
        }

        if (ceil == arrayLength) {
            floorAndCeil[1] = -1;
        } else {
            floorAndCeil[1] = array[ceil];
        }

        return floorAndCeil;
    }

    private static int binarySearchForFloor(int[] array, int target, int start, int end) {
        if (start > end)
            return end;

        int mid = start + (end - start) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return binarySearchForFloor(array, target, mid + 1, end);
        } else {
            return binarySearchForFloor(array, target, start, mid - 1);
        }

    }

    private static int binarySearchForCeil(int[] array, int target, int start, int end) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return binarySearchForCeil(array, target, mid + 1, end);
        } else {
            return binarySearchForCeil(array, target, start, mid - 1);
        }

    }
}

/*
Floor: The largest number in the array that is less than or equal to the target.
Ceil: The smallest number in the array that is greater than or equal to the target.
Function Breakdown:
1. getFloorAndCeil(int[] array, int target, int arrayLength)
This is the main method that returns an array containing the floor and ceil of the target within the sorted array.

Parameters:
array: The sorted array where you want to find the floor and ceil.
target: The number for which you want to find the floor and ceil.
arrayLength: The length of the array.
Logic:
Calls binarySearchForFloor to find the index of the floor value.
Calls binarySearchForCeil to find the index of the ceil value.
Initializes floorAndCeil, an array of two elements, to store the results.
If no valid floor is found (i.e., floor == -1), it assigns -1 to floorAndCeil[0], otherwise, it assigns the actual value from the array.
If no valid ceil is found (i.e., ceil == arrayLength), it assigns -1 to floorAndCeil[1], otherwise, it assigns the actual value from the array.
Returns the floorAndCeil array containing both the floor and ceil.
2. binarySearchForFloor(int[] array, int target, int start, int end)
This method performs a binary search to find the floor (the largest number less than or equal to the target).

Parameters:

array: The sorted array.
target: The target value for which to find the floor.
start: The starting index for the search.
end: The ending index for the search.
Logic:

If the start index becomes greater than the end index, it returns end. This ensures that the last checked position (which might be smaller than the target) is returned.
Otherwise, it calculates the mid index.
If the array[mid] is equal to the target, then the floor is the target itself, so it returns mid.
If array[mid] < target, it means the floor could be at or after mid, so the search continues to the right (mid + 1 to end).
If array[mid] > target, the floor must be to the left (start to mid - 1), so it continues searching there.
3. binarySearchForCeil(int[] array, int target, int start, int end)
This method performs a binary search to find the ceil (the smallest number greater than or equal to the target).

Parameters:

Same as the binarySearchForFloor method.
Logic:

If start becomes greater than end, it returns start. This ensures that if the target is greater than the current mid, the search shifts to the next element, or start is the best candidate for ceil.
Otherwise, it calculates the mid index.
If array[mid] is equal to the target, then the ceil is the target itself, so it returns mid.
If array[mid] < target, the ceil must be to the right (mid + 1 to end).
If array[mid] > target, the ceil could be at mid or to the left, so it searches in the left half (start to mid - 1).
Example:
Suppose you have the following sorted array:

java
Copy code
int[] array = {1, 3, 5, 6, 9};
int target = 7;
Finding the Floor:

binarySearchForFloor(array, 7, 0, 4) starts with the whole array.
Midpoint: mid = 2 (value = 5), 5 < 7, so search continues in the right half.
Midpoint: mid = 3 (value = 6), 6 < 7, so search continues in the right half.
Now start = 4, end = 4. array[4] is 9, which is greater than 7, so it returns end = 3.
The floor is array[3] = 6.
Finding the Ceil:

binarySearchForCeil(array, 7, 0, 4) starts similarly.
Midpoint: mid = 2 (value = 5), 5 < 7, so search continues in the right half.
Midpoint: mid = 3 (value = 6), 6 < 7, so search continues in the right half.
Now start = 4, end = 4. array[4] is 9, which is greater than 7, so the ceil is array[4] = 9.
Final Result:

java
Copy code
floorAndCeil = [6, 9];
Edge Cases:
Target smaller than the smallest element: The floor will be -1, and the ceil will be the smallest element.
Target larger than the largest element: The floor will be the largest element, and the ceil will be -1.
Target equal to an element: Both floor and ceil will be the same and equal to that element.
 */
