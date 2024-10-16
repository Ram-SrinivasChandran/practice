package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class FindTheSmallestDivisorGivenAThreshold {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] numbers = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            numbers[i] = scanner.nextInt();
        }

        int threshold = scanner.nextInt();

        System.out.println(smallestDivisor(numbers, threshold));
    }

    private static int smallestDivisor(int[] numbers, int threshold) {

        int max = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }

        }

        return binarySearchForSmallestDivisor(numbers, threshold, 1, max);
    }

    private static int binarySearchForSmallestDivisor(int[] numbers, int threshold, int start, int end) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;
        int answer = 0;
        for (int number : numbers) {
            answer += number / mid;
            if (number % mid != 0) {
                answer++;
            }

        }

        if (answer <= threshold) {
            return binarySearchForSmallestDivisor(numbers, threshold, start, mid - 1);
        } else {
            return binarySearchForSmallestDivisor(numbers, threshold, mid + 1, end);
        }

    }
}

/*
Example 1:
Input Format:
 N = 5, arr[] = {1,2,3,4,5}, limit = 8
Result:
 3
Explanation:
 We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor.
The sum is 9(1 + 1 + 2 + 2 + 3)  if we choose 2 as a divisor. Upon dividing all the elements of the array by 3, we get 1,1,1,2,2 respectively. Now, their sum is equal to 7 <= 8 i.e. the threshold value. So, 3 is the minimum possible answer.

Example 2:
Input Format:
 N = 4, arr[] = {8,4,2,3}, limit = 10
Result:
 2
Explanation:
 If we choose 1, we get 17 as the sum. If we choose 2, we get 9(4+2+1+2) <= 10 as the answer. So, 2 is the answer.



Point to remember:

While dividing the array elements with a chosen number, we will always take the ceiling value. And then we will consider their summation. For example, 3 / 2 = 2.
Observation:

Minimum possible divisor: We can easily consider 1 as the minimum divisor as it is the smallest positive integer.
Maximum possible divisor: If we observe, we can conclude the maximum element in the array i.e. max(arr[]) is the maximum possible divisor. Any number > max(arr[]), will give the exact same result as max(arr[]) does. This divisor will generate the minimum possible result i.e. n(1 for each element), where n = size of the array.
With these observations, we can surely say that our answer will lie in the range
[1, max(arr[])].
 */
