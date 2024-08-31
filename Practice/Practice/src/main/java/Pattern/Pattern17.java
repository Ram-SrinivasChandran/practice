package Pattern;

import java.util.Scanner;

public class Pattern17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int space = num - 1;
        int star = 1;

        for (int i = 0; i < num; i++) {
            int character = 'A';
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            space--;
            for (int j = 0; j < star; j++) {
                System.out.print((char) character);
                character++;
            }

            character=character-2;

            for (int j = star - 1; j > 0; j--) {
                System.out.print((char) character);
                character--;
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
 ABA
ABCBA


Input Format: N = 6
Result:
     A
    ABA
   ABCBA
  ABCDCBA
 ABCDEDCBA
ABCDEFEDCBA
 */
