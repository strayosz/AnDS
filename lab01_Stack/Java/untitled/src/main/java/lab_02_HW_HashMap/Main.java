package lab_02_HW_HashMap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        task1("abc, abc. new! old start start");
        task2(new int[]{1, 2, 3, 1, 1}, 3);
        task3(new int[]{2, 4, 4, 1}, new int[]{2, 2, 4,4, 4, 5, 3});
    }

    public static void task1(String text) {
        Map<String, Integer> hashMap = new HashMap<>();
        int startIndex = -1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (text.charAt(i - 1) == ',' || text.charAt(i - 1) == '.' || text.charAt(i - 1) == '!') {
                    hashMap.merge(text.substring(startIndex + 1, i - 1), 1, (valOld, valNew) -> valOld + valNew);
                } else {
                    hashMap.merge(text.substring(startIndex + 1, i), 1, (valOld, valNew) -> valOld + valNew);
                }
                startIndex = i;
            } else if (i == text.length() - 1) {
                hashMap.merge(text.substring(startIndex + 1), 1, (valOld, valNew) -> valOld + valNew);
            }

        }
        System.out.println(hashMap);
    }

    public static void task2(int[] nums, int k) {
        boolean result = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                int prevIndex = map.get(num);
                if (i - prevIndex <= k) {
                    result = true;
                    System.out.println(result);
                    return;
                }
            }
            map.put(num, i);
        }
        System.out.println(result);
    }

    public static void task3(int[] x, int[] y) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            mapX.merge(x[i], 1, (oldVal, newVal) -> oldVal + newVal);
        }
        for (int i = 0; i < y.length; i++) {
            mapY.merge(y[i], 1, (oldVal, newVal) -> oldVal + newVal);
        }
        for (Integer p : mapX.keySet()) {
            if (mapY.containsKey(p)) {
                for (int i = 0; i < Math.min(mapX.get(p), mapY.get(p)); i++) {
                    result.add(p);
                }
            }

        }
        System.out.println(result);
    }
}
