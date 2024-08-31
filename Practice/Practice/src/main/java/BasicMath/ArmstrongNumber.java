package BasicMath;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int temp = num;
        int count = 0;
        int newNum = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }

        num = temp;

        while (num > 0) {
            int lastDigit = num % 10;
            int result = 1;
            for (int i = 0; i < count; i++) {
                result *= lastDigit;
            }

            newNum += result;
            num /= 10;
        }

        System.out.println(newNum == temp);

    }
}
