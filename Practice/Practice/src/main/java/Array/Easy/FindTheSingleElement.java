package Array.Easy;

import java.util.Scanner;

public class FindTheSingleElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(getSingleElement(array));
    }

    private static int getSingleElement(int[] array) {
        int result = 0;

        for (int j : array) {
            result ^= j;
        }

        return result;
    }
}

/*
Explanation:
XOR Operation: The XOR operation (^) is applied between all elements of the array.
Efficiency:
Since XOR-ing the same numbers results in 0, all the duplicate numbers will cancel each other out, leaving only the number that appears once.
This approach works in a single pass through the array.
Time Complexity:
O(n): The loop iterates over the array exactly once.
Space Complexity:
O(1): No extra space is used beyond a few variables.
Summary:
The optimized solution reduces the time complexity to O(n) and the space complexity to O(1), making it more efficient than the original version.

Example 1:
Input Format:
 arr[] = {2,2,1}
Result:
 1
Explanation:
 In this array, only the element 1 appear once and so it is the answer.

Example 2:
Input Format:
 arr[] = {4,1,2,1,2}
Result:
 4
Explanation:
 In this array, only element 4 appear once and the other elements appear twice. So, 4 is the answer.
 */
