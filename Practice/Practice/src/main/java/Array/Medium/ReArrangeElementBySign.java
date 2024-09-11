package Array.Medium;

import java.util.Scanner;

public class ReArrangeElementBySign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        int[] result = rearrangeArray(array);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    private static int[] rearrangeArray(int[] array) {
        int positive = 0;
        int negative = 1;
        int[] result = new int[array.length];
        for (int j : array) {
            if (j > 0) {
                result[positive] = j;
                positive += 2;
            } else {
                result[negative] = j;
                negative += 2;
            }

        }

        return result;
    }
}

/*
Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.
Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
 */
