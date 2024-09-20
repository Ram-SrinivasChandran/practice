package Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MergeAllOverlappingIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] array = new int[a][b];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                array[i][j] = scanner.nextInt();
            }

        }

        int[][] ints = mergeOverlappingIntervals(array);

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.println(ints[i][j]);
            }

        }

    }

    private static int[][] mergeOverlappingIntervals(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : intervals) {
            Arrays.sort(row);
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                if (end < intervals[i][intervals[0].length - 1]) {
                    end = intervals[i][intervals[0].length - 1];
                }

            } else {
                List<Integer> overlap = List.of(start, end);
                result.add(overlap);
                start = intervals[i][0];
                end = intervals[i][intervals[0].length - 1];
            }

        }

        List<Integer> overlap = List.of(start, end);
        result.add(overlap);

        int[][] mergedIntervals = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            mergedIntervals[i][0] = result.get(i).get(0);
            mergedIntervals[i][1] = result.get(i).get(1);
        }

        return mergedIntervals;
    }
}

/*
Example 1:
Input:
 intervals=[[1,3],[2,6],[8,10],[15,18]]

Output:
 [[1,6],[8,10],[15,18]]

Explanation:
 Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
 intervals.

Example 2:
Input:
 [[1,4],[4,5]]

Output:
 [[1,5]]

Explanation:
 Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].
 */
