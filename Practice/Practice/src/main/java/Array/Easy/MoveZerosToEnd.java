package Array.Easy;

import java.util.Scanner;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        moveZeroToEnd(array, arrayLength);

        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }

    }

    private static void moveZeroToEnd(int[] array, int arrayLength) {
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] == 0) {
                for (int j = i; j < arrayLength - 1; j++) {
                    if (array[j + 1] != 0) {
                        array[i] = array[j + 1];
                        array[j + 1] = 0;
                        break;
                    }

                }

            }

        }

    }
}

/*
Example 1:
Input:
 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
Output:
 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
Explanation:
 All the zeros are moved to the end and non-negative integers are moved to front by maintaining order

Example 2:
Input:
 1,2,0,1,0,4,0
Output:
 1,2,1,4,0,0,0
Explanation:
 All the zeros are moved to the end and non-negative integers are moved to front by maintaining order
 */