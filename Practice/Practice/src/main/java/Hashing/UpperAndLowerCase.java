package Hashing;

import java.util.Scanner;

public class UpperAndLowerCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        int[] hash = new int[256];
        for (int i = 0; i < string.length(); i++) {
            hash[string.charAt(i)] += 1;
        }

        int q = scanner.nextInt();
        while (q-- != 0) {
            char character=scanner.next().charAt(0);

            System.out.print(hash[character]+" ");
        }
    }
}
