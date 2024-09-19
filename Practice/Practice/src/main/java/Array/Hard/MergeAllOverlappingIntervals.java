package Array.Hard;

import java.util.ArrayList;
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

        System.out.println(mergeOverlappingIntervals(array));

    }

    private static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int start = arr[0][0];
        int end = 0;
        for (int[] ints : arr) {
            if (start > ints[0] || end > ints[arr[0].length - 1]) {
                List<Integer> overlapped = new ArrayList<>();
                overlapped.add(start);
                overlapped.add(end);
                result.add(overlapped);
                start = ints[0];
            }
            end = ints[arr[0].length - 1];

        }

        return result;
    }
}

