package Array.Easy;

import java.util.Scanner;

public class FindMissingNumberInAnArrayON {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(missingNumber(array, arrayLength));
    }

    private static int missingNumber(int[] array, int arrayLength) {
        int totalSum = arrayLength * (arrayLength + 1) / 2;
        int givenSumFromArray = 0;
        for (int num : array) {
            givenSumFromArray += num;
        }

        return totalSum - givenSumFromArray;
    }
}

/*
Sample Input 1 :
4
1 2 3
Sample Output 1:
4
Explanation Of Sample Input 1:
4 is the missing value in the range 1 to 4.
Sample Input 2:
8
1 2 3 5 6 7 8
Sample Output 2:
4
Explanation Of Sample Input 2:
4 is the missing value in the range 1 to 8.
Expected time complexity:
The expected time complexity is O(n).
Constraints:
1 <= 'n' <= 10^6
1 <= 'a'[i] <= 'n'
Time Limit: 1 sec
 */
