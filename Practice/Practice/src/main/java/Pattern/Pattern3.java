package Pattern;

import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1 + " ");
            }

            System.out.println();
        }

    }
}

/*
Input Format: N = 3
Result:
1
1 2
1 2 3

Input Format: N = 6
Result:
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
1 2 3 4 5 6
 */