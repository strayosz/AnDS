package lab_last_exam.N21_PutQueen;

public class Put_Queen {
    public static void main(String[] args) {
        Put_Queen pq = new Put_Queen();
        pq.putQueen(0);
        System.out.println(pq.count);
    }

    int count = 0;
    int[] y = new int[8];

    void putQueen(int x) {
        if (x == 8) {
            if (isCorrectSequance()) count++;
        } else {
            for (int i = 0; i < 8; i++) {
                y[x] = i;
                putQueen(x + 1);
            }
        }
    }

    boolean isCorrectSequance() {
        boolean ans = true;

        for (int x1 = 0; x1 < 8; x1++) {
            for (int x2 = 0; x2 < x1; x2++) {//не перебираем варианты "дубликаты"
                if (Math.abs(y[x1] - y[x2]) == Math.abs(x1 - x2) || y[x1] == y[x2]) ans = false;
            }
        }
        return ans;
    }
}