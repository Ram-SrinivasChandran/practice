package BinarySearch.BinarySearchOn2DArray;

import java.util.Scanner;

public class FindAPeakElementIn2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int[][] numbers = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                numbers[i][j] = scanner.nextInt();
            }

        }

        int[] result = findPeakGrid(numbers);

        for (int ans : result) {
            System.out.print(ans + " ");
        }

    }

    private static int[] findPeakGrid(int[][] numbers) {
        return binarySearchForFindPeekElementInThe2DArray(numbers, 0, numbers[0].length - 1);
    }

    private static int[] binarySearchForFindPeekElementInThe2DArray(int[][] numbers, int start, int end) {
        if (start > end)
            return new int[] { -1, -1 };

        int mid = start + (end - start) / 2;
        int max = -1;
        int index = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i][mid] > max) {
                max = numbers[i][mid];
                index = i;
            }

        }

        int maxNumber = numbers[index][mid];

        int left = ((mid - 1) > -1) ? numbers[index][mid - 1] : -1;

        int right = ((mid + 1) < numbers[0].length) ? numbers[index][mid + 1] : -1;

        if (maxNumber > left && maxNumber > right) {
            return new int[] { index, mid };
        } else if (maxNumber < left) {
            return binarySearchForFindPeekElementInThe2DArray(numbers, start, mid - 1);
        } else {
            return binarySearchForFindPeekElementInThe2DArray(numbers, mid + 1, end);
        }

    }
}

/*
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.



Example 1:



Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
Example 2:



Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 */