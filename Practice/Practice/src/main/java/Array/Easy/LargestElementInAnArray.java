package Array.Easy;

import java.util.Scanner;

public class LargestElementInAnArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(largestElement(array, arrayLength));

    }

    public static int largestElement(int[] array, int arrayLength) {
        int largestElement = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] > largestElement) {
                largestElement = array[i];
            }

        }

        return largestElement;
    }
}

/*
Sample input 1:
6
4 7 8 6 7 6
Sample output 1:
8
Explanation of sample input 1:
The answer is 8.
From {4 7 8 6 7 6}, 8 is the largest element.
Sample input 2:
8
5 9 3 4 8 4 3 10
Sample output 2:
10
Expected Time Complexity:
O(n), Where ‘n’ is the size of an input array ‘arr’.
Constraints :
1 <= 'n' <= 10^5
1 <= 'arr[i]' <= 10^9

Time Limit: 1 sec
 */