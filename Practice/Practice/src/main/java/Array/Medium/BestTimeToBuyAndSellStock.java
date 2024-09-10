package Array.Medium;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(maxProfit(array));

    }

    private static int maxProfit(int[] array) {
        int buy = 0;
        int sell = 0;
        int profit = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[buy] >= array[i]) {
                buy = i;
                sell = i;
            } else if (array[buy] < array[i]) {
                sell = i;
                int currentProfit = array[sell] - array[buy];
                if (currentProfit > profit) {
                    profit = currentProfit;
                }

            }

        }

        return profit;

    }
}

/*
Initialization:

buy = 0: This variable tracks the index of the day when the stock was bought. Initially, it's set to the first day (index 0).
sell = 0: This variable tracks the index of the day when the stock was sold. It starts at the same day as buy.
profit = 0: This variable stores the maximum profit encountered so far. Initially, it is set to 0.
Loop (for (int i = 1; i < array.length; i++)):

The loop iterates over each element of the array starting from the second day (i = 1).
At each iteration, the code compares the price of the stock at the current day (array[i]) with the price at the day the stock was bought (array[buy]).
Logic:

Case 1 (if (array[buy] >= array[i])):

If the price on day i is less than or equal to the price at the day we last bought the stock, we update buy = i. This means we decide to buy the stock on day i because it's cheaper.
The sell = i is updated as well because if we are buying on the current day, we can't sell before it, so sell is reset to i.
Case 2 (else if (array[buy] < array[i])):

If the price on day i is greater than the price at the day we bought the stock, we update sell = i, meaning we are considering selling the stock on day i to potentially maximize our profit.
The currentProfit is calculated as array[sell] - array[buy], which is the difference between the selling price and buying price.
If this currentProfit is greater than the previously recorded profit, the profit is updated.
Return Statement:

After the loop completes, the method returns the maximum profit found (profit).
Example:
Suppose the input array is {7, 1, 5, 3, 6, 4}:

Start at i = 1: Buy at day 1 (price = 1), compare future prices.
At i = 2: Price is 5, profit = 5 - 1 = 4 (store this as the current maximum profit).
At i = 3: Price is 3, no new profit opportunity.
At i = 4: Price is 6, new profit = 6 - 1 = 5 (update the maximum profit to 5).
At i = 5: Price is 4, no better profit than the previous one.
The method returns the maximum profit, which is 5.

Key Points:
The code effectively tracks the minimum buy price and checks for maximum possible selling price after that day.
The time complexity is O(n), where n is the length of the array since it involves a single pass over the array.

Example 1:
Input:
 prices = [7,1,5,3,6,4]
Output:
 5
Explanation:
 Buy on day 2 (price = 1) and
sell on day 5 (price = 6), profit = 6-1 = 5.

Note
: That buying on day 2 and selling on day 1
is not allowed because you must buy before
you sell.

Example 2:
Input:
 prices = [7,6,4,3,1]
Output:
 0
Explanation:
 In this case, no transactions are
done and the max profit = 0.
 */
