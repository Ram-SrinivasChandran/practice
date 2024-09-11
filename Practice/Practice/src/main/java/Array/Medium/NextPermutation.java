package Array.Medium;

import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        nextPermutation(array);

        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }

    }

    private static void nextPermutation(int[] array) {
        int index = -1;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] < array[i + 1]) {
                index = i;
                break;
            }

        }

        if (index != -1) {
            for (int i = array.length - 1; i > index; i--) {
                if (array[index] < array[i]) {
                    int temp = array[index];
                    array[index] = array[i];
                    array[i] = temp;
                    break;
                }

            }

        }

        int start = index + 1, end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

    }
}

/*
Example 1 :

Input format:
 Arr[] = {1,3,2}
Output
: Arr[] = {2,1,3}
Explanation:
All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,3,2} is {2,1,3}.
Example 2:

Input format:
 Arr[] = {3,2,1}
Output:
Arr[] = {1,2,3}
Explanation:
As we see all permutations of {1,2,3}, we find {3,2,1} at the last position. So, we have to return the topmost permutation.
 */
