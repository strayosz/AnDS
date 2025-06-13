package lab_last_exam.N04_N10_Sort.N04_Sort_Count;

import java.util.Arrays;

public class Sort_Count {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(algorithm(new int[]{0, 3, 3, 1, 1, 0}, 4)));
    }

    public static int[] algorithm(int[] x, int p) {
        int[] count = new int[p];

        for (int i = 0; i < x.length; i++) {
            count[x[i]]++;
        }

        int k = 0;
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < count[i]; j++) {
                x[k] = i;
                k++;
            }
        }
        return x;
    }
}
