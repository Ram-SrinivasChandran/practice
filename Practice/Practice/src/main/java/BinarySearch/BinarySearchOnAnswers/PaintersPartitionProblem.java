package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class PaintersPartitionProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] boards = new int[arrayLength];
        int numberOfPainters = scanner.nextInt();

        for (int i = 0; i < arrayLength; i++) {
            boards[i] = scanner.nextInt();
        }

        System.out.println(findPainterPartition(boards, numberOfPainters));

    }

    private static int findPainterPartition(int[] boards, int numberOfPainters) {
        int total = 0;
        int max = Integer.MIN_VALUE;
        for (int board : boards) {
            total += board;
            if (board > max) {
                max = board;
            }

        }

        return binarySearchForPainterPartition(boards, numberOfPainters, max, total);
    }

    private static int binarySearchForPainterPartition(int[] boards, int numberOfPainters, int start, int end) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        int totalBoard = 0;
        int painterCount = 1;

        for (int i = 0; i < boards.length; i++) {
            if (totalBoard + boards[i] > mid) {
                totalBoard = 0;
                painterCount++;
                i--;
            } else {
                totalBoard += boards[i];
            }

        }

        if (painterCount <= numberOfPainters) {
            return binarySearchForPainterPartition(boards, numberOfPainters, start, mid - 1);
        } else {
            return binarySearchForPainterPartition(boards, numberOfPainters, mid + 1, end);
        }

    }
}

/*
Example 1:
Input Format:
 N = 4, boards[] = {5, 5, 5, 5}, k = 2
Result:
 10
Explanation:
 We can divide the boards into 2 equal-sized partitions, so each painter gets 10 units of the board and the total time taken is 10.

Example 2:
Input Format:
 N = 4, boards[] = {10, 20, 30, 40}, k = 2
Result:
 60
Explanation:
 We can divide the first 3 boards for one painter and the last board for the second painter.

We can allocate the boards to the painters in several ways but it is clearly said in the question that we have to allocate the boards in such a way that the painters can paint all the boards in the minimum possible time. The painters will work simultaneously.

Note: Upon close observation, we can understand that this problem is similar to the previous problem: BS-18. Allocate Books or Book Allocation | Hard Binary Search. There we had to allocate books to the students and here we need to allocate walls to the painters.

Assume the given array is {10, 20, 30, 40} and number of painters, k = 2. Now, we can allocate these boards in different ways. Some of them are the following:

10 | 20, 30, 40  → Minimum time required to paint all the boards  = 90
10, 20 | 30, 40  → Minimum time required to paint all the boards = 70
10, 20, 30 | 40  → Minimum time required to paint all the boards = 60
From the above allocations, we can clearly observe that in the last case, the first painter will paint the first 3 walls in 60 units of time and the second painter will take 40 units of time. So, the minimum time required to paint all the boards is 60.

Observations:

Minimum possible answer: We will get the minimum answer when we give n boards of the array to n painters(i.e. Each painter will be allocated 1 board). Now, in this case, the minimum time required to paint all the boards will be the maximum element in the array. So, the minimum possible answer is max(arr[]).
Maximum possible answer: We will get the maximum answer when we give all n boards to a single painter. The total time required is the summation of array elements i.e. sum(arr[]). So, the maximum possible answer is sum(arr[]).
From the observations, it is clear that our answer lies in the range [max(arr[]), sum(arr[])].

How to calculate the number of painters we need if we have to paint all the walls within ‘time’ units of time:

In order to calculate the number of painters we will write a function, countPainters(). This function will take the array and ‘time’ as parameters and return the number of painters to whom we can allocate the boards.

countPainters(arr[], time):

We will first declare two variables i.e. ‘painters’(stores the no. of painters), and ‘boardsPainter’(stores the unit of boards, a painter will paint). As we are starting with the first painter, ‘painters’ should be initialized with 1.
We will start traversing the given array.
If boardsPainter + arr[i] <= time: If upon adding the current board with ‘boardsPainter’ does not exceed the time limit, we can allocate this i-th board to the current painter.
Otherwise, we will move to the next painter(i.e. painters += 1 ) and allocate the i-th board.
Finally, we will return the value of ‘painters’.
 */
