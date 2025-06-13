package lab_last_exam.N04_N10_Sort.N08_Sort_Insertion_Merge;

import java.util.Arrays;

public class Sort_Merge {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(algorithm(new int[] {5, 4, 3, 2, 1, 6}, 0, 5)));
    }

    public static int[] merge(int[] x, int l, int m, int r){
        //нужно реализовать так, чтобы массив С был размера r - l
        int[] c = new int[x.length];
        int i = l;
        int j = m + 1;
        int k = l;
        //записываем пока не закончится одна из частей
        while (i <= m && j <= r) {
            if (x[i] > x[j]) {
                c[k] = x[j];
                j++;
            } else {
                c[k] = x[i];
                i++;
            }
            k++;
        }
        //записываем одну из частей до конца
        while (i <= m) {
            c[k] = x[i];
            i++;
            k++;
        }

        while (j <= r) {
            c[k] = x[j];
            j++;
            k++;
        }
        //переписываем результат
        for (int p = l; p <= r; p++) {
            x[p] = c[p];
        }

        return x;
    }

    public static int[] algorithm(int[] x, int l, int r) {
        if (l >= r) return x;
        int m = (l + r)/2;
        algorithm(x, l, m);
        algorithm(x, m + 1, r);
        merge(x, l, m, r);
        return x;
    }

}
