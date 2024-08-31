package Pattern;

import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int star = 'A';

        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) star + " ");
            }

            star++;
            System.out.println();
        }

    }
}

/*
Input Format: N = 3
Result:
A
B B
C C C

Input Format: N = 6
Result:
A
B B
C C C
D D D D
E E E E E
F F F F F F
 */
