package Array.Hard;

import java.util.Scanner;

public class CountInversionsInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(numberOfInversions(array, arrayLength));
    }

    private static int numberOfInversions(int[] array, int arrayLength) {
        int count = 0;
        for (int i = 0; i < arrayLength; i++) {
            int j = i + 1;
            while (j < arrayLength) {
                if (array[i] > array[j]) {
                    count++;
                }

                j++;
            }

        }

        return count;
    }
}

/*
Sample Input 1:
4
4 3 2 1
Sample Output 1:
6
Explanation Of Sample Input 1:
Input:
A = [4, 3, 2, 1], N = 4
Output:
6
Explanation:
The pairs satisfying the condition for inversion are (1, 2), (1, 3), (1, 4), (2, 3), (2, 4), and (3, 4).
The number of inversions in the array is 6.
Sample Input 2:
5
1 20 6 4 5
Sample Output 2:
5
Constraints:
1 <= N <= 10^5
1 <= A[i] <= 10^9
Time Limit: 1 sec
 */