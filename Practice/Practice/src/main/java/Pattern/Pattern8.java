package Pattern;

import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int rowCount = (num * 2) - 1;

        for (int i = 0; i < num; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }

            for (int j = rowCount; j > 0; j--) {
                System.out.print("*");
            }

            rowCount = rowCount - 2;
            System.out.println();

        }

    }
}

/*
Input Format: N = 3
Result:
*****
 ***
  *
Input Format: N = 6
Result:
***********
 *********
  *******
   *****
    ***
     *
 */
