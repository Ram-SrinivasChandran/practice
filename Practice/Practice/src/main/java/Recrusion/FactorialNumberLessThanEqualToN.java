package Recrusion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FactorialNumberLessThanEqualToN {
    static ArrayList<Long> result=new ArrayList<>();
    static int count=1;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long num=scanner.nextInt();
        System.out.println(factorialNumbers(num));
    }

    static ArrayList<Long> factorialNumbers(long N){
        long ans=1;
        for (int i=1;i<=count;i++){
            ans*=i;
        }
        if(ans<=N){
            result.add(ans);
            count++;
            factorialNumbers(N);
        }

        return result;
    }
}
