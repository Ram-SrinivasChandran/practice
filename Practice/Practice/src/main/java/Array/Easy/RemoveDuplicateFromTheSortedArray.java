package Array.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicateFromTheSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(removeDuplicate(array, arrayLength));
    }

    private static int removeDuplicate(int[] array, int arrayLength) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++) {
            if (!result.contains(array[i])) {
                result.add(array[i]);
            }

        }

        return result.size();
    }
}

/*
Sample input 1:
10
1 2 2 3 3 3 4 4 5 5
Sample output 1:
5
Explanation of sample input 1:
The new array will be [1 2 3 4 5].
So our answer is 5.
Sample input 2:
9
1 1 2 3 3 4 5 5 5
Sample output 2:
5
Expected time complexity:
The expected time complexity is O(n).
Constraints :
1 <= 'n' <= 10^6
-10^9 <= 'arr[i]' <=10^9

Where ‘arr[i]’ is the value of elements of the array.

Time limit: 1 sec
 */
