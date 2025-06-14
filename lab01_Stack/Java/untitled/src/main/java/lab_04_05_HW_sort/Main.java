package lab_04_05_HW_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        task1(new int[] {90, 89, 88, 87, 80, 79, 78, 77, 76, 75, 71, 72, 73, 74, 75, 76});
        task2("bly is the sky");
        task3(new int[] {3, 30, 34, 5, 9});
        task4(new int[] {15, 5, 11, 10, 12, 5, 5}, 30);

    }

    public static void task1(int[] x) {
        int l = 0;
        int r = x.length - 1;
        int m;
        while (l <= r) {
            m = (l + r)/2;
            if (x[m] > x[m + 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println(l - 1);
    }

    public static void task2(String text) {
        int index = 0;
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                result = text.substring(index, i) + " " + result;
                index = i + 1;
            }
        }
        result = text.substring(index, text.length()) + " " + result;
        System.out.println(result);
    }

    public static void task3(int[] x) {
        /**
         * Отрывок из метода merge в MergeSort, если predication = true
         * int Ili = l[i];
         * String li = Integer.toString(Ili);
         * int Iri = r[i];
         * String ri = Integer.toString(Iri);
         * //l[i] >= r[j]
         * if (Integer.parseInt(li + ri) >= Integer.parseInt(ri + li)) {
         *     a[k++] = l[i++];
         * }
         * else {
         *     a[k++] = r[j++];
         * }
         */
        Sort.mergeSort(x, x.length, true);
        System.out.println(Arrays.toString(x));
    }

    public static void task4(int[] x, int s) {
        Sort.mergeSort(x, x.length, false);
        int sum;
        for (int i = 0; i < x.length; i++) {
            sum = 0;
            for (int j = 0; j < i; j++) {
                sum += x[j];
            }
            if (sum > s) {
                System.out.println(i - 1);
                break;
            }

        }
    }
}
