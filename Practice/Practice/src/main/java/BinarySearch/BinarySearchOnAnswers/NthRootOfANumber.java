package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class NthRootOfANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(nthRoot(n, m));
    }

    private static int nthRoot(int n, int m) {
        return binarySearch(n, m, 0, m);
    }

    private static int binarySearch(int n, int m, int start, int end) {
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= mid;
            if (ans > m) {
                break;
            }

        }

        if (ans == m) {
            return mid;
        } else if (ans > m) {
            return binarySearch(n, m, start, mid - 1);
        } else {
            return binarySearch(n, m, mid + 1, end);
        }

    }
}

/*
Sample Input 1:
3 27


Sample Output 1:
3


Explanation For Sample Input 1:
3rd Root of 27 is 3, as (3)^3 equals 27.


Sample Input 2:
4 69


Sample Output 2:
-1


Explanation For Sample Input 2:
4th Root of 69 is not an integer, hence -1.


Expected Time Complexity:
Try to do this in O(log(n+m)).


Constraints:
1 <= n <= 30
1 <= m <= 10^9

Time Limit: 1 sec.
 */
