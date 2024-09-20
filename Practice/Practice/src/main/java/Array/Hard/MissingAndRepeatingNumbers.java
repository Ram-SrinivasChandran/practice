package Array.Hard;

import java.util.Arrays;
import java.util.Scanner;

public class MissingAndRepeatingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        int[] missingRepeatingNumbers = findMissingRepeatingNumbers(array);

        for (int missingRepeatingNumber : missingRepeatingNumbers) {
            System.out.print(missingRepeatingNumber + " ");
        }

    }

    private static int[] findMissingRepeatingNumbers(int[] array) {
        Arrays.sort(array);
        int temp = array[0];
        int repeat = 0;
        int missing = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] - temp == 2) {
                missing = temp + 1;
            } else if (temp - array[i] == 0) {
                repeat = temp;
            }

            temp = array[i];
        }

        if (missing == 0) {
            missing = temp + 1;
        }

        return new int[] { repeat, missing };
    }
}

/*
Sample Input 1:
4
1 2 3 2
Sample Output 1:
2 4
Explanation Of Sample Input 1:
Input: ‘N’ = 4
‘A’ = [1, 2, 3, 2]
Output: {2, 4} - The integer appearing twice is ‘2’, and the integer missing is ‘4’.
Sample Input 2:
3
1 2 1
Sample Output 2:
1 3
 */