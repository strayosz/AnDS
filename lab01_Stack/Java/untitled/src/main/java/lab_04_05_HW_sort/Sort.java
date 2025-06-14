package lab_04_05_HW_sort;

public class Sort {
    public static void mergeSort(int[] a, int n, boolean prediction) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid, prediction);
        mergeSort(r, n - mid, prediction);

        merge(a, l, r, mid, n - mid, prediction);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right, boolean prediction) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (!prediction) {
                if (l[i] <= r[j]) {
                    a[k++] = l[i++];
                }
                else {
                    a[k++] = r[j++];
                }
            } else {
                int Ili = l[i];
                String li = Integer.toString(Ili);
                int Iri = r[i];
                String ri = Integer.toString(Iri);
                //l[i] >= r[j]
                if (Integer.parseInt(li + ri) >= Integer.parseInt(ri + li)) {
                    a[k++] = l[i++];
                }
                else {
                    a[k++] = r[j++];
                }
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
