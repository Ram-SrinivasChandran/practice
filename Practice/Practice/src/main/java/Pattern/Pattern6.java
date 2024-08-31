package Pattern;

import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            int count = 1;
            for (int j = num; j > i; j--) {
                System.out.print(count + " ");
                count++;
            }

            System.out.println();
        }

    }
}

/*
Input Format: N = 3
Result:
1 2 3
1 2
1

Input Format: N = 6
Result:
1 2 3 4 5 6
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1
 */