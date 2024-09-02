package Array.Easy;

import java.util.Scanner;

public class SecondLargestAndLargestElementWithoutSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        int[] result = secondLargestAndLargestElementWithoutSorting(array, arrayLength);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    public static int[] secondLargestAndLargestElementWithoutSorting(int[] array, int arrayLength) {
        int largestNumber1 = Integer.MIN_VALUE;
        int largestNumber2 = Integer.MIN_VALUE;
        int smallestNumber1 = Integer.MAX_VALUE;
        int smallestNumber2 = Integer.MAX_VALUE;

        for (int i = 0; i < arrayLength; i++) {
            if (largestNumber1 < array[i]) {
                largestNumber1 = array[i];
            }

            if (smallestNumber1 > array[i]) {
                smallestNumber1 = array[i];
            }

        }

        for (int i = 0; i < arrayLength; i++) {
            if (largestNumber2 < array[i] && array[i] < largestNumber1) {
                largestNumber2 = array[i];
            }

            if (smallestNumber2 > array[i] && array[i] > smallestNumber1) {
                smallestNumber2 = array[i];
            }

        }

        return new int[] { largestNumber2, smallestNumber2 };
    }
}

/*
Sample Input 1 :
4
3 4 5 2
Sample Output 1 :
4 3
Explanation For Sample Input 1 :
The second largest element after 5 is 4 only, and the second smallest element after 2 is 3.
Sample Input 2 :
5
4 5 3 6 7
Sample Output 2 :
6 4
Expected Time Complexity:
O(n), Where ‘n’ is the size of an input array ‘a’.
Constraints:
2 ≤ 'n' ≤ 10^5
0 ≤ 'a'[i] ≤ 10^9

Time limit: 1 sec


Hints:
1. Sort the array.
2. More efficiently, can you use the largest and smallest elements to find the required elements?
 */
