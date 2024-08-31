package Pattern;

import java.util.Scanner;

public class Pattern22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int space = -1;

        for (int i = 0; i < (2 * num) - 1; i++) {
            if (i < num) {
                space++;
            } else {
                space--;
            }

            int star = num;
            for (int j = 0; j < space; j++) {
                System.out.print(star);
                star--;
            }

            for (int j = 0; j < (2 * num - 1 - 2 * space); j++) {
                System.out.print(star);
            }

            star++;
            for (int j = 0; j < space; j++) {
                System.out.print(star);
                star++;
            }

            System.out.println();
        }

    }
}

/*

Input Format: N = 3
Result:
3 3 3 3 3
3 2 2 2 3
3 2 1 2 3
3 2 2 2 3
3 3 3 3 3

Input Format: N = 6
Result:
6 6 6 6 6 6 6 6 6 6 6
6 5 5 5 5 5 5 5 5 5 6
6 5 4 4 4 4 4 4 4 5 6
6 5 4 3 3 3 3 3 4 5 6
6 5 4 3 2 2 2 3 4 5 6
6 5 4 3 2 1 2 3 4 5 6
6 5 4 3 2 2 2 3 4 5 6
6 5 4 3 3 3 3 3 4 5 6
6 5 4 4 4 4 4 4 4 5 6
6 5 5 5 5 5 5 5 5 5 6
6 6 6 6 6 6 6 6 6 6 6
 */