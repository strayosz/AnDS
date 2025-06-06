package lab_06_DaC;

public class Main {
    public static void main(String[] args) {
        System.out.println(task1(new int[] {9, 0, 5, 7, 2}, 0, 4));
    }

    public static int task1(int[] x, int l, int r) {
        if (r - l == 1) {
            return x[l];
        }
        int answer = task1(x, l, r - (r-l)/2);
        int answer1 = task1(x, l + (r - l)/2, r);
        return Math.max(answer1, answer);
    }
}