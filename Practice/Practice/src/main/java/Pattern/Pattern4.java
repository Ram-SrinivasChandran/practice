package Pattern;

import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 1;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(count + " ");
            }

            count++;
            System.out.println();
        }

    }
}

/*
Input Format: N = 3
Result:
1
2 2
3 3 3

Input Format: N = 6
Result:
1
2 2
3 3 3
4 4 4 4
5 5 5 5 5
6 6 6 6 6 6
 */
