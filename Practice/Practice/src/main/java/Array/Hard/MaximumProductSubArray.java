package Array.Hard;

import java.util.Scanner;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(subArrayWithMaxProduct(array));
    }

    private static int subArrayWithMaxProduct(int[] array) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                continue;
            }

            int product = array[i];
            if (product > result) {
                result = product;
            }

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] != 0) {
                    product *= array[j];

                    if (product > result) {
                        result = product;
                    }

                } else {
                    if (product > result) {
                        result = product;
                    }

                    break;
                }

            }

        }

        return result;
    }
}

/*
Example 1:
Input:

 Nums = [1,2,3,4,5,0]
Output:

 120
Explanation:

 In the given array, we can see 1×2×3×4×5 gives maximum product value.


Example 2:
Input:
 Nums = [1,2,-3,0,-4,-5]
Output:

 20
Explanation:

 In the given array, we can see (-4)×(-5) gives maximum product value.
 */