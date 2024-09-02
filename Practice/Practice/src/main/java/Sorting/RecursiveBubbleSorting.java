package Sorting;

import java.util.Scanner;

public class RecursiveBubbleSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        bubbleSort(array,arrayLength);

        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static void bubbleSort(int[] array, int arrayLength) {
        if (arrayLength == 1)
            return;
        for (int j = 0; j <= arrayLength - 2; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }

        }

        bubbleSort(array, arrayLength - 1);

    }
}
