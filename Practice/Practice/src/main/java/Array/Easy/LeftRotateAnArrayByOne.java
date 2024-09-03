package Array.Easy;

import java.util.Scanner;

public class LeftRotateAnArrayByOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        int[] resultArray = leftRotateArray(array, arrayLength);

        for (int i = 0; i < arrayLength; i++) {
            System.out.print(resultArray[i] + " ");
        }

    }

    private static int[] leftRotateArray(int[] array, int arrayLength) {
        int lastElement = array[0];
        for (int i = 0; i < arrayLength - 1; i++) {
            array[i] = array[i + 1];
        }

        array[arrayLength - 1] = lastElement;
        return array;
    }
}

/*
Sample input 1:
4
5 7 3 2
Sample output 1:
7 3 2 5
Explanation of sample input 1:
Move the first element to the last and rest all the elements to the left.
Sample input 2:
5
4 0 3 2 5
Sample output 2:
0 3 2 5 4
Explanation of sample input 2:
Same as sample input 1, Move the first element to the last and rest all the elements to the left
Expected time complexity:
O( n ), Where ‘n’ is the size of an input array ‘arr’.
Constraints :
1 <= 'n' <= 10^5
1 <= 'arr[i] <= 10^9

Time Limit: 1 sec
 */
