package Array.Easy;

import java.util.Scanner;

public class RotateArrayNTimes {
    static int times = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int rotationCount = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        if (rotationCount > array.length) {
            rotationCount = rotationCount % array.length;
        }

        rotateNTimes(array, rotationCount);

        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }

    }

    private static void rotateNTimes(int[] array, int rotationCount) {

        if (times == rotationCount)
            return;

        int temp = array[array.length - 1];
        for (int j = array.length - 1; j > 0; j--) {
            array[j] = array[j - 1];
        }

        array[0] = temp;
        times++;
        rotateNTimes(array, rotationCount);
    }
}

/*
Example 1:
Input: N = 7, array[] = {1,2,3,4,5,6,7} , k=2 , right
Output: 6 7 1 2 3 4 5
Explanation: array is rotated to right by 2 position .

Example 2:
Input: N = 6, array[] = {3,7,8,9,10,11} , k=3 , left
Output: 9 10 11 3 7 8
Explanation: Array is rotated to right by 3 position.
 */
