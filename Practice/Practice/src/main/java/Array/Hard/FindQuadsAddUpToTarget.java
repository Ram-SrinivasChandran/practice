package Array.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindQuadsAddUpToTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int target = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(fourSum(array, target));

    }

    private static List<List<Integer>> fourSum(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length) {
                for (int j = i + 1; j < array.length; j++) {
                    if (j + 1 < array.length) {
                        for (int k = j + 1; k < array.length; k++) {
                            if (k + 1 < array.length) {
                                for (int l = k + 1; l < array.length; l++) {
                                    if (array[i] + array[j] + array[k] + array[l] == target) {
                                        List<Integer> sum =
                                                new ArrayList<>(List.of(array[i], array[j], array[k], array[l]));
                                        Collections.sort(sum);
                                        if (!result.contains(sum)) {
                                            result.add(sum);
                                        }

                                    }

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
Input Format:
 arr[] = [1,0,-1,0,-2,2], target = 0
Result:
 [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Explanation:
 We have to find unique quadruplets from the array such that the sum of those elements is equal to the target sum given that is 0. The result obtained is such that the sum of the quadruplets yields 0.

Example 2:
Input Format:
 arr[] = [4,3,3,4,4,2,1,2,1,1], target = 9
Result:
 [[1,1,3,4],[1,2,2,4],[1,2,3,3]]
Explanation:
 The sum of all the quadruplets is equal to the target i.e. 9.
 */