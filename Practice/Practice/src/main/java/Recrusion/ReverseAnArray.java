package Recrusion;

import java.lang.reflect.Array;
import java.util.Scanner;

public class ReverseAnArray {
    static int count=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num = scanner.nextInt();
        int [] numbers=new int[num];
        for(int i=0;i<num;i++){
            numbers[i]= scanner.nextInt();
        }
        int[] reversedArray = reverseArray(num, numbers);

        for (int i:reversedArray){
            System.out.print(i+" ");
        }
    }
    static int [] reverseArray(int num,int [] numbers){
        if(count!=(num/2)){
            int temp=numbers[count];
            numbers[count]=numbers[num-count-1];
            numbers[num-count-1]=temp;
            count++;
            return reverseArray(num,numbers);
        }
        return numbers;
    }
}
