package Array.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuperiorElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(superiorElements(array));
    }

    private static List<Integer> superiorElements(int[] array) {
        List<Integer> result = new ArrayList<>();
        int leader = array[array.length - 1];
        result.add(leader);
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > leader) {
                result.add(array[i]);
                leader = array[i];
            }

        }

        return result;
    }
}

/*
Sample Input 1:
4
1 2 2 1


Sample Output 1:
1 2


Explanation of Sample Input 1:
Element present at the last index is '1' and is a superior element since there are no integers to the right of it.
Element present at index 2 (0-indexed) is '2' and is greater than all the elements to the right of it.
There are no other superior elements present in the array.
Hence the final answer is [1,2].


Sample Input 2:
3
5 4 3


Sample Output 2:
3 4 5


Expected Time Complexity:
Try to solve this in O(n).


Constraints:
1 <= n <=10^5
1 <= a[i] <= 10^9
Time Limit: 1 sec
 */