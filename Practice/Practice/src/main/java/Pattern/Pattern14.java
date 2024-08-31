package Pattern;

import java.util.Scanner;

public class Pattern14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            for (char j = 'A'; j <= 'A' + i; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }

    }
}

/*

Input Format: N = 3
Result:
A
A B
A B C

Input Format: N = 6
Result:
A
A B
A B C
A B C D
A B C D E
A B C D E F
 */