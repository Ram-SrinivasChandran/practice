package Pattern;

import java.util.Scanner;

public class Pattern11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int binaryValue = 0;

        for (int i = 0; i < num; i++) {
            if (i % 2 != 0) {
                binaryValue = 0;
            } else {
                binaryValue = 1;
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(binaryValue + " ");
                binaryValue = 1 - binaryValue;
            }

            System.out.println();

        }

    }
}

/*
Input Format: N = 3
Result:
1
01
101

Input Format: N = 6
Result:
1
01
101
0101
10101
010101
 */