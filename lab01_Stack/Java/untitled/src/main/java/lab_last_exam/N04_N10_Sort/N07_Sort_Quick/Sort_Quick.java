package lab_last_exam.N04_N10_Sort.N07_Sort_Quick;

import java.util.Arrays;

public class Sort_Quick {
    public static void main(String[] args) {
        int[] x = new int[] {1, 4, 3, 5, 6, 7, 10, 11, 12, 13, 17, 6, 11};
        algorithm(x, 0, x.length - 1);
        System.out.println(Arrays.toString(x));
    }

    public static void algorithm(int[] x, int l, int r) {
        int i = l;
        int j = r;
        //pivot элемент
        int m = x[(l + r)/2];

        //пока указатели не встретились
        while (i <= j) {
            //передвигаем, пока не встретим число, которое находится не в своей части
            while (x[i] < m) i++;
            while (x[j] > m) j--;

            //применяем swap
            if (i <= j) {
                int temp = x[i];
                x[i] = x[j];
                x[j] = temp;
                i++;
                j--;
            }
        }

        //если части еще существуют, то вызываем алгоритм
        if (l < j) algorithm(x, l, j);
        if (i < r) algorithm(x, i, r);
    }
}
