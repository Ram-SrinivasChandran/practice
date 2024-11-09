package BinarySearch.BinarySearchOn2DArray;

import java.util.Scanner;

public class FindTheRowWithMaximumNumberOfOnes {
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

        System.out.println(rowMaxOnes(numbers, x, y));
    }

    private static int rowMaxOnes(int[][] numbers, int x, int y) {
        int max = 0;
        int index = 0;

        if (x == 0 && y == 0) {
            return -1;
        }

        for (int i = 0; i < x; i++) {
            int indexTotal = binarySearchForCount1s(numbers[i], 0, y - 1);
            if (max < y - indexTotal) {
                max = y - indexTotal;
                index = i;
            }

        }

        return index;
    }

    private static int binarySearchForCount1s(int[] numbers, int start, int end) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        if (numbers[mid] >= 1) {
            return binarySearchForCount1s(numbers, start, mid - 1);
        } else {
            return binarySearchForCount1s(numbers, mid + 1, end);
        }

    }
}

/*
Example 1:
Input Format:
 n = 3, m = 3,
mat[] =
1 1 1
0 0 1
0 0 0
Result:
 0
Explanation:
 The row with the maximum number of ones is 0 (0 - indexed).

Example 2:
Input Format:
 n = 2, m = 2 ,
mat[] =
0 0
0 0
Result:
 -1
Explanation:
  The matrix does not contain any 1. So, -1 is the answer.
 */