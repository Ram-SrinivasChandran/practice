package Array.Hard;

import java.util.Scanner;

public class ReversePairs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int arrayLength=scanner.nextInt();
        int [] array=new int[arrayLength];

        for (int i=0;i<arrayLength;i++){
            array[i]=scanner.nextInt();
        }

        System.out.println(countPairs(array));
    }

    public static int countPairs(int[] array) {
        return mergeSortAndCount(array, 0, array.length - 1);
    }

    private static int mergeSortAndCount(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = mergeSortAndCount(array, left, mid);
        count += mergeSortAndCount(array, mid + 1, right);
        count += mergeAndCount(array, left, mid, right);

        return count;
    }

    private static int mergeAndCount(int[] array, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && array[i] > 2L * array[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        int[] temp = new int[right - left + 1];
        int i = left, k = 0;
        j = mid + 1;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        System.arraycopy(temp, 0, array, left, temp.length);

        return count;
    }
}

/*
Here’s a line-by-line explanation of the optimized Java program that counts the number of valid pairs (i, j) such that i < j and arr[i] > 2 * arr[j], using a modified merge sort:

1. Main Class and Method
java
Copy code
public class PairCounterOptimized {

    public static int countPairs(int[] array) {
        return mergeSortAndCount(array, 0, array.length - 1);
    }
PairCounterOptimized: This is the class containing the logic to count the pairs.
countPairs: This method takes an array as input and returns the total number of valid pairs. It calls the recursive mergeSortAndCount function to divide the array, sort it, and count the pairs.
array.length - 1: We pass the entire array from index 0 to array.length - 1 to be processed.
2. Recursive Merge Sort with Counting
java
Copy code
    private static int mergeSortAndCount(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
mergeSortAndCount: This is the recursive function that splits the array and counts valid pairs. It is similar to a standard merge sort but includes logic for counting the pairs that meet the condition.
if (left >= right): This is the base case of recursion. If the array (or sub-array) has only one element (or no elements), no pairs can be counted, so the function returns 0.
mid = left + (right - left) / 2: This calculates the midpoint of the current sub-array, which is used to split it into two halves.
java
Copy code
        int count = mergeSortAndCount(array, left, mid);
        count += mergeSortAndCount(array, mid + 1, right);
        count += mergeAndCount(array, left, mid, right);

        return count;
    }
mergeSortAndCount(array, left, mid): Recursively processes the left half of the array and counts pairs in that half.
mergeSortAndCount(array, mid + 1, right): Recursively processes the right half of the array and counts pairs in that half.
mergeAndCount(array, left, mid, right): This function merges the two sorted halves back together and counts the number of valid pairs across the halves where arr[i] > 2 * arr[j] and i < j.
count: The total number of valid pairs found in the current recursive step is returned after counting in both halves and the merge step.
3. Merge and Count Function
java
Copy code
    private static int mergeAndCount(int[] array, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && array[i] > 2L * array[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
mergeAndCount: This function does two things: counts the valid pairs and merges the two sorted halves.
count = 0: Initializes a variable to keep track of the number of valid pairs.
j = mid + 1: j starts at the first element of the right half of the array.
for (int i = left; i <= mid; i++): Loops over each element in the left half (i ranging from left to mid).
while (j <= right && array[i] > 2L * array[j]): For each i, this inner loop checks whether array[i] > 2 * array[j]. If the condition holds, j is incremented until it finds the point where the condition no longer holds.
count += (j - (mid + 1)): This line counts how many valid pairs exist for the current i. Since j is incremented within the inner loop, j - (mid + 1) gives the number of elements j such that array[i] > 2 * array[j].
4. Merging Two Halves
java
Copy code
        int[] temp = new int[right - left + 1];
        int i = left, k = 0;
        j = mid + 1;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
temp = new int[right - left + 1]: This temporary array will hold the merged result of the two sorted halves.
i = left, k = 0, j = mid + 1: Initializes i to point to the left half, j to point to the right half, and k to point to the temporary array where the sorted elements will be merged.
while (i <= mid && j <= right): This loop merges the two halves. It compares array[i] and array[j], and places the smaller element into the temp array.
temp[k++] = array[i++] or temp[k++] = array[j++]: The smaller of the two elements (array[i] or array[j]) is placed into the temp array, and the pointers i, j, and k are incremented accordingly.
java
Copy code
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        System.arraycopy(temp, 0, array, left, temp.length);

        return count;
    }
while (i <= mid): If there are any remaining elements in the left half, they are copied into the temp array.
while (j <= right): Similarly, if there are any remaining elements in the right half, they are copied into the temp array.
System.arraycopy(temp, 0, array, left, temp.length): This copies the merged temp array back into the original array between the indices left and right.
return count: The function returns the total number of valid pairs counted during this merge.
5. Main Method
java
Copy code
    public static void main(String[] args) {
        // Example 1
        int[] array1 = {1, 3, 2, 3, 1};
        System.out.println("Output for Example 1: " + countPairs(array1));  // Output: 2

        // Example 2
        int[] array2 = {3, 2, 1, 4};
        System.out.println("Output for Example 2: " + countPairs(array2));  // Output: 1
    }
}
The main method provides two example test cases.
For array1 = {1, 3, 2, 3, 1}, the program outputs 2 because there are two pairs that satisfy the condition.
For array2 = {3, 2, 1, 4}, the program outputs 1 because only one pair satisfies the condition.
Summary:
The program uses a merge sort to both sort the array and count the valid pairs (i, j) such that i < j and arr[i] > 2 * arr[j].
The time complexity is
𝑂
(
𝑁
log
⁡
𝑁
)
O(NlogN) due to the merge sort, making it much more efficient than the
𝑂
(
𝑁
2
)
O(N
2
 ) brute-force solution for large arrays.
 */