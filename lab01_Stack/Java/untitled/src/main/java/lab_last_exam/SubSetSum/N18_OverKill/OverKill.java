package lab_last_exam.SubSetSum.N18_OverKill;

public class OverKill {
    public static void main(String[] args) {
        System.out.println(algorithm(new int[] {1, 2, 3, 4, 5}, 6));
    }

    public static boolean algorithm(int[] x, int k) {
        boolean ans = false;
        //формируем число равное 2^n
        int n2 = 1;
        for (int i = 0; i < x.length; i++) n2 *= 2;
        for (int q = 0; q < n2; q++) {
            int w = q;
            int s = 0;
            //проходимся по каждому числу
            for (int i = 0; i < x.length; i++) {
                //если оно соответствует единичке, то берем, иначе не берем
                if (w % 2 != 0) s += x[i];
                w /= 2;
            }
            //если набралась нужная сумма, то выводим ответ
            if (s == k) {
                ans = true;
                break;
            }
        }
        return ans;

    }
}
