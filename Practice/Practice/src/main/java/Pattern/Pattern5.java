package Pattern;

import java.util.Scanner;

public class Pattern5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            for (int j = num; j > i; j--) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }
}

/*
Input Format: N = 3
Result:
* * *
* *
*

Input Format: N = 6
Result:
* * * * * *
* * * * *
* * * *
* * *
* *
*
 */
