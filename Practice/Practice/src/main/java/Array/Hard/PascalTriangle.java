package Array.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        System.out.println(generate(numRows));
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = List.of(1);
        result.add(one);
        int iterator = 0;
        for (int i = 1; i < numRows; i++) {
            List<Integer> integers = result.get(iterator);
            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(1);
            for (int j = 0; j < integers.size() - 1; j++) {
                nextRow.add(integers.get(j) + integers.get(j + 1));
            }

            nextRow.add(1);
            result.add(nextRow);
            iterator++;
        }

        return result;
    }
}

/*
Example 1:
Input Format:
 N = 5, r = 5, c = 3
Result:
 6 (for variation 1)
1 4 6 4 1 (for variation 2)

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1    (for variation 3)

Explanation:
 There are 5 rows in the output matrix. Each row is formed using the logic of Pascal’s triangle.

Example 2:
Input Format:
 N = 1, r = 1, c = 1
Result:
 1 (for variation 1)
    1 (for variation 2)
    1  (for variation 3)
Explanation:
 The output matrix has only 1 row.
 */