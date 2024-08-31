package Recrusion;

import java.util.Scanner;

public class SumOfFirstNNumbers {
    static int count=0;
    static int total;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int total=sumOfSeries(num);
        System.out.println(total);
    }

    static int sumOfSeries(int N){
        if(count!=N){
            count++;
            total+=count*count*count;
            sumOfSeries(N);
        }
        return total;
    }
}
