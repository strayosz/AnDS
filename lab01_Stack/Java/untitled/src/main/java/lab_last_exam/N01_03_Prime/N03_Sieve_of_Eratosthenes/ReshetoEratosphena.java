package lab_last_exam.N01_03_Prime.N03_Sieve_of_Eratosthenes;

import java.util.Arrays;

public class ReshetoEratosphena {
    public static void main(String[] args) {
        algorithm(30);
    }

    public static boolean[] algorithm(int N) {
        //arr[i] = true если i – простое, иначе false
        //Если i – простое, то все 2*i, 3*i, 4*i ... k*i – составные
        //помечаем все 2*i, 3*i, 4*i ... k*i false, оставляя только простые true числа
        boolean[] arr = new boolean[N];
        //помечаем изначально все числа простыми, будем вычеркивать составные числа
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        //первое простое число – 2
        for (int i = 2; i < N; i++) {
            //если число простое, то вычеркиваем все кратные ему
            if (arr[i]) {
                for (int j = 2; j*i < N; j++) {
                    arr[j*i] = false;
                }
            }
            //в конце передвигаем указатель i
        }

        //выводим все простые числа
        for (int i = 0; i < N; i++) {
            if (arr[i]) {
                System.out.print(i + " ");
            }
        }
        return arr;
    }
}
