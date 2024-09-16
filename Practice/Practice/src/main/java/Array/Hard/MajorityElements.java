package Array.Hard;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MajorityElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(majorityElements(array));

    }

    private static List<Integer> majorityElements(int[] array) {
        Map<Integer, Integer> hash = new LinkedHashMap<>();

        for (int num : array) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() > array.length / 3) {
                result.add(entry.getKey());
            }

        }

        return result;
    }
}

/*
Example 1:
Input Format
: N = 5, array[] = {1,2,2,3,2}
Result
: 2
Explanation:
 Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.

Example 2:
Input Format
:  N = 6, array[] = {11,33,33,11,33,11}
Result:
 11 33
Explanation:
 Here we can see that the Count(11) = 3 and Count(33) = 3. Therefore, the count of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.
 */