package BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class MinimumDaysToMakeMBouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] flowerToBloomAtADay = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            flowerToBloomAtADay[i] = scanner.nextInt();
        }

        int flowers = scanner.nextInt();
        int bouquet = scanner.nextInt();

        System.out.println(roseGarden(flowerToBloomAtADay, flowers, bouquet));
    }

    private static int roseGarden(int[] flowerToBloomAtADay, int flowers, int bouquet) {
        int max = Integer.MIN_VALUE;

        for (int bloomingDay : flowerToBloomAtADay) {
            if (bloomingDay > max) {
                max = bloomingDay;
            }

        }

        int result = binarySearchForArrangingBouquet(flowerToBloomAtADay, flowers, bouquet, 1, max);

        if (result > max) {
            return -1;
        }

        return result;
    }

    private static int binarySearchForArrangingBouquet(int[] flowerToBloomAtADay, int flowers, int bouquet, int start,
            int end) {
        if (start > end)
            return start;

        int mid = start + (end - start) / 2;

        int adjacentFlowerCount = 0;
        int bouquetCount = 0;
        for (int bloomingDay : flowerToBloomAtADay) {
            if (bloomingDay <= mid) {
                adjacentFlowerCount++;
                if (adjacentFlowerCount == flowers) {
                    bouquetCount++;
                    adjacentFlowerCount = 0;
                }

            } else {
                adjacentFlowerCount = 0;
            }

        }

        if (bouquet <= bouquetCount) {
            return binarySearchForArrangingBouquet(flowerToBloomAtADay, flowers, bouquet, start, mid - 1);
        } else {
            return binarySearchForArrangingBouquet(flowerToBloomAtADay, flowers, bouquet, mid + 1, end);
        }

    }
}

/*
Example 1:
Input Format:
 N = 8, arr[] = {7, 7, 7, 7, 13, 11, 12, 7}, m = 2, k = 3
Result:
 12
Explanation:
 On the 12th the first 4 flowers and the last 3 flowers would have already bloomed. So, we can easily make 2 bouquets, one with the first 3 and another with the last 3 flowers.

Example 2:
Input Format:
 N = 5, arr[] = {1, 10, 3, 10, 2}, m = 3, k = 2
Result:
 -1
Explanation:
 If we want to make 3 bouquets of 2 flowers each, we need at least 6 flowers. But we are given only 5 flowers, so, we cannot make the bouquets.


Let's grasp the question better with the help of an example. Consider an array: {7, 7, 7, 7, 13, 11, 12, 7}. We aim to create bouquets with k, which is 3 adjacent flowers, and we need to make m, which is 2 such bouquets. Now, if we try to make bouquets on the 11th day, the first 4 flowers and the 6th and the last flowers would have bloomed. So, we will be having 6 flowers in total on the 11th day. However, we require two groups of 3 adjacent flowers each. Although we can form one group with the first 3 adjacent flowers, we cannot create a second group. Therefore, 11 is not the answer in this case.

If we choose the 12th day, we can make 2 such groups, one with the first 3 adjacent flowers and the other with the last 3 adjacent flowers. Hence, we need a minimum of 12 days to make 2 bouquets.

Observation:

Impossible case: To create m bouquets with k adjacent flowers each, we require a minimum of m*k flowers in total. If the number of flowers in the array, represented by array-size, is less than m*k, it becomes impossible to form m bouquets even after all the flowers have bloomed. In such cases, where array-size < m*k, we should return -1.
 Maximum possible answer: The maximum potential answer corresponds to the time needed for all the flowers to bloom. In other words, it is the highest value within the given array i.e. max(arr[]).
Minimum possible answer: The minimum potential answer corresponds to the time needed for atleast one flower to bloom. In other words, it is the smallest value within the given array i.e. min(arr[]).
Note: From the above observations, we can conclude that our answer lies between the range [min(arr[]), max(arr[])].

How to calculate the number of bouquets we can make on dth day:

We will count the number of adjacent bloomed flowers(say cnt) and whenever we get a flower that is not bloomed, we will add the number of bouquets we can make with ‘cnt’ adjacent flowers i.e. floor(cnt/k) to the answer. We will follow the process throughout the array.

Now, we will write a function possible(), that will return true if, on a certain day, we can make at least m bouquets otherwise it will return false. The steps will be the following:

possible(arr[], day, m, k) algorithm:

We will declare two variables i.e. ‘cnt’ and ‘noOfB’.
cnt -> the number of adjacent flowers,
noOfB -> the number of bouquets.
We will run a loop to traverse the array.
Inside the loop, we will do the following:
If arr[i] <= day: This means the ith flower has bloomed. So, we will increase the number of adjacent flowers i.e. ‘cnt’ by 1.
Otherwise, the flower has not bloomed. Here, we will calculate the number of bouquets we can make with ‘cnt’ adjacent flowers i.e. floor(cnt/k), and add it to the noOfB. Now, as this ith flower breaks the sequence of the adjacent bloomed flowers, we will set the ‘cnt’ 0.
Lastly, outside the loop, we will calculate the floor(cnt/k) and add it to the noOfB.
If noOfB >= m: This means, we can make at least m bouquets. So, we will return true.
Otherwise, We will return false.
Note: We actually pass a particular day as a parameter to the possible() function. The function returns true if it is possible to make atleast m bouquets on that particular day, otherwise, it returns false.
 */
