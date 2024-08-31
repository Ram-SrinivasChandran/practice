package Pattern;

import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int rowCount = 1;
        for (int i = 0; i < num; i++) {
            for (int j = num - 1; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j < rowCount; j++) {
                System.out.print("*");
            }

            rowCount += 2;
            System.out.println();
        }

    }
}

/*
Input Format: N = 3
Result:
  *
 ***
*****
Input Format: N = 6
Result:
     *
    ***
   *****
  *******
 *********
***********
 */
