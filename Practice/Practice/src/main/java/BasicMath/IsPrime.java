package BasicMath;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                count++;
            }

        }

        System.out.println(count <= 1 && num != 1);

    }
}
