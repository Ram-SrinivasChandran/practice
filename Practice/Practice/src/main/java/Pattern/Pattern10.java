package Pattern;

import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 1; i < (num * 2); i++) {
            int rowCount = i;
            if (i > num) {
                rowCount = (num * 2) - i;
            }

            for (int j = 0; j < rowCount; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }
}

/*
Input Format: N = 3
Result:
  *
  **
  ***
  **
  *
Input Format: N = 6
Result:
     *
     **
     ***
     ****
     *****
     ******
     *****
     ****
     ***
     **
     *
 */