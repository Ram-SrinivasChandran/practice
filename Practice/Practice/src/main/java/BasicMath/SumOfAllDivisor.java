package BasicMath;

import java.util.Scanner;

public class SumOfAllDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }

            }

            sum += i;
        }

        System.out.println(sum);
    }
}

/*
Sample Input 1:
3


Sample Output 1:
8


Explanation of sample output 1:
We need to find sumOfDivisors(1) + sumOfDivisors(2) +sumOfDivisors(3).
sumOfDivisors(1) = 1
sumOfDivisors(2) = 2 + 1 = 3
sumOfDivisors(3) = 3 + 1 = 4
Therefore, the answer is sumOfDivisors(1) + sumOfDivisors(2) + sumOfDivisors(3) = 1 + 3 + 4 = 8.

Sample Input 2:
10


Sample Output 2:
87


Expected Time Complexity:
Try to solve this in O(sqrt(‘n’)).


Constraints:
1 <= ‘n’ <= 3*10^4

Time Limit: 1 sec
 */