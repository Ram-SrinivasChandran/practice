package Pattern;

import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }
}

/*
Example 1:
Input: N = 3
Output:
* * *
* * *
* * *


Example 2:
Input: N = 6
Output:
* * * * * *
* * * * * *
* * * * * *
* * * * * *
* * * * * *
* * * * * *
 */
