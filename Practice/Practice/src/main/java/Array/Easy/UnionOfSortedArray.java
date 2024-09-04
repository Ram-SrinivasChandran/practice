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

Example 1:
Input:

n = 5,m = 5.
arr1[] = {1,2,3,4,5}
arr2[] = {2,3,4,4,5}
Output:

 {1,2,3,4,5}

Explanation:

Common Elements in arr1 and arr2  are:  2,3,4,5
Distnict Elements in arr1 are : 1
Distnict Elemennts in arr2 are : No distinct elements.
Union of arr1 and arr2 is {1,2,3,4,5}

Example 2:
Input:

n = 10,m = 7.
arr1[] = {1,2,3,4,5,6,7,8,9,10}
arr2[] = {2,3,4,4,5,11,12}
Output:
 {1,2,3,4,5,6,7,8,9,10,11,12}
Explanation:

Common Elements in arr1 and arr2  are:  2,3,4,5
Distnict Elements in arr1 are : 1,6,7,8,9,10
Distnict Elemennts in arr2 are : 11,12
Union of arr1 and arr2 is {1,2,3,4,5,6,7,8,9,10,11,12}
 */
