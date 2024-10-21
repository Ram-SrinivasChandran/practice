package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] numbers = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            numbers[i] = scanner.nextInt();
        }

        int missingTerm = scanner.nextInt();

        System.out.println(missingK(numbers, arrayLength, missingTerm));
    }

    private static int missingK(int[] numbers, int arrayLength, int missingTerm) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arrayLength; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }

        }

        int result = binarySearchForFindingMissingKthPositiveNumber(numbers, missingTerm, 1, max);

        if (result == -1) {
            result = arrayLength + missingTerm;
        }

        return result;
    }

    private static int binarySearchForFindingMissingKthPositiveNumber(int[] numbers, int missingTerms, int start,
            int end) {

        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        int misTermCount = 0;

        if (!binarySearch(numbers, mid, 0, numbers.length - 1)) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] > mid) {
                    misTermCount = mid - i;
                    break;
                }

            }

        }

        if (misTermCount == 0) {
            int presentAt = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == mid) {
                    presentAt = i;
                    break;
                }

            }

            int checkForMissing = mid - (presentAt + 1);

            if (checkForMissing >= missingTerms) {
                return binarySearchForFindingMissingKthPositiveNumber(numbers, missingTerms, start, mid - 1);
            } else {
                return binarySearchForFindingMissingKthPositiveNumber(numbers, missingTerms, mid + 1, end);
            }

        } else {
            if (misTermCount == missingTerms) {
                return mid;
            } else if (misTermCount > missingTerms) {
                return binarySearchForFindingMissingKthPositiveNumber(numbers, missingTerms, start, mid - 1);
            } else {
                return binarySearchForFindingMissingKthPositiveNumber(numbers, missingTerms, mid + 1, end);
            }

        }

    }

    private static boolean binarySearch(int[] numbers, int number, int start, int end) {
        if (start > end)
            return false;

        int mid = start + (end - start) / 2;

        if (numbers[mid] == number) {
            return true;
        } else if (numbers[mid] > number) {
            return binarySearch(numbers, number, start, mid - 1);
        } else {
            return binarySearch(numbers, number, mid + 1, end);
        }

    }
}

/*
Example 1:
Input Format:
 vec[]={4,7,9,10}, k = 1
Result:
 1
Explanation:
 The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 1, the first missing element is 1.
Example 2:
Input Format:
 vec[]={4,7,9,10}, k = 4
Result:
 5
Explanation:
 The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 4, the fourth missing element is 5.
 */
