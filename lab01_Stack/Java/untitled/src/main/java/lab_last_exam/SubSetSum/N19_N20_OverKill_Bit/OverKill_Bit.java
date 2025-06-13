package lab_last_exam.SubSetSum.N19_N20_OverKill_Bit;

public class OverKill_Bit {
    public static void main(String[] args) {
        System.out.println(algorithm(new int[] {1, 2, 3, 4, 5}, 6));
    }

    public static boolean algorithm(int[] x, int k) {
        boolean ans = false;
        //формируем число равное 2^n
        int n2 = 1<<x.length;

        for (int q = 0; q < n2; q++) {
            int s = 0;
            //проходимся по каждому числу
            for (int i = 0; i < x.length; i++) {
                //если оно соответствует единичке, то берем, иначе не берем
                if ((q & (1<<i)) != 0) s += x[i];
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
