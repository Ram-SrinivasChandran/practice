package BasicMath;

import java.util.Scanner;

public class CountDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }

        System.out.println(count);
    }
}
