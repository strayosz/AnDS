package lab_last_exam.N01_03_Prime.N01_IsPrime;

import static java.lang.Math.sqrt;

public class IsPrime {
    public static void main(String[] args) {
        System.out.println(algorithm(18));
    }

    public static boolean algorithm(int x) {
        for (int i = 2; i < sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
