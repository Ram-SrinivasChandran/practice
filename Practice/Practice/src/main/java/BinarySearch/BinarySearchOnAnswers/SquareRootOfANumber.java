package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class SquareRootOfANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();

        System.out.println(sqrtN(num));
    }

    public static int sqrtN(long num) {
        return binarySearchForSquareRoot(num, 0, (int) num );
    }

    private static int binarySearchForSquareRoot(long num, int start, int end) {
        if (start > end)
            return end;

        int mid = start + (end - start) / 2;

        if ((long) mid * mid == num) {
            return mid;
        } else if ((long) mid * mid > num) {
            return binarySearchForSquareRoot(num, start, mid - 1);
        } else {
            return binarySearchForSquareRoot(num, mid + 1, end);
        }

    }
}

/*
Example 1:
Input Format:
 n = 36
Result:
 6
Explanation:
 6 is the square root of 36.

Example 2:
Input Format:
 n = 28
Result:
 5
Explanation:
 Square root of 28 is approximately 5.292. So, the floor value will be 5.
 */
