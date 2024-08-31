package BasicMath;

import java.util.Scanner;

public class GcdAndLcm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 =scanner.nextInt();
        int gcd=0;
        int lcm;

        int smallNum = Math.min(num1, num2);

        for(int i=1;i<=smallNum;i++){
            if(num1%i==0 && num2%i==0){
                gcd=i;
            }
        }
        lcm=(num1*num2)/gcd;


        System.out.println(lcm +" "+gcd);
    }
}
