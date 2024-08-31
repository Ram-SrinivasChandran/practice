package BasicMath;

import java.util.Scanner;

public class ReverseANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        long newNum = 0;
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num *= -1;
        }

        while (num > 0) {
            newNum = newNum * 10 + (num % 10);
            num /= 10;

            if (newNum > Integer.MAX_VALUE || newNum < Integer.MIN_VALUE) {
                newNum = 0;
            }

        }

        if (isNegative) {
            newNum *= -1;
        }

        System.out.println(newNum);
    }
}
