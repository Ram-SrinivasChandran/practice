package Pattern;

import java.util.Scanner;

public class Pattern21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i=0;i<num;i++){
            for (int j=0;j<num;j++){
                if((i==0)||(j==0)||(i==num-1)||(j==num-1)){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

/*

Input Format: N = 3
Result:
***
* *
***

Input Format: N = 6
Result:
******
*    *
*    *
*    *
*    *
******

 */