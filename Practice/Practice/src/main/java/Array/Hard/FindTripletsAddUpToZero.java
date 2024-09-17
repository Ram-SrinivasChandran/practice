package Array.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTripletsAddUpToZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(triplet(arrayLength, array));
    }

    private static List<List<Integer>> triplet(int arrayLength, int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++) {
            if (i + 1 < arrayLength) {
                for (int j = i + 1; j < arrayLength; j++) {
                    if (j + 1 < arrayLength) {
                        for (int k = j + 1; k < arrayLength; k++) {
                            if (array[i] + array[j] + array[k] == 0) {
                                List<Integer> sum = List.of(array[i], array[j], array[k]);
                                if (!result.contains(sum)) {
                                    result.add(sum);
                                }

                            }

                        }

                    }

                }

            }

        }

        return result;
    }
}

/*
Example 1:
Input:
 nums = [-1,0,1,2,-1,-4]

Output:
 [[-1,-1,2],[-1,0,1]]

Explanation:
 Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition of summing up to zero with i!=j!=k

Example 2:
Input:
 nums=[-1,0,1,0]
Output:
 Output: [[-1,0,1],[-1,1,0]]
Explanation:
 Out of all possible unique triplets possible, [-1,0,1] and [-1,1,0] satisfy the condition of summing up to zero with i!=j!=k
 */
