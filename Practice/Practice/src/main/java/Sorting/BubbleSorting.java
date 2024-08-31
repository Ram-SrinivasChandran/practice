package Sorting;

import java.util.Scanner;

public class BubbleSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        int iterator = arrayLength - 1;
        while (iterator > 0) {
            for (int i = 0; i < iterator; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }

            }

            iterator--;
        }

        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }

    }
}

/*
Suppose we have the following list of numbers to sort: [5, 1, 4, 2, 8]

First pass:

Compare 5 and 1: Swap → [1, 5, 4, 2, 8]
Compare 5 and 4: Swap → [1, 4, 5, 2, 8]
Compare 5 and 2: Swap → [1, 4, 2, 5, 8]
Compare 5 and 8: No swap → [1, 4, 2, 5, 8]
Largest element 8 is in the correct place.

Second pass:

Compare 1 and 4: No swap → [1, 4, 2, 5, 8]
Compare 4 and 2: Swap → [1, 2, 4, 5, 8]
Compare 4 and 5: No swap → [1, 2, 4, 5, 8]
Now 5 is in its correct place.

Third pass:

Compare 1 and 2: No swap → [1, 2, 4, 5, 8]
Compare 2 and 4: No swap → [1, 2, 4, 5, 8]
At this point, the list is fully sorted.
 */