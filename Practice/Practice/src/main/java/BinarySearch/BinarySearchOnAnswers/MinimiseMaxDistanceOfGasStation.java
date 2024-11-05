package BinarySearch.BinarySearchOnAnswers;

import java.util.Arrays;
import java.util.Scanner;

public class MinimiseMaxDistanceOfGasStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] gasStations = new int[arrayLength];
        int newGasStations = scanner.nextInt();

        for (int i = 0; i < arrayLength; i++) {
            gasStations[i] = scanner.nextInt();
        }

        System.out.println(MinimiseMaxDistance(gasStations, newGasStations));
    }

    private static double MinimiseMaxDistance(int[] gasStations, int newGasStations) {
        Arrays.sort(gasStations);

        double start = 0;
        double end = gasStations[gasStations.length - 1] - gasStations[0];

        return binarySearchForPlacingGasStations(gasStations, newGasStations, start, end);
    }

    private static double binarySearchForPlacingGasStations(int[] gasStations, int newGasStations, double start, double end) {
        if (end - start < 1e-6) {
            return start;
        }

        double mid = (start + end) / 2;

        if (canPlaceNewStations(gasStations, newGasStations, mid)) {
            return binarySearchForPlacingGasStations(gasStations, newGasStations, start, mid);
        } else {
            return binarySearchForPlacingGasStations(gasStations, newGasStations, mid, end);
        }
    }

    private static boolean canPlaceNewStations(int[] gasStations, int newGasStations, double maxDist) {
        int stationsNeeded = 0;

        for (int i = 1; i < gasStations.length; i++) {
            double gap = gasStations[i] - gasStations[i - 1];

            stationsNeeded += (int) (gap / maxDist);

            if (stationsNeeded > newGasStations) {
                return false;
            }
        }

        return true;
    }
}

/*
Input Format:
 N = 5, arr[] = {1,2,3,4,5}, k = 4
Result:
 0.5
Explanation:
 One of the possible ways to place 4 gas stations is {1,1.5,2,2.5,3,3.5,4,4.5,5}. Thus the maximum difference between adjacent gas stations is 0.5. Hence, the value of ‘dist’ is 0.5. It can be shown that there is no possible way to add 4 gas stations in such a way that the value of ‘dist’ is lower than this.
Example 2:
Input Format:
 N = 10, arr[] = {1,2,3,4,5,6,7,8,9,10}, k = 1
Result:
 1
Explanation:
 One of the possible ways to place 1 gas station is {1,1.5,2,3,4,5,6,7,8,9,10}. Thus the maximum difference between adjacent gas stations is still 1. Hence, the value of ‘dist’ is 1. It can be shown that there is no possible way to add 1 gas station in such a way that the value of ‘dist’ is lower than this.

Let’s understand how to place the new gas stations so that the maximum distance between two consecutive gas stations is reduced.

Let’s consider a small example like this: given gas stations = {1, 7} and k = 2.

Observation: A possible arrangement for placing 2 gas stations is as follows: {1, 7, 8, 9}. In this arrangement, the new gas stations are positioned after the last existing one. Prior to adding the new stations, the maximum distance between stations was 6 (i.e. the distance between 1 and 7). Even after placing the 2 new stations, the maximum distance remains unchanged at 6.

Conclusions:

From the above observation, we can conclude that placing new gas stations before the first existing station or after the last existing station will make no difference to the maximum distance between two consecutive stations.
So, in order to minimize the maximum distance we have to place the new gas stations in between the existing stations.
How to place the gas stations in between so that the maximum distance is minimized:

Until now we have figured out that we have to place the gas stations in between the existing ones. But we have to place them in such a way that the maximum distance between two consecutive stations is the minimum possible.
Let’s understand this considering the previous example. Given gas stations = {1, 7} and k = 2.
If we place the gas stations as follows: {1, 2, 6, 7}, the maximum distance will be 4(i.e. 6-2 = 4). But if we place them like this: {1, 3, 5, 7}, the maximum distance boils down to 2. It can be proved that we cannot make the maximum distance lesser than 2.
To minimize the maximum distance between gas stations, we need to insert new stations with equal spacing. If we have to add 'k' gas stations within a section of length 'section_length', each station should be placed at a distance of
(section_length / (k + 1)) from one another.
This way, we maintain a uniform spacing between consecutive gas stations.

For example, the gas stations are = {1, 7} and k = 2. Here, the ‘dist’ is = (7-1) = 6. So, the space between two gas stations will be dis / (k+1) = 6 / (2+1) = 2. The placements will be as follows: {1, 3, 5, 7}.
 */
