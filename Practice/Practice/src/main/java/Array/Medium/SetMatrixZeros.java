package Array.Medium;

import java.util.Scanner;

public class SetMatrixZeros {
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

        setMatrixZeros(array);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(array[i][j] + " ");
            }

            System.out.println();
        }

    }

    private static void setMatrixZeros(int[][] array) {
        int[] column = new int[array.length];
        int[] row = new int[array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) {
                    row[j] = 1;
                    column[i] = 1;
                }

            }

        }

        for (int i = 0; i < column.length; i++) {
            for (int j = 0; j < row.length; j++) {
                if (column[i] == 1 || row[j] == 1) {
                    array[i][j] = 0;
                }

            }

        }

    }
}

/*
Examples 1:
Input:
 matrix=[[1,1,1],[1,0,1],[1,1,1]]

Output:
 [[1,0,1],[0,0,0],[1,0,1]]

Explanation:
 Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.

Input:
 matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]

Output:
[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Explanation:
Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0
 */