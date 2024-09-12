package Array.Medium;

import java.util.Scanner;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] array = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                array[i][j] = scanner.nextInt();
            }

        }

        rotateMatrixBy90(array);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(array[i][j] + " ");
            }

            System.out.println();
        }

    }

    private static void rotateMatrixBy90(int[][] array) {
        int[][] result = new int[array.length][array[0].length];
        int row = 0;
        for (int i = 0; i < array[0].length; i++) {
            int column = 0;
            for (int j = array.length - 1; j >= 0; j--) {
                result[row][column] = array[j][i];
                column++;
            }

            row++;
        }

        for (int i = 0; i < array.length; i++) {
            System.arraycopy(result[i], 0, array[i], 0, array[0].length);
        }

    }
}

/*
Example 1:
Input:
 [[1,2,3],[4,5,6],[7,8,9]]

Output
: [[7,4,1],[8,5,2],[9,6,3]]

Explanation:
 Rotate the matrix simply by 90 degree clockwise and return the matrix.

Example 2:
Input:
 [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]

Output:
[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Explanation:
 Rotate the matrix simply by 90 degree clockwise and return the matrix
 */
