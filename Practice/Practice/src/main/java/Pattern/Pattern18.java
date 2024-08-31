package Pattern;

import java.util.Scanner;

public class Pattern18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int character = 'A' + num - 1;

        for (int i = 0; i < num; i++) {
            int star = character - i;
            for (int j = 0; j <= i; j++) {
                System.out.print((char) star);
                star++;
            }

            System.out.println();
        }

    }
}

/*
Input Format: N = 3
Result:
C
B C
A B C

Input Format: N = 6
Result:
F
E F
D E F
C D E F
B C D E F
A B C D E F
 */