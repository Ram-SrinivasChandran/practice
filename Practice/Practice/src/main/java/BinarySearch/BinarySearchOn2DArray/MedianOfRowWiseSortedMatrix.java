package BinarySearch.BinarySearchOn2DArray;

import java.util.Scanner;

public class MedianOfRowWiseSortedMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int[][] numbers = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                numbers[i][j] = scanner.nextInt();
            }

        }

        System.out.println(median(numbers, x, y));

    }

    private static int median(int[][] numbers, int x, int y) {
        return binarySearchForFindingMedian(numbers, 0, (int) 1e+9, (x * y) / 2);
    }

    private static int binarySearchForFindingMedian(int[][] numbers, int start, int end, int total) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        int totalNumbers = 0;

        for (int[] number : numbers) {
            totalNumbers += binarySearch(number, 0, number.length - 1, mid);
        }

        if (totalNumbers <= total) {
            return binarySearchForFindingMedian(numbers, mid + 1, end, total);
        } else {
            return binarySearchForFindingMedian(numbers, start, mid - 1, total);
        }

    }

    private static int binarySearch(int[] numbers, int start, int end, int numberToFind) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        if (numbers[mid] <= numberToFind) {
            return binarySearch(numbers, mid + 1, end, numberToFind);
        } else {
            return binarySearch(numbers, start, mid - 1, numberToFind);
        }

    }
}

/*
Example 1:
Input Format:M = 3, N = 3, matrix[][] =

                    1 4 9
                    2 5 6
                    3 8 7

Result: 5
Explanation:  If we find the linear sorted array, the array becomes 1 2 3 4 5 6 7 8 9. So, median = 5
Example 2:
Input Format:M = 3, N = 3, matrix[][] =

                    1 3 8
                    2 3 4
                    1 2 5

Result: 3
Explanation:  If we find the linear sorted array, the array becomes 1 1 2 2 3 3 4 5 7 8. So, median = 3

 The main logic behind this code is to find the median of a row-wise sorted 2D matrix without fully merging or sorting it, which would be inefficient. Instead, the approach combines binary search on value ranges and binary search on each row to count elements effectively.

Theoretical Explanation of the Code Logic
1. Understanding the Median in a Sorted Matrix
The median in a matrix of size x * y is the middle element when all elements are sorted. If x * y is odd, the median is the element at index (x * y) / 2. If it’s even, it would typically be the average of the middle two elements, but this code finds the middle one only.
Since the matrix rows are sorted individually but not together, fully sorting it would require merging all rows, which is computationally expensive.
2. Binary Search on Value Range
Instead of sorting or merging rows, this solution uses binary search on possible values within the matrix, searching within a range from 0 to a large possible value (like 1e9, assuming matrix elements could potentially be very large).
The midpoint value of this range (mid) is calculated, and the algorithm checks how many elements in the matrix are less than or equal to mid.
The logic is:
If there are enough elements less than or equal to mid to reach or exceed the median position, then mid might be the median, or the median could be a smaller number. Thus, the algorithm narrows down the range to focus on smaller numbers.
If not enough elements are less than or equal to mid, the median must be a larger number, so the search range is shifted upwards.
3. Counting Elements Efficiently with Binary Search on Each Row
For each midpoint value (mid), the algorithm needs to count how many elements in the matrix are less than or equal to it.
Since each row is sorted, this can be done efficiently with binary search on each row:
Binary search on a row finds the position where mid would fit in the sorted order, which effectively gives the count of elements in that row that are less than or equal to mid.
This count from each row is summed to get a total count of elements in the entire matrix that are less than or equal to mid.
4. Recursive Binary Search on the Value Range
The function binarySearchForFindingMedian performs binary search on the start to end range, adjusting based on whether the count of elements ≤ mid matches the desired median position.
The recursion ends when start exceeds end, meaning the start value is as close as possible to the true median.
Summary of the Approach
Binary Search on Values: We guess a potential median (mid in the range start to end) and count how many elements are less than or equal to it.
Binary Search on Rows: For each row, we efficiently count elements ≤ mid by performing a binary search on the row.
Adjust Range Based on Count:
If the total count of elements ≤ mid is at least the target median position, then the true median might be mid or something smaller, so we adjust the range to focus on smaller values.
Otherwise, we adjust the range to look for larger values.
Recursive Narrowing to Find the Median: The recursion continues to narrow down the possible values for the median until it converges on the median value, which is then returned.
This approach reduces the complexity compared to a brute-force sort-and-find-median method, achieving an efficient
𝑂(𝑥⋅log⁡(𝑦)⋅log⁡(max value))O(x⋅log(y)⋅log(max value)) time complexity.
 */
