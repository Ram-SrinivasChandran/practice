package Array.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnionOfSortedArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array1Length = scanner.nextInt();
        int array2Length = scanner.nextInt();
        int[] array1 = new int[array1Length];
        for (int i = 0; i < array1Length; i++) {
            array1[i] = scanner.nextInt();
        }

        int[] array2 = new int[array2Length];

        for (int i = 0; i < array2Length; i++) {
            array2[i] = scanner.nextInt();
        }

        List<Integer> result = sortedArray(array1, array2);

        System.out.println(result);
    }

    public static List<Integer> sortedArray(int[] array1, int[] array2) {
        List<Integer> result = new ArrayList<>();
        int array1Iterator = 0;
        int array2Iterator = 0;
        while (array1Iterator < array1.length) {
            if (array2Iterator < array2.length) {
                if (array1[array1Iterator] < array2[array2Iterator]) {
                    if (!result.contains(array1[array1Iterator])) {
                        result.add(array1[array1Iterator]);
                    }

                    array1Iterator++;
                } else {
                    if (!result.contains(array2[array2Iterator])) {
                        result.add(array2[array2Iterator]);
                    }

                    array2Iterator++;
                }

            } else {
                if (!result.contains(array1[array1Iterator])) {
                    result.add(array1[array1Iterator]);
                }

                array1Iterator++;
            }

        }

        if (array2Iterator < array2.length) {
            for (int i = array2Iterator; i < array2.length; i++) {
                if (!result.contains(array2[i])) {
                    result.add(array2[i]);
                }

            }

        }

        return result;
    }
}

/*

Sample Input 1 :
5 3
1 2 3 4 6
2 3 5
Sample Output 1 :
1 2 3 4 5 6
Explanation Of Sample Input 1 :
Input: ‘n’ = 5 ‘m’ = 3
‘a’ = [1, 2, 3, 4, 6]
‘b’ = [2, 3, 5]

Output: [1, 2, 3, 4, 5, 6]

Explanation: Common elements in ‘a’ and ‘b’ are: [2, 3]
Distinct elements in ‘a’ are: [1, 4, 6]
Distinct elements in ‘b’ are: [5]
Union of ‘a’ and ‘b’ is: [1, 2, 3, 4, 5, 6]
Sample Input 2:
4 3
1 2 3 3
2 2 4
Sample Output 2:
1 2 3 4
Explanation Of Sample Input 2 :
Input: ‘n’ = 5 ‘m’ = 3
‘a’ = [1, 2, 3, 3]
‘b’ = [2, 2, 4]

Output: [1, 2, 3, 4]

Explanation: Common elements in ‘a’ and ‘b’ are: [2]
Distinct elements in ‘a’ are: [1, 3]
Distinct elements in ‘b’ are: [4]
Union of ‘a’ and ‘b’ is: [1, 2, 3, 4]
Expected Time Complexity:
O(( N + M )), where 'N' and ‘M’ are the sizes of Array ‘A’ and ‘B’.
Constraints :
1 <= 'n', 'm' <= 10^5
-10^9 <= 'a'[i], 'b'[i] <= 10^9

Time Limit: 1 sec
 */
