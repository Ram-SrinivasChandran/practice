package Recrusion;

import java.util.Scanner;

public class FibanacciSeries {
    static int count=1;
    static int firstNum=1;
    static int prevNum=0;
    static int result=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        System.out.println(fib(num));
    }

    public static int fib(int n){
        if(n==0){
            count=0;
        }else if(n==1){
            result=firstNum;
        }
        if(count!=n){
            result=firstNum+prevNum;
            prevNum=firstNum;
            firstNum=result;
            count++;
            return fib(n);
        }
        return result;
    }
}
