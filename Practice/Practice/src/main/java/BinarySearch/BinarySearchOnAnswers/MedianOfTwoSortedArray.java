package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array1Length = scanner.nextInt();
        int array2Length = scanner.nextInt();
        int[] num1 = new int[array1Length];
        int[] num2 = new int[array2Length];

        for (int i = 0; i < array1Length; i++) {
            num1[i] = scanner.nextInt();
        }

        for (int i = 0; i < array2Length; i++) {
            num2[i] = scanner.nextInt();
        }

        System.out.println(median(num1, num2));

    }

    private static double median(int[] num1, int[] num2) {
        return binarySearchForFindingMedian(num1, num2, 0, num1.length - 1, (num1.length + num2.length) / 2);
    }

    private static double binarySearchForFindingMedian(int[] num1, int[] num2, int start, int end, int total) {
        if (start > end)
            throw new IllegalArgumentException("Input arrays are not sorted.");

        int minX = start + (end - start) / 2;

        int maxY = ((total - minX - 1) > -1) ? num2[total - minX - 1] : Integer.MAX_VALUE;

        int minY = ((total - minX - 2) > -1 ? num2[total - minX - 2] : Integer.MIN_VALUE);

        int maxX = ((minX + 1) < num1.length ? num1[minX + 1] : Integer.MAX_VALUE);

        if ((num1[minX] <= maxY && minY <= maxX)) {
            if ((num1.length + num2.length) % 2 == 0) {
                return ((double) Math.max(num1[minX], minY) + Math.min(maxY, maxX)) / 2;
            } else {
                return Math.min(maxX, maxY);
            }

        } else if (num1[minX] < maxY && maxX < minY) {
            return binarySearchForFindingMedian(num1, num2, minX + 1, end, total);
        } else {
            return binarySearchForFindingMedian(num1, num2, start, minX - 1, total);
        }

    }
}

/*
Example 1:
Input Format:
 n1 = 3, arr1[] = {2,4,6}, n2 = 3, arr2[] = {1,3,5}
Result:
 3.5
Explanation:
 The array after merging 'a' and 'b' will be { 1, 2, 3, 4, 5, 6 }. As the length of the merged list is even, the median is the average of the two middle elements. Here two medians are 3 and 4. So the median will be the average of 3 and 4, which is 3.5.

Example 2:
Input Format:
 n1 = 3, arr1[] = {2,4,6}, n2 = 2, arr2[] = {1,3}
Result:
 3
Explanation:
 The array after merging 'a' and 'b' will be { 1, 2, 3, 4, 6 }. The median is simply 3.

 1. Median Definition:
The median of two sorted arrays is the middle element if the combined number of elements is odd. If the combined number of elements is even, the median is the average of the two middle elements.
2. Key Idea of the Binary Search Approach:
We can partition the two sorted arrays such that:

The left side contains roughly half of the total elements from both arrays.
The right side contains the other half.
The partitioning is done using the binary search on one of the arrays (say num1), while ensuring that the combined left partition from both arrays contains fewer than or equal to elements as the right partition.

3. Steps for Binary Search to Find the Median:
Step 1: Calculate Partitions
Let the total length of both arrays combined be total = num1.length + num2.length.
Perform a binary search on the smaller array (num1) by maintaining two pointers, start and end, which represent the range of indices in num1.
The partition point in num1 is at index minX = (start + end) / 2.
Step 2: Partition the Arrays
The partition in num2 is determined by the total number of elements and the partition in num1:
If minX elements are chosen from num1, then the corresponding index in num2 is total - minX - 2 (because the indices are 0-based).
Step 3: Check Validity of Partition
For the partition to be valid, the following conditions must hold:
All elements on the left side (from both arrays) must be less than or equal to all elements on the right side.
Specifically, the largest element on the left side of num1 (i.e., num1[minX]) must be less than or equal to the smallest element on the right side of num2 (i.e., num2[total - minX - 2]).
Similarly, the largest element on the left side of num2 (i.e., num2[total - minX - 2]) must be less than or equal to the smallest element on the right side of num1 (i.e., num1[minX + 1]).
Step 4: Adjust the Partition
If the partition is not valid:
If num1[minX] is too large compared to num2[total - minX - 2], it means we need to move the partition in num1 to the left (end = mid - 1).
If num1[minX] is too small compared to num2[total - minX - 2], it means we need to move the partition in num1 to the right (start = mid + 1).
Step 5: Calculate the Median
Once a valid partition is found:

If the combined total number of elements is even, the median is the average of the maximum value from the left partition and the minimum value from the right partition.
If the combined total number of elements is odd, the median is the maximum value from the left partition.
4. Theoretical Formulation:
Median Conditions:

Let leftX = num1[minX], rightX = num1[minX + 1] (if minX + 1 is within bounds).
Let leftY = num2[total - minX - 2], rightY = num2[total - minX - 1] (if the indices are valid).
For a valid partition:

leftX
≤
rightY and leftY≤rightX
leftX≤rightY and leftY≤rightX
Median Calculation:

If the total number of elements is odd:
Median=max⁡(leftX,leftY)
Median=max(leftX,leftY)
If the total number of elements is even:
Median=max⁡(leftX,leftY)+min⁡(rightX,rightY)
2
Median=
2
max(leftX,leftY)+min(rightX,rightY)
​

5. Time Complexity:
The time complexity of the binary search approach is
𝑂
(log⁡(min⁡(𝑛,𝑚)))
O(log(min(n,m))), where:
n is the length of num1,
m is the length of num2.
Since we're performing a binary search on the smaller array, the search space is reduced logarithmically, making it much more efficient than merging the arrays and then calculating the median.

6. Summary:
The key to the binary search approach is:

Partitioning the two arrays such that the elements to the left of the partition in both arrays are smaller than the elements to the right.
Using binary search on the smaller array to efficiently find the correct partition.
Calculating the median based on the values at the partition edges once a valid partition is found.
This method ensures that we find the median in
𝑂(log⁡(min⁡(𝑛,𝑚)))
O(log(min(n,m))) time, which is significantly faster than merging the arrays and sorting them.
 */
