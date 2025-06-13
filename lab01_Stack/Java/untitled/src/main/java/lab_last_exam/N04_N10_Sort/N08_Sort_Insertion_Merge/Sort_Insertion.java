package lab_last_exam.N04_N10_Sort.N08_Sort_Insertion_Merge;

import java.util.Arrays;

public class Sort_Insertion {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(algorithm(new int[] {5, 4, 3, 1, 6})));
    }

    public static int[] algorithm(int[] x) {
        for (int i = 1; i < x.length; i++) {
            int j = i;
            while (j > 0 && x[j - 1] > x[j]) {
                int temp = x[j - 1];
                x[j - 1] = x[j];
                x[j] = temp;
                j--;
            }
        }

        return x;
    }
}
