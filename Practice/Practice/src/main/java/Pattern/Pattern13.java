package Pattern;

import java.util.Scanner;

public class Pattern13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int star = 1;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(star + " ");
                star++;
            }

            System.out.println();
        }

    }
}

/*

Input Format: N = 3
Result:
1
2 3
4 5 6

Input Format: N = 6
Result:
1
2  3
4  5  6
7  8  9  10
11  12  13  14  15
16  17  18  19  20  21
 */