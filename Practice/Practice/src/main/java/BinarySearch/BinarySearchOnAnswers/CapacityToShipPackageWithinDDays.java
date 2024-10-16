package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class CapacityToShipPackageWithinDDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();

        int days = scanner.nextInt();
        int[] weights = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.println(leastWeightCapacity(weights, days));
    }

    private static int leastWeightCapacity(int[] weights, int days) {
        int totalWeight = 0;
        int max = Integer.MIN_VALUE;
        for (int weight : weights) {
            totalWeight += weight;
            if (weight > max) {
                max = weight;
            }

        }

        return binarySearchForShipPackageWithinDDays(weights, days, max, totalWeight);
    }

    private static int binarySearchForShipPackageWithinDDays(int[] weights, int days, int start, int end) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;
        int daysCount = 1;
        int weightCount = 0;
        for (int weight : weights) {
            if (weightCount + weight <= mid) {
                weightCount += weight;
            } else {
                daysCount++;
                weightCount = weight;
            }

        }

        if (daysCount <= days) {
            return binarySearchForShipPackageWithinDDays(weights, days, start, mid - 1);
        } else {
            return binarySearchForShipPackageWithinDDays(weights, days, mid + 1, end);
        }

    }
}

/*
Example 1:
Input Format:
 N = 5, weights[] = {5,4,5,2,3,4,5,6}, d = 5
Result:
 9
Explanation:
 If the ship capacity is 9, the shipment will be done in the following manner:
Day         Weights            Total
1        -       5, 4          -        9
2        -       5, 2          -        7
3        -       3, 4          -        7
4        -       5              -        5
5        -       6              -        6
So, the least capacity should be 9.

Example 2:
Input Format:
 N = 10, weights[] = {1,2,3,4,5,6,7,8,9,10}, d = 1
Result:
 55
Explanation:
 We have to ship all the goods in a single day. So, the weight capacity should be the summation of all the weights i.e. 55.

Observation:

Minimum ship capacity: The minimum ship capacity should be the maximum value in the given array. Let’s understand using an example. Assume the given weights array is {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} and the ship capacity is 8. Now in the question, it is clearly stated that the loaded weights in the ship must not exceed the maximum weight capacity of the ship. For this constraint, we can never ship the weights 9 and 10, if the ship capacity is 8. That is why, in order to ship all the weights, the minimum ship capacity should be equal to the maximum of the weights array i.e. nax(weights[]).
Maximum capacity: If the ship capacity is equal to the sum of all the weights, we can ship all goods within a single day. Any capacity greater than this will yield the same result. So, the maximum capacity will be the summation of all the weights i.e. sum(weights[]).
From the observations, it is clear that our answer lies in the range
[max(weights[]), sum(weights[])].

How to calculate the number of days required to ship all the weights for a certain ship capacity:

In order to calculate this, we will write a function findDays(). This function accepts the weights array and a capacity as parameters and returns the number of days required for that particular capacity. The steps will be the following:

findDays(weights[], cap):

We will declare to variables i.e. ‘days’(representing the required days) and ‘load’ (representing the loaded weights in the ship). As we are on the first day, ‘days’ should be initialized with 1 and ‘load’ should be initialized with 0.
Next, we will use a loop(say i) to iterate over the weights. For each weight, weights[i], we will check the following:
If load+weights[i] > cap: If upon adding current weight with load exceeds the ship capacity, we will move on to the next day(i.e. day = day+1) and then load the current weight(i.e. Set load to weights[i], load = weights[i]).
Otherwise, We will just add the current weight to the load(i.e. load = load+weights[i]).
Finally, we will return ‘days’ which represents the number of days required.
 */
