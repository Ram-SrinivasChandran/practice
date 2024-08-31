package Pattern;

import java.util.Scanner;

public class Pattern15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i=0;i<num;i++){
            for (int j='A';j<=('A'+num)-i-1;j++){
                System.out.print((char)j+" ");
            }
            System.out.println();
        }
    }
}


/*
Input Format: N = 3
Result:
A B C
A B
A

Input Format: N = 6
Result:
A B C D E F
A B C D E
A B C D
A B C
A B
A
 */