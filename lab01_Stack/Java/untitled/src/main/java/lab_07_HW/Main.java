package lab_07_HW;

public class Main {
    public static void main(String[] args) {
        System.out.println(task1(new int[][]{
                {1, 3, 4, 8, 1, 3},
                {2, 1, 4, 6, 7, 4},
                {2, 1, 4, 6, 7, 4},
                {2, 1, 4, 6, 7, 4}}));
    }

    public static int task1(int[][] x) {
        int current = x[0][0];


        for (int i = 1; i < x[0].length; i++) {
            x[0][i] += current;
            current = x[0][i];
        }

        current = x[0][0];
        for (int i = 1; i < x.length; i++) {
            x[i][0] += current;
            current = x[i][0];
        }

        for (int i = 1; i < x.length; i++) {
            for (int j = 1; j < x[0].length; j++) {
                x[i][j] += Math.max(x[i - 1][j], x[i][j - 1]);
            }
        }
        return x[x.length - 1][x[0].length - 1];
    }

}
