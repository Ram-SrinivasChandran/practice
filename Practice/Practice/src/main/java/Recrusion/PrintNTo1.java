package Recrusion;

import java.util.Scanner;

public class PrintNTo1 {
    static int count=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        printNos(num);
    }

    static void printNos(int N){
        if(count!=N){
            System.out.print(N-count+" ");
            count++;
            printNos(N);
        }
    }
}
