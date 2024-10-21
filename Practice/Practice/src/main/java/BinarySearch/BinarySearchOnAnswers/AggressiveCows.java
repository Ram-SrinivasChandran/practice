package BinarySearch.BinarySearchOnAnswers;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int totalCows = scanner.nextInt();
        int[] stalls = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            stalls[i] = scanner.nextInt();
        }

        System.out.println(aggressiveCows(stalls, totalCows));

    }

    private static int aggressiveCows(int[] stalls, int totalCows) {
        Arrays.sort(stalls);

        int max = Integer.MIN_VALUE;

        for (int stall : stalls) {
            if (stall > max) {
                max = stall;
            }

        }

        return binarySearchForPlacingCowsInStall(stalls, totalCows, 1, max);
    }

    private static int binarySearchForPlacingCowsInStall(int[] stalls, int totalCows, int start, int end) {
        if (start > end)
            return end;

        int mid = start + (end - start) / 2;

        if (isPlacingCowsInStallPossible(stalls, mid, totalCows)) {
            return binarySearchForPlacingCowsInStall(stalls, totalCows, mid + 1, end);
        } else {
            return binarySearchForPlacingCowsInStall(stalls, totalCows, start, mid - 1);
        }

    }

    private static boolean isPlacingCowsInStallPossible(int[] stalls, int distance, int totalCows) {
        int cowPlaced = 1;
        int i = 0;
        while (i < stalls.length) {
            for (int j = i + 1; j < stalls.length; j++) {
                if (stalls[j] - stalls[i] >= distance) {
                    cowPlaced++;
                    i = j;
                    i--;
                    break;
                }

            }

            if (cowPlaced == totalCows) {
                return true;
            }

            i++;

        }

        return false;
    }
}

/*
Example 1:
Input Format:
 N = 6, k = 4, arr[] = {0,3,4,7,10,9}
Result:
 3
Explanation:
 The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.

Example 2:
Input Format:
 N = 5, k = 2, arr[] = {4,2,1,3,6}
Result:
 5
Explanation:
 The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at positions {1, 6}.

Why do we need to sort the stalls?

To arrange the cows in a consecutive manner while ensuring a certain distance between them, the initial step is to sort the stalls based on their positions. In a sorted array, the minimum distance will always be obtained from any two consecutive cows. Arranging the cows in a consecutive manner does not necessarily mean placing them in consecutive stalls.

Assume the given stalls array is: {1,2,8,4,9} and after sorting it will be {1, 2, 4, 8, 9}. The given number of cows is 3.



We have to fit three cows in these 5 stalls. Each stall can accommodate only one. Our task is to maximize the minimum distance between two stalls. Let’s look at some arrangements:







In the first arrangement, the minimum distance between the cows is 1. Now, in the later cases, we have tried to place the cows in a manner so that the minimum distance can be increased. This is done in the second and third cases. It’s not possible to get a minimum distance of more than 3 in any arrangement, so we output 3.

Observation:

Minimum possible distance between 2 cows: The minimum possible distance between two cows is 1 as the minimum distance between 2 consecutive stalls is 1.
Maximum possible distance between 2 cows: The maximum possible distance between two cows is = max(stalls[])-min(stalls[]). This case occurs when we place 2 cows at two ends of the sorted stalls array.
From the observations, we can conclude that our answer lies in the range
[1, max(stalls[])-min(stalls[])].

How to place cows with maintaining a certain distance, ‘dist’, in the sorted stalls:

To begin, we will position the first cow in the very first stall. Next, we will iterate through the array, starting from the second stall. If the distance between the current stall and the last stall where a cow was placed is greater than or equal to the value 'dist', we will proceed to place the next cow in the current stall. Thus we will try to place the cows and finally, we will check if we have placed all the cows maintaining the distance, ‘dist’.

To serve this purpose, we will write a function canWePlace() that takes the distance, ‘dist’, as a parameter and returns true if we can place all the cows maintaining a minimum distance of ‘dist’. Otherwise, it returns false.

canWePlace(stalls[], dist, k):

We will declare two variables, ‘cntCows’ and ‘last’. ‘cntCows’ will store the number of cows placed, and ‘last’ will store the position of the last placed cow.
First, we will place the first cow in the very first stall. So, we will set ‘cntCows’ to 1 and ‘last’ to stall[0].
Then, using a loop we will start iterating the array from index 1. Inside the loop, we will do the following:
If stalls[i] - ‘last’ >= dist: This means the current stall is at least ‘dist’ distance away from the last stall. So, we can place the next cow here. We will increase the value ‘cntCows’ by 1 and set ‘last’ to the current stall.
If cntCows >= k: This means we have already placed k cows with maintaining the minimum distance ‘dist’. So, we will return true from this step.
If we are outside the loop, we cannot place k cows with a minimum distance of ‘dist’. So, we will return false.
 */