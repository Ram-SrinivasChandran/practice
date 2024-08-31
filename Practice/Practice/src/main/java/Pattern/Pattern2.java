package Pattern;

import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }
}


/*
Input Format: N = 3
Result:
*
* *
* * *

Input Format: N = 6
Result:
*
* *
* * *
* * * *
* * * * *
* * * * * *
 */
