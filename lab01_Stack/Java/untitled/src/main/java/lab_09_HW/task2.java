package lab_09_HW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class task2 {

    public static void main(String[] args) {
        // Пример: для каждой позиции i заданы допустимые ходы
        Map<Integer, List<Integer>> moves = new HashMap<>();
        moves.put(1, Arrays.asList(1));
        moves.put(2, Arrays.asList(1, 2));
        moves.put(3, Arrays.asList(1, 2, 3));

        int n = 5; // Общее число палочек
        boolean firstPlayerWins = canWin(n, moves);
        System.out.println(firstPlayerWins ? "First player wins" : "Second player wins");
    }
    public static boolean canWin(int n, Map<Integer, List<Integer>> moves) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false; // Проигрышная позиция

        for (int i = 1; i <= n; i++) {
            List<Integer> allowedMoves = moves.get(i);
            if (allowedMoves == null) {
                dp[i] = false; // Если нет допустимых ходов, текущий игрок проигрывает
                continue;
            }

            boolean canWinCurrent = false;
            for (int move : allowedMoves) {
                if (i - move >= 0 && !dp[i - move]) {
                    canWinCurrent = true;
                    break;
                }
            }
            dp[i] = canWinCurrent;
        }

        return dp[n];
    }

}
