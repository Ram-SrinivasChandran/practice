package Array.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubArrayWithTheSumK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(longestSubArrayWithSumK(array, k));
    }

    private static int longestSubArrayWithSumK(int[] array, int k) {
        int start = 0;
        int end = 0;
        int currentSum = 0;
        int maxLength = 0;

        while (end < array.length) {
            currentSum += array[end];

            while (currentSum > k && start <= end) {
                currentSum -= array[start];
                start++;
            }

            if (currentSum == k) {
                maxLength = Math.max(maxLength, end - start + 1);
            }

            end++;
        }

        return maxLength;
    }
}

/*

Sample Input 1 :
7 3
1 2 3 1 1 1 1


Sample Output 1 :
3


Explanation Of Sample Input 1 :
Subarrays whose sum = ‘3’ are:
[1, 2], [3], [1, 1, 1] and [1, 1, 1]
Here, the length of the longest subarray is 3, which is our final answer.


Sample Input 2 :
4 2
1 2 1 3


Sample Output 2 :
1


Sample Input 3 :
5 2
2 2 4 1 2


Sample Output 3 :
1


Expected time complexity :
The expected time complexity is O(n).


Constraints :
1 <= 'n' <= 5 * 10 ^ 6
1 <= 'k' <= 10^18
0 <= 'a[i]' <= 10 ^ 9

Time Limit: 1-second
 */