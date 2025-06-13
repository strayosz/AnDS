package lab_last_exam.N21_PutQueen.PutQueen_Border;

public class Put_Queen_Border {
    public static void main(String[] args) {
        Put_Queen_Border pq = new Put_Queen_Border();
        pq.putQueen(0);
        System.out.println(pq.count);
    }

    int count = 0;
    int[] y = new int[8];

    void putQueen(int x) {
        if (x == 8) {//получена полная последовательность
            count++;
        } else {
            for (int i = 0; i < 8; i++) {
                y[x] = i;
                //отсекаем ту ветку, когда у нас уже неправильно стоят ферзи на этапе формирования
                 if (isCorrect(x)) putQueen(x + 1);
            }
        }
    }


    boolean isCorrect(int x) {
        boolean ans = true;
        for (int x1 = 0; x1 < x; x1++) {
            if (Math.abs(y[x1] - y[x]) == Math.abs(x1 - x) || y[x1] == y[x]) ans = false;
        }
        return ans;
    }
}
