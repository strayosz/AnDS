package lab_last_exam.N04_N10_Sort.N05_Sort_Choice;

import java.util.Arrays;

public class Sort_Choice {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(algorithm(new int[] {5, 3, 2, 1, 6})));
    }

    public static int[] algorithm(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (x[i] > x[j]) {
                    int temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                }
            }
        }
        return x;
    }
}
