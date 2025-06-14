package lab_04_Search;

public class Main {
    public static void main(String[] args) {
        int[] answer = bs(new int[] {0, 1, 2, 2, 2, 2, 2, 3, 4, 5}, 2);
        System.out.println(answer[0] + " " + answer[1]);
        System.out.println(search("aaabaa", "aabaaaaa"));
    }

    public static int[] bs(int[] x, int y) {
        int[] answer = new int[2];
        int l = 0;
        int r = x.length - 1;
        int m;

        while(l <= r) {
            m = (l+r)/2;
            if (x[m] < y) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        answer[0] = l;

        l = 0;
        r = x.length - 1;
        while(l <= r) {
            m = (l+r)/2;
            if (x[m] <= y) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        answer[1] = l - 1;
        return answer;
    }

    public static int search(String s, String t) {
        int answer = 0;
        String result = s + t;
        int tempIndex = s.length() - 1;
        for(int i = 0; i < result.length() - s.length(); i++) {
            while (tempIndex>= 0 && s.indexOf(tempIndex) == result.indexOf(answer + tempIndex)) {
                tempIndex--;
            }

            if (tempIndex < 0) {
                answer = tempIndex;
                return answer;
            }
            answer++;
        }
        answer = -1;
        return answer;
    }

}
