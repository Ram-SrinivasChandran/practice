package BasicMath;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int newNum = 0;
        int temp = x;
        if (x < 0) {
            x *= -1;
        }

        while (x > 0) {
            newNum = newNum * 10 + (x % 10);
            x /= 10;
        }

        if (newNum == temp) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
