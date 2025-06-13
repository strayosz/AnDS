package lab_last_exam.N04_N10_Sort.N06_Sort_Bubble;

import java.util.Arrays;

public class Sort_Bubble {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(algorithm(new int[] {5, 4, 3, 1, 6})));
    }

    public static int[] algorithm(int[] x) {
        for (int i = x.length - 1; i > -1; i--) {
            //проверяем, отсортирован ли массив
            boolean isSwaped = false;
            for (int j = 0; j < i; j++) {
                if (x[j] > x[j + 1]) {
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                    isSwaped = true;
                }
            }
            //если не было swap'ов, то массив отсортирован
            if (!isSwaped) {
                break;
            }
        }

        return x;
    }
}
