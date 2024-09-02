package Array.Easy;

import java.util.Scanner;

public class CheckSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(checkSortedArray(array, arrayLength));

    }

    public static int checkSortedArray(int[] array, int arrayLength) {
        int count = 0;
        for (int i = 0; i < arrayLength - 1; i++) {

            if (array[i] < array[i + 1]) {
                count++;
            }

        }

        if (count == arrayLength - 1) {
            return 1;
        }

        return 0;
    }
}

/*
Sample Input 1 :
4
0 0 0 1
Sample Output 1 :
1
Explanation For Sample Input 1 :
The given array is sorted in non-decreasing order; hence the answer will be 1.
Sample Input 2 :
5
4 5 4 4 4
Sample Output 2 :
0
Expected Time Complexity:
O(n), Where ‘n’ is the size of an input array ‘a’.
Constraints:
1 ≤ 'n' ≤ 5*10^6
0 ≤ 'a'[i] ≤ 10^9

Time limit: 1 sec
 */