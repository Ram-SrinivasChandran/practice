package Array.Easy;

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
        int longestSubArray = 0;
        int count = 0;
        boolean isEquals = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > k) {
                continue;
            } else if (array[i] == k) {
                isEquals = true;
            }

            int j = i + 1;
            count = 1;
            long sum = array[i];
            int zeroCount = 0;
            while (j < array.length) {
                if (sum + array[j] < k) {
                    sum += array[j];
                    count++;
                } else if (sum + array[j] == k) {
                    count++;

                    for (int l = j + 1; l < array.length ; l++) {
                        if (array[l] == 0) {
                            zeroCount++;
                        } else {
                            break;
                        }

                    }

                    isEquals = true;
                    break;
                } else {
                    break;
                }

                j++;
            }

            count += zeroCount;

            if (isEquals) {
                if (count > longestSubArray) {
                    longestSubArray = count;
                }
                isEquals=false;
            }

        }

        return longestSubArray;
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