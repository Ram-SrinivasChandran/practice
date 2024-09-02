package Sorting;

import java.util.Scanner;

public class RecursiveInsertionSort {
    static int count = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        insertionSorting(array);

        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static void insertionSorting(int[] array) {
        if (count == array.length)
            return;
        for (int i = count; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
            }

        }

        count++;
        insertionSorting(array);
    }
}
