package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class KthElementOfTwoSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array1Length = scanner.nextInt();
        int array2Length = scanner.nextInt();
        int[] num1 = new int[array1Length];
        int[] num2 = new int[array2Length];

        int k = scanner.nextInt();

        for (int i = 0; i < array1Length; i++) {
            num1[i] = scanner.nextInt();
        }

        for (int i = 0; i < array2Length; i++) {
            num2[i] = scanner.nextInt();
        }

        System.out.println(kthElement(k, num1, num2));

    }

    private static long kthElement(int k, int[] num1, int[] num2) {
        if (num1.length > num2.length) {
            return kthElement(k, num2, num1);
        }

        return binarySearchToFindKthElement(num1, num2, 0, num1.length, k - 1);
    }

    private static long binarySearchToFindKthElement(int[] num1, int[] num2, int start, int end, int k) {
        if (start > end)
            return binarySearchToFindKthElement(num2, num1, 0, num2.length, k);

        int minX = (start + end) / 2;

        if (minX >= k) {
            return binarySearchToFindKthElement(num1, num2, start, minX - 1, k);
        }

        int maxY = (((k - minX - 1) > -1) && (k - minX - 1) < num2.length) ? num2[k - minX - 1] : Integer.MAX_VALUE;

        int minY = (((k - minX - 2) > -1) && (k - minX - 2) < num2.length) ? num2[k - minX - 2] : Integer.MIN_VALUE;

        int maxX = ((minX + 1) < num1.length) && ((minX + 1) > -1) ? num1[minX + 1] : Integer.MAX_VALUE;

        if ((num1[minX] <= maxY && minY <= maxX)) {
            return Math.min(maxX, maxY);
        } else if (num1[minX] < maxY && maxX < minY) {
            return binarySearchToFindKthElement(num1, num2, minX + 1, end, k);
        } else {
            return binarySearchToFindKthElement(num1, num2, start, minX - 1, k);
        }

    }

}

/*
Input: k = 5, arr1[] = [2, 3, 6, 7, 9], arr2[] = [1, 4, 8, 10]
Output: 6
Explanation: The final combined sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10. The 5th element of this array is 6.
Input: k = 7, arr1[] = [100, 112, 256, 349, 770], arr2[] = [72, 86, 113, 119, 265, 445, 892]
Output: 256
Explanation: Combined sorted array is - 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892. 7th element of this array is 256.

Algorithm / Intuition
We are going to use the Binary Search algorithm to optimize the approach.

The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

Note: Please refer to the article Median of 2 sorted arrays to get a detailed overview of this optimal approach.

The optimal approach will be exactly similar to the one of the problem Median of 2 sorted arrays In that problem, the approach is the following:

Assume, m = size of arr1[] and n = size of arr2[].

We know the median creates a partition on the final merged array. So, the array can be divided into two halves that contain almost equal elements. So, the size of the left and right halves is approx. (m+n) / 2.
We also discussed that for a valid merged array, the left and the right half will be unique.
So, our approach was to form the unique left half correctly assuming that it contains x elements from arr1[] and ((m+n)/2)-x elements from arr2[]. Now the possible range of the variable x is [0, min(m, n)].
For all possible values of that range, we checked the configuration of the left half. Now, to validate the left half configuration, we used the condition l1 <= r2 && l2 <=r1. These four variables refer to as follows:

For example,


Here, l1 = arr1[1], l2 = arr2[2], r1 = arr1[2], r2 = arr2[3].

We are going to use the same approach with some minor changes in the values. The changes will be as follows:

The size of the left half will be k: Here, we don’t need to find the median and instead, we want the k-th element. So, the partition will be after the k-th element. So, the size of the left half will be k instead of (m+n)/2. For example,

Range of x:

The maximum possible value of x: We want to build the left subarray of size k. So, the maximum possible value should be k. But if we are considering arr1[] of size n1 and n1 < k, in that case, the maximum possible value will be n1. So, after generalization, the maximum value will be min(k, n1), where n1 = the size of the smaller array. Here n1 = min(m, n).
The minimum possible value of x: Let’s understand this using an example, given arr1[] size i.e. m = 6, and arr2[] size i.e. n = 5 and k = 7. Now, the lowest value of x(i.e. The no. of elements we should take from arr1[]) should be 2. If we have to build an array of size, 7, and the maximum element we can take from arr2[] is 5, so, we have to take a minimum of 2 elements from arr1[].

So, the minimum possible value should be k-n2, where n2 = the size of the not-considered array i.e. the bigger array.

But if k < n2, the k-n2, will be negative. So, to handle this case, we will consider the minimum value as max(0, k-n2), where n2 = the size of the bigger array, and here, n2 = max(m, n).

The new range of x will be [max(0, k-n2), min(k, n1)], where n1 = the size of the smaller array, and n2 = the size of the bigger array. Here n1 = min(m, n) as we want to optimize the time complexity we will consider the array with a smaller length. And we will apply binary search in this new range.

Note: The answer will always be max(l1, l2) as the kth element will be the maximum element of the left half.

The rest of the process will be as similar to the one used in the problem, Median of 2 sorted arrays.

Algorithm:
First, we have to make sure that the arr1[] is the smaller array. If not by default, we will just swap the arrays. Our main goal is to consider the smaller array as arr1[].
Calculate the length of the left half: left = k.
Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to max(0, k-n2), and the high will point to min(k, n1) (i.e. n1 = The size of the smaller array, n2 = the size of the bigger array).
Calculate the ‘mid1’ i.e. x and ‘mid2’ i.e. left-x: Now, inside the loop, we will calculate the value of ‘mid1’ using the following formula:

mid1 = (low+high) // 2 ( ‘//’ refers to integer division)

mid2 = left-mid1

Calculate l1, l2, r1, and r2: Generally,

l1 = arr1[mid1-1]
l2 = arr1[mid2-1]
r1 = arr1[mid1]
r1 = arr1[mid2]
The possible values of ‘mid1’ and ‘mid2’ might be 0 and n1 and n2 respectively. So, to handle these cases, we need to store some default values for these four variables. The default value for l1 and l2 will be INT_MIN and for r1 and r2, it will be INT_MAX.

Eliminate the halves based on the following conditions:

If l1 <= r2 && l2 <=r1: We have found the answer. Return max(l1, l2).
If l1 > r2: This implies that we have considered more elements from arr1[] than necessary. So, we have to take less elements from arr1[] and more from arr2[]. In such a scenario, we should try smaller values of x. To achieve this, we will eliminate the right half (high = mid1-1).
If l2 > r1: This implies that we have considered more elements from arr2[] than necessary. So, we have to take less elements from arr2[] and more from arr1[]. In such a scenario, we should try bigger values of x. To achieve this, we will eliminate the left half (low = mid1+1).
Finally, outside the loop, we will include a dummy return statement just to avoid warnings or errors.
 */