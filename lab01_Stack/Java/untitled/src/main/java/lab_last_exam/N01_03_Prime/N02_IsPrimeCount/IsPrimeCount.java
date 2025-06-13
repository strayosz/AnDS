package lab_last_exam.N01_03_Prime.N02_IsPrimeCount;

import static java.lang.Math.sqrt;

public class IsPrimeCount {
    public static void main(String[] args) {
        System.out.println(algorithm(10));
    }

    public static int algorithm(int N) {
        int count = 0;
        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                count++;
            }
        }
        return count;
    }

}
