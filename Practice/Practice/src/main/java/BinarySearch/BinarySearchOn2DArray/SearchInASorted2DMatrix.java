package BinarySearch.BinarySearchOn2DArray;

import java.util.Scanner;

public class SearchInASorted2DMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int target = scanner.nextInt();

        int[][] numbers = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                numbers[i][j] = scanner.nextInt();
            }

        }

        System.out.println(searchMatrix(numbers, target));
    }

    private static boolean searchMatrix(int[][] numbers, int target) {
        for (int[] number : numbers) {
            int ans = binarySearchForSearchMatrix(number, 0, number.length - 1, target);
            if (ans >= 0 && ans < number.length && number[ans] == target) {
                return true;
            }

        }

        return false;
    }

    private static int binarySearchForSearchMatrix(int[] numbers, int start, int end, int target) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        if (numbers[mid] >= target) {
            return binarySearchForSearchMatrix(numbers, start, mid - 1, target);
        } else {
            return binarySearchForSearchMatrix(numbers, mid + 1, end, target);
        }

    }
}

/*
Example 1:
Input Format:
 N = 3, M = 4, target = 8,
mat[] =
1 2 3 4
5 6 7 8
9 10 11 12
Result:
 true
Explanation:
 The ‘target’  = 8 exists in the 'mat' at index (1, 3).

Example 2:
Input Format:
 N = 3, M = 3, target = 78,
mat[] =
1 2 4
6 7 8
9 10 34
Result:
 false
Explanation:
 The ‘target' = 78 does not exist in the 'mat'. Therefore in the output, we see 'false'.
 */