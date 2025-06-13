package lab_last_exam.N04_N10_Sort.N09_N10_BinaryHeap;

import java.util.Arrays;

public class BinaryHeap {
    int s;
    int[] a;

    public BinaryHeap(int size) {
        this.a = new int[size];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1, 6};
        BinaryHeap bh = new BinaryHeap(arr.length);
        bh.s = 0;
        //записываем в тот же массив
        bh.a = arr;
        //когда мы записываем в массив кучи, то массив кучи меняется только до левой границы
        for (int i = 0; i < arr.length; i++) {
            bh.add(bh.a[i]);
        }
        //когда мы записываем в исходный массив, то массив кучи в конце освобождается, поэтому туда же и
        //записываем ответ, получаем ответ в обратном порядке
        for (int i = arr.length - 1; i>= 0; i--) {
            bh.a[i] = bh.minDel();
        }
        System.out.println(Arrays.toString(bh.a));
    }

   void add(int x) {
        //добавляем последний элемент
        a[s] = x;
        s++;
        //назначаем временную переменную
        int i = s - 1;
        //поднимаемся вверх, пока не дойдем до корня и пока наш элемент нарушает порядок в куче
        while (i != 0 && a[i] < a[(i - 1)/2]) {
            //swap
            int temp = a[i];
            a[i] = a[(i - 1)/2];
            a[(i - 1)/2] = temp;
            //меняем временную переменную, то есть переходим к родителю
            i = (i - 1)/2;
        }
   }

   int minDel() {
        int ans = a[0];
       //swap с последним
       int temp = a[s - 1];
       a[s - 1] = a[0];
       a[0] = temp;
       s--;
       //назначаем временную переменную
       int i = 0;
       //предполагаем, что левый ребенок наименьший
       int m = 2*i + 1;
       //в случае, если это не так, то правый становится наименьшим
       if (m + 1 < s && a[m] > a[m + 1]) m++;
        // спускаемся вниз, пока есть дети и пока наш элемент нарушает порядок в куче
       while (2*i < s && a[i] > a[m]) {
           //меняем местами наш элемент и ребенка
           int temp1 = a[i];
           a[i] = a[m];
           a[m] = temp1;
           //меняем временную переменную, то есть переходим к ребенке
           i = m;
           m = 2*i + 1;
           //снова выбираем минимального ребенка
           if (m + 1 < s && a[m] > a[m+1]) m++;
       }
       return ans;
   }
}
