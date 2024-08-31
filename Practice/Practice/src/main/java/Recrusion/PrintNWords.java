package Recrusion;

import java.util.Scanner;

public class PrintNWords {
    static int count=0;

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int num=s.nextInt();
        printNos(num);

    }
    public static void printNos(int N)
    {
        if(count!=N){
            count++;
            System.out.print("GFG ");
            printNos(N);
        }
    }
}
