package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class NumberOccurance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array1Length = scanner.nextInt();
        int[] array1 = new int[array1Length];

        for (int i = 0; i < array1Length; i++) {
            array1[i] = scanner.nextInt();
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // int [] hash=new int[13];
        for (int i = 0; i < array1Length; i++) {
            Integer i1 = 0;
            if (hashMap.containsKey(array1[i])) {
                i1 = hashMap.get(array1[i]);
            }

            hashMap.put(array1[i], i1 + 1);
            // hash[array1[i]]+=1;
        }

        int length = scanner.nextInt();
        while (length-- != 0) {
            int number = scanner.nextInt();
            // System.out.print(hash[number]+" ");
            if (hashMap.containsKey(number)) {
                System.out.println(hashMap.get(number));
            } else {
                System.out.println(0);
            }

        }

    }
}
