package Pattern;

import java.util.Scanner;

public class Pattern12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int space = (num * 2) - 2;

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            for (int j = i; j > 0; j--) {
                System.out.print(j);
            }

            space -= 2;
            System.out.println();
        }

    }
}

/*
Input Format: N = 3
Result:
1    1
12  21
123321


Input Format: N = 6
Result:
1          1
12        21
12       321
1234    4321
12345  54321
123456654321
 */
