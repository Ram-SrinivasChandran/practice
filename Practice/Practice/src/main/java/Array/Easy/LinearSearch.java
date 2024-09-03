package Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int arrayLength=scanner.nextInt();
        int [] array=new int[arrayLength];
        int number=scanner.nextInt();

        for (int i=0;i<arrayLength;i++){
            array[i]=scanner.nextInt();
        }

        System.out.println(linearSearch(array,number));
    }

    private static int linearSearch(int[] array,int number){
        List<Integer> result = Arrays.stream(array).boxed().toList();
        if(result.indexOf(number)>0){
            return 1;
        }
        return -1;
    }
}

/*
Example 1:
Input: arr[]= 1 2 3 4 5, num = 3
Output: 2
Explanation: 3 is present in the 2nd index

Example 2:
Input: arr[]= 5 4 3 2 1, num = 5
Output: 0
Explanation: 5 is present in the 0th index
 */