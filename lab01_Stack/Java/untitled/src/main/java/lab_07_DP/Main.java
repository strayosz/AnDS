package lab_07_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        task2(18, 6);
    }

    public static void task1(int n) {
        int temp1 = 1;
        int temp2 = 1;
        int sum = temp1 + temp2;
        int i = 3;
        while (i < n){
            temp1 = temp2;
            temp2 = sum;
            sum = temp1 + temp2;
            i++;

        }
        System.out.println(sum%10);
    }

    public static void task2(int n, int k) {
        int[] arr = new int[k];
        if (n % k != 0){
            return;
        }
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < k; i++) {
            for(int j = Math.abs(k - i); j < k - 1; j++){
                arr[i] += arr[j];
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
