package Hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class HighestLowestFrequecyElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < arrayLength; i++) {
            int reOccurance = 0;
            if (hash.containsKey(array[i])) {
                reOccurance = hash.get(array[i]);
            }

            hash.put(array[i], reOccurance + 1);
        }

        Iterator<Integer> iterator = hash.keySet().iterator();
        int greaterValue = 0;
        int highestFrequencyKey = 0;
        int smallerValue = Integer.MAX_VALUE;
        int lowestFrequencyKey = 0;
        while (iterator.hasNext()) {
            int key = iterator.next();
            if (hash.get(key) > greaterValue) {
                greaterValue = hash.get(key);
                highestFrequencyKey = key;
            }

            if (hash.get(key) < smallerValue) {
                smallerValue = hash.get(key);
                lowestFrequencyKey = key;
            }

        }

        System.out.print(highestFrequencyKey + " " + lowestFrequencyKey);
    }
}



/*
Example 1:
Input: array[] = {10,5,10,15,10,5};
Output: 10 15
Explanation: The frequency of 10 is 3, i.e. the highest and the frequency of 15 is 1 i.e. the lowest.

Example 2:

Input: array[] = {2,2,3,4,4,2};
Output: 2 3
Explanation: The frequency of 2 is 3, i.e. the highest and the frequency of 3 is 1 i.e. the lowest.
 */