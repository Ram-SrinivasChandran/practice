package Pattern;

import java.util.Scanner;

public class Pattern19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int star = num;
        int space = 0;

        for (int i = 0; i < num; i++) {
            for (int j = star; j > 0; j--) {
                System.out.print("*");
            }

            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            for (int j = star; j > 0; j--) {
                System.out.print("*");
            }

            star--;
            space += 2;
            System.out.println();
        }

        space = (num * 2) - 2;

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }

            space -= 2;
            System.out.println();
        }

    }
}

/*
Input Format: N = 3
Result:
******
**  **
*    *
*    *
**  **
******

Input Format: N = 6
Result:
************
*****  *****
****    ****
***      ***
**        **
*          *
*          *
**        **
***      ***
****    ****
*****  *****
************
 */
